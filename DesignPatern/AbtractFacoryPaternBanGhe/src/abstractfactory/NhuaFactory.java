package abstractfactory;

import model.Ban;
import model.BanNhua;
import model.Ghe;
import model.GheNhua;

public class NhuaFactory extends VatLieuAbstractFactory{

	@Override
	public Ban themBan() {
		// TODO Auto-generated method stub
		return new BanNhua();
	}

	@Override
	public Ghe themGhe() {
		// TODO Auto-generated method stub
		return new GheNhua();
	}



}
