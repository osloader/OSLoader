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

public class PopupMenu  extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5639231076995913638L;
	private final JMenu view;
	private final JCheckBoxMenuItem  inventory;
	//private final JMenuItem ;
	private final Config config = Config.getInstance();

	public PopupMenu() {
		view = new JMenu("View");

		inventory = new JCheckBoxMenuItem("Inventory");
		inventory.addActionListener(this);
		
		add(new JSeparator());
		view.add(inventory);

		add(view);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}