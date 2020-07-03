package com.jfsfeb.stockmanagementsystemjdbc.service;

import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOInvestor;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;
import com.jfsfeb.stockmanagementsystemjdbc.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemjdbc.validation.ValidationSMS;

public class InvestorServiceImple implements InvestorService {
	private DAOInvestor dao = SMSFactory.getInvestorDAOImplInstance();
	ValidationSMS validation = new ValidationSMS();

	@Override
	public boolean registerInvestor(Investor investor) {
		// TODO Auto-generated method stub
		return dao.registerInvestor(investor);
	}

	@Override
	public boolean investorLogin(String emailId, String password) {
		if (validation.validateEmail(emailId)) {
			if (validation.validatePassword(password)) {

				return dao.investorLogin(emailId, password);
			}
		}
		return false;
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return dao.changePassword(emailId, oldPassword, newPassword);
	}

	@Override
	public boolean stockRequest(int userId, int stockId) {
		// TODO Auto-generated method stub
		return dao.stockRequest(userId, stockId);
	}

}
