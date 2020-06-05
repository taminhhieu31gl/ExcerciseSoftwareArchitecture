package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Product;

public class ProductDAO {
	private EntityManager em;
	public ProductDAO() {
		em= ControlEntityManager.getInstance().getEntityManager();
	}
	public Product themDoUong(Product o) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(o);
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return o;
	}
	public Product tim1DoUong(int id) {
		return em.find(Product.class, id);
	}
	public List<Product> dsDoUong(){
		return em.createNativeQuery("db.DoUong.find({})",Product.class).getResultList();
	}
}
