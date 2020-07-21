package state;

import java.util.ArrayList;
import java.util.List;

public class DonHang {
	private String maDonHang;
	private String ngayDatHang;
	List<KhachHAng> listMH = new ArrayList<KhachHAng>();
	private String trangthai;
	public DonHang(String trangthai) {
		super();
		this.trangthai = trangthai;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public DonHang(List<KhachHAng> listMH) {
		super();
		this.listMH = listMH;
	}
	public List<KhachHAng> getListMH() {
		return listMH;
	}
	public void setListMH(List<KhachHAng> listMH) {
		this.listMH = listMH;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public String getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public DonHang(String maDonHang, String ngayDatHang) {
		super();
		this.maDonHang = maDonHang;
		this.ngayDatHang = ngayDatHang;
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", ngayDatHang=" + ngayDatHang + ", listMH=" + listMH + "]";
	}
	private State curState;
	private State datHangState;
	private State xulyhangState;
	private State huydonState;
	private State giaoHangState;
	
	
	public State getCurState() {
		return curState;
	}
	public void setCurState(State curState) {
		this.curState = curState;
	}
	public State getDatHangState() {
		return datHangState;
	}

	public State getXulyhangState() {
		return xulyhangState;
	}

	public State getHuydonState() {
		return huydonState;
	}

	public State getGiaoHangState() {
		return giaoHangState;
	}

	public DonHang() {
		  datHangState = new ttDatHang(this);
		  xulyhangState = new ttXLDonHang(this);
		  huydonState = new ttHuyDonHang(this);
		  giaoHangState = new ttGiaoHang(this);
		  curState = datHangState;
	}

	public void dat() {
		curState.dat();
	}
	public void xl() {
		curState.xuLy();
	}
	public void huy() {
		curState.huy();
	}
	public void giao() {
		curState.Giao();
	}
	
	
	
	
	
}
