package com.jfsfeb.stockmanagementsystemspring.dao;

import com.jfsfeb.stockmanagementsystemhibernate.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;

public interface DAOInvestor {

public boolean registerInvestor(Investor investor);
	
	boolean investorLogin(String emailId, String password);
	
	boolean changePassword(String emailId, String oldPassword, String newPassword);
	
	public boolean sellStock(int stockId);
	
	public boolean buyStock(DetailsOfStock stock);
	
}
