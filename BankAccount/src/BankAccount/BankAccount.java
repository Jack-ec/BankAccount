package BankAccount;

public class BankAccount {
	
	String accountName = "";
	double balance;
	double withdrawalFee;
	double annualInterestRate;
	int accountID;
	
	public BankAccount() {
		this("");
	}
	public BankAccount(String accountName) {
		this(accountName, 0);
	}
	public BankAccount(String accountName, double balance) {
		this(accountName, balance, 0);
	}
	public BankAccount(String accountName, double balance, double withdrawalFee) {
		this(accountName, balance, withdrawalFee, 0);
	}
	public BankAccount(String accountName, double balance, double withdrawalFee, double annualInterestRate) {
		
	}

}
