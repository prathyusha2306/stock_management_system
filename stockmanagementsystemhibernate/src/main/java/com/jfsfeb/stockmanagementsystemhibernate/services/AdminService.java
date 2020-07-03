package com.jfsfeb.stockmanagementsystemhibernate.services;

import java.util.List;

import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Manager;

public interface AdminService {

	boolean authenticateAdmin(String email, String password);

	boolean addInvestor(Investor investor);

	boolean addCompanyManager(Manager manager);

	List<Investor> viewInvestors();
}
