package org.client.loader;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JPanel;

import org.client.Config;
import org.client.Constants;
import org.util.FileDownloader;
import org.util.Random;
import org.util.Utilities;

public class RSLoader extends JPanel implements AppletStub {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8902296630509146560L;
	private boolean isAppletLoaded = false;
	private final Font font = new Font("Calibri", Font.PLAIN, 15);


	private ClassLoader classLoader;
	private FileDownloader downloader;
	@SuppressWarnings("unused")
	private Applet applet;
	private static Class<?> clientClass;
	private static Object client;
	
	private final Parameters params;

	public RSLoader(final Config configuration) {
		this.setLayout(new BorderLayout());
		params = new Parameters(Constants.WORLDS[Random.nextInt(0, Constants.WORLDS.length)] - 300);
		setPreferredSize(new Dimension(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT));

		if (Constants.CLIENT_TEST <= Constants.CLIENT_VERSION) {
			final Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					
					downloader = new FileDownloader(params.get("codebase") + params.get("initial_jar"),
							Utilities.getContentDirectory() + "game/os-gamepack.jar");
					downloader.run();

					final File jar = new File(Utilities.getContentDirectory() + "game/os-gamepack.jar");
					
					try{
						String loaderURL = "" + jar.toURI().toURL();
						classLoader = new URLClassLoader(new URL[] { new URL(loaderURL) });
						clientClass = classLoader.loadClass("client");
						client = clientClass.newInstance();
					}catch (Exception e){
						System.out.println(e);
					}
					Applet applet = (Applet) (client);
					applet.setStub(RSLoader.this);
					applet.setPreferredSize(new Dimension(763, 504));
					applet.init();
					applet.start();
					isAppletLoaded = true;
					RSLoader.this.add(applet, BorderLayout.CENTER);
					RSLoader.this.revalidate();

					while (applet.getComponents().length == 0) {
						Utilities.sleep(1000, 1500);
					}

				}
			});
			thread.start();
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void paintComponent(Graphics graphics) {
		if (!isAppletLoaded) {
			final Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			graphics2D.setColor(Color.BLACK);
			graphics2D.fillRect(0, 0, getWidth(), getHeight());
			graphics2D.setFont(font);

			if (Constants.CLIENT_TEST > Constants.CLIENT_VERSION) {
				graphics.setColor(Color.GREEN.darker());
				graphics2D.drawString("There is Newer Version for the client , Please download it from ", 150, 280);
			} else {
				if (downloader != null || downloader.isFinished()) {
					final int width = downloader.getPercentage() * 300 / 100;

					graphics.setColor(Color.GREEN.darker());
					graphics2D.fillRect(225, 200, width, 45);
					graphics.setColor(Color.GREEN.darker());
					graphics2D.drawRect(225, 200, 300, 45);

					graphics2D.setColor(Color.WHITE);
					graphics2D.drawString("Downloading gamepack - " + downloader.getPercentage() + "%", 285, 230);
				}
				graphics.setColor(Color.GREEN.darker());
				graphics2D.drawString("OSLoader is loading, please wait!", 285, 480);
			}
			repaint(600);
		}
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL(params.get("codebase"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getParameter(String name) {
		return params.get(name);
	}


	@Override
	public AppletContext getAppletContext() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
	@Override
	public void appletResize(int width, int height) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
	
}
