package org.client.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.nikkii.alertify4j.Alertify;
import org.nikkii.alertify4j.AlertifyBuilder;
import org.nikkii.alertify4j.AlertifyType;
import org.util.NetUtil;


public class Parameters {

	private static final Map<String, String> PARAMETER_MAP = new HashMap<>();
	private static final String PARAMETER_BASE_URL = "runescape.com/l=0/jav_config.ws";

	/**
	 * Creates a new instance of the parameters class.
	 *
	 * @param worldId the world you wish to load into
	 */
	public Parameters(final int worldId) {
		parse(worldId);
	}

	public void parse(final int worldId) {
		try {
			final URLConnection connection = NetUtil.createURLConnection("http://oldschool" + worldId + "." + PARAMETER_BASE_URL);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			PARAMETER_MAP.clear();

			String input;
			try {
				while ((input = reader.readLine()) != null) {
					if (input.contains("=")) {
						input = input.replaceAll("param=", "");
						final String[] parts = input.split("=");
						if (parts.length == 1) {
							add(parts[0], "");
						} else if (parts.length == 2) {
							add(parts[0], parts[1]);
						} else if (parts.length == 3) {
							add(parts[0], parts[1] + "=" + parts[2]);
						} else if (parts.length == 4) {
							add(parts[0], parts[1] + "=" + parts[2] + "=" + parts[3]);
						}
					}
				}

				reader.close();
			} catch (IOException exception) {
				exception.printStackTrace();
				String[] options = new String[]{"OK"};
				JOptionPane.showOptionDialog(null,
						"Please check your internet connection and restar the client!", "Error loading data",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			}
		} catch (Exception e) {
			Alertify.show(new AlertifyBuilder()
		    .type(AlertifyType.ERROR)
		    .text("Cannot connect to RS Servers.")
		    .autoClose(5000)
		.build());
		}
	}

	/**
	 * Stores the given data in the Parameter map if it does not already exist.
	 *
	 * @param key The identification key
	 * @param val The parameter data
	 */
	private void add(String key, String val) {
		PARAMETER_MAP.put(key, val);
	}

	/**
	 * Returns the value based on the key. If the key isn't found, it returns a blank string.
	 *
	 * @param key
	 * @return the retrieved parameter
	 */
	public String get(String key) {
		return PARAMETER_MAP.containsKey(key) ? PARAMETER_MAP.get(key) : "";
	}
}
