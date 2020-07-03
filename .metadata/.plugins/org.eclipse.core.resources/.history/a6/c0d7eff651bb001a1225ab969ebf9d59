package com.jfsfeb.stockmanagementsystemcollections.dao;

import java.util.List;

import com.jfsfeb.stockmanagementsystemcollections.dto.Investor;
import com.jfsfeb.stockmanagementsystemcollections.dto.Manager;

public interface AdminDAO {
	boolean authenticateAdmin(String email, String password);

	boolean addInvestor(Investor investor);
	
	boolean addCompanyManager(Manager manager);

	List<Investor> viewInvestors();
}
