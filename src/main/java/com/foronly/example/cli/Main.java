package com.foronly.example.cli;


import com.foronly.example.cli.util.CliTool;
import com.foronly.example.cli.util.OSDetection;
import org.apache.commons.cli.*;

/**
 * <p>
 *	cli 主类
 * </p>
 *
 * @author li_cang_long
 * @since 2023/5/17 8:31
 */
public class Main {
	public static void main(String[] args) {

		// headless
		System.setProperty("java.awt.headless", "true");

		// cli parser
		CommandLineParser parser = new DefaultParser();
		CommandLine       commandLine;

		// load options
		_Options();

		try {
			commandLine = parser.parse(allOptions, args, false);

			if (!OSDetection.is64Bit()) {
				System.err.println("32 bit support is deprecated. Apktool will not support 32bit on v3.0.0.");
			}
		} catch (ParseException ex) {
			System.err.println(ex.getMessage());
			usage();
			System.exit(1);
			return;
		}
		boolean cmdFound = false;

		// if no commands ran, run the version / usage check.
		if (!cmdFound) {
			if (commandLine.hasOption("version")) {
				_version();
			} else {
				// usage();
				_version();
			}
		}
		System.exit(0);
	}

	private final static Options allOptions;

	private final static Options normalOptions;

	static {
		normalOptions = new Options();
		allOptions    = new Options();
	}

	private static void _Options() {
		// create options
		Option versionOption = Option.builder("version")
									 .longOpt("version")
									 .desc("prints the version then exits")
									 .build();

		// add global options
		normalOptions.addOption(versionOption);

		// add all, loop existing cats then manually add advance
		for (Option op : normalOptions.getOptions()) {
			allOptions.addOption(op);
		}
	}

	private static void usage() {


	}

	private static void _version() {
		System.out.println(CliTool.getVersion());
	}
}
