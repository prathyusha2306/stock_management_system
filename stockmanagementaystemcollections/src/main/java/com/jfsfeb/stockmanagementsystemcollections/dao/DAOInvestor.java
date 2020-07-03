package com.jfsfeb.stockmanagementsystemcollections.dao;

import com.jfsfeb.stockmanagementsystemcollections.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemcollections.dto.Investor;

public interface DAOInvestor {

public boolean registerInvestor(Investor investor);
	
	boolean investorLogin(String emailId, String password);
	
	boolean changePassword(String emailId, String oldPassword, String newPassword);
	
	public boolean sellStock(int stockId);
	
	public boolean buyStock(DetailsOfStock stock);
	
}
