package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Product;

/**
 * Session Bean implementation class ProductManagement
 */
@Stateless(name="ProductManagement", mappedName = "ejbs/ProductManagement")
@LocalBean
public class ProductManagement implements ProductManagementRemote, ProductManagementLocal {

	@PersistenceContext(unitName = "GiuaKy_EJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ProductManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Product persistProduct(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p;
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from DoUong",Product.class).getResultList();
	}

	@Override
	public String testhehe() {
		// TODO Auto-generated method stub
		return "ddax ket noi";
	}

	@Override
	public Product find1Product(int id) {
		// TODO Auto-generated method stub
		return em.find(Product.class,id);
	}

}
