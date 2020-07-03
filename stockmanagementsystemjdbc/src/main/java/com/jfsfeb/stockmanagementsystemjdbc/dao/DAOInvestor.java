package com.jfsfeb.stockmanagementsystemjdbc.dao;

import com.jfsfeb.stockmanagementsystemjdbc.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;

public interface DAOInvestor {
	public boolean registerInvestor(Investor investor);

	boolean investorLogin(String emailId, String password);

	boolean changePassword(String emailId, String oldPassword, String newPassword);

	public boolean sellStock(int stockId);

	public boolean buyStock(DetailsOfStock stock);

	boolean stockRequest(int userId, int stockId);
}
