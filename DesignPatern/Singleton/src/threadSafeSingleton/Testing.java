package threadSafeSingleton;

public class Testing {
	public static void main(String[] args) {
		ThreadSafeSingleton eg1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton eg2 = ThreadSafeSingleton.getInstance();

	}
}
