package decorate;

public class Sua extends AbstractDecorate{
	
	public Sua(MonChinh master) {
		super(master);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getGia() {
		// TODO Auto-generated method stub
		return this.master.getGia()+4;
	}

	@Override
	public String getMoTa() {
		// TODO Auto-generated method stub
		return this.master.getMoTa()+" ,sữa";
	}

}
