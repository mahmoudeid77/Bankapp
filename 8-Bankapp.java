import java.util.Scanner;
public class Bankapp
{ public static void main(String[] args)
{ Scanner s = new Scanner(System.in);
    Bank myBank = new Bank();
    int user_choice = 2;
    ////////////////////////// choise avialiable for bank application
    do {  System.out.println(); System.out.println("1) Open a new bank account");
        System.out.println("2) Deposit to a bank account");
        System.out.println("3) Withdraw to bank account");
        System.out.println("4) Print account balance");
        System.out.println("5) Quit");
        System.out.println();
        System.out.print("Enter choice [1-5]: ");
        user_choice = s.nextInt();
        switch (user_choice)
        {
            case 1: System.out.println("Enter a customer name");
            String cn = s.next(); System.out.println("Enter a opening balance");
            double d = s.nextDouble();
                System.out.println("Account was created and it has the following number: " + myBank.openNewAccount(cn, d));
                break;
                case 2: System.out.println("Enter a account number");
                int an = s.nextInt();
                System.out.println("Enter a deposit amount");
                double da = s.nextDouble();
                myBank.depositTo(an, da);
                break;
                case 3: System.out.println("Enter a account number");
                int acn = s.nextInt();
                System.out.println("Enter a withdraw amount");
                double wa = s.nextDouble();
                myBank.withdrawFrom(acn, wa);
                break;
                case 4: System.out.println("Enter a account number");
                int anum = s.nextInt();
                myBank.printAccountInfo(anum);
                break;
                case 5: System.out.println("Here are the balances " + "for each account:");
                case 6: System.exit(0);
        } } while (user_choice != '6');
    ////////////////////////// class of bank application to count the number of account
} } class Bank {
    private BankAccount[]accounts;
    int numOfAccounts = 5;
    private BankAccount[] counts;

    public Bank() { accounts = new BankAccount[5];
        numOfAccounts = 0;
    }   ////////////////////////// function to  open account in the bank
    public int openNewAccount(String customerName, double openingBalance)
    { BankAccount b = new BankAccount(customerName, openingBalance);
        accounts[numOfAccounts] = b;
        numOfAccounts++;
        return b.getAccountNum();

        ////////////////////////// function to withdraw from your account
    }  public void withdrawFrom(int accountNum, double amount)
    {
        for (int i =0; i<numOfAccounts; i++)
        {
            if (accountNum == accounts[i].getAccountNum() )
            {
                accounts[i].withdraw(amount);
                System.out.println("Amount withdrawn successfully");
                return;
            } } System.out.println("Account number not found.");
    }
    ////////////////////////// function to deposite from your account

    public void depositTo(int accountNum, double amount)

    {
        for (int i =0; i<numOfAccounts; i++)
        { if (accountNum == accounts[i].getAccountNum() )
        {
            accounts[i].deposit(amount);
            System.out.println("Amount deposited successfully");
            return;
        } } System.out.println("Account number not found.");
        ////////////////////////// function to print your information of your account

    }  public void printAccountInfo(int accountNum)
    {
        for (int i =0; i<numOfAccounts; i++)
        {
            if (accountNum == accounts[i].getAccountNum() )
            {
                System.out.println(accounts[i].getAccountInfo());
                return;
            } } System.out.println("Account number not found.");
    }
     } class BankAccount{
    private int accountNum;
    private String customerName;
    private double balance;
    private static int noOfAccounts=0;
    public String getAccountInfo(){
        return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance +"\n";
    }
    public BankAccount(String abc, double xyz)
    { customerName = abc; balance = xyz; noOfAccounts ++; accountNum = noOfAccounts;
    } public int getAccountNum(){
        return accountNum;
    } public void deposit(double amount){ if (amount<=0) {
        System.out.println("Amount to be deposited should be positive");
    } else { balance = balance + amount;
    }
    }
    public void withdraw(double amount)
    { if (amount<=0){ System.out.println("Amount to be withdrawn should be positive"); } else {

    if (balance < amount)
    {
        System.out.println("Insufficient balance");
    } else { balance = balance - amount;
    }
    }
    }
}