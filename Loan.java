public class Loan {
    private int accountNumber;
    private double loanReq;
    private String currentVal;

    public Loan(int accountNumber, double loanReq) {
        this.accountNumber = accountNumber;
        this.loanReq = loanReq;
        currentVal = "Pending";}

    public Loan(int accountNumber, double loanReq, String currentVal) {
        this.accountNumber = accountNumber;
        this.loanReq = loanReq;
        this.currentVal = currentVal;}
    
    public String print() {
        return accountNumber+","+loanReq+","+currentVal+"\n";}

    public int getAccountNumber() {
        return accountNumber;}

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;}

    public double getAmount() {
        return loanReq;}

    public void setAmount(double amount) {
        this.loanReq = amount;}

    public String getStatus() {
        return currentVal;}

    public void setStatus(String currentVal) {
        this.currentVal = currentVal;}

    public String getRequest() {
        return loanReq+" Loan";}
}
