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
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.client.Config;
import org.ui.hs.HiscoresForm;
import org.ui.map.MapFrame;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3147770371892729345L;
	private final Color color = new Color(92, 98, 106);
	private final Color colorDark = color.darker();

	private Buttons mapButton, linkButton, statsButton;
	private PopupMenu menu;
	private final Config config = Config.getInstance();

	public ButtonPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		menu = new PopupMenu();
		
		add(Box.createHorizontalGlue());
		linkButton = new Buttons("buttons/link24.png");
		linkButton.setButtonHoverIcon("buttons/link24_hover.png");
		linkButton.setToolTipText("Links to OSRS & OSL.");
		linkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JButton button = (JButton) e.getSource();
				menu.show(ButtonPanel.this, button.getX(), button.getY());
			}
		});
		
		add(linkButton);
		
		mapButton = new Buttons("buttons/map24.png");
		mapButton.setButtonHoverIcon("buttons/map24-hover.png");
		mapButton.setToolTipText("OSRS World Map.");
		mapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//JFrame map = new MapFrame();
					//map.setVisible(true);
				} catch (Exception e1)  {
				}
			}
		});
		
		add(mapButton);
		
		statsButton = new Buttons("buttons/stats24.png");
		statsButton.setButtonHoverIcon("buttons/stats24-hover.png");
		statsButton.setToolTipText("OSRS HiScore searcher.");
		statsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame hiscore = new HiscoresForm();
					hiscore.setVisible(true);
				} catch (Exception e1)  {
					
				}
			}
		});
		
		add(statsButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		final Graphics2D graphics2D = (Graphics2D) g;
		final GradientPaint gradient = new GradientPaint(getX(), getY(), colorDark, getWidth(), getY(), color);
		graphics2D.setPaint(gradient);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
