package com.jfsfeb.stockmanagementsystemhibernate.services;

import java.util.List;

import com.jfsfeb.stockmanagementsystemhibernate.dao.AdminDAO;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Manager;
import com.jfsfeb.stockmanagementsystemhibernate.exception.ExceptionSMS;
import com.jfsfeb.stockmanagementsystemhibernate.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemhibernate.validation.ValidationSMS;

public class AdminServiceImple implements AdminService {
	private AdminDAO dao = SMSFactory.getAdminDAOImplInstance();
	ValidationSMS validation = new ValidationSMS();

	@Override
	public boolean authenticateAdmin(String email, String password) {

		if (validation.validateEmail(email)) {
			if (validation.validatePassword(password)) {
				return dao.authenticateAdmin(email, password);
			}

		}
		return false;
	}

	@Override
	public boolean addInvestor(Investor investor) {
//		if (validation.validateId(investor.getInvestorId())) {
//			if (validation.validateName(investor.getInvestorName())) {
//					if (validation.validateMobileNumber(investor.getMobileNumber())) {
//						if (validation.validatePassword(investor.getPassword())) {
//							if (validation.validateEmail(investor.getEmailId())) {
//						
//												return dao.addInvestor(investor);
//											}
//										}
//									}
//
//								}
//							}
//
//		return false;
//	}
		// TODO Auto-generated method stub
				if (investor != null) {
					return dao.addInvestor(investor);
				}
				throw new ExceptionSMS("Enter Correct details");
	}
	@Override
	public List<Investor> viewInvestors() {

		return dao.viewInvestors();
	}

	@Override
	public boolean addCompanyManager(Manager manager) {
		if (manager != null) {
			return dao.addCompanyManager(manager);
		}
		return false;
	}
}