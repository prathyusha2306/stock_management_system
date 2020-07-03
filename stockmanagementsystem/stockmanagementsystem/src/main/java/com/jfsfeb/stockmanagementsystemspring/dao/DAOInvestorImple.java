package com.jfsfeb.stockmanagementsystemspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jfsfeb.stockmanagementsystemhibernate.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;
import com.jfsfeb.stockmanagementsystemhibernate.exception.ExceptionSMS;

public class DAOInvestorImple implements DAOInvestor {
	EntityManagerFactory factory = null;
	@Override
	public boolean registerInvestor(Investor investor) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(investor);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ExceptionSMS ("User Already Exists Or User Can't Be added");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean investorLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sellStock(int stockId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyStock(DetailsOfStock stock) {
		// TODO Auto-generated method stub
		return false;
	}


	}

