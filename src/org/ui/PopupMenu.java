package org.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import org.client.Config;
import org.client.Constants;

public class PopupMenu  extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5639231076995913638L;
	private final JMenu oslinks, osllinks;
	private final JCheckBoxMenuItem  osrsforums, osrshome, oslforums, oslgithub, oslissues;
	//private final JMenuItem ;
	private final Config config = Config.getInstance();

	public PopupMenu() {
		oslinks = new JMenu("OSRS Links");
		osllinks = new JMenu("OSLoader Links");

		osrsforums = new JCheckBoxMenuItem("OSRS Forums");
		osrsforums.addActionListener(this);
		
		osrshome = new JCheckBoxMenuItem("OSRS Homepage");
		osrshome.addActionListener(this);
		
		oslinks.add(osrshome);
		oslinks.add(osrsforums);
		
		add(oslinks);
		
		oslforums = new JCheckBoxMenuItem("OSLoader Forums");
		oslforums.addActionListener(this);
		
		oslgithub = new JCheckBoxMenuItem("OSLoader Github");
		oslgithub.addActionListener(this);
		
		oslissues = new JCheckBoxMenuItem("Report a bug");
		oslissues.addActionListener(this);
		
		osllinks.add(oslforums);
		osllinks.add(oslgithub);
		osllinks.add(oslissues);
		
		add(osllinks);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == osrshome) {
			try{
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(Constants.OSRS_HOME));
			}catch (Exception e1){
				System.out.println(e1);
			}
		} else if (e.getSource() == osrsforums) {
			try{
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(Constants.OSRS_FORUM));
			}catch (Exception e1){
				System.out.println(e1);
			}
		} else if (e.getSource() == oslforums){
			try{
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(Constants.OSL_FORUM));
			}catch (Exception e1){
				System.out.println(e1);
			}
		} else if (e.getSource() == oslgithub){
			try{
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(Constants.OSL_GITHUB));
			}catch (Exception e1){
				System.out.println(e1);
			}
		} else if (e.getSource() == oslissues){
			try{
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(Constants.OSL_ISSUES));
			}catch (Exception e1){
				System.out.println(e1);
			}
		}
	}
}