public class Transaction {

    private int amount;
    private Type_Transaction type_transaction;
    private Date date;

    public Transaction(int amount, String type_transaction, Date date) {
        this.amount = amount;
        setType_transaction(type_transaction);
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Type_Transaction getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        if (type_transaction.compareTo("Withdraw") == 0)
            this.type_transaction = Type_Transaction.Withdraw;
        else if (type_transaction.compareTo("Deposit") == 0)
            this.type_transaction = Type_Transaction.Deposit;
        else if (type_transaction.compareTo("Interest") == 0)
            this.type_transaction = Type_Transaction.Interest;
        else if (type_transaction.compareTo("Fees") == 0)
            this.type_transaction = Type_Transaction.Fees;
        else
            this.type_transaction = null;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type_transaction=" + type_transaction +
                ", date=" + date +
                '}';
    }
}
