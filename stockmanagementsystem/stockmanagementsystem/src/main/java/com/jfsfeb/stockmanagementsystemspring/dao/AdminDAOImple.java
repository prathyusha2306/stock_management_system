package com.jfsfeb.stockmanagementsystemspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jfsfeb.stockmanagementsystemhibernate.dto.AdminInfo;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Manager;
import com.jfsfeb.stockmanagementsystemhibernate.exception.ExceptionSMS;

public class AdminDAOImple implements AdminDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");;
	@Override
	public boolean authenticateAdmin(String email, String password) {
		
		EntityManager	manager = factory.createEntityManager();
		String jpql = "select l from  user_info l where l.Emailid = :emailId and l.password =:password";
		TypedQuery<AdminInfo> query = manager.createQuery(jpql, AdminInfo.class);
		query.setParameter("emailId", email);
		query.setParameter("password", password);
		try {
			return true;
		} catch (Exception e) {
			throw new ExceptionSMS("Invalid Login Credentials, Please Enter Corre ctly");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean addInvestor(Investor investor) {
//		Investor investorInfo =new Investor();
//		investorInfo.setInvestorId(investor.getInvestorId());
//		investorInfo.setInvestorName(investor.getInvestorName());
//		investorInfo.setMobileNumber(investor.getMobileNumber());
//		investorInfo.setPassword(investor.getPassword());
//		investorInfo.setEmailId(investor.getEmailId());
//		investorInfo.setRole(investor.getRole())
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
		
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(investor);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ExceptionSMS("Investor Details already Exists ");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean addCompanyManager(Manager manager) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(manager);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ExceptionSMS("Manager  Details already Exists ");
		} finally {
			entityManager.close();
			factory.close();
		}
	}

	@Override
	public List<Investor> viewInvestors() {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select l from user_info l ";
		TypedQuery<Investor> query = manager.createQuery(jpql, Investor.class);
		List<Investor> recordlist = query.getResultList();
		manager.close();
		factory.close();
		return recordlist;
	}

}
