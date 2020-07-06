package test;

public class EagerInitializedSingleton {
	public static int count = 0;
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to useconstructor

	private EagerInitializedSingleton(){
		count++;
		System.out.println("value eager initialized singleton: " +count);
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}