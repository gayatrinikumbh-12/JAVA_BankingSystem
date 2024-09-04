package Bank_system;

public  abstract class BankAccount implements BankOperations{

	private int acc_numb;
	private double acc_bal;
	private String name;

	BankAccount() {
		this.acc_bal = 0;
	}

    public BankAccount(double initialBalance) {
	        this.acc_bal = initialBalance;
	    }
	
    

	public BankAccount(int accountNumber, double accountBalance) {
		
		this.acc_numb = accountNumber;
		this.acc_bal = accountBalance;
	}

	public BankAccount(int accountNumber, String name, double accountBalance) {
		
		this.acc_numb = accountNumber;
		this.name = name;
		this.acc_bal = accountBalance;
	}
	
	public final  double getAccountBalance() {
		return this.acc_bal;

	}

	

	public final  int getAccountNumber() {
		return this.acc_numb;

	}

	double setAccountBalance(double newBalance) {
		return this.acc_bal = newBalance;
	}

	double setAccountNumber(int an) {
		return this.acc_numb = an;
	}
	
	public boolean deposit(double amount) {
		
		boolean flag = false;
		
		try {	
			this.acc_bal = this.acc_bal + amount;
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean withdraw(double amount) throws OverdraftLimitExceededException {
		
		boolean val = false;
		if (amount > this.acc_bal) {
			System.out.println("Can't withdraw money as Balance is less ");
			val = false;
		} else {
			this.acc_bal = this.acc_bal - amount;
			val = true;
		}
		
		return val;
	}

	public String displayAccountDetails() {
		String console;

		return console = "Account Number :" + this.acc_numb + "\n" + "Account Balance: " + "$" + this.acc_bal;

	}
	
	@Override
	public String toString() {
	    return "Business Account - Account Number: " + getAccountNumber() + ", Account Balance: $" + getAccountBalance();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		BankAccount myAccount = new BankAccount();
		myAccount.setAccountNumber(123);
		myAccount.setAccountBalance(860.07);
		System.out.println("Account number " + myAccount.acc_numb);
		System.out.println("Account Balance " + myAccount.acc_bal);

		// myAccount.deposit(6000);
		try {
			myAccount.withdraw(400);
		} catch (OverdraftLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Account Balance after deposit " + myAccount.acc_bal);
		System.out.println(myAccount.displayAccountDetails());
		SavingsAccount s = new SavingsAccount(543, 1000, 10);
		
		s.earnInterest();
		
		
		CheckingAccount account = new CheckingAccount(123);
	    
		 try {
		        account.withdraw(800);
		    } catch (OverdraftLimitExceededException e) {
		        System.out.println(e.getMessage());
		    }
		    
		    try {
		        account.withdraw(1200);
		    } catch (OverdraftLimitExceededException e) {
		        System.out.println(e.getMessage());
		    }
		    
		    System.out.println(myAccount.displayAccountDetails());
		
		    System.out.println("----------------------");
		    SavingsAccount savings = new SavingsAccount(12345, 5000.0, 0.03);
	        CheckingAccount checking = new CheckingAccount(67890, 1000.0, 2000.0);
	        savings.deposit(1000.0);
	        System.out.println(savings.getAccountDetails());
	        
	        try {
	            checking.withdraw(500.0);
	        } catch (OverdraftLimitExceededException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println(checking.getAccountDetails());
	        
	        */
		
		
		 SavingsAccount savingsAccount = new SavingsAccount(1001);
		    CheckingAccount checkingAccount = new CheckingAccount(1002, 2000, 500);

		    // Test deposit for SavingsAccount
		    savingsAccount.deposit(1000);
		    System.out.println("Savings account balance: " + savingsAccount.getAccountBalance());

		    // Test withdrawal for SavingsAccount
		    savingsAccount.withdraw(3000);
		    System.out.println("Savings account balance: " + savingsAccount.getAccountBalance());

		    // Test deposit for CheckingAccount
		    checkingAccount.deposit(1500);
		    System.out.println("Checking account balance: " + checkingAccount.getAccountBalance());

		    // Test withdrawal for CheckingAccount
		    checkingAccount.withdraw(3500);
		    System.out.println("Checking account balance: " + checkingAccount.getAccountBalance());

	}

	double calculateAccountFees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		//return null;
		
		String console;

		return console = "Account Number :" + this.acc_numb + "\n" + "Account Balance: " + "$" + this.acc_bal;
	}

	public String getAccountHolderName() {
		// TODO Auto-generated method stub
		
		
		return this.name;
	}

	public void setAccountHolderName(String accountHolderName) {
		accountHolderName =this.name ;
		
	}
}
