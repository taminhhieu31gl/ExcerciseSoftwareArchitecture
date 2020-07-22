package factoryPaternBai2;

public class BankFactory {
	public Bank getBank(String bank) {
		if(bank.equalsIgnoreCase("Sacombank"))
			return new Sacombank();
		else if(bank.equalsIgnoreCase("Viettinbank"))
			return new ViettinBank();
		else if(bank.equalsIgnoreCase("ACB"))
			return new ACB();
		else return null;
	}
}
