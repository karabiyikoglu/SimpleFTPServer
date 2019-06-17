package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.IConstants;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class LISTFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		
		if (isLogged(ftpConnection)) {
			StringBuffer stringBuffer = new StringBuffer();
			ftpConnection.sendResponseToClient("150 OK\r\n");
			PrintStream printDataStream = null;
			try {
				printDataStream = new PrintStream(ftpConnection.dataSocket.getOutputStream());
			} catch (IOException e1) {
				ConsoleLogger.error(e1.getMessage());
				e1.printStackTrace();
			}
			File afile[] = ftpConnection.currentDirectory.listFiles();
			int i2 = afile.length;
			Calendar calendar = Calendar.getInstance();
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
				stringBuffer.append(IConstants.months[calendar.get(2)]).append(' ');
				String s3 = String.valueOf(calendar.get(5));
				if (s3.length() == 1)
					stringBuffer.append('0');
				stringBuffer.append(s3).append(' ').append(' ');
				stringBuffer.append(String.valueOf(calendar.get(1))).append(' ').append(file9.getName()).append("\r\n");
				ftpConnection.sendResponseToClient(printDataStream, stringBuffer.toString());
			}
			printDataStream.close();
			try {
				ftpConnection.dataSocket.close();
			} catch (IOException e) {
				ConsoleLogger.error(e.getMessage());
				e.printStackTrace();
			}
			ftpConnection.dataSocket = null;
			ftpConnection.sendResponseToClient("226 OK\r\n");
			System.gc();///WHY
		}
	}

}
