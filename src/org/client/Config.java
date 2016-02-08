package org.client;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.ui.ClientFrame;

public class Config {
	private ClientFrame clientframe;
	
	private static Config instance = new Config();
	
	public static Config getInstance() {
		return instance;
	}
	
	public ClientFrame getclientFrame() {
		if (clientframe == null)
			System.out.println("Client Frame isn't set!");
		return clientframe;
	}

	public void setclientFrame(ClientFrame clientframe) {
		this.clientframe = clientframe;
	}
	
	public static List<Image> icons(){
		
        final List<Image> icons = new ArrayList<Image>();
        icons.add(Constants.icon256);
        icons.add(Constants.icon128);
        icons.add(Constants.icon64);
        icons.add(Constants.icon32);
        icons.add(Constants.icon16);
        
		return icons;
	}
}
