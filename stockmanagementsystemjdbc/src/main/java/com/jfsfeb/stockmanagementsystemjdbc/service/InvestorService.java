package com.jfsfeb.stockmanagementsystemjdbc.service;

import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;

public interface InvestorService {

	public boolean registerInvestor(Investor investor);

	boolean investorLogin(String emailId, String password);

	boolean changePassword(String emailId, String oldPassword, String newPassword);

	boolean stockRequest(int userId, int stockId);
}
