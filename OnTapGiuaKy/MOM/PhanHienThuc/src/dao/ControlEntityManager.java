package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Synchronization;

public class ControlEntityManager {
	private static ControlEntityManager instance= null;
	private EntityManager em;
	private ControlEntityManager() {
		em = Persistence.createEntityManagerFactory("MOM__GiuaKy_TaMinhHieu_17087871").createEntityManager();
	}
	public synchronized static ControlEntityManager getInstance() {
		if(instance == null) return instance = new ControlEntityManager();
		return instance;
	}
	public EntityManager getEntityManager() {
		return em;
	}
}
