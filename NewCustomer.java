import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class NewCustomer extends JFrame {
    //private static final long serialVersionUID = 1L;
    protected String name;
    protected String accountType;
    protected String dateOfBirth;
    protected String email;
    protected String nationality;
    protected double salary;
    protected int phoneNum;
    protected String IDgiven;
    protected double balanceSet;
    private JPanel contentPane;
    private JTextField nameT;
    private JTextField emailT;
    private JTextField phoneNumT;
    private JTextField nationalityT;
    private JTextField salaryT;
    private JTextField datebirth;
    private JTextField textField;
    BankerNotif bn = BankerNotif.getInstance();


    public static void main(String[] args) throws FileNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer view = new NewCustomer();
                    view.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer(String name, String accountType, String email, String nationality, int phoneNum, String dateOfBirth, double salary, double balanceSet) throws FileNotFoundException {
        this.name = name;
        this.accountType = accountType;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.phoneNum = phoneNum;
        this.nationality = nationality;
        this.balanceSet = balanceSet;
    }

    public NewCustomer(NewCustomer a) throws FileNotFoundException {
        name = a.name;
        accountType = a.accountType;
        email = a.email;
        dateOfBirth = a.dateOfBirth;
        salary = a.salary;
        phoneNum = a.phoneNum;
        nationality = a.nationality;
        IDgiven = a.IDgiven;
        balanceSet = a.balanceSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String fName) {
        this.name = fName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String date) {
        this.dateOfBirth = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIDgiven() {
        return IDgiven;
    }

    public void setIDgiven(String iDgiven) {
        IDgiven = iDgiven;
    }

    public double getBalanceSet() {
        return balanceSet;
    }

    public void setBalanceSet(double balanceSet) {
        this.balanceSet = balanceSet;
    }

    public NewCustomer() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 605);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBounds(new Rectangle(100, 100, 550, 550));
        contentPane.setBounds(100, 100, 550, 550);

        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameL = new JLabel("Enter your name:");
        nameL.setForeground(new Color(0, 0, 0));
        nameL.setFont(new Font("SansSerif", Font.BOLD, 17));
        nameL.setBounds(21, 41, 160, 46);
        contentPane.add(nameL);

        JPanel panel = new JPanel();
        panel.setBounds(531, 509, -525, -507);
        contentPane.add(panel);

        JLabel emailL = new JLabel("Enter your email:");
        emailL.setForeground(new Color(0, 0, 0));
        emailL.setFont(new Font("SansSerif", Font.BOLD, 17));
        emailL.setBounds(21, 98, 218, 46);
        contentPane.add(emailL);

        JLabel dateofbirthL = new JLabel("Enter your date of birth:");
        dateofbirthL.setForeground(new Color(0, 0, 0));
        dateofbirthL.setFont(new Font("SansSerif", Font.BOLD, 17));
        dateofbirthL.setBounds(21, 155, 239, 46);
        contentPane.add(dateofbirthL);

        JLabel nationalityL = new JLabel("Enter your nationality:");
        nationalityL.setForeground(new Color(0, 0, 0));
        nationalityL.setFont(new Font("SansSerif", Font.BOLD, 17));
        nationalityL.setBounds(21, 269, 239, 46);
        contentPane.add(nationalityL);

        JLabel accountTypeL = new JLabel("Choose your account type:");
        accountTypeL.setForeground(new Color(0, 0, 0));
        accountTypeL.setFont(new Font("SansSerif", Font.BOLD, 17));
        accountTypeL.setBounds(21, 326, 239, 46);
        contentPane.add(accountTypeL);

        JLabel salaryL = new JLabel("Enter your salary:");
        salaryL.setFont(new Font("SansSerif", Font.BOLD, 17));
        salaryL.setForeground(new Color(0, 0, 0));
        salaryL.setBounds(21, 383, 218, 46);
        contentPane.add(salaryL);

        JLabel phoneNumL = new JLabel("Enter your phone number:");
        phoneNumL.setForeground(new Color(0, 0, 0));
        phoneNumL.setFont(new Font("SansSerif", Font.BOLD, 17));
        phoneNumL.setBounds(21, 212, 239, 46);
        contentPane.add(phoneNumL);

        nameT = new JTextField();
        nameT.setFont(new Font("SansSerif", Font.PLAIN, 17));
        nameT.setBounds(284, 41, 218, 46);
        contentPane.add(nameT);
        nameT.setColumns(10);

        emailT = new JTextField();
        emailT.setFont(new Font("SansSerif", Font.PLAIN, 17));
        emailT.setBounds(284, 98, 218, 46);
        contentPane.add(emailT);
        emailT.setColumns(10);

        phoneNumT = new JTextField();
        phoneNumT.setFont(new Font("SansSerif", Font.PLAIN, 17));
        phoneNumT.setBounds(284, 212, 218, 46);
        contentPane.add(phoneNumT);
        phoneNumT.setColumns(10);

        nationalityT = new JTextField();
        nationalityT.setFont(new Font("SansSerif", Font.PLAIN, 17));
        nationalityT.setBounds(284, 269, 218, 46);
        contentPane.add(nationalityT);
        nationalityT.setColumns(10);

        salaryT = new JTextField();
        salaryT.setFont(new Font("SansSerif", Font.PLAIN, 17));
        salaryT.setBounds(284, 383, 218, 46);
        contentPane.add(salaryT);
        salaryT.setColumns(10);

        String[] list = {"", "Saving Account", "Current Account"};
        JComboBox comboBox_1 = new JComboBox(list);
        comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
        comboBox_1.setBounds(284, 341, 218, 22);
        contentPane.add(comboBox_1);
        comboBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox_1.getSelectedIndex() == 1) {
                    setAccountType("Savings");
                } else if (comboBox_1.getSelectedIndex() == 2) {
                    setAccountType("Current");
                }
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
        exitButton.setBounds(318, 509, 129, 39);
        contentPane.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel lblNewLabel = new JLabel("Forum to register user");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblNewLabel.setBounds(146, 0, 239, 42);
        contentPane.add(lblNewLabel);

        datebirth = new JTextField();
        datebirth.setFont(new Font("SansSerif", Font.PLAIN, 17));
        datebirth.setBounds(284, 155, 218, 46);
        contentPane.add(datebirth);
        datebirth.setColumns(10);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
        enterButton.setBounds(87, 509, 129, 39);
        contentPane.add(enterButton);

        JLabel TextField = new JLabel("Enter the initial deposit:");
        TextField.setForeground(new Color(0, 0, 0));
        TextField.setFont(new Font("SansSerif", Font.BOLD, 17));
        TextField.setBounds(21, 440, 395, 46);
        contentPane.add(TextField);

        textField = new JTextField();
        textField.setFont(new Font("SansSerif", Font.PLAIN, 17));
        textField.setBounds(284, 440, 218, 46);
        contentPane.add(textField);
        textField.setColumns(10);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameT.getText().isEmpty() || emailT.getText().isEmpty() || nationalityT.getText().isEmpty() || salaryT.getText().isEmpty() || phoneNumT.getText().isEmpty() || textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please do not leave any empty fields", "", JOptionPane.ERROR_MESSAGE);
                } else if (phoneNumT.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Your phone number should be 10 digits long.", "", JOptionPane.ERROR_MESSAGE);
                } else if (!(emailT.getText().contains("@"))) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.parseInt(textField.getText()) < 5000) {
                    JOptionPane.showMessageDialog(null, "Please enter an amount greater than 5000", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    print();
                    setVisible(false);
                    Log_in l = new Log_in();
                    JOptionPane.showMessageDialog(null, "Your request has been submitted", "", JOptionPane.PLAIN_MESSAGE);
                    l.setVisible(true);

                }
            }
        });
    }

    public void print() {
        Customer customer = new Customer(nameT.getText(), emailT.getText(), datebirth.getText(), phoneNumT.getText(),
                nationalityT.getText(), getAccountType(), Double.parseDouble(salaryT.getText()), Double.parseDouble(textField.getText()));
        JOptionPane.showMessageDialog(null, "Account Number = "+customer.getAccountNumber()+
                "\nPin = "+customer.getPin(), "", JOptionPane.PLAIN_MESSAGE);
        Files File1 = new Files();
        File1.newCustomer(customer);
    }
}
