package abstractfactory;

import model.Ban;
import model.Ghe;

public class NhuaFactory implements VatLieuAbstractFactory{

	@Override
	public Ban themBan() {
		// TODO Auto-generated method stub
		return new Ban("ban nhua", 4);
	}

	@Override
	public Ghe themGhe() {
		// TODO Auto-generated method stub
		return new Ghe("ghe nhua", 4);
	}

}
