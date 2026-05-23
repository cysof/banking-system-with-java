public class CustomerUser extends User{
    public CustomerUser(String name, String email){
        super(name, email, "CUSTOMER");
    }

    public void applyForLoan(){
        System.out.println("Loan Application Submitted");
    }
}
