package com.ty.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class Crud {
	EntityManagerFactory entityManagerFactory;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void insert(Invoice invoice, Item item) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

	public void uodateInvoice(Invoice invoice) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Item item = invoice.getItem();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

	public Invoice getInvoiceAndItem(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		if (invoice != null) {
			entityTransaction.commit();
			return invoice;
		}
		Item item = entityManager.find(Item.class, id);
		if (item != null) {
			int id2 = item.getId();
			Invoice invoice2 = entityManager.find(Invoice.class, id2);
			entityTransaction.commit();
			return invoice2;
		}
		return null;
	}

	public void deleteInvoiceAndItem(Invoice invoice, Item item) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Invoice invoice2 = entityManager.find(Invoice.class, invoice.getId());
		if (invoice2 != null)
			entityManager.remove(invoice2);
		Item item2 = entityManager.find(Item.class, item.getId());
		if (item2 != null)
			entityManager.remove(item2);
		entityTransaction.commit();
	}
}
