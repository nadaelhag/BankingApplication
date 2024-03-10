
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class UtilityPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField accNumTextField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	public UtilityPayment(Customer customer) {
		setTitle("Utility Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Amount you would like to pay");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 194, 357, 67);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField.setBounds(191, 255, 265, 41);
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
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Name of the Utility Service");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 21, 383, 49);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textField_1.setBounds(191, 69, 265, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton.setBounds(143, 361, 97, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confim");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter an amount","",JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int response=JOptionPane.showConfirmDialog(null, "Do you want to Continue with this Transaction?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						Files File1 = new Files();
						double amt=Double.parseDouble(textField.getText());
						Customer c = File1.searchClient(Integer.parseInt(accNumTextField.getText()));
						File1.updateBalance(customer.getAccountNumber(),amt,"minus");
						File1.updateBalance(c.getAccountNumber(),amt,"add");
						Transaction transaction = new Transaction("Utility",customer.getAccountNumber(),textField_1.getText(),amt);
						File1.transactions(transaction.toString());
						TransactionInterface t1=new TransactionInterface(customer);
						t1.setVisible(true);
						setVisible(false);
						
					}
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnNewButton_1.setBounds(424, 361, 97, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter account number:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(219, 121, 208, 35);
		contentPane.add(lblNewLabel_2);
		
		accNumTextField = new JTextField();
		accNumTextField.setFont(new Font("SansSerif", Font.PLAIN, 13));
		accNumTextField.setBounds(191, 160, 265, 41);
		contentPane.add(accNumTextField);
		accNumTextField.setColumns(10);
	}
}
