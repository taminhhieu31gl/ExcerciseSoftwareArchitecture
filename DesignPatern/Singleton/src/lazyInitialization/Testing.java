package lazyInitialization;

public class Testing {
	public static void main(String[] args) {
		LazyInitializedSingleton eg1 = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton eg2 = LazyInitializedSingleton.getInstance();
	}
}
