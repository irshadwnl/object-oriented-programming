
// Program to Simulate an ATM


import java.util.Scanner;

public class BankAccount {
    int accNum;
        String accHoldName;
        int accBalance;
                public BankAccount(int accNum,String accHoldName,int accBalance){
                    this.accNum=accNum;
                    this.accHoldName=accHoldName;
                    this.accBalance=accBalance;
                }
                void deposit(int add){
                    this.accBalance+=add;
                } 
                void withdraw(int wd){
                    this.accBalance-=wd;
                }
                void checkBal(){
                    System.out.println("Your Balance is: "+this.accBalance);
                }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount c1=new BankAccount(321,"Sam",2000);
        // Customer c2=new Customer(121,"Sam",5000);
        System.out.println("Enter the Customer Account Number:");
        int user=sc.nextInt();
        if(user==c1.accNum){
            System.out.println("What you want to do:");
            System.out.println("1.Add Deposit:");
            System.out.println("2.Withdraw Cas:h");
            System.out.println("3.Check Balance:");

            int n=sc.nextInt();
            if(n==1){
                System.out.println("Enter How Much You want to Deposit:");
                int add=sc.nextInt();
                c1.deposit(add);
                System.out.println("Deposit SuccessFullyyyyyy!!");
                System.out.println("Your Balance is: "+c1.accBalance);
            }else if(n==2){
                System.out.println("Enter the Ammount to be Withdrawn:");
                int wd=sc.nextInt();
                c1.withdraw(wd);
                System.out.println("Withdrawn Successfull");
                System.out.println("Total Balance:-"+c1.accBalance);
            }else if(n==3){
                c1.checkBal();
            }else{
                System.out.println("Invalid Input");
            }
        }else{
            System.out.println("Not Found");
        }

    }

}
