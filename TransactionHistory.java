import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class TransactionHistory extends JFrame {
	private JPanel panel1;
	
	public TransactionHistory(String addToRow[][],JFrame view) {
		super("Transaction History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 128, 128));
		panel1.setForeground(new Color(0, 128, 128));
		panel1.setBounds(new Rectangle(100, 100, 850, 600));
		panel1.setBounds(100, 100, 850, 600);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(panel1);
		panel1.setLayout(null);
		setSize(800, 550);
		String row[][]= addToRow;
		String column[]={"Transaction Type","Sender","Receiver","Amount","Date"};
		JTable table =new JTable(row,column);
		table.setBounds(30,40,200,300);
		JScrollPane scroll =new JScrollPane(table);
		scroll.setBounds(30,40,700,400);
		JButton btnClose = new JButton("Go Back");
		btnClose.setBounds(350, 450, 100, 30);
		add(scroll);
		add(btnClose);
		setLayout(null);
		setVisible(true);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				view.setVisible(true);
			}
		});
	}

}
