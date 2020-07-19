package abstraction;

public abstract class Bank {
	protected Account account;
	public Bank(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	public abstract void openAccount();

	
}
