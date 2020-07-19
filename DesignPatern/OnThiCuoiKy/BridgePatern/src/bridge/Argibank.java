package bridge;
 
public class Argibank extends Bank{

	public Argibank(Account account) {
		super(account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAccount() {
		// TODO Auto-generated method stub
		System.out.println("Mở Tài Khoản Argibank");
	}

}
