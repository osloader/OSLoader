package org.client;
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
}
