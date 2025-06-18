import java.util.Scanner;
public class password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean isValid = true;

        // Check each condition and give feedback
        if (!isLengthValid(password)) {
            System.out.println("- Password must be at least 8 characters long.");
            isValid = false;
        }

        if (!hasUppercase(password)) {
            System.out.println("- Password must contain at least one uppercase letter.");
            isValid = false;
        }

        if (!hasLowercase(password)) {
            System.out.println("- Password must contain at least one lowercase letter.");
            isValid = false;
        }

        if (!hasDigit(password)) {
            System.out.println("- Password must contain at least one digit.");
            isValid = false;
        }

        if (!hasSpecialChar(password)) {
            System.out.println("- Password must contain at least one special character.");
            isValid = false;
        }

        if (isValid) {
            System.out.println(" Password is strong!");
        } else {
            System.out.println(" Password is weak. Try again!");
        }

        scanner.close(); // Always close Scanner
    }

    // Check if password is at least 8 characters
    public static boolean isLengthValid(String password) {
        return password.length() >= 8;
    }

    // Check for uppercase letter
    public static boolean hasUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    // Check for lowercase letter
    public static boolean hasLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    // Check for digit
    public static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    // Check for special character (non-letter and non-digit)
    public static boolean hasSpecialChar(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return true;
        }
        return false;
    }
}