package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class SIZEFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file4 = ftpConnection.getFile(5);
				if (file4 == null || !file4.exists() || file4.isDirectory() || !file4.canRead()) {
					ftpConnection.sendResponseToClient("550 Error occured\r\n");
				} else {
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.append("213 ").append(file4.length()).append("\r\n");
					ConsoleLogger.info(stringBuffer.toString());
					ftpConnection.sendResponseToClient(stringBuffer.toString());
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
