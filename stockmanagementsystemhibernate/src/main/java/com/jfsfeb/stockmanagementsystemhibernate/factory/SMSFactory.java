package com.jfsfeb.stockmanagementsystemhibernate.factory;

import com.jfsfeb.stockmanagementsystemhibernate.dao.AdminDAO;
import com.jfsfeb.stockmanagementsystemhibernate.dao.AdminDAOImple;
import com.jfsfeb.stockmanagementsystemhibernate.dao.DAOInvestor;
import com.jfsfeb.stockmanagementsystemhibernate.dao.DAOInvestorImple;
import com.jfsfeb.stockmanagementsystemhibernate.dao.DAOManager;
import com.jfsfeb.stockmanagementsystemhibernate.dao.DAOManagerImple;
import com.jfsfeb.stockmanagementsystemhibernate.services.AdminService;
import com.jfsfeb.stockmanagementsystemhibernate.services.AdminServiceImple;
import com.jfsfeb.stockmanagementsystemhibernate.services.InvestorService;
import com.jfsfeb.stockmanagementsystemhibernate.services.InvestorServiceImple;
import com.jfsfeb.stockmanagementsystemhibernate.services.ManagerService;
import com.jfsfeb.stockmanagementsystemhibernate.services.ManagerServiceImple;

public class SMSFactory {

	private SMSFactory() {

	}

	public static AdminDAO getAdminDAOImplInstance() {
		AdminDAO dao = new AdminDAOImple();
		return dao;

	}

	public static DAOInvestor getInvestorDAOImplInstance() {
		DAOInvestor investor = new DAOInvestorImple();
		return investor;

	}

	public static DAOManager getDAOManagerImpleInstance() {
		DAOManager manager = new DAOManagerImple();
		return manager;

	}

	public static AdminService getAdminServicesInstance() {
		AdminService adminService = new AdminServiceImple();
		return adminService;

	}

	public static InvestorService getInvestorServiceInstance() {
		InvestorService investorService = new InvestorServiceImple();
		return investorService;
	}

	public static ManagerService getManagerServiceInstance() {
		ManagerService ladServices = new ManagerServiceImple();
		return ladServices;

	}


}


