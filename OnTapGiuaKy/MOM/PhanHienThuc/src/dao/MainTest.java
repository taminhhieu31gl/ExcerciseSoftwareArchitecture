package dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import entities.Order;
import entities.OrderDetail;
import entities.Product;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OrderDAO orderDAO = new OrderDAO();
			ProductDAO productDAO = new ProductDAO();
			Product p1 = new Product("Sting", 5, 10000);
			Product p2 = new Product("Number One", 25, 13000);
			Product p3 = new Product("0 do", 15, 13000);
			Product p4 = new Product("Pepsi", 35, 12000);
			System.out.println(productDAO.themDoUong(p1));
			System.out.println(productDAO.themDoUong(p2));
			System.out.println(productDAO.themDoUong(p3));
			System.out.println(productDAO.themDoUong(p4));
			
			OrderDetail o1 = new OrderDetail(3, productDAO.tim1DoUong(p1.getId()));
			OrderDetail o2 = new OrderDetail(4, productDAO.tim1DoUong(p2.getId()));
			//System.out.println("haha" +productDAO.tim1DoUong(p1.getId()));
			
			List<OrderDetail> list = Arrays.asList(o1,o2);
			Order order = new Order(LocalDate.of(1999, 4, 3), 16, 3*p1.getDonGia() + 4*p2.getDonGia(), list);
			System.out.println(orderDAO.orderDoUong(order));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
