import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REGISTRATION {

    Scanner scanner = new Scanner(System.in);

    public String UserName;
    public String password;
    public String phoneNumber;
    public String FirstName;
    public String LastName;

    public boolean checkUserName(String UserName) {
        return UserName.length()<=5&& UserName.contains("_");
    }
    public boolean checkpassword(String password) {
        if (password.length() <8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else {
                Pattern specialPat = Pattern.compile("[^a-zA-Z0-9]");
                Matcher specialMat = specialPat.matcher(String.valueOf(c));
                if (specialMat.find()) {
                    hasSpecial = true;
                }
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27)[0-9]{9}");
    }
    public void Register() {
        while (true) {
            System.out.println("Enter your Firstname :");
            FirstName = scanner.nextLine();

            if (FirstName != null) {
                System.out.println("Firstname is valid.");
                break;
            } else {System.out.println("Invalid, Your Firstname cannot be empty.");}
        }
        // ends here

        while (true) {
            System.out.println("Enter your Lastname :");
            LastName = scanner.nextLine();

            if (LastName != null) {
                System.out.println("LastName is valid.");
                break;
            } else {System.out.println("Invalid, Your Lastname cannot be empty.");}
        }
        // ends here

        while (true) {
            System.out.println("Enter your username (Must contain '_' and not be more than 5 characters):");
            UserName = scanner.nextLine();

            if (UserName.contains("_") && UserName.length() <= 5) {
                System.out.println("Username is valid.");
                break;
            } else {
                System.out.println("Invalid username, try again.");
            }
        }

        while (true) {
            System.out.println("Enter your password (must be 8 characters, a capital letter, at least one number, a special character):");
            password = scanner.nextLine();

            if (checkpassword(password)) {
                System.out.println("Password is valid.");
                break;
            } else {
                System.out.println("Password is invalid, try again.");
            }
        }

        while (true) {
            System.out.println("Enter your phone number (must contain international country code, 10 numbers):");
            phoneNumber = scanner.nextLine();

            if (checkphoneNumber(phoneNumber)) {
                System.out.println("Valid phone number.");
                break;
            } else {
                System.out.println("Invalid phone number, try again.");
            }
        }
    }

}