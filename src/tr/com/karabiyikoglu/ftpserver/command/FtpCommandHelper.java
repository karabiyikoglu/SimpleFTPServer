package tr.com.karabiyikoglu.ftpserver.command;

import java.util.HashMap;
import java.util.Map;

import tr.com.karabiyikoglu.ftpserver.enums.EnumFTPCommand;

public class FtpCommandHelper {
	
	private static  Map<EnumFTPCommand, IFtpCommand> ftpCommandMap = new HashMap<>();
	
	static {
		ftpCommandMap.put(EnumFTPCommand.SYST, new SYSTFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.USER, new USERFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.PASS, new PASSFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.QUIT, new QUITFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.PORT, new PORTFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.LIST, new LISTFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.PASV, new PASVFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.PWD,  new PWDFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.STOR, new STORFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.RETR, new RETRFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.MKD,  new MKDFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.CWD,  new CWDFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.SIZE, new SIZEFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.CDUP, new CDUPFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.DELE, new DELEFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.RMD,  new RMDFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.TYPE, new TYPEFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.RNFR, new RNFRFtpCommand());
		ftpCommandMap.put(EnumFTPCommand.RNTO, new RNTOFtpCommand());
	}
	
	public static IFtpCommand getFtpCommand(EnumFTPCommand ftpCommand) {
		return ftpCommandMap.get(ftpCommand);
	}
}
