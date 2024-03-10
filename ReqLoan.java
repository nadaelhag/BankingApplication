import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReqLoan extends JFrame {

	private JPanel contentPane;

	public ReqLoan(Customer customer) {
		setTitle("Loan Request");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField moneyField = new JTextField();
		moneyField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		moneyField.setBounds(294, 133, 265, 41);
		contentPane.add(moneyField);
		moneyField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionInterface t1=new TransactionInterface(customer);
				t1.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount of money you would like to loan");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(183, 63, 532, 49);
		contentPane.add(lblNewLabel_1);
		
		
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.setBounds(183, 245, 102, 41);
		contentPane.add(btnNewButton);
		
		JCheckBox check = new JCheckBox("I agree to the Terms and Conditions of availing a loan and I understand that I might not be able to recieve one if I am deemed uneligible by the bank");
		check.setFont(new Font("SansSerif", Font.PLAIN, 12));
		check.setHorizontalAlignment(SwingConstants.RIGHT);
		check.setBounds(6, 370, 835, 66);
		contentPane.add(check);
		
		JButton btnNewButton_1 = new JButton("Confim");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (moneyField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please do not leave any empty fields","",JOptionPane.ERROR_MESSAGE);}
				else if (moneyField.getText().isEmpty()==false && check.isSelected()==false )
				{
					JOptionPane.showMessageDialog(null, "Please agree to the Terms and Conditions","",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					int response=JOptionPane.showConfirmDialog(null, "Do you want to Continue with this Transaction?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						double moneysent=Double.parseDouble(moneyField.getText());
						Files file1 = new Files();
						Loan loan = new Loan(customer.getAccountNumber(),moneysent);
						file1.loanRequest(loan);
						TransactionInterface t1=new TransactionInterface(customer);
						t1.setVisible(true);
						setVisible(false);
					}
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton_1.setBounds(571, 245, 102, 41);
		contentPane.add(btnNewButton_1);
	}
}
