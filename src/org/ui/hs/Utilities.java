package org.ui.hs;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class Utilities {
    public static String downloadString(String url, boolean splitLines) throws IOException {
        final URLConnection connection = new URL(url).openConnection();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        final StringBuilder builder = new StringBuilder();

        String input;
        while ((input = reader.readLine()) != null) {
            builder.append(input).append(splitLines ? "\n" : "");
        }

        return builder.toString();
    }
    

    public static Image downloadImage(String link) {
        Image image;
        URL url;
        try {
            url = new URL(link);
            image = ImageIO.read(url);
        } catch (IOException ex) {
            return null;
        }
        return image;
    }
    
    public static String getContentDirectory() {
        return System.getProperty("user.home") + File.separator + "OSLoader" + File.separator;
    }
    
    public static Image getImage(String file) {
        return Toolkit.getDefaultToolkit().createImage(file);
    }
}
