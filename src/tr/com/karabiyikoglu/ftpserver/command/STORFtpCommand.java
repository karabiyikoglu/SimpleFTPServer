package tr.com.karabiyikoglu.ftpserver.command;

import java.io.File;
import java.io.FileOutputStream;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class STORFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		if (isLogged(ftpConnection)) {
			try {
				File file = ftpConnection.getFile(5);
				if (ftpConnection.readOnly || file == null || file.exists() && (file.isDirectory() || !file.canWrite())) {
					ftpConnection.sendResponseToClient("550 You do not have permission to upload file\r\n");
				} else {
					ftpConnection.sendResponseToClient("150 OK\r\n");
					ftpConnection.upload(ftpConnection.cs(ftpConnection.dataSocket.getInputStream(), new FileOutputStream(file)));
					ftpConnection.dataSocket.close();
					ftpConnection.dataSocket = null;
					ftpConnection.sendResponseToClient("226 OK\r\n");
				}
			} catch (Exception e) {
				ConsoleLogger.error(e.getMessage());
			}
			
		}
	}
}
