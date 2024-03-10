import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class EStatementInterface extends JFrame {
	//private static final long serialVersionUID = 1L;
	public JLabel label;
	private JPanel panel1;
	public JTextField textField;

	
	public EStatementInterface(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 128, 128));
		panel1.setForeground(new Color(0, 128, 128));
		panel1.setBounds(new Rectangle(100, 100, 850, 600));
		panel1.setBounds(100, 100, 850, 600);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		

		textField = new JTextField();
		
		label=new JLabel("E-Statements");
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(205, 64, 461, 34);
		label.setFont(new Font("SansSerif", Font.PLAIN, 27));
		Files File1 = new Files();

		String row[][]= File1.searchTransactions(customer.getAccountNumber());
		String column[]={"Transaction Type","Sender","Receiver","Amount","Date"};
		JTable table =new JTable(row,column);
		table.setBounds(20,120,800,300);
		JScrollPane scroll =new JScrollPane(table);
		scroll.setBounds(20,120,800,400);


		setContentPane(panel1);
		panel1.setLayout(null);
		panel1.add(label);
		panel1.add(scroll);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 836, 35);
		panel1.add(toolBar);

		JButton btnNewButton = new JButton("Back To Main Menu");
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		toolBar.add(btnNewButton);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInterface c1=new CustomerInterface(customer);
				c1.setVisible(true);
				setVisible(false);
			}
		});
		setVisible(true);


	}

}
