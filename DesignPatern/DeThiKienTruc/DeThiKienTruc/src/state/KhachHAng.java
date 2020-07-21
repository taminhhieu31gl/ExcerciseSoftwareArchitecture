package state;

import java.util.ArrayList;
import java.util.List;

public class KhachHAng {
	private String id;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private List<MatHang> listmh= new ArrayList<MatHang>();
	
	@Override
	public String toString() {
		return "KhachHAng [id=" + id + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", listmh=" + listmh
				+ "]";
	}
	public List<MatHang> getListDH() {
		return listmh;
	}
	public KhachHAng(List<MatHang> listmh) {
		super();
		this.listmh = listmh;
	}
	public void setListDH(List<MatHang> listmh) {
		this.listmh = listmh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public KhachHAng(String id, String hoTen, String diaChi, String sdt) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public KhachHAng() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
