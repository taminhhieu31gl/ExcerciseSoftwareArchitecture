package state;

public class ttHuyDonHang implements State{

	
	private DonHang donHang;
	
	public ttHuyDonHang(DonHang donHang) {
		super();
		this.donHang = donHang;
	}

	@Override
	public void dat() {
		// TODO Auto-generated method stub
		System.out.println("Đơn Hàng đã bị hủy");
	}

	@Override
	public void xuLy() {
		// TODO Auto-generated method stub
		System.out.println("Đơn Hàng đã bị hủy");
	}

	@Override
	public void huy() {
		// TODO Auto-generated method stub
		System.out.println("Đơn Hàng đã bị hủy");
	}

	@Override
	public void Giao() {
		// TODO Auto-generated method stub
		System.out.println("Đơn Hàng đã bị hủy");
	}
	
}
