import java.util.Random;
import java.util.Scanner;

public class Account {

    private int balance;
    private Date date;
    private Type_Account type_account;
    private int ID_account;
    Transaction transactions[];
    private int counter_Transactions = 0;
    Random ran = new Random();

    public Account(int balance, Date date, String type_account) {
        this.balance = balance;
        this.date = date;
        setType_account(type_account);
        ID_account = ran.nextInt(1000000) + 100000;
        counter_Transactions = 0;
        transactions = new Transaction[100];
    }

    public Account(Scanner input) {
        System.out.print("Enter balance:");
        balance = input.nextInt();
        input.nextLine();
        System.out.print("Enter Type_account(Checking_Account , Saving_Account , Loan_Account):");
        setType_account(input.nextLine());
        ID_account = ran.nextInt(1000000) + 100000;
        date = new Date(input);
        transactions = new Transaction[100];
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type_Account getType_account() {
        return type_account;
    }

    public int getID_account() {
        return ID_account;
    }

    public int getCounter_Transactions() {
        return counter_Transactions;
    }

    public void setCounter_Transactions(int counter_Transactions) {
        this.counter_Transactions = counter_Transactions;
    }

    public void setType_account(String type_account) {
        if (type_account.compareTo("Checking_Account") == 0)
            this.type_account = Type_Account.Checking_Account;
        else if (type_account.compareTo("Saving_Account") == 0)
            this.type_account = Type_Account.Saving_Account;
        else if (type_account.compareTo("Loan_Account") == 0)
            this.type_account = Type_Account.Loan_Account;
        else
            this.type_account = null;
    }

    public void addTransaction(Transaction transaction) {
        transactions[counter_Transactions] = transaction;
        counter_Transactions++;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", date=" + date +
                ", type_account=" + type_account +
                ", ID_account=" + ID_account +
                '}';
    }
}
