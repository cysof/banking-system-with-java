public class AdminUser extends User{
    public AdminUser(String name, String email){
        super(name, email, "ADMIN");
    }

    public void approvedLoan(){
        System.out.println("Loan Approved Successfully");
    }
}
