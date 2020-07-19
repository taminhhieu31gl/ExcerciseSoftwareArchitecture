package bridge;

public class Client {
	public static void main(String[] args) {
		Bank b = new BIDV(new TypeAccountNormal());
		b.openAccount();
	}
}
