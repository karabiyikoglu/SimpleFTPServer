package tr.com.karabiyikoglu.ftpserver;

import java.util.ArrayList;
import java.util.List;

public class ActiveFtpConnections {
	
	public static List<FtpConnection> connectionList;
	
	static {
		connectionList = new ArrayList<>();
	}
	
	public static synchronized void addConnection(FtpConnection ftpConn) {
		connectionList.add(ftpConn);
	}
	
	public static synchronized void removeConnection(FtpConnection ftpConn) {
		connectionList.remove(ftpConn);
	}
	
	public synchronized static void stopAll() {
		for(FtpConnection ftpConnection : connectionList) {
			ftpConnection.stopConnection();
		}
		connectionList.removeAll(connectionList);
	}
}
