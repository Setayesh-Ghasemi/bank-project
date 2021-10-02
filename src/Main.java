import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Scanner input;
    Customer customers[];
    int counter_customer;

    public Main() {
        input = new Scanner(System.in);
        customers = new Customer[1000];
        counter_customer = 0;
        menuManager();
    }

    public void menuManager() {
        int x = 0;
        do {
            System.out.println("1.Add new account");
            System.out.println("2.Views accounts");
            System.out.println("3.Withdraw");
            System.out.println("4.Deposit");
            System.out.println("5.Calculate interests");
            System.out.println("6.View Transactions");
            System.out.println("7.Exit");
            x = input.nextInt();
        } while (x > 7 || x < 1);
        switch (x) {
            case 1:
                addNewAccount();
                break;
            case 2:
                viewsAccounts();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                deposit();
                break;
            case 5:
                calculateInterests();
                break;
            case 6:
                viewTransactions();
                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    public void addNewAccount() {
        System.out.println("***Add New Account***");
        input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        Account account = new Account(input);
        int index = -1;
        for (int i = 0; i < counter_customer; i++) {
            if (customers[i].getName().compareTo(name) == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            customers[counter_customer] = new Customer(name);
            customers[counter_customer].addAccount(account);
            counter_customer++;
        } else {
            customers[index].addAccount(account);
        }
        System.out.println("Account added Successfully.");
        menuManager();
    }

    public void viewsAccounts() {
        System.out.println("***Views Accounts***");
        input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        int index = -1;
        for (int i = 0; i < counter_customer; i++) {
            if (customers[i].getName().compareTo(name) == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Customer not exist.");
        } else {
            for (int i = 0; i < customers[index].getCounter_account(); i++) {
                System.out.println(customers[index].accounts[i]);
            }
        }
        menuManager();
    }

    public void withdraw() {
        System.out.println("***Withdraw***");
        System.out.print("Enter ID Account:");
        int idAccount = input.nextInt();
        System.out.print("Enter Amount:");
        int amount = input.nextInt();
        Date date = new Date(input);
        for (int i = 0; i < customers.length; i++) {
            int index = customers[i].existAccount(idAccount);
            if (index != -1) {
                if (customers[i].accounts[index].getBalance() >= amount) {
                    customers[i].accounts[index].addTransaction(new Transaction(amount, "Withdraw", date));
                    customers[i].accounts[index].setBalance(customers[i].accounts[index].getBalance() - amount);
                    System.out.println("The tram was completed successfully.");
                } else {
                    System.out.println("Inventory is not enough.");
                }
                menuManager();
            }
        }
        System.out.println("Account not exist.");
        menuManager();
    }

    public void deposit() {
        System.out.println("***Deposit***");
        System.out.print("Enter ID Account:");
        int idAccount = input.nextInt();
        System.out.print("Enter Amount:");
        int amount = input.nextInt();
        Date date = new Date(input);
        for (int i = 0; i < customers.length; i++) {
            int index = customers[i].existAccount(idAccount);
            if (index != -1) {
                customers[i].accounts[index].addTransaction(new Transaction(amount, "Deposit", date));
                customers[i].accounts[index].setBalance(customers[i].accounts[index].getBalance() + amount);
                System.out.println("The tram was completed successfully.");
                menuManager();
            }
        }
        System.out.println("Account not exist.");
        menuManager();
    }

    public void calculateInterests() {
        System.out.println("***Calculate Interests***");
        System.out.print("Enter ID Account:");
        int idAccount = input.nextInt();
        for (int i = 0; i < customers.length; i++) {
            int index = customers[i].existAccount(idAccount);
            if (index != -1 && (customers[i].accounts[index].getType_account() == Type_Account.Loan_Account ||
                    customers[i].accounts[index].getType_account() == Type_Account.Saving_Account)) {
                customers[i].accounts[index].setBalance(customers[i].accounts[index].getBalance()
                        + (customers[i].accounts[index].getBalance() * 100) / 10);
                System.out.println("The tram was completed successfully.");
                menuManager();
            }
            System.out.println("Account not exist.");
            menuManager();
        }
    }

    public void viewTransactions() {
        System.out.println("***View Transactions***");
        System.out.print("Enter ID Account:");
        int idAccount = input.nextInt();
        for (int i = 0; i < customers.length; i++) {
            int index = customers[i].existAccount(idAccount);
            if (index != -1) {
                for (int j = 0; j < customers[i].accounts[index].getCounter_Transactions(); j++) {
                    System.out.println(customers[i].accounts[index].transactions[j]);
                }
                System.out.println("The tram was completed successfully.");
                menuManager();
            }
            System.out.println("Account not exist.");
            menuManager();
        }
    }
}
