package com.jfsfeb.stockmanagementsystemjdbc.factory;

import com.jfsfeb.stockmanagementsystemjdbc.dao.AdminDAO;
import com.jfsfeb.stockmanagementsystemjdbc.dao.AdminDAOImple;
import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOInvestor;
import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOInvestorImple;
import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOManager;
import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOManagerImple;
import com.jfsfeb.stockmanagementsystemjdbc.service.AdminService;
import com.jfsfeb.stockmanagementsystemjdbc.service.AdminServiceImple;
import com.jfsfeb.stockmanagementsystemjdbc.service.InvestorService;
import com.jfsfeb.stockmanagementsystemjdbc.service.InvestorServiceImple;
import com.jfsfeb.stockmanagementsystemjdbc.service.ManagerService;
import com.jfsfeb.stockmanagementsystemjdbc.service.ManagerServiceImple;

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


