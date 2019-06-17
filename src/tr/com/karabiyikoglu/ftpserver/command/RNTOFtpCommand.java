package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class RNTOFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file8 = ftpConnection.getFile(5);
				if (ftpConnection.oldFile == null || file8 == null || file8.exists()) {
					ftpConnection.sendResponseToClient("550 Error occured\r\n");
					ftpConnection.oldFile = null;
				} else {
					ftpConnection.oldFile.renameTo(file8);
					ftpConnection.oldFile = null;
					ftpConnection.sendResponseToClient("250 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
