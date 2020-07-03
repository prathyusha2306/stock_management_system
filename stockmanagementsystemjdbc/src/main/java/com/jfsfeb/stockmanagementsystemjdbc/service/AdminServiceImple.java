package com.jfsfeb.stockmanagementsystemjdbc.service;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dao.AdminDAO;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Manager;
import com.jfsfeb.stockmanagementsystemjdbc.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemjdbc.validation.ValidationSMS;

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
		if (validation.validateId(investor.getUserId())) {
			if (validation.validateName(investor.getName())) {
				if (validation.validateMobileNumber(investor.getMobileNumber())) {
					if (validation.validatePassword(investor.getPassword())) {
						if (validation.validateEmail(investor.getEmailId())) {

							return dao.addInvestor(investor);
						}
					}
				}

			}
		}

		return false;
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

	@Override
	public boolean issueStock(int requestId) {
		if (validation.validateId(requestId)) {
			return dao.issueStock(requestId);
		}
		return false;
	}
}