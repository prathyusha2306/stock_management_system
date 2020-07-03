package com.jfsfeb.stockmanagementsystemjdbc.service;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dto.DetailsOfStock;

public interface ManagerService {


boolean addStock(DetailsOfStock stockDetails);
	
    boolean  authenticateManager(String emailId, String password);
	
	boolean removeStock(int id);
	
	boolean changePassword(String emailId, String oldPassword, String newPassword);

	public List<DetailsOfStock> viewstocks();
}
