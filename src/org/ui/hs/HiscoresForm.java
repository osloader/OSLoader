package org.ui.hs;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import org.client.Config;
import org.ui.hs.VerticalFlowLayout;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Created by Kenneth on 6/15/2014.
 */
public class HiscoresForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###");

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdf asdf
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JLabel label3;
    private JCheckBox chckbxIronman;

    public HiscoresForm() {
        super("Player Stats Lookup");
        initComponents();
        setVisible(true);
    }

    private void btnActionEvent() {
        panel1.removeAll();
        HiscoresLookup lookup = new HiscoresLookup(textField1.getText(), !checkBox1.isSelected(), chckbxIronman.isSelected());
        label1.setText(textField1.getText());
        setTitle("Player Stats Lookup - " + textField1.getText());
        panel1.setLayout(new VerticalFlowLayout());
        for (Skill skill : lookup.getSkillMap().values()) {
            panel1.add(createSkillPanel(skill));
        }
        this.label2.setIcon(new ImageIcon(Utilities.downloadImage("http://services.runescape.com/m=avatar-rs/" + textField1.getText() + "/chat.png")));
        this.label2.repaint();
        this.label2.revalidate();

        this.label3.setIcon(new ImageIcon(Utilities.downloadImage("http://services.runescape.com/m=avatar-rs/" + textField1.getText() + "/ownclan.png")));
        this.label3.repaint();
        this.label3.revalidate();

        panel1.repaint();
        panel1.revalidate();
    }

    private JPanel createSkillPanel(Skill skill) {
        final JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBackground(Color.WHITE);
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        panel.setToolTipText("<html>Experience: " + decimalFormat.format(skill.getExperience()) + " <br>Rank: " + decimalFormat.format(skill.getRank()) + "</html>");
        label1.setIcon(new ImageIcon(Utilities.getImage(Utilities.getContentDirectory() + "resources/skills/" + skill.getSkillName() + ".png")));

        label2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label2.setText(skill.getSkillName());

        label3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label3.setForeground(Color.GRAY);
        label3.setText(skill.getLevel() == 1 ? "Unranked" : String.valueOf(skill.getLevel()));

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addContainerGap(78, Short.MAX_VALUE))
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        return panel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdf asdf
        textField1 = new JTextField();
        textField1.setBounds(59, 56, 113, 20);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnActionEvent();
                }
            }
        });
        checkBox1 = new JCheckBox();
        checkBox1.setBounds(10, 66, 71, 23);
        checkBox1.setSelected(true);
        label1 = new JLabel();
        label1.setBounds(141, 99, 100, 14);
        label2 = new JLabel();
        label2.setBounds(141, 119, 0, 0);
        JButton button1 = new JButton();
        button1.setBounds(59, 48, 113, 23);
        button1.addActionListener(listener -> btnActionEvent());
        panel1 = new JPanel();
        panel1.setBounds(10, 148, 549, 290);
        label3 = new JLabel();
        label3.setBounds(294, 11, 265, 126);

        //======== this ========
        Container contentPane = getContentPane();

        //---- checkBox1 ----
        checkBox1.setText("Oldschool");

        //---- label1 ----
        label1.setText("Username");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Tahoma", Font.BOLD, 11));

        //---- label2 ----
        label2.setIcon(new ImageIcon(Utilities.getImage(Utilities.getContentDirectory() + "resources/skills/chat head.png")));

        //---- button1 ----
        button1.setText("Search");

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new EtchedBorder());

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGap(0, 318, Short.MAX_VALUE)
            );
        }

        //---- label3 ----
        label3.setIcon(new ImageIcon(Utilities.getImage(Utilities.getContentDirectory() + "resources/skills/default banner.png")));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().setLayout(null);
        
        chckbxIronman = new JCheckBox();
        chckbxIronman.setBounds(10, 66, 97, 23);
        chckbxIronman.setText("Ironman?");
        getContentPane().add(chckbxIronman);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPaneLayout.setHorizontalGroup(
        	contentPaneLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(contentPaneLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(contentPaneLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        				.addGroup(contentPaneLayout.createSequentialGroup()
        					.addGroup(contentPaneLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(contentPaneLayout.createSequentialGroup()
        							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addGroup(contentPaneLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(label2)
        								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        						.addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
        					.addGap(53)
        					.addComponent(label3, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
        	contentPaneLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(contentPaneLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(contentPaneLayout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(contentPaneLayout.createSequentialGroup()
        					.addGroup(contentPaneLayout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(contentPaneLayout.createSequentialGroup()
        							.addComponent(label1)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(label2))
        						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED))
        				.addGroup(contentPaneLayout.createSequentialGroup()
        					.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(checkBox1)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(button1)
        					.addGap(28)))
        			.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        			.addGap(4))
        );
        contentPane.setLayout(contentPaneLayout);
        setSize(585, 480);
        this.setIconImages(Config.icons());
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}