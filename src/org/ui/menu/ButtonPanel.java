package org.ui.menu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.client.Config;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3147770371892729345L;
	private final Color color = new Color(92, 98, 106);
	private final Color colorDark = color.darker();

	private Buttons settingsButton;
	private PopupMenu menu;
	private final Config config = Config.getInstance();

	public ButtonPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		menu = new PopupMenu();
		
		add(Box.createHorizontalGlue());
		settingsButton = new Buttons("link24.png");
		settingsButton.setButtonHoverIcon("link24_hover.png");
		settingsButton.setToolTipText("Links to OSRS & OSL.");
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JButton button = (JButton) e.getSource();
				menu.show(ButtonPanel.this, button.getX(), button.getY());
			}
		});
		
		add(settingsButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		final Graphics2D graphics2D = (Graphics2D) g;
		final GradientPaint gradient = new GradientPaint(getX(), getY(), colorDark, getWidth(), getY(), color);
		graphics2D.setPaint(gradient);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
