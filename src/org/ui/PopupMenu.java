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
	private final JCheckBoxMenuItem smartBreak, gameObjects, npcs, groundItems, players, inventory, gameState, playerLocation, mouseLocation, floor, mapBase, camera, menu, displayfps;
	private final JMenuItem settings, widgets, console, accounts, creator;
	private final Config config = Config.getInstance();

	public PopupMenu() {
		view = new JMenu("View");

		gameState = new JCheckBoxMenuItem("Game State");
		gameState.addActionListener(this);

		playerLocation = new JCheckBoxMenuItem("Player Location");
		playerLocation.addActionListener(this);

		mouseLocation = new JCheckBoxMenuItem("Mouse Location");
		mouseLocation.addActionListener(this);

		floor = new JCheckBoxMenuItem("Floor");
		floor.addActionListener(this);

		mapBase = new JCheckBoxMenuItem("Map base");
		mapBase.addActionListener(this);

		camera = new JCheckBoxMenuItem("Camera");
		camera.addActionListener(this);

		menu = new JCheckBoxMenuItem("Menu");
		menu.addActionListener(this);

		players = new JCheckBoxMenuItem("Players");
		players.addActionListener(this);

		npcs = new JCheckBoxMenuItem("NPCs");
		npcs.addActionListener(this);

		displayfps = new JCheckBoxMenuItem("Display FPS");
		displayfps.addActionListener(this);

		smartBreak = new JCheckBoxMenuItem("Smart Break");
		smartBreak.addActionListener(this);
		smartBreak.setSelected(true);

		console = new JMenuItem("Display Console");
		console.addActionListener(this);

		inventory = new JCheckBoxMenuItem("Inventory");
		inventory.addActionListener(this);

		groundItems = new JCheckBoxMenuItem("Ground Items");
		groundItems.addActionListener(this);

		gameObjects = new JCheckBoxMenuItem("GameObjects");
		gameObjects.addActionListener(this);

		settings = new JMenuItem("Settings Explorer");
		settings.addActionListener(this);

		widgets = new JMenuItem("Widget Explorer");
		widgets.addActionListener(this);

		accounts = new JMenuItem("Account Manager");
		accounts.addActionListener(this);


		creator = new JMenuItem("Account Creator");
		creator.addActionListener(this);

		view.add(displayfps);
		view.add(gameState);
		view.add(playerLocation);
		view.add(mouseLocation);
		view.add(floor);
		view.add(mapBase);
		view.add(camera);
		view.add(menu);
		add(new JSeparator());
		view.add(inventory);
		view.add(players);
		view.add(gameObjects);
		view.add(npcs);
		view.add(groundItems);

		add(view);
		add(new JSeparator());
		add(settings);
		add(widgets);
		add(accounts);
		add(creator);
		add(new JSeparator());
		add(smartBreak);
		add(console);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**if (e.getSource() == canvas) {
			config.drawCanvas(!config);
		} else if (e.getSource() == mouse) {
			config.drawMouse(!config);
		}**/
	}
}