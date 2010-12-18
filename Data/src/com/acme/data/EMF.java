package com.acme.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions-optional");
	
	public static EntityManagerFactory get() {
		return emf;
	}
	private EMF() {
	}
}