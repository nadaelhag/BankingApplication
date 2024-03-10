import java.util.Random;

public class Customer {
    private int accountNumber;
    private int pin;
    private String name;
    private String email;
    private String dateOfBirth;
    private String phoneNumber;
    private String nationality;
    private String type;
    private double salary;
    private double balance;
    private boolean status;

    public Customer(String name, String email, String dateOfBirth, String phoneNumber, String nationality,
                    String type, double salary, double balance) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.type = type;
        this.salary = salary;
        this.balance = balance;
        accountNumber = generate() ;
        pin = generate();
        status = false;
    }
    public String print(){
        return  ("Account Number= " + accountNumber +"\n"+"Pin= " + pin +"\n"+
                "Name= " + name + "\n"+"Email= " + email + "\n"+
                "Date Of Birth= " + dateOfBirth + "\n"+"Phone Number= " + phoneNumber + "\n"+
                "Nationality= " + nationality + "\n"+"Type= " + type + "\n"+
                "Salary= " + salary + "\n"+"Balance= " + balance+ "\n");
    }

    public String toString() {
        return (accountNumber +"\n"+pin+"\n"+name +"\n"+email +"\n"+dateOfBirth +"\n"+phoneNumber +"\n"+
                nationality +"\n"+type +"\n"+salary +"\n"+balance +"\n"+status) ;
    }

    private int generate() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    public Customer(int accountNumber,int pin, String name, String email, String dateOfBirth, String phoneNumber,
                    String nationality, String type, double salary, double balance, boolean status) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.type = type;
        this.salary = salary;
        this.balance = balance;
        this.status = status;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
