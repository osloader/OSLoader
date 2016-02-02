package org.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Constants {
	public static final double CLIENT_VERSION = 0.01;
	public static final double CLIENT_TEST = 0.01;
	public static String User;
	public static String Dev;
	
	public static final String VERSION_FILE = System.getProperty("user.home") + "/OSLoader/Version.txt";
	
	public static double getCurrentVersion(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(VERSION_FILE)));
			return Double.parseDouble(br.readLine());
		} catch (Exception e) {
			return 0.1;
		}
	}
	
	public static double version = getCurrentVersion();
	
	public static final String CLIENT_TITLE = "OSLoader";

	public static final int APPLET_WIDTH = 765;
	public static final int APPLET_HEIGHT = 503;
	
	public static final String HOME_PATH = (new File(System.getProperty("user.home")).exists() ? System.getProperty("user.home") : "/root") + "/OSLoader";

	public static String SITE_URL = "http://scarscripts.xyz/";
	
	public static String OSRS_HOME = "http://oldschool.runescape.com/oldschool_index";
	public static String OSRS_FORUM = "http://services.runescape.com/m=forum/forums.ws#group63";
	public static String OSRS_WIKI = "http://2007.runescape.wikia.com/wiki/2007scape_Wiki";
	
	public static String OSL_FORUM = "";
	public static String OSL_GITHUB = "https://github.com/osloader/OSLoader";
	public static String OSL_ISSUES = "https://github.com/osloader/OSLoader/issues";
	/**public static String = "";
	public static String = "";
	public static String = "";
	public static String = "";**/
	
	public static final int[] WORLDS = {301, 302, 303, 304, 305, 306, 308, 309, 310,
		311, 312, 313, 314, 316, 317, 318, 319, 320, 321, 322, 326, 327, 328, 329, 330,
		333, 334, 335, 336, 338, 341, 342, 343, 344, 346, 349, 350, 351,
		354, 358, 359, 360, 362, 365, 367, 368, 369, 370, 373, 374, 375, 376,
		377, 378, 386};
}
