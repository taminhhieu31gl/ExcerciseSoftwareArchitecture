package abstractfactory;

public class AbstractFactory {
	public static AbstractTwoFactory create(String type) {
		if(type.equalsIgnoreCase("nhua"))
			return new NhuaFactory();
		else if(type.equalsIgnoreCase("go")) {
			return new GoFactory();
		}else return null;
	}
}
