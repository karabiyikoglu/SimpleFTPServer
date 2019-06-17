package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public abstract class AbstractFtpCommand implements IFtpCommand {

	protected boolean isLogged(FtpConnection ftpConnection) {
		if (!ftpConnection.loginOK) {
			ftpConnection.sendResponseToClient("550 Error\r\n");
			ConsoleLogger.info("550 Error");
			return false;
		}
		return true;
	}

}
