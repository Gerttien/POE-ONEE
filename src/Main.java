import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        REGISTRATION registration = new REGISTRATION();
        registration.Register();


        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your log in details.");
        System.out.println("Enter your username.");
        String UserName = scanner.nextLine();
        System.out.println("Enter your password.");
        String password = scanner.nextLine();

        LOGIN login = new LOGIN(registration.UserName, registration.password, registration.FirstName, registration.LastName);
        System.out.println(login.loginUser(UserName, password));


    }
}