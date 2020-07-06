package model;

public class Ban {
	public String ten;
	public double gia;

	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public double getGia() {
		return gia;
	}


	public void setGia(double gia) {
		this.gia = gia;
	}

	

	public Ban(String ten, double gia) {
		super();
		this.ten = ten;
		this.gia = gia;
	}


	@Override
	public String toString() {
		return "Ban [ten=" + ten + ", gia=" + gia + "]";
	}
	
}
