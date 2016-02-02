package org.web;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import org.client.Constants;
import org.client.Keys;
import org.nikkii.alertify4j.Alertify;
import org.nikkii.alertify4j.AlertifyBuilder;
import org.nikkii.alertify4j.AlertifyType;
import org.util.NetUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.pack();
					frame.setSize(450, 260);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(265, 62, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setLabelFor(textField);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsername.setBounds(265, 37, 122, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(265, 92, 122, 14);
		contentPane.add(lblPassword);
		

		
		passwordField = new JPasswordField();
		lblPassword.setLabelFor(passwordField);
		passwordField.setBounds(265, 117, 144, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(265, 182, 144, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText().replaceAll(" ", "%20");
                String password = new String(passwordField.getPassword());
                if (!attemptLogin(username, password)) {
                	Alertify.show(new AlertifyBuilder()
                    .type(AlertifyType.ERROR)
                    .text("Login Failed. Try Again.")
                    .autoClose(3000)
                .build());
                } else {
                    dispose();
                }
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLogin.setBounds(265, 151, 144, 20);
		contentPane.add(btnLogin);
		
	}
	
    private boolean attemptLogin(String username, String password) {
        final String raw = NetUtil.readPage(org.client.Constants.SITE_URL + "/client/login.php?crypt=" + Keys.CRYPT + "&name=" + username.replaceAll(" ", "%20").replaceAll("\0", "") + "&pass=" + password)[0];
        if (raw.contains("FAILED") || raw.isEmpty()) {
            return false;
        } else if (raw.contains("TRUE4")) {
        	Constants.User = textField.getText();
        	Constants.Dev = "Developer";
            return true;
        } else if(raw.substring(0, 4).contains("TRUE")){
        	Constants.User = textField.getText();
        	Constants.Dev = "";
        	return true;
        }
		return false;
    }
}
