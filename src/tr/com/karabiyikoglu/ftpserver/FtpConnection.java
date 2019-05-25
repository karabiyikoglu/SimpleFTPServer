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
	public FtpConnection(Users userArray[], Socket socket, InetAddress inetaddress) throws Exception {
		this.users = userArray;
		stringBuffer = new StringBuffer(256);
		dataBuffer = new byte[512];
		calendar = Calendar.getInstance();
		this.socket = socket;
		ip = inetaddress;
		loginOK = false;

		if (!FTPGui.isUnlimited())
			socket.setSoTimeout(FTPGui.getTimeOut());

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
		totalUpload += i;
		FTPGui.writeUploadedInfo(String.valueOf(totalUpload >> 10));
	}

	synchronized void download(int i) {
		totalDownload += i;
		FTPGui.witeDownloadedInfo(String.valueOf(totalDownload >> 10));
	}

	public void run() {
		ServerSocket dataServerSocket = null;
		try {
			inputStreamReader = new InputStreamReader(socket.getInputStream(), "ISO-8859-9");
			printStream = new PrintStream(socket.getOutputStream(), true, "ISO-8859-9");
			printStream.print("220 IK Ftp Server Hosgeldiniz .\r\n");
			
			
			boolean isCommandReceived;
			
			do {
				stringBuffer.setLength(0);
				isCommandReceived = true;
				do {
					int readAsciiValue = inputStreamReader.read();
					if (readAsciiValue <= 0) {
						if (stringBuffer.length() <= 0) {
							isCommandReceived = false;
						}
						break;
					}
					char readSingleChar = (char) readAsciiValue;
					if (readSingleChar == '\r') {
						inputStreamReader.skip(1L);
						break;
					}
					stringBuffer.append(readSingleChar);
				} while (true);
				
				if(!isCommandReceived) {
					break;
				}
				
				int j = stringBuffer.length();
				for (int i1 = j - 1; i1 >= 0 && stringBuffer.charAt(i1) == ' '; i1--) {
					stringBuffer.setLength(--j);
				}

				if (j == 0) {
					continue;
				}
				receivedCommand = stringBuffer.toString();
				
				System.out.println(receivedCommand);
				
				if (receivedCommand.startsWith("SYST")) {//Return system type.
					printStream.print("215 UNIX Type: L8\r\n");
					continue;
				}
				if (receivedCommand.startsWith("USER")) {//Authentication username.
					int i = 0;
					userOk = false;
					while (i < users.length) {
						if (receivedCommand.endsWith(users[i].getUsername())) {
							java.io.File ad = new java.io.File(users[i].getRootFolder());
							rootFolder = currentDirectory = ad;
							rootPath = ad.getCanonicalPath();
							rootLength = rootPath.length();
							readOnly = (!users[i].isWritePermission());
							userOk = true;
							passwordIndex = i;
							break;
						}
						i++;
					}
					if (userOk) {

						printStream.print("331 Username accepted\r\n");

					} else {
						printStream.print("332 Please login\r\n");
					}
					continue;

				}
				if (receivedCommand.startsWith("PASS")) {///Authentication password.
					if (receivedCommand.endsWith(users[passwordIndex].getPassword())) {
						printStream.print("230 Password accepted. Login OK\r\n");
						loginOK = true;
						continue;
					}
				}
				if (receivedCommand.startsWith("QUIT")) {///Disconnect
					printStream.print("221 Bye.\r\n");
					FTPGui.connectionList.remove(this);
					break;
				}
				if (!loginOK) {
					printStream.print("550 Error\r\n");
					System.out.println("550 Error");
					continue;
				}
				if (receivedCommand.startsWith("PORT")) {///Specifies an address and port to which the server should connect.
					stringBuffer.setLength(0);
					int j1 = 5;
					int k1 = 0;
					for (int l1 = 0; l1 < 4; l1++) {
						k1 = receivedCommand.indexOf(',', j1);
						stringBuffer.append(receivedCommand.substring(j1, k1));
						if (l1 != 3)
							stringBuffer.append('.');
						j1 = k1 + 1;
					}

					String s1 = stringBuffer.toString();
					k1 = receivedCommand.indexOf(',', j1);
					stringBuffer.setLength(0);
					stringBuffer.append(Integer.toHexString(Integer.parseInt(receivedCommand.substring(j1, k1))));
					k1++;
					stringBuffer.append(Integer.toHexString(Integer.parseInt(receivedCommand.substring(k1))));
					dataSocket = new Socket(s1, Integer.parseInt(stringBuffer.toString(), 16));
					printStream.print("200 OK\r\n");
					continue;
				}
				if (receivedCommand.startsWith("PASV")) {///Enter passive mode.
					stringBuffer.setLength(0);
					int dataPort = getPort();
					stringBuffer.append(FTPGui.PA).append(dataPort >>> 8 & 0xff).append(',');
					stringBuffer.append(dataPort & 0xff).append(')').append("\r\n");
					dataServerSocket = new ServerSocket(dataPort, 10, ip);
					printStream.print(stringBuffer.toString());
					dataSocket = dataServerSocket.accept();
					System.out.println(stringBuffer.toString());
					continue;
				}
				if (receivedCommand.startsWith("LIST")) {///Returns information of a file or directory if specified, else information of the current working directory is returned.
					printStream.print("150 OK\r\n");
					PrintStream printstream = new PrintStream(dataSocket.getOutputStream());
					File afile[] = currentDirectory.listFiles();
					int i2 = afile.length;
					for (int j2 = 0; j2 < i2; j2++) {
						File file9 = afile[j2];
						stringBuffer.setLength(0);
						if (file9.isDirectory())
							stringBuffer.append("drwxr-xr-x   2 ikftp    server  ");
						else
							stringBuffer.append("-rw-r--r--   1 ikftp    server  ");
						String s2 = file9.isDirectory() ? "512" : String.valueOf(file9.length());
						int l = 9 - s2.length();
						for (int k2 = 0; k2 < l; k2++)
							stringBuffer.append(' ');

						stringBuffer.append(s2).append(' ');
						calendar.setTimeInMillis(file9.lastModified());
						stringBuffer.append(months[calendar.get(2)]).append(' ');
						String s3 = String.valueOf(calendar.get(5));
						if (s3.length() == 1)
							stringBuffer.append('0');
						stringBuffer.append(s3).append(' ').append(' ');
						stringBuffer.append(String.valueOf(calendar.get(1))).append(' ').append(file9.getName()).append("\r\n");
						printstream.print(stringBuffer.toString());
					}

					dataSocket.close();
					dataSocket = null;
					printStream.print("226 OK\r\n");
					System.gc();
					continue;
				}
				if (receivedCommand.startsWith("STOR")) {///Accept the data and to store the data as a file at the server site
					File file = getFile(5);
					if (readOnly || file == null || file.exists() && (file.isDirectory() || !file.canWrite())) {
						printStream.print("550 You do not have permission to upload file\r\n");
					} else {
						printStream.print("150 OK\r\n");
						upload(cs(dataSocket.getInputStream(), new FileOutputStream(file)));
						dataSocket.close();
						dataSocket = null;
						printStream.print("226 OK\r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("RETR")) {///Retrieve a copy of the file
					File file1 = getFile(5);
					if (file1 == null || !file1.exists() || file1.isDirectory() || !file1.canRead()) {
						printStream.print("550 Error occured\r\n");
					} else {
						printStream.print("150 OK\r\n");
						download(cs(new FileInputStream(file1), dataSocket.getOutputStream()));
						dataSocket.close();
						dataSocket = null;
						printStream.print("226 OK\r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("MKD")) {//Make Directory
					File file2 = getFile(4);
					if (readOnly || file2 == null || file2.exists()) {
						printStream.print("550 You do not have permission to make directory\r\n");
					} else {
						file2.mkdir();
						printStream.print("257 OK\r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("CWD")) {//Change working directory.
					File file3 = getFile(4);
					if (file3 == null || !file3.exists() || !file3.isDirectory() || !file3.canRead()) {
						printStream.print("550 Error occured\r\n");
					} else {
						currentDirectory = file3;
						printWorkingDirectory("250");
					}
					continue;
				}
				if (receivedCommand.startsWith("SIZE")) {//Return the size of a file.
					File file4 = getFile(5);
					if (file4 == null || !file4.exists() || file4.isDirectory() || !file4.canRead()) {
						printStream.print("550 Error occured\r\n");
					} else {
						stringBuffer.setLength(0);
						stringBuffer.append("213 ").append(file4.length()).append("\r\n");
						System.out.println(stringBuffer.toString());
						printStream.print(stringBuffer.toString());
					}
					continue;
				}
				if (receivedCommand.startsWith("CDUP")) {///Change to Parent Directory.
					if (!currentDirectory.equals(rootFolder))
						currentDirectory = currentDirectory.getParentFile();
					printWorkingDirectory("250");
					continue;
				}
				if (receivedCommand.startsWith("DELE")) {//Delete file.
					File file5 = getFile(5);
					if (readOnly || file5 == null || !file5.exists() || file5.isDirectory() || !file5.canWrite()) {
						printStream.print("550 You do not have permission to delete\r\n");
					} else {
						file5.delete();
						printStream.print("250 OK\r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("RMD")) {//Remove a directory.
					File file6 = getFile(4);
					if (readOnly || file6 == null || !file6.exists() || !file6.isDirectory() || !file6.canWrite()
							|| file6.list().length != 0) {
						printStream.print("550 You do not have permission to delete\r\n");
					} else {
						file6.delete();
						printStream.print("250 OK\r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("PWD")) {///Print working directory. 
					printWorkingDirectory("257");
					continue;
				}
				if (receivedCommand.startsWith("TYPE")) {///Sets the transfer mode
					printStream.print("200 OK\r\n");
					continue;
				}
				if (receivedCommand.startsWith("RNFR")) { ///Rename From
					File file7 = getFile(5);
					if (readOnly || file7 == null || !file7.exists() || !file7.canWrite()) {
						printStream.print("550 Error occured\r\n");
						oldFile = null;
					} else {
						oldFile = file7;
						printStream.print("350 \r\n");
					}
					continue;
				}
				if (receivedCommand.startsWith("RNTO")) {///Rename To
					File file8 = getFile(5);
					if (oldFile == null || file8 == null || file8.exists()) {
						printStream.print("550 Error occured\r\n");
						oldFile = null;
					} else {
						oldFile.renameTo(file8);
						oldFile = null;
						printStream.print("250 OK\r\n");
					}
					continue;
				}
				printStream.print("550 Error occured\r\n");

			} while (true);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			try {
				if (dataSocket != null) {
					dataSocket.close();
				}
				if (socket != null) {
					socket.close();
				}
				if(dataServerSocket != null) {
					dataServerSocket.close();
				}
			} catch (Exception exception2) {
			}
			System.gc();
		}
	}

	File getFile(int i) throws Exception {
		if (i >= receivedCommand.length())
			return null;
		String requestedFileName = receivedCommand.substring(i);
		File file = (new File(requestedFileName.startsWith("/") ? rootFolder : currentDirectory, requestedFileName)).getCanonicalFile();
		if (!file.getAbsolutePath().startsWith(rootPath))
			return null;
		else
			return file;
	}

	void printWorkingDirectory(String s1) {
		String currentDirectoryAbsolutePath = currentDirectory.getAbsolutePath();
		int i = currentDirectoryAbsolutePath.length();
		stringBuffer.setLength(0);
		stringBuffer.append(s1).append(" \"");
		if (i > rootLength)
			stringBuffer.append(currentDirectoryAbsolutePath.substring(rootLength).replace('\\', '/'));
		else
			stringBuffer.append('/');
		stringBuffer.append('"').append("\r\n");
		printStream.print(stringBuffer.toString());
	}

	public int cs(InputStream inputstream, OutputStream outputstream) throws IOException {
		int i = 0;
		int j = 0;
		while ((i = inputstream.read(dataBuffer, 0, 512)) > -1) {
			j += i;
			outputstream.write(dataBuffer, 0, i);
		}
		inputstream.close();
		outputstream.close();
		return j;
	}
	
	public void stopConnection(){
		if(printStream != null) {
			printStream.close();
		}
		if(inputStreamReader != null) {
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(dataSocket != null) {
			try {
				dataSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static final String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec" };
	static long totalUpload;
	static long totalDownload;
	StringBuffer stringBuffer;
	byte dataBuffer[];
	static int pnum = 5000;
	boolean readOnly;
	String receivedCommand;
	Calendar calendar;
	Socket socket;
	Socket dataSocket;
	InetAddress ip;
	InputStreamReader inputStreamReader;
	PrintStream printStream;
	File rootFolder;
	String rootPath;
	int rootLength;
	File currentDirectory;
	File oldFile;
	boolean loginOK;
	boolean userOk;
	Users users[];
	int passwordIndex = 0;
}
