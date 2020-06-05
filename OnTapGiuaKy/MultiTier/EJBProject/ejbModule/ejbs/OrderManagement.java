package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Order;
/**
 * Session Bean implementation class OrderManagement
 */
@Stateless(name="OrderManagement",mappedName = "ejbs/OrderManagement")
@LocalBean
public class OrderManagement implements OrderManagementRemote, OrderManagementLocal {

	@PersistenceContext(unitName = "GiuaKy_EJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public OrderManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Order persistOrder(Order p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p;
	}

}
