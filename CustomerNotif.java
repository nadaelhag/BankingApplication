import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.Font;

public class CustomerNotif extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable table;

	public CustomerNotif(Customer customer) {
		setTitle("Notifications");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 10, 623, 235);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 614, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(231, 20, 63));
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);
		model.setColumnIdentifiers(new String[] {"Request","Amount", "Status"});
		model.setColumnCount(3);
		Files obj = new Files();
		String [][] str = obj.getCustomerNotifications(customer);
		for (String[] strings : str) {
			model.addRow(strings);
		}

		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		scrollPane.setViewportView(table);
		
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
		setVisible(true);
	}
	

}
