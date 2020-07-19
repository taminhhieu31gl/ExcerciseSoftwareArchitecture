package decorate;

public class TranChau extends AbstractMonPhu {

	public TranChau(MonChinh master) {
		super(master);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getDonGia() {
		// TODO Auto-generated method stub
		return master.getDonGia() + 2;
	}

	@Override
	public String getMoTa() {
		// TODO Auto-generated method stub
		return master.getMoTa() + ", trân châu";
	}
}
