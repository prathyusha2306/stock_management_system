package com.jfsfeb.stockmanagementsystemjdbc.service;

import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Manager;


public interface AdminService {

	boolean authenticateAdmin(String email, String password);

	boolean addInvestor(Investor investor);

	boolean addCompanyManager(Manager manager);

	public boolean issueStock(int requestId);
	
	List<Investor> viewInvestors();
	
}
