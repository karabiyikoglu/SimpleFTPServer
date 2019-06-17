package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;

public interface IFtpCommand {

	public void process(FtpConnection ftpConnection);
	
}
