import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Payment extends JFrame {

	private JPanel contentPane;
	public Payment(Customer customer,String payment) {
		setTitle(payment+" Payment");
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
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 194, 357, 67);
		contentPane.add(lblNewLabel);
		
		JTextField moneyTransfer = new JTextField();
		moneyTransfer.setBounds(191, 272, 265, 41);
		contentPane.add(moneyTransfer);
		moneyTransfer.setColumns(10);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Enter the number of the "+payment);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 50, 383, 49);
		contentPane.add(lblNewLabel_1);
		
		JTextField accountNum = new JTextField();
		accountNum.setBounds(191, 122, 265, 41);
		contentPane.add(accountNum);
		accountNum.setColumns(10);
		
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(143, 361, 97, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confim");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moneyTransfer.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter an amount", "", JOptionPane.ERROR_MESSAGE);
				} else if(Integer.parseInt(moneyTransfer.getText())>customer.getBalance()){
					JOptionPane.showMessageDialog(null, "Your Balance is not enough for this transaction", "", JOptionPane.ERROR_MESSAGE);
				} else {
					int response=JOptionPane.showConfirmDialog(null, "Do you want to continue with this Transaction?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						Files File1 = new Files();
						double transfer =Double.parseDouble(moneyTransfer.getText());
						Customer c = File1.searchClient(Integer.parseInt(accountNum.getText()));
						if (payment.equals("Account")){
							if(c!= null && c.getPhoneNumber().equals(customer.getPhoneNumber()) && c.getEmail().equals(customer.getEmail())){
								File1.updateBalance(customer.getAccountNumber(),transfer,"minus");
								Transaction transaction = new Transaction(payment,customer.getAccountNumber(),accountNum.getText(),transfer);
								File1.transactions(transaction.toString());
								File1.updateBalance(c.getAccountNumber(),transfer,"add");
								TransactionInterface t1=new TransactionInterface(customer);
								t1.setVisible(true);
								setVisible(false);
							}else{
								JOptionPane.showMessageDialog(null, "Please Enter Your Account number ", "", JOptionPane.ERROR_MESSAGE);
							}
						}else if(payment.equals("Another Account")) {
							File1.updateBalance(customer.getAccountNumber(),transfer,"minus");
							File1.updateBalance(c.getAccountNumber(),transfer,"add");
							Transaction transaction = new Transaction(payment,customer.getAccountNumber(),accountNum.getText(),transfer);
							File1.transactions(transaction.toString());
							TransactionInterface t1=new TransactionInterface(customer);
							t1.setVisible(true);
							setVisible(false);
						}else{
							File1.updateBalance(customer.getAccountNumber(),transfer,"minus");
							Transaction transaction = new Transaction(payment,customer.getAccountNumber(),accountNum.getText(),transfer);
							File1.transactions(transaction.toString());
							TransactionInterface t1=new TransactionInterface(customer);
							t1.setVisible(true);
							setVisible(false);

						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton_1.setBounds(424, 361, 97, 35);
		contentPane.add(btnNewButton_1);
	}
}
