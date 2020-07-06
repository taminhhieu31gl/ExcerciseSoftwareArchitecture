package threadSafeSingleton;

public class ThreadSafeSingleton {
	public static int count = 0;
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
		count++;
		System.out.println("value thread safe singeleton: " +count);
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
}