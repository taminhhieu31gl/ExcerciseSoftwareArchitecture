package test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbs.OrderManagementRemote;
import ejbs.ProductManagementRemote;
import entities.Order;
import entities.OrderDetail;
import entities.Product;

public class TestEJB {
	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		ProductManagementRemote pm = (ProductManagementRemote) ctx.lookup("ejbs/ProductManagement");
		OrderManagementRemote om = (OrderManagementRemote) ctx.lookup("ejbs/OrderManagement");
		System.out.println("haha ");
		System.out.println(pm.testhehe());
		//System.out.println(pm.te);
		Product p1 = new Product("Bo Huc",2, 10000);
		Product p2 = new Product("Number One",3, 12000);
		//1.theem 1 do uong
		System.out.println(pm.persistProduct(p1));
		System.out.println(pm.persistProduct(p2));
		//2.ds do uong
		System.out.println(pm.listProducts());
		
		//3. them 1 order (co' ds do uong')
		OrderDetail ord1 = new OrderDetail(2, pm.find1Product(1));
		OrderDetail ord2 = new OrderDetail(3, pm.find1Product(2));
		List<OrderDetail> listord = Arrays.asList(ord1,ord2);
		double tongTien = 2*pm.find1Product(1).getDonGia() + 3*pm.find1Product(2).getDonGia();
		Order o1 = new Order(LocalDate.now(), 12, tongTien, listord);
		System.out.println("them 1 hd "+ om.persistOrder(o1));
		
		
	}
}
