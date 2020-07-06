package adapter3;

public class TestAdapter {
	public static void main(String[] args) {
		//USAddress usAddress = new USAddress();
		//System.out.println(usAddress.isValidAddress("aaa12312323123","aaa12312323123","aaa12312323123"));
		//CAAddress caAddress = new CAAddress();
		//System.out.println(caAddress.isValidCanadianAddr("aaa","aaa","aaa"));
		Customer customer1 = new Customer("KH1", "12345678910111213", "123456", "123456", Customer.CANADA);
		System.out.println(customer1.isValidAddress());
		Customer customer2 = new Customer("bbbbbbbbbbb", "bbbbbbbbbbb", "bbbbbbbbbbb", "bbbbbbbbbbb", Customer.US);
		System.out.println(customer2.isValidAddress());
	}
}
