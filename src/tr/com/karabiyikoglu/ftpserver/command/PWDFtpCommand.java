package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;

public class PWDFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {

		if(isLogged(ftpConnection)) {
			ftpConnection.printWorkingDirectory("257");
		}
	}

}
