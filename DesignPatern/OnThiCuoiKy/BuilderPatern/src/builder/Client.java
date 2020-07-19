package builder;

public class Client {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount
				.BankAccountBuilder("a","123").withAddress("213").build();
		System.out.println(account1);

		BankAccount account2 = new BankAccount
				.BankAccountBuilder("b","111").withEmail("a@gmail.com").build();
		

		System.out.println(account2);
	}
}
