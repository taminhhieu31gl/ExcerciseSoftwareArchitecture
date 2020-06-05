package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DoUong")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ten;
	private int soLuong;
	private double donGia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Product( String ten, int soLuong, double donGia) {
		super();
		this.ten = ten;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String ten, int soLuong, double donGia) {
		super();
		this.id = id;
		this.ten = ten;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "DoUong [id=" + id + ", ten=" + ten + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}
	
	
	
	
	
}
