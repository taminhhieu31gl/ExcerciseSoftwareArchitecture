package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface ProductManagementRemote {
	public Product persistProduct(Product p);
	public List<Product> listProducts();
	public String testhehe();
	public Product find1Product(int id);
}
