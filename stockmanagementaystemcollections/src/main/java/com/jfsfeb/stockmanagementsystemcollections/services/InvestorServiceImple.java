package com.jfsfeb.stockmanagementsystemcollections.services;

import com.jfsfeb.stockmanagementsystemcollections.dao.DAOInvestor;
import com.jfsfeb.stockmanagementsystemcollections.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemcollections.dto.Investor;
import com.jfsfeb.stockmanagementsystemcollections.exception.ExceptionSMS;
import com.jfsfeb.stockmanagementsystemcollections.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemcollections.repository.SMSDataBase;
import com.jfsfeb.stockmanagementsystemcollections.validation.ValidationSMS;

public class InvestorServiceImple implements InvestorService {
	private DAOInvestor dao = SMSFactory.getInvestorDAOImplInstance();
	ValidationSMS validation = new ValidationSMS();

	@Override
	public boolean registerInvestor(Investor investor) {
      if(investor!=null) {
		return dao.registerInvestor(investor);
	}
	return false;
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

		return dao.changePassword(emailId, oldPassword, newPassword);
	}

	@Override
	public boolean sellStock(int stockId) {

		for (DetailsOfStock infoStock : SMSDataBase.STOCK_DETAILS) {
			if (infoStock.getStockId() == stockId) {
				SMSDataBase.STOCK_DETAILS.remove(infoStock);
				return true;
			}
		}
		throw new ExceptionSMS("Unable To Remove The Book from the Library");
	}

	@Override
	public boolean buyStock(DetailsOfStock stock) {

		boolean add = true;
		for (DetailsOfStock Info : SMSDataBase.STOCK_DETAILS) {
			if (Info.getStockId() == stock.getStockId()) {
				throw new ExceptionSMS("Stock Can't Be Added, As stock Id Already Exists");
			}
		}
		SMSDataBase.STOCK_DETAILS.add(stock);
		return add;
	}

}
