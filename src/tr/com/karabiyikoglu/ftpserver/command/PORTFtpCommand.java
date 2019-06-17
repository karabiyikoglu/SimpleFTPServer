package tr.com.karabiyikoglu.ftpserver.command;

import java.io.IOException;
import java.net.Socket;

import tr.com.karabiyikoglu.ftpserver.FtpConnection;
import tr.com.karabiyikoglu.ftpserver.util.ConsoleLogger;

public class PORTFtpCommand extends AbstractFtpCommand {

	@Override
	public void process(FtpConnection ftpConnection) {
		
		if (isLogged(ftpConnection)) {
			StringBuffer stringBuffer = new StringBuffer();
			int j1 = 5;
			int k1 = 0;
			for (int l1 = 0; l1 < 4; l1++) {
				k1 = ftpConnection.receivedCommand.indexOf(',', j1);
				stringBuffer.append(ftpConnection.receivedCommand.substring(j1, k1));
				if (l1 != 3)
					stringBuffer.append('.');
				j1 = k1 + 1;
			}

			String s1 = stringBuffer.toString();
			k1 = ftpConnection.receivedCommand.indexOf(',', j1);
			stringBuffer.setLength(0);
			stringBuffer.append(Integer.toHexString(Integer.parseInt(ftpConnection.receivedCommand.substring(j1, k1))));
			k1++;
			stringBuffer.append(Integer.toHexString(Integer.parseInt(ftpConnection.receivedCommand.substring(k1))));
			try {
				ftpConnection.dataSocket = new Socket(s1, Integer.parseInt(stringBuffer.toString(), 16));
			} catch (NumberFormatException | IOException e) {
				ConsoleLogger.error(e.getMessage());
				e.printStackTrace();
			}
			ftpConnection.sendResponseToClient("200 OK\r\n");
		}
	}

}
