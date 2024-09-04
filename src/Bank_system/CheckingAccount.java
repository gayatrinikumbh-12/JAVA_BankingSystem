package Bank_system;

import Bank_system.OverdraftLimitExceededException;

public class CheckingAccount extends BankAccount {

	private int transactionCount;
	private int freeTransactionLimit = 3;
	private double overdraftLimit = 500;

	public CheckingAccount(int accountNumber) {
		super(accountNumber);
	}

	public CheckingAccount(int i, double d, double e) {
	
		
		this.overdraftLimit=e;
		// TODO Auto-generated constructor stub
	}

	

	 public CheckingAccount(int i, String str, double d) {
		// TODO Auto-generated constructor stub
		 super(i,str,d);
	}



	double getOverdraftLimit() {
		// TODO Auto-generated method stub
		return this.overdraftLimit;
	}
	
	@Override
	public boolean withdraw(double amount) {
	    if (amount <= getAccountBalance() + getOverdraftLimit()) {
	        setAccountBalance(getAccountBalance() - amount);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	

	@Override
	public boolean deposit(double amount) {
	    setAccountBalance(getAccountBalance() + amount);
	    return true;
	}

	public void applyTransactionFees(double feePerTransaction) {
		int transactionsToCharge = transactionCount - freeTransactionLimit;
		if (transactionsToCharge > 0) {
			double fees = transactionsToCharge * feePerTransaction;
			try {
				super.withdraw(fees);
			} catch (OverdraftLimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		transactionCount = 0;
	}

}
