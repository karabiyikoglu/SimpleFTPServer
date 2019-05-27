package tr.com.karabiyikoglu.ftpserver.enums;

public enum EnumFTPCommand {
	
	///These are not all the ftp commands
	
	SYST,	//Return system type.
	USER,	//Authentication username.
	PASS,	//Authentication password.
	QUIT,	//Disconnect
	PORT,	//Specifies an address and port to which the server should connect.
	PASV,	//Enter passive mode.
	LIST,	//Returns information of a file or directory if specified, else information of the current working directory is returned.
	STOR,	//Accept the data and to store the data as a file at the server site
	RETR,	//Retrieve a copy of the file
	MKD,	//Make Directory
	CWD,	//Change working directory.
	SIZE,	//Return the size of a file.
	CDUP,	//Change to Parent Directory.
	DELE,	//Delete file.
	RMD,	//Remove a directory.
	PWD,	//Print working directory. 
	TYPE, 	//Sets the transfer mo
	RNFR, 	//Rename From
	RNTO;  	//Rename To
	
	public static EnumFTPCommand findFTPCommand(String commandStr) {
		for(EnumFTPCommand command : EnumFTPCommand.values()) {
			if(commandStr.startsWith(command.name())) {
				return command;
			}
		}
		return null;
	}
}
