package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.ActiveFtpConnections;
import tr.com.karabiyikoglu.ftpserver.FtpConnection;

public class QUITFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		ftpConnection.sendResponseToClient("221 Bye.\r\n");
		ActiveFtpConnections.removeConnection(ftpConnection);
		ftpConnection.quitMessageReceived = true;
	}

}
