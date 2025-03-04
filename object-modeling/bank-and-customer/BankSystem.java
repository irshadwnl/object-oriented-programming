import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;  // Association: Bank has Customers

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " is now a customer of " + name);
    }

    public Account openAccount(Customer customer, double initialBalance) {
        Account account = new Account(this, customer, initialBalance);
        customer.addAccount(account);  // Associate account with customer
        System.out.println("New account opened for " + customer.getName() + " at " + name);
        return account;
    }

    public String getName() {
        return name;
    }
}


class Customer {
    private String name;
    private List<Account> accounts;  // Association: Customer has Accounts

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Balance details for " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.getBank().getName() + " | Balance: Rs" + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}


class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI Bank");
        Customer customer1 = new Customer("Mohit");
        Customer customer2 = new Customer("Sam");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.openAccount(customer1, 1000);
        bank.openAccount(customer2, 2000);
        bank.openAccount(customer1, 500); 

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
