package state;

public class ttGiaoHang implements State{
	private DonHang donHang;

	public ttGiaoHang(DonHang donHang) {
		super();
		this.donHang = donHang;
	}

	@Override
	public void dat() {
		// TODO Auto-generated method stub
		System.out.println("Dơn Hàng đã được giao");
	}

	@Override
	public void xuLy() {
		// TODO Auto-generated method stub
		System.out.println("Dơn Hàng đã được giao");
	}

	@Override
	public void huy() {
		// TODO Auto-generated method stub
		System.out.println("Dơn Hàng đã được giao");
	}

	@Override
	public void Giao() {
		// TODO Auto-generated method stub
		System.out.println("Dơn Hàng đã được giao");
	}
	
	
}
