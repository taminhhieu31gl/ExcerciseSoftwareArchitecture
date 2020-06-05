package ejbs;

import javax.ejb.Remote;

import entities.Order;
import entities.Product;

@Remote
public interface OrderManagementRemote {
	public Order persistOrder(Order p);
}
