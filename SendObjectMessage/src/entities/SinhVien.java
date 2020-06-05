package entities;

import java.io.Serializable;

public class SinhVien implements Serializable{
	private String ma;
	private String ten;
	private int tuoi;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
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
	public SinhVien(String ma, String ten, int tuoi) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.tuoi = tuoi;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SinhVien [ma=" + ma + ", ten=" + ten + ", tuoi=" + tuoi + "]";
	}
	
}
