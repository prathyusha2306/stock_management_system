package com.jfsfeb.stockmanagementsystemcollections.dao;

import com.jfsfeb.stockmanagementsystemcollections.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemcollections.dto.Investor;
import com.jfsfeb.stockmanagementsystemcollections.exception.ExceptionSMS;
import com.jfsfeb.stockmanagementsystemcollections.repository.SMSDataBase;

public class DAOInvestorImple implements DAOInvestor {

	@Override
	public boolean registerInvestor(Investor investor) {

		for (Investor i : SMSDataBase.INVESTOR_INFOS) {
			if ((i.getEmailId()).equals(investor.getEmailId())) {
				return false;
			}
		}
		SMSDataBase.INVESTOR_INFOS.add(investor);
		return true;
	}

	@Override
	public boolean investorLogin(String emailId, String password) {

		for (Investor userInfo : SMSDataBase.INVESTOR_INFOS) {
			if (userInfo.getEmailId().equalsIgnoreCase(emailId) && userInfo.getPassword().equals(password)) {
				return true;
			}
		}
		throw new ExceptionSMS("Invalid Login Credentials,Please enter Correctly");
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) {
		for (Investor userInfo : SMSDataBase.INVESTOR_INFOS) {
			if ((userInfo.getEmailId().equalsIgnoreCase(emailId)) && (userInfo.getPassword().equals(oldPassword))) {
				userInfo.setPassword(newPassword);
				return true;
			}

		}
		throw new ExceptionSMS("Password Can't be Changed Due To Invalid Credentials");

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
