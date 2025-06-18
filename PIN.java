import java.util.Scanner;

public class PIN {
    static int balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctPIN = createPIN(scanner);
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            String inputPIN = scanner.nextLine();

            if (inputPIN.equals(correctPIN)) {
                System.out.println(" PIN verified successfully.");
                showMenu(scanner);
                scanner.close();
                return;
            } else {
                attempts++;
                System.out.println(" Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println(" Too many incorrect attempts. System locked.");
        scanner.close();
    }

    public static String createPIN(Scanner scanner) {
        String pin;
        do {
            System.out.print("Create a 4-digit PIN: ");
            pin = scanner.nextLine();

            if (!pin.matches("\\d{4}")) {
                System.out.println(" PIN must be exactly 4 digits (numbers only). Try again.");
            }
        } while (!pin.matches("\\d{4}"));

        return pin;
    }

    public static void showMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n---  Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print(" Invalid input. Please enter a number (1-4): ");
                scanner.next(); // discard wrong input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> deposit(scanner);
                case 2 -> withdraw(scanner);
                case 3 -> checkBalance();
                case 4 -> System.out.println("Exiting system. Thank you!");
                default -> System.out.println(" Invalid choice. Please select from 1 to 4.");
            }

        } while (choice != 4);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int amount = readPositiveAmount(scanner);
        balance += amount;
        System.out.println(" Deposited successfully.");
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int amount = readPositiveAmount(scanner);

        if (amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawn successfully.");
        } else {
            System.out.println(" Insufficient balance.");
        }
    }

    public static void checkBalance() {
        System.out.println(" Your balance is: " + balance);
    }

    public static int readPositiveAmount(Scanner scanner) {
        int amount;

        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print(" Invalid input. Enter a positive number: ");
                scanner.next(); // discard
            }

            amount = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (amount > 0) return amount;

            System.out.print(" Amount must be greater than 0. Try again: ");
        }
    }
}