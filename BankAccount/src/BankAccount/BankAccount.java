package BankAccount;

public class BankAccount {

	String accountName = "";
	double balance;
	double withdrawalFee;
	double annualInterestRate;
	static int accountID;
	// constructors
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
		this(accountName, balance, withdrawalFee, annualInterestRate, 0);
	}
	public BankAccount(String accountName, double balance, double withdrawalFee, double annualInteresrRate, int accountID) {

	}
	//getters
	public String getAccountName() {
		return this.accountName;
	}
	public double getBalance() {
		return this.balance;
	}
	public double getWithdrawalFee() {
		return this.withdrawalFee;
	}
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	public int getAccountID() {
		return BankAccount.accountID;
	}




}
