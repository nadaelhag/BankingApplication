import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class CustomerInterface extends JFrame {
	public JLabel lblWelcomeToAbb;
	private JPanel panel1;
	public JTextField textField;

	
	public CustomerInterface(Customer customer) {
		super("Welcome");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);

		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 128, 128));
		panel1.setForeground(new Color(0, 128, 128));
		panel1.setBounds(new Rectangle(100, 100, 850, 600));
		panel1.setBounds(100, 100, 850, 600);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		
		lblWelcomeToAbb=new JLabel("Welcome to ABB Banking");
		lblWelcomeToAbb.setForeground(new Color(0, 0, 0));
		lblWelcomeToAbb.setBounds(273, 55, 650, 40);
		lblWelcomeToAbb.setFont(new Font("SansSerif", Font.BOLD, 27));
		panel1.add(lblWelcomeToAbb);
		
		JButton btn1 = new JButton("View Account Details");
		btn1.setBounds(300, 150, 250, 40);
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setPreferredSize(new Dimension(100, 55));
		btn1.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAccount v = new viewAccount(customer);
				v.setVisible(true);
				setVisible(false);
			}
		});
		
		
		JButton btn2 = new JButton("Transactions");
		btn2.setBounds(300, 250, 250, 40);
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setPreferredSize(new Dimension(100, 55));
		btn2.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionInterface t1=new TransactionInterface(customer);
				t1.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btn3 = new JButton("E-Statements");
		btn3.setBounds(300, 350, 250, 40);
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setPreferredSize(new Dimension(100, 55));
		btn3.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EStatementInterface e1=new EStatementInterface(customer);
				e1.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton exit = new JButton("Exit");
		exit.setBounds(300, 450, 250, 40);
		exit.setBackground(new Color(255, 255, 255));
		exit.setPreferredSize(new Dimension(100, 55));
		exit.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		textField = new JTextField();
		
		setContentPane(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel.setBounds(60, 476, 165, 57);
		panel1.add(lblNewLabel);
		setVisible(true);
	}
}
