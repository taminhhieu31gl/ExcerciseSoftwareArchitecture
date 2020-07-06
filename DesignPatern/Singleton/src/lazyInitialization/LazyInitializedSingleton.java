package lazyInitialization;

public class LazyInitializedSingleton {
	public static int count = 0;
	private static final LazyInitializedSingleton instance = new LazyInitializedSingleton();

	// private constructor to avoid client applications to useconstructor

	private LazyInitializedSingleton(){
		count++;
		System.out.println("value lazy initialized singeleton: " +count);
	}

	public static LazyInitializedSingleton getInstance() {
		return instance;
	}
}