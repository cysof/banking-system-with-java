public class LoanOfficerUser extends User{

    public LoanOfficerUser(String name, String email){
        super(name, email, "LOAN_OFFICER");
    }

    public void officerInCharge(){
        System.out.println("Loan Application Review in Progress");
    }
}
