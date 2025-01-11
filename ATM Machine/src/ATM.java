import java.util.Scanner;

public class ATM {

    private static double balance = 1000.0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to the ATM Machine");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    depositMoney(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawMoney(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("$%.2f has been deposited successfully.%n", amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private static void withdrawMoney(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("$%.2f has been withdrawn successfully.%n", amount);
                checkBalance();
            } else {
                System.out.println("Insufficient balance. Cannot withdraw.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}