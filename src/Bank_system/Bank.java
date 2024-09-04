package Bank_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {

	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	public void addAccount(BankAccount BankAccOB) {

		accounts.add(BankAccOB);
	}

	public void removeAccount(int accountNumber) {
		for (BankAccount a : accounts) {
			if ((a.getAccountNumber()) == accountNumber) {
				accounts.remove(accountNumber);
				System.out.println(accountNumber + " account has been closed");
			} else {
				System.out.println("Account not found with given account number ");
			}
		}

	}

	public BankAccount getAccount(BankAccount accountNumber) {

		for (int i = 0; i <= accounts.size(); i++) {
			if ((accounts.get(i)).equals(accountNumber)) {
				return accountNumber;
			} else {
				return null;
			}
		}
		return accountNumber;

	}

	public void updateAccount(int accountNumber, BankAccount updatedAccount) {
		boolean accountFound = false;

		for (BankAccount account : accounts) {

			if (account.getAccountNumber() == accountNumber) {
				account.setAccountHolderName(updatedAccount.getAccountHolderName());
				account.setAccountBalance(updatedAccount.getAccountBalance());
				// Add any additional setters you have created in the BankAccount class
				accountFound = true;
				break;
			}

			accountFound = true;
			break;
		}
		if (!accountFound) {
			System.out.println("Account with account number " + accountNumber + " could not be located.");
		}

	}

	public void transferFunds(int fromAccountNumber, int toAccountNumber, double amount)
			throws OverdraftLimitExceededException {
		BankAccount fromAccount = null;
		BankAccount toAccount = null;

		for (BankAccount account : accounts) {
			if (account.getAccountNumber() == fromAccountNumber) {
				fromAccount = account;
			} else if (account.getAccountNumber() == toAccountNumber) {
				toAccount = account;
			}
		}

		if (fromAccount != null && toAccount != null) {
			if (fromAccount.getAccountBalance() >= amount) {
				fromAccount.withdraw(amount);
				toAccount.deposit(amount);
				System.out.println("Successfully transferred " + amount + " from account " + fromAccountNumber
						+ " to account " + toAccountNumber);
			} else {
				System.out.println("Insufficient funds in account " + fromAccountNumber);
			}
		} else {
			System.out.println("One or both account numbers are not found.");
		}
	}
	
	
	
	public void generateAccountReport()
	{
		System.out.printf("%-15s %-15s %10s%n", "Account Number", "Account Type", "Balance");
        System.out.println("----------------------------------------------");
		for(BankAccount b :accounts)
		{
		
			 System.out.printf("%-15d %-15s %10.2f%n", b.getAccountNumber(), b.getClass().getSimpleName(), b.getAccountBalance());
			
		}
	}

	
	public void startBankingSystem()
	{
		System.out.println("welcome to starBanking system");
		System.out.println("please choose option from given menue ");
		System.out.println("1. create account \n2. Get details of existing Account \n3. Deposit Money \n4. withdraw money 2\n5. exit");
	}
	
	public void displayAccountDetails1(int accountNumber) {
		BankAccount account = findAccount(accountNumber);
		if (account != null) {
			System.out.println(account);
		} else {
			System.out.println("Account not found.");
		}
	}

	// private BankAccount findAccount(int accountNumber) {
	// TODO Auto-generated method stub

	// return null;
	// }

	public BankAccount findAccount(int accountNumber) {
		for (BankAccount account : this.accounts) {
			if (account.getAccountNumber() == (accountNumber)) {
				return account;
			}
		}
		return null;
	}

	public void deposit(int accountNumber, double amount) {
		BankAccount account = findAccount(accountNumber);
		if (account != null) {
			account.deposit(amount);
		}
	}

	public void withdraw(int accountNumber, double amount) throws OverdraftLimitExceededException {
		BankAccount account = findAccount(accountNumber);
		if (account != null) {
			account.withdraw(amount);
		}
	}

	public void displayAccountDetails(int accountNumber) {
		BankAccount account = findAccount(accountNumber);
		if (account != null) {
			System.out.println(account);
		} else {
			System.out.println("Account not found.");
		}
	}

	public static void main(String[] args) throws OverdraftLimitExceededException {

		/*
		 * Bank myBank = new Bank();
		 * 
		 * SavingsAccount savingsAccount = new SavingsAccount(1001, 5000);
		 * myBank.addAccount(savingsAccount);
		 * 
		 * CheckingAccount checkingAccount = new CheckingAccount(1002, 3000, 1000);
		 * myBank.addAccount(checkingAccount);
		 * 
		 * BusinessAccount businessAccount = new BusinessAccount(1003, 10000);
		 * myBank.addAccount(businessAccount);
		 * 
		 * 
		 * myBank.deposit(savingsAccount.getAccountNumber(),200);
		 * myBank.deposit(checkingAccount.getAccountNumber(),300);
		 * myBank.deposit(businessAccount.getAccountNumber(), 1000);
		 * 
		 * myBank.withdraw(savingsAccount.getAccountNumber(), 100);
		 * myBank.withdraw(checkingAccount.getAccountNumber(), 200);
		 * myBank.withdraw(businessAccount.getAccountNumber(), 500);
		 * 
		 * myBank.displayAccountDetails(savingsAccount.getAccountNumber());
		 * myBank.displayAccountDetails(checkingAccount.getAccountNumber());
		 * myBank.displayAccountDetails(businessAccount.getAccountNumber());
		 * 
		 

		Bank myBank = new Bank();
		myBank.addAccount(new SavingsAccount(123, "John Doe", 500.0));
		myBank.addAccount(new CheckingAccount(456, "Jane Smith", 250.0));

		myBank.updateAccount(123, new SavingsAccount(123, "John Doe Updated", 600.0));
		myBank.updateAccount(456, new CheckingAccount(456, "Jane Smith Updated", 300.0));

		// Verify that the updates have been applied correctly
		myBank.displayAccountDetails(123);
		myBank.displayAccountDetails(456);
		
		myBank.generateAccountReport();
		*/
		Bank myBank = new Bank();
		myBank.startBankingSystem();
		int input = 0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			input = sc.nextInt();
			if(input>5)
			{
				System.out.println("Entered valid input number");
			}
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			 System.out.println("Entered valid input ");
			 //e.printStackTrace();
			 
		}
		
		switch(input)
		{
			case 1:System.out.println("You selected option to create Account");
				   System.out.println("Which type of account you want to create \n1.Saving \n2.Checking \n3.Business");
				   int accountType = sc.nextInt();
				   myBank.addAccount(new SavingsAccount(111, "Mau", 5000));
					break;
			case 2:System.out.println("You selected option to Get details of existing Account");
					myBank.getAccount(null);
					break;
			case 3:System.out.println("You selected option to Deposit Money ");
					myBank.deposit(111, 5000);
					break;
			case 4:System.out.println("You selected option to withdraw money");
					myBank.withdraw(111, 1000);
					break;
			case 5:System.out.println("You selected option to exit");
					myBank.generateAccountReport();
					break;
		}
		
	}

}
