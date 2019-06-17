package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class RMDFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file6 = ftpConnection.getFile(4);
				if (ftpConnection.readOnly || file6 == null || !file6.exists() || !file6.isDirectory() || !file6.canWrite()
						|| file6.list().length != 0) {
					ftpConnection.sendResponseToClient("550 You do not have permission to delete\r\n");
				} else {
					file6.delete();
					ftpConnection.sendResponseToClient("250 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
