package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;

public class SYSTFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		ftpConnection.sendResponseToClient("215 UNIX Type: L8\r\n");
	}

}
