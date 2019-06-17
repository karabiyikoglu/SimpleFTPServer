package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class RNFRFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file7 = ftpConnection.getFile(5);
				if (ftpConnection.readOnly || file7 == null || !file7.exists() || !file7.canWrite()) {
					ftpConnection.sendResponseToClient("550 Error occured\r\n");
					ftpConnection.oldFile = null;
				} else {
					ftpConnection.oldFile = file7;
					ftpConnection.sendResponseToClient("350 \r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
