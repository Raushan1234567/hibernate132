package com.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connect {
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("Raushan4");
	}
	
	static EntityManager getco() {
		return emf.createEntityManager();
	}

}
