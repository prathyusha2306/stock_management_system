package com.jfsfeb.stockmanagementsystemcollections.dao;

import com.jfsfeb.stockmanagementsystemcollections.dto.DetailsOfStock;

public interface DAOManager {

	boolean addStock(DetailsOfStock stockDetails);

	boolean authenticateManager(String managerEmailId, String managerPassword);

	boolean removeStock(int id);

	boolean changePassword(String emailId, String oldPassword, String newPassword);
}
