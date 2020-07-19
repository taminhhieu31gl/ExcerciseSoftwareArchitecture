package bridge;

public abstract class Bank {
	protected Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Bank(Account account) {
		super();
		this.account = account;
	}
	public abstract void openAccount();
}
