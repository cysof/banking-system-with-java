public class User {

    private String name;
    private String email;
    private  String role;

    // constructor

    public User (String name, String email, String role){
        this.email = email;
        this.name = name;
        this.role = role;
    }

    // Getter

    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }

    public void displayUserInfo(){
        System.out.println("\n === USER INFORMATION ====");
        System.out.println("NAME: " + name);
        System.out.println("EMAIL: " + email);
        System.out.println("ROLE: " + role);
    }

}
