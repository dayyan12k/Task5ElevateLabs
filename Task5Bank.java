import java.util.*;
import java.time.LocalDateTime;

class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String toString() {
        return timestamp + " | " + type + " | ₹" + amount;
    }
}

class Account {
    private static int accountCounter = 1000;

    private int accountNumber;
    private String ownerName;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.accountNumber = ++accountCounter;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  Amount must be greater than zero.");
            return;
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println(" Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  Amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.out.println("  Insufficient balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.println(" Withdrawn ₹" + amount);
    }

    public void printSummary() {
        System.out.println("\n=== Account Summary ===");
        System.out.println(" Name       : " + ownerName);
        System.out.println(" Account No : " + accountNumber);
        System.out.println(" Balance    : ₹" + balance);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println(" No transactions found.");
            return;
        }
        System.out.println("\n Transaction History:");
        for (Transaction t : transactionHistory) {
            System.out.println("• " + t);
        }
    }
}

public class Task5Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Welcome to Dayyan Bank");
        System.out.print("Enter your name to open an account: ");
        String name = sc.nextLine();

        Account account = new Account(name);
        System.out.println(" Account created successfully!");

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Account Summary");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depAmt = sc.nextDouble();
                    account.deposit(depAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withAmt = sc.nextDouble();
                    account.withdraw(withAmt);
                    break;
                case 3:
                    account.printSummary();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println(" Thank you for banking with Dayyan Bank. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}

