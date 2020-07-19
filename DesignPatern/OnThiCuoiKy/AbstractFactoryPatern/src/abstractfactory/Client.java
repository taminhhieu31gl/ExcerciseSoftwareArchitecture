package abstractfactory;

public class Client {
	public static void main(String[] args) {
		AbstractTwoFactory abstractTwoFactory = AbstractFactory.create("nhua");
		Ban b = abstractTwoFactory.createBan();
		b.create();
	}
}
