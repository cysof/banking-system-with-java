public class Transaction {

    private String reference;
    private double amount;
    private String status;

    // constructor

    public Transaction(String reference, double amount, String status){
        this.reference = reference;
        this.amount = amount;
        this.status = status;
    }

    // GETTER && SETTER

    public  String getReference(){
        return reference;
    }


    public double getAmount(){
        return amount;
    }



    public String getStatus(){
        return status;
    }

public void displayTransactionInfo(){
    System.out.println("REFERENCE: " + reference);
    System.out.println("AMOUNT: " + amount);
    System.out.println("SATUS: " + status);
}
}
