package com.jfsfeb.stockmanagementsystemspring.services;

import com.jfsfeb.stockmanagementsystemhibernate.dao.DAOManager;
import com.jfsfeb.stockmanagementsystemhibernate.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemhibernate.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemhibernate.validation.ValidationSMS;

public class ManagerServiceImple implements ManagerService {

	ValidationSMS validation = new ValidationSMS();
	DAOManager manager = SMSFactory.getDAOManagerImpleInstance();

	@Override
	public boolean addStock(DetailsOfStock stockDetails) {

		if (stockDetails != null) {
			return manager.addStock(stockDetails);
		}
		return false;
	}

	@Override
	public boolean removeStock(int id) {
		if (validation.validateId(id)) {
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
	public boolean authenticateManager(String emailId, String password) {

		if (validation.validateEmail(emailId)) {
			if (validation.validatePassword(password)) {
				return manager.authenticateManager(emailId, password);
			}

		}
		return false;
	}
}