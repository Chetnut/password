import java.util.Scanner;

public class Password {

    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "~!@#$%^&*()-=+_";

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) >= 0) hasSpecial = true;
        }

        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = scnr.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scnr.close();
    }
}
