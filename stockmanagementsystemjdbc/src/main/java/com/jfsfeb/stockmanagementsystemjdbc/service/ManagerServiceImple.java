package com.jfsfeb.stockmanagementsystemjdbc.service;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dao.DAOManager;
import com.jfsfeb.stockmanagementsystemjdbc.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemjdbc.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemjdbc.validation.ValidationSMS;

public class ManagerServiceImple implements ManagerService {
	ValidationSMS validation = new ValidationSMS();
	DAOManager manager = SMSFactory.getDAOManagerImpleInstance();

	@Override
	public boolean addStock(DetailsOfStock stockDetails) {

		if (validation.validateStockId(stockDetails.getStockId())) {
			if (validation.validateName(stockDetails.getStockName())) {
				if (validation.validateName(stockDetails.getStockType())) {
					if (validation.validateStockPrice(stockDetails.getStockPrice())) {
						return manager.addStock(stockDetails);
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean authenticateManager(String emailId, String password) {
		if (validation.validateEmail(emailId)) {
			if (validation.validatePassword(password)) {
				return manager.authenticateManager(emailId, password);
			}

		}
		return false;
	}

	@Override
	public boolean removeStock(int id) {
		if (validation.validateStockId(id)) {
			return manager.removeStock(id);
		}
		return false;
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword) {
		if (validation.validateEmail(emailId)) {
			if (validation.validatePassword(oldPassword)) {
				if (validation.validatePassword(newPassword)) {
					return manager.changePassword(emailId, oldPassword, newPassword);
				}
			}
		}
		return false;
	}

	@Override
	public List<DetailsOfStock> viewstocks() {
	
		return manager.viewstocks();
	}

}