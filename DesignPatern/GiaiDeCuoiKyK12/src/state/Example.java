package state;

public class Example {
	public static void main(String[] args) {
		DonHang dh = new DonHang();
		dh.setState(new DatHangState());
		dh.applyState();
	}
}
