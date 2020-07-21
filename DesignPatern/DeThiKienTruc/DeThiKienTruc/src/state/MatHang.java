package state;

public class MatHang {
	private String id;
	private String tenMH;
	private double donGia;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "MatHang [id=" + id + ", tenMH=" + tenMH + ", donGia=" + donGia + "]";
	}
	public MatHang(String id, String tenMH, double donGia) {
		super();
		this.id = id;
		this.tenMH = tenMH;
		this.donGia = donGia;
	}
	public MatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
