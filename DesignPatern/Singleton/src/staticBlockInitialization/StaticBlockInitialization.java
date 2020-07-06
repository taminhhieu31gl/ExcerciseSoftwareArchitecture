package staticBlockInitialization;

public class StaticBlockInitialization {
	public static int count = 0;
	private static final StaticBlockInitialization instance;

	// private constructor to avoid client applications to useconstructor

	private StaticBlockInitialization() {
		count++;
		System.out.println("value static block initialization: " +count);
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockInitialization();
		}catch(Exception e){
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockInitialization getInstance(){
		return instance;
		}
}
