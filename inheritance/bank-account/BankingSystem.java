class BankAccount {
    protected String accountNumber;
    protected double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
    }
    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + ", New Balance: $" + balance);
        }
    }
    
    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Added: $" + interest + ", New Balance: $" + balance);
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal limit exceeded! Max allowed: $" + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    private int maturityPeriod;
    private double interestRate;
    
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod, double interestRate) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
        this.interestRate = interestRate;
    }
    
    public void displayMaturityDetails() {
        System.out.println("Fixed Deposit Account, Maturity Period: " + maturityPeriod + " months, Interest Rate: " + interestRate + "%");
    }
    
    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", 1000, 5.0);
        savings.displayAccountType();
        savings.addInterest();
        
        CheckingAccount checking = new CheckingAccount("CHK456", 2000, 500);
        checking.displayAccountType();
        checking.withdraw(600);
        checking.withdraw(400);
        
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 5000, 12, 7.0);
        fixedDeposit.displayAccountType();
        fixedDeposit.displayMaturityDetails();
    }
}
