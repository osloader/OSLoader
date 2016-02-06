package org.ui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.client.Config;
import org.client.Constants;
import org.client.loader.RSLoader;
import org.ui.menu.ButtonPanel;
import org.util.Utilities;

public class ClientFrame extends JFrame implements WindowListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5752868874839930988L;

    private final RSLoader loader;
    private final ButtonPanel buttonPanel;
    private Config configuration = Config.getInstance();
    private static String name = Constants.User.substring(0, 1).toUpperCase() + Constants.User.substring(1).toLowerCase();
	public ClientFrame() {

        super(Constants.CLIENT_TITLE + " - [" + Constants.Dev + " " + name + " ] Version: " + Constants.getCurrentVersion() + " Beta");

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.buttonPanel = new ButtonPanel();
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);;
        
        this.loader = new RSLoader(configuration);
        this.getContentPane().add(loader);

        final List<Image> icons = new ArrayList<Image>();
        icons.add(Constants.icon256);
        icons.add(Constants.icon128);
        icons.add(Constants.icon64);
        icons.add(Constants.icon32);
        icons.add(Constants.icon16);

        this.addWindowListener(this);
        this.setLocationRelativeTo(getParent());
        this.setIconImages(icons);
        this.pack();
        this.setLocationRelativeTo(getOwner());
    }


    public RSLoader loader() {
        return loader;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
