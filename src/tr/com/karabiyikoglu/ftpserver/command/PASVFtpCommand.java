package tr.com.karabiyikoglu.ftpserver.command;

import java.io.IOException;
import java.net.ServerSocket;

import tr.com.karabiyikoglu.ftpserver.FTPGui;
import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class PASVFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		
		if (isLogged(ftpConnection)) {
			StringBuffer stringBuffer = new StringBuffer();
			int dataPort = ftpConnection.getPort();
			stringBuffer.append(FTPGui.PA).append(dataPort >>> 8 & 0xff).append(',');
			stringBuffer.append(dataPort & 0xff).append(')').append("\r\n");
			try {
				ftpConnection.dataServerSocket = new ServerSocket(dataPort, 10, ftpConnection.ip);
			} catch (IOException e) {
				ConsoleLogger.error(e.getMessage());
				e.printStackTrace();
			}
			ftpConnection.sendResponseToClient(stringBuffer.toString());
			try {
				ftpConnection.dataSocket = ftpConnection.dataServerSocket.accept();
			} catch (IOException e) {
				ConsoleLogger.error(e.getMessage());
				e.printStackTrace();
			}
			ConsoleLogger.info(stringBuffer.toString());
		}
	}

}
