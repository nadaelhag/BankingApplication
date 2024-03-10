import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class TransactionInterface extends JFrame {
	public JLabel label;
	private JPanel panel1;
	public JTextField textField;
	
	public TransactionInterface(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 128, 128));
		panel1.setForeground(new Color(0, 128, 128));
		panel1.setBounds(new Rectangle(100, 100, 850, 600));
		panel1.setBounds(100, 100, 850, 600);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		label=new JLabel("Please Select A Service:");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(271, 62, 650, 40);
		label.setFont(new Font("SansSerif", Font.PLAIN, 27));
		panel1.add(label);
		
		JButton btn1 = new JButton("Utility Payment");
		btn1.setBounds(100, 150, 300, 40);
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setPreferredSize(new Dimension(100, 55));
		btn1.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtilityPayment u1 = new UtilityPayment(customer);
				u1.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btn2 = new JButton("University Fees Payment");
		btn2.setBounds(100, 250, 300, 40);
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setPreferredSize(new Dimension(100, 55));
		btn2.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UniFees u2=new UniFees(customer);
				u2.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btn3 = new JButton("Tranfer to Own Account");
		btn3.setBounds(100, 350, 300, 40);
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setPreferredSize(new Dimension(100, 55));
		btn3.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment u1=new Payment(customer,"Account");
				u1.setVisible(true);
				setVisible(false);
			}
		});

		JButton btn4 = new JButton("Tranfer to Another Account");
		btn4.setBounds(450, 150, 300, 40);
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setPreferredSize(new Dimension(100, 55));
		btn4.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment u1=new Payment(customer,"Another Account");
				u1.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btn5 = new JButton("Request A Loan");
		btn5.setBounds(450, 250, 300, 40);
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setPreferredSize(new Dimension(100, 55));
		btn5.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(btn5);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReqLoan r1=new ReqLoan(customer);
				r1.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton goback = new JButton("Go back to Main Menu");
		goback.setBounds(450, 350, 300, 40);
		goback.setBackground(new Color(255, 255, 255));
		goback.setPreferredSize(new Dimension(100, 55));
		goback.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel1.add(goback);	
		
		setContentPane(panel1);
		panel1.setLayout(null);
		panel1.add(label);
		
		goback.addActionListener(e -> {
			CustomerInterface c1=new CustomerInterface(customer);
			c1.setVisible(true);
			setVisible(false);
		});

	}
}
