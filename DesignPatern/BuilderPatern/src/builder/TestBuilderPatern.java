package builder;

public class TestBuilderPatern {
	public static void main(String[] args) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments agement issues
		Computer comp = new Computer.ComputerBuilder("500db","12")
				.build();
		System.out.println(comp);
	}
}
