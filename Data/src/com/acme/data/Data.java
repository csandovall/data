package com.acme.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Data {
	
	public void createData(String key, String value) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		DataItem dataItem = new DataItem(key, value);
		try {
			tx.begin();
			em.persist(dataItem);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public String readValue(String key) {
		EntityManager em = EMF.get().createEntityManager();
		return em.find(DataItem.class, key).getValue();
	}
	
	public void updateValue(String key, String value) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		DataItem dataItem = em.find(DataItem.class, key);
		dataItem.setValue(value);
		try {
			tx.begin();
			em.merge(dataItem);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
	
	public void deleteData(String key) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		DataItem dataItem = em.find(DataItem.class, key);
		try {
			tx.begin();
			em.remove(dataItem);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			em.close();
		}
	}
}