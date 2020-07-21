package state;

public class ttDatHang implements State{
	private DonHang donHang;

	public ttDatHang(DonHang donHang) {

		super();
		this.donHang = donHang;
	}

	@Override
	public void dat() {
		// TODO Auto-generated method stub
		System.out.println("Đã đặt hàng!");
	}

	@Override
	public void xuLy() {
		// TODO Auto-generated method stub
		donHang.setCurState(donHang.getXulyhangState());
		System.out.println("Xử lý đơn hàng!!!");
	}

	@Override
	public void huy() {
		// TODO Auto-generated method stub
		donHang.setCurState(donHang.getHuydonState());
		System.out.println("Đã hủy đơn");
	}

	@Override
	public void Giao() {
		// TODO Auto-generated method stub
		System.out.println("Đơn Hàng chưa được xử lý!!!");
	}
	
	
}
