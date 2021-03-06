package com.jfsfeb.stockmanagementsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dto.DetailsOfStock;

public interface DAOManager {
	boolean addStock(DetailsOfStock stockDetails);

	boolean authenticateManager(String managerEmailId, String managerPassword);

	boolean removeStock(int id);

	boolean changePassword(String emailId, String oldPassword, String newPassword);

	
	List<DetailsOfStock> viewstocks();
}
