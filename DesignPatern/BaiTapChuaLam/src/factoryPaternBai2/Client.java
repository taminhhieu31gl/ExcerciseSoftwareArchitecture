package factoryPaternBai2;

public class Client {
	public static void main(String[] args) {
		BankFactory bank = new  BankFactory();
		bank.getBank("ACB").getThongTin();
	}
}
