import java.util.Scanner;

// BankAccount Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance=initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit (double amount) {
        if (amount>0) {
            balance +=amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount> 0 && amount <=balance) {
            balance -=amount;
            return true;
        }
        return false;
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account= account;
        this.scanner= new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice=scanner.nextInt();
            switch(choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: Rs." + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. new balance is: Rs." + account.getBalance());
        } else {
            System.out.println("Deposit failed. Please enter valid amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. new balance is: Rs." + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }
}

// Main Class
public class task4{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); 
        ATM atm = new ATM(account);
        atm.start();
    }
}
