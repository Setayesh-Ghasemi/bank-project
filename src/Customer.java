public class Customer {

    private String name;
    private int counter_account;
    Account accounts[];

    public Customer(String name) {
        this.name = name;
        this.counter_account = 0;
        this.accounts = new Account[10];
    }

    public String getName() {
        return name;
    }

    public int getCounter_account() {
        return counter_account;
    }

    public void addAccount(Account account) {
        if (counter_account >= 10) {
            System.out.println("Capacity is full.");
            return;
        }
        accounts[counter_account] = account;
        counter_account++;
    }

    public int existAccount(int idAccount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getID_account() == idAccount)
                return i;
        }
        return -1;
    }
}

