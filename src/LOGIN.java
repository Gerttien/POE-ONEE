public class LOGIN {
    private String UserName;
    private String password;
    private String firstName;
    private String lastName;

    //Constructor
    public LOGIN(String UserName,String password, String firstName,String lastName){
        this.UserName=UserName;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;

    }
    // method to attempt login
    public String loginUser(String enteredUserName,String enteredPassword){
        if (enteredUserName.equals(this.UserName)&&enteredPassword.equals(this.password)){
            return "Welcome back "+" "+ this.firstName + " " + this.lastName + " " + "It is great to see you again.";
        }else {
            return "Username or Password incorrect.Please try again.";
        }
    }
}