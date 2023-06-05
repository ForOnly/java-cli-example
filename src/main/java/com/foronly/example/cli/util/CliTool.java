package com.foronly.example.cli.util;

/**
 * <p>
 *
 * </p>
 *
 * @author li_cang_long
 * @since 2023/5/17 9:07
 */
public class CliTool {
	public static String getVersion() {
		return CliToolProperties.get("application.version");
	}
}
