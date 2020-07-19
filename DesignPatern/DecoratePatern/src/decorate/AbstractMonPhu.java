package decorate;

public abstract class AbstractMonPhu implements MonChinh{
	public MonChinh master;

	public MonChinh getMaster() {
		return master;
	}
	public AbstractMonPhu(MonChinh master) {
		super();
		this.master = master;
	}
	@Override
	public int getDonGia() {
		// TODO Auto-generated method stub
		return master.getDonGia();
	}

	@Override
	public String getMoTa() {
		// TODO Auto-generated method stub
		return master.getMoTa();
	}
	
}
