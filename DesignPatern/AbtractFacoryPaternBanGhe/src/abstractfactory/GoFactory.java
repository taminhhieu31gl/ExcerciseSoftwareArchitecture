package abstractfactory;

import model.Ban;
import model.BanGo;
import model.Ghe;
import model.GheGo;

public class GoFactory extends VatLieuAbstractFactory {

	@Override
	public Ban themBan() {
		// TODO Auto-generated method stub
		return new BanGo();
	}

	@Override
	public Ghe themGhe() {
		// TODO Auto-generated method stub
		return new GheGo();
	}


	
}
