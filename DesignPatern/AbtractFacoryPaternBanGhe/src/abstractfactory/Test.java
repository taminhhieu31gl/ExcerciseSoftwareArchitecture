package abstractfactory;

import model.Ghe;

public class Test {
	public static void main(String[] args) {
		VatLieuAbstractFactory vatLieuAbstractFactory = VatLieuFactory.getVatLieu("nhua");
		Ghe ghe = vatLieuAbstractFactory.themGhe();
		ghe.create();
	}

}
