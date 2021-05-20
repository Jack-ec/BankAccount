import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class BankAccount {

	String accountName = "";
	double balance;
	double withdrawalFee;
	double annualInterestRate;
	int accountID;
	static int nextAccountID = 1000000;
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();


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
		if (false == isOverDrawn()) {
			balance = balance + ((balance * annualInterestRate) / 100);
		}
		return balance;
	}
	public String toString() {
		if (true == isOverDrawn()) {
			return "BankAccount: name = " + "'" + accountName + "'; balance = ($" +  String.format("%.2f", balance * (-1)) +  ")";
		}
		else {
			return "BankAccount: name = " + "'" + accountName + "'; balance = $" + String.format("%.2f", balance);
		}

	}

	public ArrayList<Transaction> getTransactions(LocalDateTime startTime, LocalDateTime endTime) {
		ArrayList<Transaction> returnList = new ArrayList<Transaction>();
		for (int i = 0; i < transactions.size(); i++) {
			if (startTime != null && endTime != null) {
				if (transactions.get(i).getTransactionTime().isBefore(endTime)) {
					returnList.set(i,  transactions.get(i));
					Collections.reverse(returnList);
				}
			}
			else if (startTime != null) {
				if (transactions.get(i).getTransactionTime().isBefore(endTime)) {
					returnList.set(i,  transactions.get(i));
					Collections.reverse(returnList);
				}

			}
			else if (endTime != null) {
				if (transactions.get(i).getTransactionTime().isAfter(startTime)) {
					returnList.set(i,  transactions.get(i));
					Collections.reverse(returnList);
				}
			}
			else {
				if (transactions.get(i).getTransactionTime().isAfter(startTime) && transactions.get(i).getTransactionTime().isBefore(endTime)) {
					returnList.set(i,  transactions.get(i));
					Collections.reverse(returnList);
				}
			}
		}return returnList;

	}
}

