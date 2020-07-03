package com.jfsfeb.stockmanagementsystemspring.dao;

import com.jfsfeb.stockmanagementsystemhibernate.dto.DetailsOfStock;

public interface DAOManager {

	boolean addStock(DetailsOfStock stockDetails);

	boolean authenticateManager(String managerEmailId, String managerPassword);

	boolean removeStock(int id);

	boolean changePassword(String emailId, String oldPassword, String newPassword);
}
