package Bank_system;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(int accountNumber, double accountBalance) {
        super(accountNumber, accountBalance);
    }

    @Override
    public double calculateAccountFees() {
        return 10.0;
    }

    @Override
    public String toString() {
        return "Business Account - Account Number: " + getAccountNumber() + ", Account Balance: $" + getAccountBalance();
    }
}