package state;

public class ttXLDonHang implements State{

	
	private DonHang donHang;
	
	
	public ttXLDonHang(DonHang donHang) {
		super();
		this.donHang = donHang;
	}

	@Override
	public void dat() {
		// TODO Auto-generated method stub
		System.out.println("Đơn hàng đã được đặt và trong quá trình xử lý");
	}

	@Override
	public void xuLy() {
		// TODO Auto-generated method stub
		System.out.println("Đơn hàng đang trong quá trình xử lý");
	}

	@Override
	public void huy() {
		// TODO Auto-generated method stub
		donHang.setCurState(donHang.getHuydonState());
		System.out.println("Đã hủy đơn hàng!!!");
	}

	@Override
	public void Giao() {
		// TODO Auto-generated method stub
		donHang.setCurState(donHang.getGiaoHangState());
		System.out.println("Đơn hàng đã được giao");
	}

}
