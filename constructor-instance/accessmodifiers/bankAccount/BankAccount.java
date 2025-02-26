public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accountNumber,String  accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs" + balance);
    }
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(123456, "John Doe", 5000.0, 5.0);
        sa.displaySavingsAccountDetails();

        sa.deposit(1000);
        sa.withdraw(2000);
        sa.addInterest(); 

        sa.displaySavingsAccountDetails();
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate; 

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance); 
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest Added: $" + interest);
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); 
        System.out.println("Account Holder: " + accountHolder); 
        System.out.println("Balance: $" + getBalance());        
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
