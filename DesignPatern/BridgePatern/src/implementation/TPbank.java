package implementation;

import abstraction.Account;
import abstraction.Bank;

public class TPbank extends Bank{

	public TPbank(Account account) {
		super(account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAccount() {
		// TODO Auto-generated method stub
		System.out.print("Open your account at TPBank is a ");
        account.openAccount();
	}


	
}
