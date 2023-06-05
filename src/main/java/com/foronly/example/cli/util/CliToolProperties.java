package com.foronly.example.cli.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <p>
 *
 * </p>
 *
 * @author li_cang_long
 * @since 2023/5/17 9:02
 */
public class CliToolProperties {
	public static String get(String key) {
		return get().getProperty(key);
	}

	public static Properties get() {
		if (sProps == null) {
			loadProps();
		}
		return sProps;
	}

	private static void loadProps() {
		InputStream in = CliToolProperties.class.getResourceAsStream("/cli.properties");
		sProps = new Properties();
		try {
			sProps.load(in);
			in.close();
		} catch (IOException ex) {
			LOGGER.warning("Can't load properties.");
		}
	}

	private static Properties sProps;

	private static final Logger LOGGER = Logger.getLogger(CliToolProperties.class.getName());


}
