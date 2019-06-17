package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class TYPEFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				ftpConnection.sendResponseToClient("200 OK\r\n");
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
