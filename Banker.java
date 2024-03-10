import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Banker extends JFrame {
    private JPanel panel1;
    private JTextField searchName;
    static JTable table;
    private JTextField searchAccNum;

    BankerNotif bn = BankerNotif.getInstance();
    private static Banker instance = null;


    private Banker() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 998, 593);
        panel1 = new JPanel();
        panel1.setBackground(new Color(0, 128, 128));
        panel1.setForeground(new Color(0, 128, 128));
        panel1.setBounds(new Rectangle(100, 100, 850, 600));
        panel1.setBounds(100, 100, 850, 600);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(10, 11, 964, 55);
        toolBar.setBackground(new Color(255, 255, 255));
        toolBar.setFloatable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 215, 964, 338);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnCount(10);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        scrollPane.setViewportView(table);
        setLocationRelativeTo(null);

        model.setColumnIdentifiers(new String[]{"Account #", "Pin", "Username", "Account Type", "Email", "Nationality", "Phone Number", "Date Of Birth", "Salary", "Balance"});
        table = new JTable(model);
        table.setModel(model);
        Files obj= new Files();
        String [][] data = obj.allApprovedAccount();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (String []str : data) {
            model.addRow(str);
        }

        JButton transactionButton = new JButton("Transaction History");
        transactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (searchAccNum.getText().isEmpty() || searchAccNum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a customer", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    Files obj= new Files();
                    if(!searchAccNum.getText().isEmpty()){
                        String[][] customer = obj.searchTransactions(Integer.parseInt(searchAccNum.getText()));
                        if (customer!=null){
                            new TransactionHistory(customer,getInstance());
                        }else {
                            JOptionPane.showMessageDialog(null, "No Transaction Found");
                        }
                        setVisible(false);
                    }}}
        });

		searchName = new JTextField();
		searchName.addKeyListener(new KeyAdapter() {
			public void search(String in) {
				Files obj= new Files();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
				String [][] data = obj.searchCustomerByName(searchName.getText());
				for (String []str : data) {
					model.addRow(str);
				}

			}

			public void keyReleased(KeyEvent e) {
				Files obj= new Files();
				String [][] data = obj.searchCustomerByName(searchName.getText());
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                for (String []str : data) {
					model.addRow(str);
				}
			}
		});

		searchAccNum = new JTextField();
		searchAccNum.setBounds(540, 130, 362, 34);
		panel1.add(searchAccNum);
		searchAccNum.setColumns(10);
		searchAccNum.addKeyListener(new KeyAdapter() {
			public void search(String in) {
				Files obj= new Files();
				String [][] data = obj.searchCustomerById(Integer.parseInt(searchAccNum.getText()));
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                for (String []str : data) {
					model.addRow(str);
				}
			}

			public void keyReleased(KeyEvent e) {
				Files obj= new Files();
				String [][] data = obj.searchCustomerById(Integer.parseInt(searchAccNum.getText()));
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
                for (String []str : data) {
					model.addRow(str);
				}
			}
		});

		searchName.setBounds(80, 129, 352, 34);
		searchName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		searchName.setColumns(10);
        transactionButton.setFont(new Font("SansSerif", Font.PLAIN, 22));
        transactionButton.setBackground(new Color(255, 255, 255));
        transactionButton.setPreferredSize(new Dimension(50, 55));

        toolBar.add(transactionButton);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(809, 215, 17, 55);
        setContentPane(panel1);
        panel1.setLayout(null);
        panel1.add(searchName);
        panel1.add(toolBar);
        panel1.add(scrollPane);
        panel1.add(scrollBar);

        JLabel lblNewLabel = new JLabel("Search for customer by name:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(70, 95, 362, 23);
        panel1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Search for customer by account number:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 19));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(540, 95, 362, 23);
        panel1.add(lblNewLabel_1);
    }

    public static int generatePin() {
        Random r = new Random();
        return r.nextInt(100000); }

    public static Banker getInstance() {
        if (instance == null)
            instance = new Banker();
        return instance;}}
