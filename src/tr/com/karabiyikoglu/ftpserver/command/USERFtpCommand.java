package tr.com.karabiyikoglu.ftpserver.command;

import java.io.IOException;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.User;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class USERFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		ftpConnection.userOk = false;
		ftpConnection.loggedUser = null;
		for(User user : ftpConnection.users) {
			if(ftpConnection.receivedCommand.endsWith(user.getUsername())) {
				java.io.File ad = new java.io.File(user.getRootFolder());
				ftpConnection.rootFolder = ftpConnection.currentDirectory = ad;
				try {
					ftpConnection.rootPath = ad.getCanonicalPath();
				} catch (IOException e) {
					ConsoleLogger.error(e.getMessage());
				}
				ftpConnection.rootLength = ftpConnection.rootPath.length();
				ftpConnection.readOnly = (!user.isWritePermission());
				ftpConnection.userOk = true;
				ftpConnection.loggedUser = user;
				break;
			}
		}
		
		
		if (ftpConnection.userOk) {

			ftpConnection.sendResponseToClient("331 Username accepted\r\n");

		} else {
			ftpConnection.sendResponseToClient("332 Please login\r\n");
		}
	}

}
