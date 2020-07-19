package implementation;

import abstraction.Account;
import abstraction.Bank;

public class VietComBank extends Bank {

	public VietComBank(Account account) {
		super(account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAccount() {
		// TODO Auto-generated method stub
		System.out.print("Open your account at VietcomBank is a ");
		account.openAccount();
	}

}
