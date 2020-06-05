package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Order;
import entities.OrderDetail;

public class OrderDAO {
	private EntityManager em;
	public OrderDAO() {
		em= ControlEntityManager.getInstance().getEntityManager();
	}
	public Order orderDoUong(Order o) {
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
	
}
