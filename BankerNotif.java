import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BankerNotif extends JFrame {
	private static final long serialVersionUID = 1L;
	private static volatile BankerNotif instance=null;
	private JPanel contentPane;
	static JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	private BankerNotif() {
		
		setTitle("Notifications");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 10, 707, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 698, 170);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setBackground(new Color(231, 20, 63));
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(new String[] {"Account Number", "Request", "Status"});
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		scrollPane.setViewportView(table);
		Files obj= new Files();
		ArrayList<Customer> customers= obj.getNotifications();
		ArrayList<Loan> loans = obj.searchLoansPendingRequest();
		String [][] str = new String[customers.size()+loans.size()][3];
		for (int i = 0; i < customers.size(); i++) {
			str[i][0] = ""+customers.get(i).getAccountNumber();
			str[i][1] = "New Account";
			str[i][2] = "Pending";
			model.addRow(str[i]);
		}
		for (int i = 0; i < loans.size(); i++) {
			if(loans.get(i).getStatus().equals("pending")){
				str[i][0] = ""+loans.get(i).getAccountNumber();
				str[i][1] = loans.get(i).getRequest();
				str[i][2] = loans.get(i).getStatus();
				model.addRow(str[i]);
			}
		}
		table.setModel(model);


		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable)e.getSource();
					int row = table.getSelectedRow();
					int column = target.getSelectedColumn();
					Files obj = new Files();
					System.out.println(row);
					if((""+model.getValueAt(row,1)).equals("New Account")){
						Customer customer = obj.searchClient(Integer.parseInt(""+model.getValueAt(row,0)));
						viewAccount view = new viewAccount(customer);
						view.setVisible(true);
					}
				}
			}
		});
		ListSelectionModel listSel=table.getSelectionModel();

		btnNewButton =new JButton("Accept Request");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please Select A Customer","",JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int index=table.getSelectedRow();
					int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to accept the request?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						String request = String.valueOf(model.getValueAt(index,1));
						if (request.equals("New Account")){
							int accountNumber = Integer.parseInt(""+ model.getValueAt(index,0));
							Files obj = new Files();
							obj.updateStatus(accountNumber,true);
							model.setValueAt("Accepted",index,2);
						}else{
							Files obj = new Files();
							int accountNumber = Integer.parseInt(""+ model.getValueAt(index,0));
							String r = (String) model.getValueAt(index,1);

							for (int i = 0; i < loans.size(); i++) {
								if(loans.get(i).getAccountNumber()== accountNumber && loans.get(i).getRequest().equals(r)){
									loans.get(i).setStatus("Accepted");
									obj.updateBalance(loans.get(i).getAccountNumber(),loans.get(i).getAmount(),"add");
								}
							}
							obj.updateLoan(loans);
							model.setValueAt("Accepted",index,2);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(108, 198, 167, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Reject Request");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please Select A Customer","",JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int index=table.getSelectedRow();
					int response=JOptionPane.showConfirmDialog(null, "Are you sure you want to reject the request?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION)
					{
						String request = String.valueOf(model.getValueAt(index,1));
						if (request.equals("New Account")){
							int accountNumber = Integer.parseInt(""+ model.getValueAt(index,0));
							Files obj = new Files();
							obj.updateStatus(accountNumber,false);
							model.setValueAt("Rejected",index,2);
						}else{
							Files obj = new Files();
							int accountNumber = Integer.parseInt(""+ model.getValueAt(index,0));
							String r = (String) model.getValueAt(index,1);

							for (int i = 0; i < loans.size(); i++) {
								if(loans.get(i).getAccountNumber()== accountNumber && loans.get(i).getRequest().equals(r)){
									loans.get(i).setStatus("Rejected");
								}
							}
							obj.updateLoan(loans);
							model.setValueAt("Rejected",index,2);
						}
					}

				}
			}
			
		});
		btnNewButton_1.setBounds(383, 198, 167, 23);
		contentPane.add(btnNewButton_1);
		
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (isSelected) {
                    setBackground(Color.WHITE);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
		
	}
	public static BankerNotif getInstance()
	{
		if (instance==null)
		{
			synchronized(BankerNotif.class) {
				if(instance==null)
					instance=new BankerNotif();
			}
			
		}
		return instance;
	}

}
