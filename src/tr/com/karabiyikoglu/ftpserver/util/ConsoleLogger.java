package tr.com.karabiyikoglu.ftpserver.util;

public class ConsoleLogger {
	
	private enum EnumLogMode{
		INFO,DEBUG,ERROR
	}
	
	private static EnumLogMode logMode;
	
	static {
		logMode = EnumLogMode.INFO;
	}
	
	private ConsoleLogger() {
	}
	
	public static void info(String text) {
		if(logMode == EnumLogMode.INFO) {
			System.out.println(text);
		}
	}
	
	public static void debug(String text) {
		if(logMode == EnumLogMode.INFO || logMode == EnumLogMode.DEBUG) {
			System.out.println(text);
		}
	}
	
	public static void error(String text) {
		System.err.println(text);
	}
	
}
