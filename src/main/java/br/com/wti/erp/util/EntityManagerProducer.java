package br.com.wti.erp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("InventoryWeb");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
