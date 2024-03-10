import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Log_in extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accountNumField;
	private JPasswordField passwordField;
	private JPanel panel;
	private String bankerName = "banker";
	private String bankerPass = "banker1234";
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	JButton loginButton, registerButton;
	
	Banker banker = Banker.getInstance();
	BankerNotif bankerNotif =BankerNotif.getInstance();
	
		public Log_in() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 400, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 596, 0);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Account Number:");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 96, 206, 37);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(20, 164, 137, 37);
		contentPane.add(lblNewLabel_1);
		
		accountNumField = new JTextField();
		accountNumField.setFont(new Font("SansSerif", Font.PLAIN, 24));
		accountNumField.setBounds(236, 101, 322, 37);
		contentPane.add(accountNumField);
		accountNumField.setColumns(10);
		
		loginButton = new JButton("Log In");
		loginButton.setBorder(new LineBorder(new Color(0, 64, 64)));
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setFont(new Font("SansSerif", Font.BOLD, 24));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBounds(82, 232, 137, 53);
		contentPane.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 24));
		passwordField.setBounds(236, 163, 322, 37);
		contentPane.add(passwordField);

		
		lblNewLabel_2 = new JLabel("ABB Banking System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_2.setBounds(184, 36, 259, 42);
		contentPane.add(lblNewLabel_2);
		
		registerButton = new JButton("Register New User");
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setBorder(new LineBorder(new Color(0, 64, 64), 1, true));
		registerButton.setFont(new Font("SansSerif", Font.BOLD, 24));
		registerButton.setBounds(260, 232, 277, 53);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCustomer c;
				try {
				c = new NewCustomer();
				c.setVisible(true);
				setVisible(false);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		Login l = new Login();
		loginButton.addActionListener(l);
		accountNumField.setText("");
		passwordField.setText("");
	}
		private class Login implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String str = String.valueOf(passwordField.getPassword());
				if (accountNumField.getText().isEmpty() || str.length() == 0) {
					JOptionPane.showMessageDialog(null, "PLEASE DO NOT LEAVE ANY EMPTY FIELDS!", "", JOptionPane.ERROR_MESSAGE);
				}
				else if (accountNumField.getText().equals("banker") && str.equals("banker1234")) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully!", "", JOptionPane.PLAIN_MESSAGE);
					bankerNotif.setVisible(true);
					banker.setVisible(true);
					dispose();
				} 
				else{
					Files File1 = new Files();
					Customer customer = File1.searchClient(Integer.parseInt(accountNumField.getText()), Integer.parseInt(str));
					if (customer!=null) {
						JOptionPane.showMessageDialog(null, "You have logged in successfully!", "", JOptionPane.PLAIN_MESSAGE);
						new CustomerInterface(customer);
						new CountDownTimer();
						CustomerNotif customerNotif = new CustomerNotif(customer);
						customerNotif.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "User Not Found!", "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Log_in frame = new Log_in();
						frame.setVisible(true);}
					catch (Exception e) {
						e.printStackTrace();}
				}
				});
			}
}
