package Bank_system;

public interface BankOperations {

	
	boolean deposit(double amount);

	boolean withdraw(double amount) throws OverdraftLimitExceededException;

	String getAccountDetails();
	
	
}
