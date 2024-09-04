package Bank_system;

public class SavingsAccount extends BankAccount{
	
	private double interestRate;
	

	public SavingsAccount(int i, double d)
	{
		super();
		
		
	}
	
	public SavingsAccount(double  interestRate)
	{
		super();
		
		
	}

	 public SavingsAccount(int i, String str, double d) {
		// TODO Auto-generated constructor stub
		 super(i,str,d);
	}


	double getInterestRate() {
		// TODO Auto-generated method stub
		return this.interestRate;
	}
	
	@Override
	public boolean withdraw(double amount) {
	    if (amount <= getAccountBalance()) {
	        setAccountBalance(getAccountBalance() - amount);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	
	@Override
	public boolean deposit(double amount) {
	    double interestEarned = amount * getInterestRate();
	    setAccountBalance(getAccountBalance() + amount + interestEarned);
	    return true;
	}

	


	@Override
	public String displayAccountDetails() {
	
		 return super.displayAccountDetails() + ", Interest Rate: " + interestRate + "%";

	}
	
	
	void earnInterest()
	{
		double accountBalance = getAccountBalance();
		double interestEarned = accountBalance * this.interestRate;
		accountBalance=accountBalance+interestEarned;
		setAccountBalance(accountBalance);
		System.out.println("-----earnIntrest-------");
		System.out.printf("Interest earned: %.2f%nNew account balance: %.2f%n", interestEarned, accountBalance);
		System.out.println(displayAccountDetails());
	}
}
