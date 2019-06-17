package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class DELEFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file5 = ftpConnection.getFile(5);
				if (ftpConnection.readOnly || file5 == null || !file5.exists() || file5.isDirectory() || !file5.canWrite()) {
					ftpConnection.sendResponseToClient("550 You do not have permission to delete\r\n");
				} else {
					file5.delete();
					ftpConnection.sendResponseToClient("250 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
