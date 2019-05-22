package tr.com.karabiyikoglu.ftpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class FtpConnection implements Runnable {
	public FtpConnection(Users kullanicilar[], Socket socket, InetAddress inetaddress) throws Exception {
		this.kullanicilar = kullanicilar;
		sb = new StringBuffer(256);
		bf = new byte[512];
		cal = Calendar.getInstance();
		s = socket;
		ip = inetaddress;
		li = true;

		if (!FTPGui.limitsizMi())
			socket.setSoTimeout(FTPGui.zaman_Asimi());

	}

	synchronized int getPort() {
		pnum++;
		if (pnum == 9200)
			pnum += 10;
		if (pnum == 65500)
			pnum = 5000;
		return pnum;
	}

	synchronized void upload(int i) {
		toplamUpload += i;
		FTPGui.uploadyaz(String.valueOf(toplamUpload >> 10));
	}

	synchronized void download(int i) {
		toplamDownload += i;
		FTPGui.downloadyaz(String.valueOf(toplamDownload >> 10));
	}

	public void run() {
		try {
			okuyucu = new InputStreamReader(s.getInputStream(), "ISO-8859-9");
			ps = new PrintStream(s.getOutputStream(), true, "ISO-8859-9");
			ps.print("220 IK Ftp Server Hosgeldiniz .\r\n");

			label0: do {
				sb.setLength(0);
				do {
					int i = okuyucu.read();
					if (i <= 0) {
						if (sb.length() <= 0)
							break label0;
						break;
					}
					char c = (char) i;
					if (c == '\r') {
						okuyucu.skip(1L);
						break;
					}
					sb.append(c);
				} while (true);
				int j = sb.length();
				for (int i1 = j - 1; i1 >= 0 && sb.charAt(i1) == ' '; i1--)
					sb.setLength(--j);

				if (j == 0)
					continue;
				gelenKomut = sb.toString();
				System.out.println(gelenKomut);
				if (gelenKomut.startsWith("SYST")) {
					ps.print("215 UNIX Type: L8\r\n");
					continue;
				}
				if (gelenKomut.startsWith("USER")) {
					int i = 0;
					kulokey = false;
					while (i < kullanicilar.length) {
						if (gelenKomut.endsWith(kullanicilar[i].getKullanici())) {
							java.io.File ad = new java.io.File(kullanicilar[i].getKok_klasor());
							kokKlasor = cd = ad;
							kokYolu = ad.getCanonicalPath();
							kokUzunlugu = kokYolu.length();
							ro = (!kullanicilar[i].isYazma_izni());
							kulokey = true;
							passi = i;
							break;
						}
						i++;
					}
					if (kulokey) {

						ps.print("331 Kullanici adi dogrulandi\r\n");

						continue;
					} else
						ps.print("332 Lutfen giris yapin\r\n");

				}
				if (gelenKomut.startsWith("PASS")) {
					if (gelenKomut.endsWith(kullanicilar[passi].getSifre())) {
						ps.print("230 Sifre dogrulandi giris tamam\r\n");
						li = true;
						continue;
					}
				}
				if (!li) {
					ps.print("550 Hata\r\n");
					continue;
				}
				if (gelenKomut.startsWith("PORT")) {
					sb.setLength(0);
					int j1 = 5;
					int k1 = 0;
					for (int l1 = 0; l1 < 4; l1++) {
						k1 = gelenKomut.indexOf(',', j1);
						sb.append(gelenKomut.substring(j1, k1));
						if (l1 != 3)
							sb.append('.');
						j1 = k1 + 1;
					}

					String s1 = sb.toString();
					k1 = gelenKomut.indexOf(',', j1);
					sb.setLength(0);
					sb.append(Integer.toHexString(Integer.parseInt(gelenKomut.substring(j1, k1))));
					k1++;
					sb.append(Integer.toHexString(Integer.parseInt(gelenKomut.substring(k1))));
					dataSocket = new Socket(s1, Integer.parseInt(sb.toString(), 16));
					ps.print("200 OK\r\n");
					continue;
				}
				if (gelenKomut.startsWith("PASV")) {
					sb.setLength(0);
					int k = getPort();
					sb.append(FTPGui.PA).append(k >>> 8 & 0xff).append(',');
					sb.append(k & 0xff).append(')').append("\r\n");
					ServerSocket serversocket = new ServerSocket(k, 10, ip);
					ps.print(sb.toString());
					dataSocket = serversocket.accept();
					continue;
				}
				if (gelenKomut.startsWith("LIST")) {
					ps.print("150 OK\r\n");
					PrintStream printstream = new PrintStream(dataSocket.getOutputStream());
					File afile[] = cd.listFiles();
					int i2 = afile.length;
					for (int j2 = 0; j2 < i2; j2++) {
						File file9 = afile[j2];
						sb.setLength(0);
						if (file9.isDirectory())
							sb.append("drwxr-xr-x   2 ikftp    server  ");
						else
							sb.append("-rw-r--r--   1 ikftp    server  ");
						String s2 = file9.isDirectory() ? "512" : String.valueOf(file9.length());
						int l = 9 - s2.length();
						for (int k2 = 0; k2 < l; k2++)
							sb.append(' ');

						sb.append(s2).append(' ');
						cal.setTimeInMillis(file9.lastModified());
						sb.append(aylar[cal.get(2)]).append(' ');
						String s3 = String.valueOf(cal.get(5));
						if (s3.length() == 1)
							sb.append('0');
						sb.append(s3).append(' ').append(' ');
						sb.append(String.valueOf(cal.get(1))).append(' ').append(file9.getName()).append("\r\n");
						printstream.print(sb.toString());
					}

					dataSocket.close();
					dataSocket = null;
					ps.print("226 OK\r\n");
					System.gc();
					continue;
				}
				if (gelenKomut.startsWith("STOR")) {
					File file = gf(5);
					if (ro || file == null || file.exists() && (file.isDirectory() || !file.canWrite())) {
						ps.print("550 Dosya y�kleme izniniz yok\r\n");
					} else {
						ps.print("150 OK\r\n");
						upload(cs(dataSocket.getInputStream(), new FileOutputStream(file)));
						dataSocket.close();
						dataSocket = null;
						ps.print("226 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("RETR")) {
					File file1 = gf(5);
					if (file1 == null || !file1.exists() || file1.isDirectory() || !file1.canRead()) {
						ps.print("550 Hata olu�tu\r\n");
					} else {
						ps.print("150 OK\r\n");
						download(cs(new FileInputStream(file1), dataSocket.getOutputStream()));
						dataSocket.close();
						dataSocket = null;
						ps.print("226 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("MKD")) {
					File file2 = gf(4);
					if (ro || file2 == null || file2.exists()) {
						ps.print("550 Klas�r olu�turmaya izniniz yok\r\n");
					} else {
						file2.mkdir();
						ps.print("257 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("CWD")) {
					File file3 = gf(4);
					if (file3 == null || !file3.exists() || !file3.isDirectory() || !file3.canRead()) {
						ps.print("550 Hata olu�tu\r\n");
					} else {
						cd = file3;
						pwd("250");
					}
					continue;
				}
				if (gelenKomut.startsWith("SIZE")) {
					File file4 = gf(5);
					if (file4 == null || !file4.exists() || file4.isDirectory() || !file4.canRead()) {
						ps.print("550 Hata olu�tu\r\n");
					} else {
						sb.setLength(0);
						sb.append("213 ").append(file4.length()).append("\r\n");
						ps.print(sb.toString());
					}
					continue;
				}
				if (gelenKomut.startsWith("CDUP")) {
					if (!cd.equals(kokKlasor))
						cd = cd.getParentFile();
					pwd("250");
					continue;
				}
				if (gelenKomut.startsWith("DELE")) {
					File file5 = gf(5);
					if (ro || file5 == null || !file5.exists() || file5.isDirectory() || !file5.canWrite()) {
						ps.print("550 Silmek i�in hakk�n�z yok\r\n");
					} else {
						file5.delete();
						ps.print("250 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("RMD")) {
					File file6 = gf(4);
					if (ro || file6 == null || !file6.exists() || !file6.isDirectory() || !file6.canWrite()
							|| file6.list().length != 0) {
						ps.print("550 Klas�r silmeye hakk�n�z yok\r\n");
					} else {
						file6.delete();
						ps.print("250 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("PWD")) {
					pwd("257");
					continue;
				}
				if (gelenKomut.startsWith("TYPE")) {
					ps.print("200 OK\r\n");
					continue;
				}
				if (gelenKomut.startsWith("RNFR")) {
					File file7 = gf(5);
					if (ro || file7 == null || !file7.exists() || !file7.canWrite()) {
						ps.print("550 Hata olu�tu\r\n");
						of = null;
					} else {
						of = file7;
						ps.print("350 \r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("RNTO")) {
					File file8 = gf(5);
					if (of == null || file8 == null || file8.exists()) {
						ps.print("550 Hata olu�tu\r\n");
						of = null;
					} else {
						of.renameTo(file8);
						of = null;
						ps.print("250 OK\r\n");
					}
					continue;
				}
				if (gelenKomut.startsWith("QUIT")) {
					ps.print("221 Bye.\r\n");
					break;
				}
				ps.print("550 Hata olu�tu\r\n");

			} while (true);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			try {
				if (dataSocket != null)
					dataSocket.close();
				if (s != null)
					s.close();
			} catch (Exception exception2) {
			}
			System.gc();
		}
	}

	File gf(int i) throws Exception {
		if (i >= gelenKomut.length())
			return null;
		String s1 = gelenKomut.substring(i);
		File file = (new File(s1.startsWith("/") ? kokKlasor : cd, s1)).getCanonicalFile();
		if (!file.getAbsolutePath().startsWith(kokYolu))
			return null;
		else
			return file;
	}

	void pwd(String s1) {
		String s2 = cd.getAbsolutePath();
		int i = s2.length();
		sb.setLength(0);
		sb.append(s1).append(" \"");
		if (i > kokUzunlugu)
			sb.append(s2.substring(kokUzunlugu).replace('\\', '/'));
		else
			sb.append('/');
		sb.append('"').append("\r\n");
		ps.print(sb.toString());
	}

	public int cs(InputStream inputstream, OutputStream outputstream) throws IOException {
		int i = 0;
		int j = 0;
		while ((i = inputstream.read(bf, 0, 512)) > -1) {
			j += i;
			outputstream.write(bf, 0, i);
		}
		inputstream.close();
		outputstream.close();
		return j;
	}

	static final String aylar[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };
	static long toplamUpload;
	static long toplamDownload;
	StringBuffer sb;
	byte bf[];
	static int pnum = 5000;
	boolean ro;
	String gelenKomut;
	Calendar cal;
	Socket s;
	Socket dataSocket;
	InetAddress ip;
	InputStreamReader okuyucu;
	PrintStream ps;
	File kokKlasor;
	String kokYolu;
	int kokUzunlugu;
	File cd;
	File of;
	boolean li;
	boolean kulokey;
	Users kullanicilar[];
	int passi = 0;
}
