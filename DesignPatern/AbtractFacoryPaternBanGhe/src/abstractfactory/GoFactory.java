package abstractfactory;

import model.Ban;
import model.Ghe;

public class GoFactory implements VatLieuAbstractFactory {

	@Override
	public Ban themBan() {
		// TODO Auto-generated method stub
		return new Ban("Ban go", 4);
	}

	@Override
	public Ghe themGhe() {
		// TODO Auto-generated method stub
		return new Ghe("Ghe Go",5);
	}
	
}
