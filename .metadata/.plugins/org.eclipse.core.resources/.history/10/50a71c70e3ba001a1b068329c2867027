package com.jfsfeb.stockmanagementsystemcollections.factory;

import com.jfsfeb.stockmanagementsystemcollections.dao.AdminDAO;
import com.jfsfeb.stockmanagementsystemcollections.dao.AdminDAOImple;
import com.jfsfeb.stockmanagementsystemcollections.dao.DAOInvestor;
import com.jfsfeb.stockmanagementsystemcollections.dao.DAOInvestorImple;
import com.jfsfeb.stockmanagementsystemcollections.dao.DAOManager;
import com.jfsfeb.stockmanagementsystemcollections.dao.DAOManagerImple;
import com.jfsfeb.stockmanagementsystemcollections.services.AdminService;
import com.jfsfeb.stockmanagementsystemcollections.services.AdminServiceImple;
import com.jfsfeb.stockmanagementsystemcollections.services.InvestorService;
import com.jfsfeb.stockmanagementsystemcollections.services.InvestorServiceImple;
import com.jfsfeb.stockmanagementsystemcollections.services.ManagerService;
import com.jfsfeb.stockmanagementsystemcollections.services.ManagerServiceImple;

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


