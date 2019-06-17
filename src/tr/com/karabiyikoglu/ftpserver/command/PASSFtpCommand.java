package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;

public class PASSFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (ftpConnection.loggedUser != null && ftpConnection.receivedCommand.endsWith(ftpConnection.loggedUser.getPassword())) {
			ftpConnection.sendResponseToClient("230 Password accepted. Login OK\r\n");
			ftpConnection.loginOK = true;
		}else {
			ftpConnection.sendResponseToClient("336 Password Error\r\n");
		}
	}

}
