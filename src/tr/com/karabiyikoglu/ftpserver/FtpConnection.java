package tr.com.karabiyikoglu.ftpserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import tr.com.karabiyikoglu.ftpserver.command.FtpCommandHelper;
import tr.com.karabiyikoglu.ftpserver.enums.EnumFTPCommand;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class FtpConnection implements Runnable {
	
	public FtpConnection(List<User> userList, Socket socket, InetAddress inetaddress,int timeout) throws Exception {
		this.users = userList;
		stringBuffer = new StringBuffer(256);
		dataBuffer = new byte[512];
		this.socket = socket;
		ip = inetaddress;
		loginOK = false;

		if (timeout > 0) {
			socket.setSoTimeout(timeout);
		}

	}

	public synchronized int getPort() {
		pnum++;
		if (pnum == 9200)
			pnum += 10;
		if (pnum == 65500)
			pnum = 5000;
		return pnum;
	}

	public synchronized void upload(int i) {
		totalUpload += i;
		FTPGui.writeUploadedInfo(String.valueOf(totalUpload >> 10));
	}

	public synchronized void download(int i) {
		totalDownload += i;
		FTPGui.witeDownloadedInfo(String.valueOf(totalDownload >> 10));
	}

	public void run() {
		try {
			inputStreamReader = new InputStreamReader(socket.getInputStream(), IConstants.CHARACTER_ENCODING);
			printStream = new PrintStream(socket.getOutputStream(), IConstants.AUTO_FLUSH, IConstants.CHARACTER_ENCODING);
			sendResponseToClient(IConstants.FTP_WELCOME_MESSAGE);
			
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
				
				ConsoleLogger.info(receivedCommand);
				
				EnumFTPCommand ftpCommand = EnumFTPCommand.findFTPCommand(receivedCommand);
				
				try {
					FtpCommandHelper.getFtpCommand(ftpCommand).process(this);
					if(quitMessageReceived) {
						break;
					}
					continue;
				} catch (Exception e) {
					ConsoleLogger.error(e.getMessage());
				}
				sendResponseToClient("550 Error occured\r\n");

			} while (true);
		} catch (Exception exception) {
			ConsoleLogger.error(exception.getMessage());
		} finally {
			closeSockets();
		}
	}

	private void closeSockets() {
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
	}

	public File getFile(int i) throws Exception {
		if (i >= receivedCommand.length())
			return null;
		String requestedFileName = receivedCommand.substring(i);
		File file = (new File(requestedFileName.startsWith("/") ? rootFolder : currentDirectory, requestedFileName)).getCanonicalFile();
		if (!file.getAbsolutePath().startsWith(rootPath))
			return null;
		else
			return file;
	}

	public void printWorkingDirectory(String s1) {
		String currentDirectoryAbsolutePath = currentDirectory.getAbsolutePath();
		int i = currentDirectoryAbsolutePath.length();
		stringBuffer.setLength(0);
		stringBuffer.append(s1).append(" \"");
		if (i > rootLength)
			stringBuffer.append(currentDirectoryAbsolutePath.substring(rootLength).replace('\\', '/'));
		else
			stringBuffer.append('/');
		stringBuffer.append('"').append("\r\n");
		sendResponseToClient(stringBuffer.toString());
	}
	
	public void sendResponseToClient(String response) {
		sendResponseToClient(printStream,response);
	}
	
	public void sendResponseToClient(PrintStream prntStream,String response) {
		ConsoleLogger.error(response);
		prntStream.print(response);
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

	static long totalUpload;
	static long totalDownload;
	StringBuffer stringBuffer;
	byte dataBuffer[];
	static int pnum = 5000;
	public boolean readOnly;
	public String receivedCommand;
	Socket socket;
	public Socket dataSocket;
	public InetAddress ip;
	InputStreamReader inputStreamReader;
	PrintStream printStream;
	public File rootFolder;
	public String rootPath;
	public int rootLength;
	public File currentDirectory;
	public File oldFile;
	public boolean loginOK;
	public boolean userOk;
	public List<User> users;
	public User loggedUser = null;
	public boolean quitMessageReceived = false;
	public ServerSocket dataServerSocket = null;
}
