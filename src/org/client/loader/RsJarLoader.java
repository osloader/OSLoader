package org.client.loader;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class RsJarLoader {


	private Hashtable<String, byte[]> entries;
	private Hashtable<String, Class<?>> classes;
	private URL gamepackUrl;
	private RsJarLoader classLoader = null;

	public RsJarLoader(URL url) {
		gamepackUrl = url;
		entries = new Hashtable<>();
		classes = new Hashtable<>();
		loadJar();
	}


	public Hashtable<String, Class<?>> classes() {
		return classes;
	}

	private void loadJar() {
		try {
			JarInputStream jis = new JarInputStream(gamepackUrl.openStream());
			JarEntry entry;
			while ((entry = jis.getNextJarEntry()) != null) {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] data = new byte[1024];
				int read;
				while ((read = jis.read(data, 0, 1024)) > 0) {
					bos.write(data, 0, read);
				}


				entries.put(entry.getName().replace(".class", ""), bos.toByteArray());
				int percent = (entries.size() * 100) / 201;
				bos.close();
			}
			jis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Class<?> loadClass(final String className) throws ClassNotFoundException {
		if (classLoader == null) {
			System.out.println("Error Null Class Loader");
			return null;
		}
		if(!classLoader.classes().containsKey(className)){
			return classLoader.loadClass(className);
		}
		return classLoader.classes().get(className);
	}
}
