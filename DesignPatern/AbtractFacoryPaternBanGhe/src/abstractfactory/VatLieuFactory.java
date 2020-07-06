package abstractfactory;

import model.Ban;
import model.Ghe;

public class VatLieuFactory {
	public static Ban getBan(VatLieuAbstractFactory factory) {
		return factory.themBan();
	}
	public static Ghe getGhe(VatLieuAbstractFactory factory) {
		return factory.themGhe();
	}
}
