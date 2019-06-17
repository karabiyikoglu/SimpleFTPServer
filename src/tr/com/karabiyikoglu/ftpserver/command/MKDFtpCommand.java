package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class MKDFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file2 = ftpConnection.getFile(4);
				if (ftpConnection.readOnly || file2 == null || file2.exists()) {
					ftpConnection.sendResponseToClient("550 You do not have permission to make directory\r\n");
				} else {
					file2.mkdir();
					ftpConnection.sendResponseToClient("257 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
