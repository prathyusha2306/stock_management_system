package com.jfsfeb.stockmanagementsystemjdbc.dao;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Manager;

public interface AdminDAO {
	boolean authenticateAdmin(String email, String password);

	boolean addInvestor(Investor investor);
	
	boolean addCompanyManager(Manager manager);

	List<Investor> viewInvestors();
	
	boolean issueStock(int requestId);
}
