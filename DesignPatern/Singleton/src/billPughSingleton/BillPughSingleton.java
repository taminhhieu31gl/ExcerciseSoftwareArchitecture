package billPughSingleton;

public class BillPughSingleton {

	public static int count = 0;
	private BillPughSingleton() {
		count++;
		System.out.println("value bill pugh singleton: " +count);
	}

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
		
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
