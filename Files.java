import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Files {

	public String[][] searchCustomerByName(String name) {
        ArrayList<Customer> c = new ArrayList<Customer>();
        String [][] twoArray ;
        try {
            String set = "Customers";
            File File1 = new File(set);
            File[] emptyFileArray = null;

            emptyFileArray = File1.listFiles();
            if (File1.isDirectory() && File1.exists()) {
            	emptyFileArray = File1.listFiles();
                for (int i = 0; i < emptyFileArray.length; i++) {
                    if (emptyFileArray[i].isFile()) {
                        File File2 = new File(emptyFileArray[i].getAbsolutePath());
                        Scanner rd = new Scanner(File2);
                        Customer account = new Customer(Integer.parseInt(rd.nextLine()),Integer.parseInt(rd.nextLine()),
                                rd.nextLine(), rd.nextLine(), rd.nextLine(), rd.nextLine(),
                                rd.nextLine(), rd.nextLine(), Double.parseDouble(rd.nextLine()),
                                Double.parseDouble(rd.nextLine()), Boolean.parseBoolean(rd.nextLine()));
                        if(account.getName().equals(name)){
                            c.add(account);
                        }
                        while (rd.hasNextLine()) {
                            String data = rd.nextLine();
                        }
                        rd.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        twoArray = new String[c.size()][10];
        for (int i = 0; i < c.size(); i++) {
            twoArray[i][0] = ""+c.get(i).getAccountNumber();
            twoArray[i][1] = ""+c.get(i).getPin();
            twoArray[i][2] = c.get(i).getName();
            twoArray[i][3] = c.get(i).getType();
            twoArray[i][4] = c.get(i).getEmail();
            twoArray[i][5] = c.get(i).getNationality();
            twoArray[i][6] = c.get(i).getPhoneNumber();
            twoArray[i][7] = c.get(i).getDateOfBirth();
            twoArray[i][8] = ""+c.get(i).getSalary();
            twoArray[i][9] = ""+c.get(i).getBalance();
        }
        return twoArray;

    }
	
	public ArrayList<Customer> getNotifications() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        try {
            String path = "Customers";
            File File1 = new File(path);
            File[] a = null;

            a = File1.listFiles();
            if (File1.exists() && File1.isDirectory()) {
                a = File1.listFiles();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].isFile()) {
                        File File2 = new File(a[i].getAbsolutePath());
                        Scanner r = new Scanner(File2);
                        Customer customer = new Customer(Integer.parseInt(r.nextLine()),Integer.parseInt(r.nextLine()),
                                r.nextLine(), r.nextLine(), r.nextLine(), r.nextLine(),
                                r.nextLine(), r.nextLine(), Double.parseDouble(r.nextLine()),
                                Double.parseDouble(r.nextLine()), Boolean.parseBoolean(r.nextLine()));
                        if (!customer.isStatus()){
                            c.add(customer);
                        }
                        while (r.hasNextLine()) {
                            String data = r.nextLine();
                        }
                        r.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return c;
    }
	
	public String[][] getCustomerNotifications(Customer customer) {
        ArrayList<Loan> allLoans = new ArrayList<Loan>();
        try {
            File File1 = new File("loan.txt");
            Scanner r = new Scanner(File1);
            while (r.hasNextLine()) {
                String individual = r.nextLine();
                StringTokenizer split = new StringTokenizer(individual, ",");
                Loan loan = new Loan(Integer.parseInt(split.nextToken()),Double.parseDouble(split.nextToken()), split.nextToken());
                if(loan.getAccountNumber() == customer.getAccountNumber()){
                    allLoans.add(loan);
                }
            }
            r.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Transaction> transfers = new ArrayList<Transaction>();
        try {
            File File3 = new File("transaction.txt");
            Scanner r = new Scanner(File3);
            while (r.hasNextLine()) {
                String individual = r.nextLine();
                StringTokenizer st = new StringTokenizer(individual, ",");
                Transaction t = new Transaction(st.nextToken(), Integer.parseInt(st.nextToken()),
                        st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken());
                try {
                    if (t.getSender() == customer.getAccountNumber() || Integer.parseInt(t.getReceiver()) ==customer.getAccountNumber()) {
                        transfers.add(t);
                    }
                }catch(Exception e){

                }
            }
            r.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[][] table = new String[allLoans.size()+transfers.size()][3];
        int z = 0;
        while ( z < allLoans.size() ) {
            table[z][0] = allLoans.get(z).getRequest();
            table[z][1] = String.valueOf(allLoans.get(z).getAmount());
            table[z][2] = allLoans.get(z).getStatus();
            z++;
        }
        int y =0 ;
        while ( z < transfers.size() ) {
            if(transfers.get(y).getSender()== customer.getAccountNumber()){
                table[z][0] = "Sent";
            }else{
                table[z][0] = "Received";
            }
            table[z][1] = String.valueOf(transfers.get(y).getAmount());
            table[z][2] = "Completed";
            z++;
            y++;
        }
        return table;
    }
	
	 public void newCustomer(Customer c){
	        String path = "Customers";
	        File File1 = new File(path);
	        path = File1.getAbsolutePath();
	        File list[] = null;
	        list = File1.listFiles();
	        int fileNo;
	        if (list == null){
	            fileNo = 1;
	        }else{
	            fileNo = list.length;
	        }
	        String filename = fileNo+".txt";
	        try {
	            File newPath = new File(path+"\\"+filename);

	            FileWriter writeTo = new FileWriter(newPath.getAbsolutePath());
	            writeTo.write(c.toString());
	            writeTo.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	 
    public Customer searchClient(int username, int password) {
        try {
            String path = "Customers";
            File fObj = new File(path);
            File[] a = null;

            a = fObj.listFiles();
            if (fObj.exists() && fObj.isDirectory()) {
                a = fObj.listFiles();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].isFile()) {
                        System.out.println(a[i].getName());
                        File myObj = new File(a[i].getAbsolutePath());
                        Scanner myReader = new Scanner(myObj);
                        Customer account = new Customer(Integer.parseInt(myReader.nextLine()),Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine(), myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                myReader.nextLine(), myReader.nextLine(), Double.parseDouble(myReader.nextLine()),
                                Double.parseDouble(myReader.nextLine()), Boolean.parseBoolean(myReader.nextLine()));

                        if (account.getAccountNumber() ==username && account.getPin()== password && account.isStatus()) {
                            return account;
                        }
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Customer searchClient(int username) {
        try {
            String path = "Customers";
            File fObj = new File(path);
            File[] a = null;

            a = fObj.listFiles();
            if (fObj.exists() && fObj.isDirectory()) {
                a = fObj.listFiles();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].isFile()) {
                        File myObj = new File(a[i].getAbsolutePath());
                        Scanner myReader = new Scanner(myObj);
                        Customer account = new Customer(Integer.parseInt(myReader.nextLine()),Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine(), myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                myReader.nextLine(), myReader.nextLine(), Double.parseDouble(myReader.nextLine()),
                                Double.parseDouble(myReader.nextLine()), Boolean.parseBoolean(myReader.nextLine()));

                        if (account.getAccountNumber() ==username ) {
                            return account;
                        }
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    

    public String[][] searchCustomerById(int accountNumber) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        String [][] str ;
        try {
            String path = "Customers";
            File fObj = new File(path);
            File[] a = null;

            a = fObj.listFiles();
            if (fObj.exists() && fObj.isDirectory()) {
                a = fObj.listFiles();
                for (int i = 0; i < a.length; i++) {
                    if (a[i].isFile()) {
                        System.out.println(a[i].getName());
                        File myObj = new File(a[i].getAbsolutePath());
                        Scanner myReader = new Scanner(myObj);
                        Customer account = new Customer(Integer.parseInt(myReader.nextLine()),Integer.parseInt(myReader.nextLine()),
                                myReader.nextLine(), myReader.nextLine(), myReader.nextLine(), myReader.nextLine(),
                                myReader.nextLine(), myReader.nextLine(), Double.parseDouble(myReader.nextLine()),
                                Double.parseDouble(myReader.nextLine()), Boolean.parseBoolean(myReader.nextLine()));
                        if(account.getAccountNumber()==accountNumber){
                            customers.add(account);
                        }
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        str = new String[customers.size()][11];
        for (int i = 0; i < customers.size(); i++) {
            str[i][0] = ""+customers.get(i).getAccountNumber();
            str[i][1] = customers.get(i).getType();
            str[i][2] = ""+customers.get(i).getPin();
            str[i][3] = customers.get(i).getName();
            str[i][4] = customers.get(i).getType();
            str[i][5] = customers.get(i).getEmail();
            str[i][6] = customers.get(i).getNationality();
            str[i][7] = customers.get(i).getPhoneNumber();
            str[i][8] = customers.get(i).getDateOfBirth();
            str[i][9] = ""+customers.get(i).getSalary();
            str[i][10] = ""+customers.get(i).getBalance();
        }
        return str;
    }
    
    public void transactions(String line) {
        try {
            BufferedWriter write = new BufferedWriter(
                    new FileWriter("transaction.txt", true));
            write.write(line);
            write.close();
        } catch (IOException e) {
        }
    }
    
    
    
    public String[][] allApprovedAccount() {
        ArrayList<Customer> c = new ArrayList<Customer>();
        String [][] rowCol ;
        try {
            String path = "Customers";
            File File1 = new File(path);
            File[] arrayList = null;

            arrayList = File1.listFiles();
            if (File1.exists() && File1.isDirectory()) {
                arrayList = File1.listFiles();
                for (int x = 0; x < arrayList.length; x++) {
                    if (arrayList[x].isFile()) {
                        File myObj = new File(arrayList[x].getAbsolutePath());
                        Scanner rd = new Scanner(myObj);
                        Customer account = new Customer(Integer.parseInt(rd.nextLine()),Integer.parseInt(rd.nextLine()),
                                rd.nextLine(), rd.nextLine(), rd.nextLine(), rd.nextLine(),
                                rd.nextLine(), rd.nextLine(), Double.parseDouble(rd.nextLine()),
                                Double.parseDouble(rd.nextLine()), Boolean.parseBoolean(rd.nextLine()));
                        if(account.isStatus()){
                            c.add(account);
                        }
                        while (rd.hasNextLine()) {
                            String data = rd.nextLine();
                        }
                        rd.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        rowCol = new String[c.size()][11];
        for (int z = 0; z < c.size(); z++) {
            rowCol[z][0] = ""+c.get(z).getAccountNumber();
            rowCol[z][1] = ""+c.get(z).getPin();
            rowCol[z][2] = c.get(z).getName();
            rowCol[z][3] = c.get(z).getType();
            rowCol[z][4] = c.get(z).getEmail();
            rowCol[z][5] = c.get(z).getNationality();
            rowCol[z][6] = c.get(z).getPhoneNumber();
            rowCol[z][7] = c.get(z).getDateOfBirth();
            rowCol[z][8] = ""+c.get(z).getSalary();
            rowCol[z][9] = ""+c.get(z).getBalance();
        }
        return rowCol;
    }
    
    public void updateLoan(ArrayList<Loan> allRequests) {
        try {
            File File1 = new File("loan.txt");

            FileWriter writeTo = new FileWriter(File1.getAbsolutePath());
            for (Loan l : allRequests) {
                writeTo.write(l.print());
            }
            writeTo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String[][] searchTransactions(int currentAcc) {
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        String[][] twoArray = null;
        try {
            File File1 = new File("transaction.txt");
            Scanner rd = new Scanner(File1);
            while (rd.hasNextLine()) {
                String individual = rd.nextLine();
                StringTokenizer st = new StringTokenizer(individual, ",");
                Transaction transaction = new Transaction(st.nextToken(), Integer.parseInt(st.nextToken()),
                        st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken());
                try {
                    if (transaction.getSender() == currentAcc || Integer.parseInt(transaction.getReceiver()) == currentAcc) {
                        list.add(transaction);
                    }
                }catch(Exception e){

                }
            }
            twoArray = new String[list.size()][5];
            for (int x = 0; x < list.size(); x++) {
                twoArray[x][0] = list.get(x).getTitle();
                twoArray[x][1] = String.valueOf(list.get(x).getSender());
                twoArray[x][2] = String.valueOf(list.get(x).getReceiver());
                twoArray[x][3] = String.valueOf(list.get(x).getAmount());
                twoArray[x][4] = list.get(x).getDate();
            }
            rd.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return twoArray;
    }


    public void updateBalance(int accountNumber,double addMoney, String operation) {
        Customer current_acc = searchClient(accountNumber);
        if(current_acc!=null){
            if(operation.equals("add")){
                current_acc.setBalance(current_acc.getBalance() + addMoney);
            }else {
                current_acc.setBalance(current_acc.getBalance() - addMoney);
            }
            try {
                File file1 = searchClientFileName(accountNumber);
                FileWriter writeTo = new FileWriter(file1.getAbsolutePath());
                writeTo.write(current_acc.toString());
                writeTo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public File searchClientFileName(int accountNumber) {
        try {
            String path = "Customers";
            File File1 = new File(path);
            File[] list = null;

            list = File1.listFiles();
            if (File1.exists() && File1.isDirectory()) {
                list = File1.listFiles();
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile()) {
                        File abspath = new File(list[i].getAbsolutePath());
                        Scanner rd = new Scanner(abspath);
                        Customer customer = new Customer(Integer.parseInt(rd.nextLine()),Integer.parseInt(rd.nextLine()),
                                rd.nextLine(), rd.nextLine(), rd.nextLine(), rd.nextLine(),
                                rd.nextLine(), rd.nextLine(), Double.parseDouble(rd.nextLine()),
                                Double.parseDouble(rd.nextLine()), Boolean.parseBoolean(rd.nextLine()));
                        if (customer.getAccountNumber() == accountNumber) {
                            return list[i];
                        }
                        while (rd.hasNextLine()) {
                            String data = rd.nextLine();
                        }
                        rd.close();
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public ArrayList<Loan> searchLoansPendingRequest(){
        ArrayList<Loan> list = new ArrayList<Loan>();
        try {
            File File1 = new File("loan.txt");
            Scanner rd = new Scanner(File1);
            while (rd.hasNextLine()) {
                String individual = rd.nextLine();
                StringTokenizer st = new StringTokenizer(individual, ",");
                Loan loan = new Loan(Integer.parseInt(st.nextToken()),Double.parseDouble(st.nextToken()), st.nextToken());
                list.add(loan);
            }
            rd.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void loanRequest(Loan loan){
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("loan.txt", true));
            out.write(loan.print());
            out.close();
        } catch (IOException e) {
        }
    }
    public void updateStatus(int accNum, boolean b) {
        Customer customer = searchClient(accNum);
        customer.setStatus(b);
        try {
            File file = searchClientFileName(accNum);
            FileWriter writeTo = new FileWriter(file.getAbsolutePath());
            writeTo.write(customer.toString());
            writeTo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
