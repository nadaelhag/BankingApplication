import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UniFees extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField accNumTextField;

	public UniFees(Customer customer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the amount you would like to pay");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 23));
		lblNewLabel.setBounds(124, 194, 432, 67);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setBounds(163, 263, 293, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionInterface t1=new TransactionInterface(customer);
				t1.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Name of the University");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(153, 11, 383, 49);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_1.setBounds(163, 60, 293, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(143, 361, 98, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confim");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter an amount", "", JOptionPane.ERROR_MESSAGE);
				} else if(Integer.parseInt(textField.getText())>customer.getBalance()){
					JOptionPane.showMessageDialog(null, "Your Balance is not enough for this transaction", "", JOptionPane.ERROR_MESSAGE);
				} else {
					int response=JOptionPane.showConfirmDialog(null, "Do you want to continue with this Transaction?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						Files File1 = new Files();
						double amt=Double.parseDouble(textField.getText());
						Customer c = File1.searchClient(Integer.parseInt(accNumTextField.getText()));
						File1.updateBalance(customer.getAccountNumber(),amt,"minus");
						File1.updateBalance(c.getAccountNumber(),amt,"add");
						Transaction transaction = new Transaction("University",customer.getAccountNumber(),textField_1.getText(),amt);
						File1.transactions(transaction.toString());
						TransactionInterface t1=new TransactionInterface(customer);
						t1.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton_1.setBounds(434, 361, 102, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter account number:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(191, 113, 265, 30);
		contentPane.add(lblNewLabel_2);
		
		accNumTextField = new JTextField();
		accNumTextField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		accNumTextField.setBounds(163, 154, 293, 41);
		contentPane.add(accNumTextField);
		accNumTextField.setColumns(10);
		
		
	}
}
