package org;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.client.Config;
import org.ui.ClientFrame;
import org.util.Utilities;
import org.util.Condition;
import org.util.Time;
import org.web.LoginFrame;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class Main {
	
	public Main(){
		
		final Config config = Config.getInstance();
		
		LoginFrame login = new LoginFrame();
		login.pack();
		login.setSize(450, 260);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		login.setVisible(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				login.setVisible(true);
			}
		}).start();
		
		Time.sleep(new Condition() {
			@Override
			public boolean active() {
				return !login.isVisible();
			}
		}, 2000); // to help people with slower computers.
		
		while (login.isVisible()) {
			Utilities.sleep(200, 300);
		} //TODO When OSLoader website is bought re-add forum login
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run(){
				config.setclientFrame(new ClientFrame());
				config.getclientFrame().setVisible(true);
			}
		});
	}

	public static void main(String[] args)  {
		try { 
		    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (Exception e) {
		    e.printStackTrace();
		}

		JPopupMenu.setDefaultLightWeightPopupEnabled(true);
		
		new Main();
	}

}
