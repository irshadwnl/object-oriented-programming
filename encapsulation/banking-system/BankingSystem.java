import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    
    public abstract double calculateInterest();
}


interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}


class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4% interest rate
    
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings account loan application submitted for: " + amount);
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Loan eligibility is 5 times the balance
    }
}


class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2% interest rate
    
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current account loan application submitted for: " + amount);
    }
    
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 10; // Loan eligibility is 10 times the balance
    }
}



public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        accounts.add(new SavingsAccount("SA123", "Alice", 50000));
        accounts.add(new CurrentAccount("CA456", "Bob", 100000));
        
        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Type: " + (account instanceof SavingsAccount ? "Savings" : "Current"));
            System.out.println("Interest Earned: " + account.calculateInterest());
            
            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
            }
            System.out.println();
        }
    }
}
