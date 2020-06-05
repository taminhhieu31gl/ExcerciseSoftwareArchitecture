package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "HoaDon")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maHd;
	private LocalDate ngayTao;
	private int banSo;
	private double tongTien;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<OrderDetail> listCthd;
	public int getMaHd() {
		return maHd;
	}
	public void setMaHd(int maHd) {
		this.maHd = maHd;
	}
	public LocalDate getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getBanSo() {
		return banSo;
	}
	public void setBanSo(int banSo) {
		this.banSo = banSo;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public List<OrderDetail> getListCthd() {
		return listCthd;
	}
	public void setListCthd(List<OrderDetail> listCthd) {
		this.listCthd = listCthd;
	}
	public Order(LocalDate ngayTao, int banSo, double tongTien, List<OrderDetail> listCthd) {
		super();
		this.ngayTao = ngayTao;
		this.banSo = banSo;
		this.tongTien = tongTien;
		this.listCthd = listCthd;
	}
	public Order(int id,LocalDate ngayTao, int banSo, double tongTien, List<OrderDetail> listCthd) {
		super();
		this.maHd = id;
		this.ngayTao = ngayTao;
		this.banSo = banSo;
		this.tongTien = tongTien;
		this.listCthd = listCthd;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [maHd=" + maHd + ", ngayTao=" + ngayTao + ", banSo=" + banSo + ", tongTien=" + tongTien
				+ ", listCthd=" + listCthd + "]";
	}
	
	
	
}