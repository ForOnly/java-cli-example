package com.foronly.example.cli.util;

/**
 * <p>
 *
 * </p>
 *
 * @author li_cang_long
 * @since 2023/5/17 8:56
 */
public class OSDetection {
	private static final String OS  = System.getProperty("os.name").toLowerCase();

	private static final String BIT = System.getProperty("sun.arch.data.model").toLowerCase();

	public static boolean isWindows() {
		return (OS.contains("win"));
	}

	public static boolean isMacOSX() {
		return (OS.contains("mac"));
	}

	public static boolean isUnix() {
		return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix") || (OS.contains("sunos")));
	}

	public static boolean is64Bit() {
		if (isWindows()) {
			String arch      = System.getenv("PROCESSOR_ARCHITECTURE");
			String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");

			return arch != null && arch.endsWith("64") || wow64Arch != null && wow64Arch.endsWith("64");
		}
		return BIT.equalsIgnoreCase("64");
	}

	public static String returnOS() {
		return OS;
	}
}
