import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class viewAccount extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel1;

	public viewAccount(Customer customer) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 128, 128));
		panel1.setForeground(new Color(0, 128, 128));
		panel1.setBounds(new Rectangle(100, 100, 700, 500));
		panel1.setBounds(100, 100, 700, 500);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(panel1);
		panel1.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 836, 39);
		panel1.add(toolBar);
		
		JButton backtomenuButton = new JButton("Back To Main Menu");
		backtomenuButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		toolBar.add(backtomenuButton);
		backtomenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInterface ci=new CustomerInterface(customer);
				ci.setVisible(true);
				setVisible(false);
			}
			});
		
		JLabel accDetailsButton = new JLabel("Account Details");
		accDetailsButton.setHorizontalAlignment(SwingConstants.CENTER);
		accDetailsButton.setForeground(new Color(255, 255, 255));
		accDetailsButton.setFont(new Font("SansSerif", Font.PLAIN, 27));
		accDetailsButton.setBounds(296, 79, 197, 30);
		panel1.add(accDetailsButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 816, 399);
		panel1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 17));
		scrollPane.setViewportView(textArea);
		textArea.setText(customer.print());
		setVisible(true);
	}

}
