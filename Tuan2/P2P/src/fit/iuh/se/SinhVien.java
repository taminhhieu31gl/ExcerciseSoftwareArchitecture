package fit.iuh.se;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String mssv;
	private String ten;
	private int tuoi;
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public SinhVien(String mssv, String ten, int tuoi) {
		super();
		this.mssv = mssv;
		this.ten = ten;
		this.tuoi = tuoi;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", ten=" + ten + ", tuoi=" + tuoi + "]";
	}
	
	
}
