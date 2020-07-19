package implementation;

import abstraction.Bank;

public class Main {
	public static void main(String[] args) {
		 Bank vietcomBank = new VietComBank(new CheckingAccount());
	     vietcomBank.openAccount();

	     Bank tpBank = new TPbank(new SavingAccount());
	     tpBank.openAccount();
	}
	
}
