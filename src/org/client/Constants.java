package org.client;

import java.io.File;


public class Constants {
	public static final double CLIENT_VERSION = 0.01;
	public static final double CLIENT_TEST = 0.01;
	public static String User;
	public static String Dev;
	
	public static final String CLIENT_TITLE = "OSLoader";

	public static final int APPLET_WIDTH = 765;
	public static final int APPLET_HEIGHT = 503;
	
	public static final String HOME_PATH = (new File(System.getProperty("user.home")).exists() ? System.getProperty("user.home") : "/root") + "/OSLoader";

	public static String SITE_URL = "http://scarscripts.xyz/";
	
	public static final int[] WORLDS = {301, 302, 303, 304, 305, 306, 308, 309, 310,
		311, 312, 313, 314, 316, 317, 318, 319, 320, 321, 322, 326, 327, 328, 329, 330,
		333, 334, 335, 336, 338, 341, 342, 343, 344, 346, 349, 350, 351,
		354, 358, 359, 360, 362, 365, 367, 368, 369, 370, 373, 374, 375, 376,
		377, 378, 386};
}
