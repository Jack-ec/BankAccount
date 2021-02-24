

public class BankAccount {

	String accountName = "";
	double balance;
	double withdrawalFee;
	double annualInterestRate;
	int accountID;
	static int nextAccountID = 1000000;
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
		if (accountName.length() <= 20) {
			this.accountName = accountName;
		}
		else { 
			this.accountName = accountName.substring(0, 20);
		}
		this.annualInterestRate = annualInterestRate;
		this.balance = balance;
		this.withdrawalFee = withdrawalFee;
		this.accountID = nextAccountID;
		nextAccountID = nextAccountID + 1;
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
		return accountID;
	}
	public static int getNextAccountID() {
		return nextAccountID;
	}

	// mutators
	public void setWithdrawalFee(double withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	//Methods
	public void deposit(double amount) {
		balance = balance + amount;
	}
	public void withdraw(double amount) {
		balance = balance - amount - withdrawalFee;

	}
	public boolean isOverDrawn( ) {
		if (balance < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public double addAnnualInterest() {
		if (balance > 0) {
			balance = balance + ((balance * annualInterestRate) / 100);
		}
		return balance;
	}
	public String toString() {
		return "BankAccount" + accountID':' + balance

	}




}
