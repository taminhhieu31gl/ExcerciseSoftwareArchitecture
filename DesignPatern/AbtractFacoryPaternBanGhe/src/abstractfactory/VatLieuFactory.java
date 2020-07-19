package abstractfactory;

public class VatLieuFactory {
	
	public VatLieuFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static VatLieuAbstractFactory getVatLieu(String type) {
		if(type.equalsIgnoreCase("nhua")) {
			return new NhuaFactory();
		}else if(type.equalsIgnoreCase("go")) {
			return new GoFactory();
		}else return null;
		
	}
}
