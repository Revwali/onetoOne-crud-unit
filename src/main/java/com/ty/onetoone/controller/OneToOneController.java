package com.ty.onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dao.Crud;
import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class OneToOneController {

	public static void main(String[] args) {
		Crud crud=new Crud();
		Item item = new Item();
		Item item2 = new Item();
		Invoice invoice = new Invoice();
		Invoice invoice2 = new Invoice();
		invoice.setBillingAdress("ssfsd");
		invoice.setGetNumber("as56l032");
		invoice.setId(1);
		invoice.setName("aseds");
		invoice.setTax(15.0);
		item.setId(1);
		item.setName("pen");
		item.setPrice(5.0);
		item.setQuantity(5);
		invoice.setItem(item);
		crud.insert(invoice, item);
		// ------------------------
		invoice2.setBillingAdress("redfs");
		invoice2.setGetNumber("re4587l");
		invoice2.setId(2);
		invoice2.setName("fees");
		invoice2.setTax(25.0);
		item2.setId(2);
		item2.setName("ball");
		item2.setPrice(15.0);
		item2.setQuantity(55);
		invoice2.setItem(item2);
		crud.insert(invoice2, item2);
	}

}
