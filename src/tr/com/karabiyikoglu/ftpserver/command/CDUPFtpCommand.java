package tr.com.karabiyikoglu.ftpserver.command;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class CDUPFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				if (!ftpConnection.currentDirectory.equals(ftpConnection.rootFolder)) {
					ftpConnection.currentDirectory = ftpConnection.currentDirectory.getParentFile();
				}
				ftpConnection.printWorkingDirectory("250");
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
