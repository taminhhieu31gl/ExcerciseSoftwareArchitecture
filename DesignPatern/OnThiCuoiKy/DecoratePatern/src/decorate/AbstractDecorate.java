package decorate;

public abstract class AbstractDecorate implements MonChinh {
	protected MonChinh master;

	public MonChinh getMaster() {
		return master;
	}

	public void setMaster(MonChinh master) {
		this.master = master;
	}

	public AbstractDecorate(MonChinh master) {
		super();
		this.master = master;
	}

	public AbstractDecorate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
