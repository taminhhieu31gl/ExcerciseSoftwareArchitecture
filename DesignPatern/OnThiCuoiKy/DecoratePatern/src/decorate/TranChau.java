package decorate;

public class TranChau extends AbstractDecorate{

	@Override
	public double getGia() {
		// TODO Auto-generated method stub
		return this.master.getGia()+12;
	}

	@Override
	public String getMoTa() {
		// TODO Auto-generated method stub
		return this.master.getMoTa() + ", Trân Châu";
	}

}
