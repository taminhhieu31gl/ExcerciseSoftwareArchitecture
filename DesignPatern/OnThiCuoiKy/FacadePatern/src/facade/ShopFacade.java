package facade;

public class ShopFacade {
	private static final ShopFacade INSTANCE = new ShopFacade();

	private AService aService;
	private BService bService;
	private CService cService;
	

	public static ShopFacade getInstance() {
		return INSTANCE;
	}
	public AService getaService() {
		return aService;
	}
	public void setaService(AService aService) {
		this.aService = aService;
	}
	public BService getbService() {
		return bService;
	}
	public void setbService(BService bService) {
		this.bService = bService;
	}
	public CService getcService() {
		return cService;
	}
	public void setcService(CService cService) {
		this.cService = cService;
	}
	public ShopFacade() {
		super();
		aService = new AService();
		bService = new BService();
		cService = new CService();
	}
	public void hanhDongA() {
		aService.XulyA();
	}
	public void hanhDongABC() {
		aService.XulyA();
		bService.XulyB();
		cService.XulyC();
	}
	
}
