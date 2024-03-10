import java.util.Date;

public class Transaction {
    String typeOf;
    int giveMon;
    String takeMon;
    String dandt;
    double sent;
    
    public String toString() {
        return  (typeOf + "," +giveMon +  "," +takeMon + "," +sent + "," +dandt+"\n" );}

    public String getTitle() {
        return typeOf;}

    public void setTitle(String title) {
        this.typeOf = title;}

    public int getSender() {
        return giveMon;}

    public void setSender(int giveMon) {
        this.giveMon = giveMon;}

    public String getDate() {
        return dandt;}

    public void setDate(String dandt) {
        this.dandt = dandt;}

    public double getAmount() {
        return sent;}
    public void setAmount(double sent) {
        this.sent = sent;}

    public String getReceiver() {
        return takeMon;}

    public void setReceiver(String takeMon) {
        this.takeMon = takeMon;}
    public Transaction(String typeOf, int giveMon, String takeMon, double sent) {
        this.typeOf = typeOf;
        this.giveMon = giveMon;
        this.takeMon = takeMon;
        this.sent = sent;
        this.dandt = String.valueOf(new Date());
    }

    public Transaction(String typeOf, int giveMon, String takeMon, double sent, String dandt) {
        this.typeOf = typeOf;
        this.giveMon = giveMon;
        this.takeMon = takeMon;
        this.sent = sent;
        this.dandt = dandt;
    }
}
