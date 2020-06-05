package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetail implements Serializable {
	private int soLuong;
	@ManyToOne
	@JoinColumn(name="doUongId")
	private Product doUong;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Product getDoUong() {
		return doUong;
	}
	public void setDoUong(Product doUong) {
		this.doUong = doUong;
	}
	public OrderDetail(int soLuong, Product doUong) {
		super();
		this.soLuong = soLuong;
		this.doUong = doUong;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", doUong=" + doUong + "]";
	}
	
	
}
