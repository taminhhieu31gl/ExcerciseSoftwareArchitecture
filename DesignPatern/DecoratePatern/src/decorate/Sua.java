package decorate;

public class Sua extends AbstractMonPhu {

	public Sua(MonChinh master) {
		super(master);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getDonGia() {
		// TODO Auto-generated method stub
		return master.getDonGia() + 4;
	}

	@Override
	public String getMoTa() {
		// TODO Auto-generated method stub
		return master.getMoTa() + ", sữa";
	}
	
}
