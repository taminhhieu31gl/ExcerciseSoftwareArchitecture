package state;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		KhachHAng kh = new KhachHAng();
		System.out.println("tên bạn là gì: ");
		String ten = scn.nextLine();
		
		System.out.println("Địa chỉ của bạn là gì");
		String diaChi = scn.nextLine();
		
		System.out.println("Nhập SDT");
		String sdt = scn.nextLine();
		
		
		kh.setId("1");
		kh.setHoTen(ten);
		kh.setDiaChi(diaChi);
		kh.setSdt(sdt);
		DonHang donHang = new DonHang();
		
		MatHang matHang = new MatHang("1", "socola", 200000);
		MatHang matHang1 = new MatHang("2", "socola", 200000);
		MatHang matHang2 = new MatHang("3", "socola", 200000);
		
		System.out.println("MH"+ matHang);
		System.out.println("MH1"+ matHang1);
		System.out.println("MH2"+ matHang2);
		
		int mh;
		ArrayList<MatHang> mathang = new ArrayList<MatHang>();
		do {
			System.out.println("Quý Khách vui lòng chọn mặt hàng!!! nhấn -1 để kết thúc mua hàng");
			 mh = scn.nextInt();
			MatHang mhnew = new MatHang();
			switch (mh) {
			case 1:
				mhnew.setId(matHang.getId());
				mhnew.setTenMH(matHang.getTenMH());
				mhnew.setDonGia(matHang.getDonGia());
				break;
			case 2:
				mhnew.setId(matHang1.getId());
				mhnew.setTenMH(matHang1.getTenMH());
				mhnew.setDonGia(matHang1.getDonGia());
				break;
			case 3:
				mhnew.setId(matHang2.getId());
				mhnew.setTenMH(matHang2.getTenMH());
				mhnew.setDonGia(matHang2.getDonGia());
				break;
			default:
				break;
			}
			if(mh != -1)
			{
				mathang.add(mhnew);
			}
		}while(mh!=-1);
		
		System.out.println(mathang);
		kh.setListDH(mathang);
		System.out.println("Thông tin của khách hàng vừa mua: "+kh);

		
		System.out.println("Trạng thái của hóa đơn");
		int stateHD;
		ArrayList<String> liststate = new ArrayList<String>();
		do
		{
	        System.out.println("Chọn trạng thái cho khách hàng -> nhập -1 để hoàn tất đơn hàng");
	        System.out.println("1. đặt hàng \n 2. xử lý \n 3. hủy đơn hàng \n 4. giao hàng");
	        stateHD  = scn.nextInt();
	       
	        switch(stateHD)
	        {
	            case 1:
	            	donHang.dat();
	            	break;
	            case 2:
	            	donHang.xl();
	            	break;
	            case 3:
	            	donHang.huy();
	            	break;
	            case 4:
	            	donHang.giao();
	            	break;
	            default:
	            	break;
	        }
	    }while(stateHD != -1);
		
		System.out.println("Xong");
	}
}
