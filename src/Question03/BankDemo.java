package Question03;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Account account = new Account(123);
        Scanner scanner = new Scanner(System.in);
        double amount;
        boolean loop = true;

        while (loop) {
            System.out.println("Depositing Rs. 10,000");
            account.deposit(10000);
            try {
                while (true) {
                    System.out.print("\nPlease enter amount to be withdrawn: ");
                    amount = scanner.nextDouble();
                    System.out.println("Withdrawing Rs. " + amount);
                    account.withdraw(amount);
                    System.out.println("Existing Amount: Rs. " + account.getBalance());
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Sorry, your account remains only Rs. " + e.getAmount());
                e.printStackTrace();
            } finally {
                System.out.print("Do you wish to continue?");
                String response = scanner.next();
                switch (response) {
                    case "no":
                        loop = false;
                        break;
                    case "yes":
                        break;
                    default:
                        System.out.println("Invalid selection!");
                        System.exit(1);
                }
            }
        }
    }
}

class Account {
    private int accountNumber;
    private double balance = 0;

    Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new InsufficientBalanceException(this.balance);
        }
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

class InsufficientBalanceException extends Exception {
    private double amount;

    InsufficientBalanceException(double amount) {
        super();
        this.amount = amount;
    }

    String getAmount() {
        return Double.toString(this.amount);
    }
}
