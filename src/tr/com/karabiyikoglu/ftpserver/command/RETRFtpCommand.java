package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;
import java.io.FileInputStream;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class RETRFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file1 = ftpConnection.getFile(5);
				if (file1 == null || !file1.exists() || file1.isDirectory() || !file1.canRead()) {
					ftpConnection.sendResponseToClient("550 Error occured\r\n");
				} else {
					ftpConnection.sendResponseToClient("150 OK\r\n");
					ftpConnection.download(ftpConnection.cs(new FileInputStream(file1), ftpConnection.dataSocket.getOutputStream()));
					ftpConnection.dataSocket.close();
					ftpConnection.dataSocket = null;
					ftpConnection.sendResponseToClient("226 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
