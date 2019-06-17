package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class CWDFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file3 = ftpConnection.getFile(4);
				if (file3 == null || !file3.exists() || !file3.isDirectory() || !file3.canRead()) {
					ftpConnection.sendResponseToClient("550 Error occured\r\n");
				} else {
					ftpConnection.currentDirectory = file3;
					ftpConnection.printWorkingDirectory("250");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
