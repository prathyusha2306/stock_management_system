package com.jfsfeb.stockmanagementsystemcollections.repository;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.stockmanagementsystemcollections.dto.AdminInfo;
import com.jfsfeb.stockmanagementsystemcollections.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemcollections.dto.Investor;
import com.jfsfeb.stockmanagementsystemcollections.dto.Manager;

public class SMSDataBase {

	public static final List<AdminInfo> ADMIN_INFOS = new ArrayList<AdminInfo>();
	public static final List<Investor> INVESTOR_INFOS = new ArrayList<Investor>();
	public static final List<Manager> MANAGER_INFOS = new ArrayList<Manager>();
	public static final List<DetailsOfStock> STOCK_DETAILS = new ArrayList<DetailsOfStock>();

	public static void addToDataBase() {

		AdminInfo info = new AdminInfo();
		info.setAdminEmail("admin@gmail.com");
		info.setPassword("Admin1@");
		ADMIN_INFOS.add(info);

		Investor investor = new Investor();
		investor.setEmailId("prathyusha@gmail.com");
		investor.setInvestorId(101);
		investor.setInvestorName("prathyusha");
		investor.setMobileNumber(98765432L);
		investor.setPassword("Password1@");
		INVESTOR_INFOS.add(investor);

		DetailsOfStock stock = new DetailsOfStock();
		stock.setStockName("IPHONE 7");
		stock.setStockId(1234);
		stock.setStockType("mobile");
		stock.setStockPrice(60000.00);
		STOCK_DETAILS.add(stock);

		DetailsOfStock stockItem = new DetailsOfStock();
		stockItem.setStockName("bluetooth EarPhones");
		stockItem.setStockId(9876);
		stockItem.setStockType("EarPhones");
		stockItem.setStockPrice(4000.00);
		STOCK_DETAILS.add(stockItem);

		DetailsOfStock stockData = new DetailsOfStock();
		stockData.setStockName("miA2");
		stockData.setStockId(5678);
		stockData.setStockType("mobiles");
		stockData.setStockPrice(9000.00);
		STOCK_DETAILS.add(stockData);
		
		DetailsOfStock stockAdd = new DetailsOfStock();
		stockAdd.setStockName("Samsung galaxy");
		stockAdd.setStockId(987);
		stockAdd.setStockType("mobile");
		stockAdd.setStockPrice(45000.00);
		STOCK_DETAILS.add(stockAdd);

		Manager manager = new Manager();
		manager.setManagerName("akhil");
		manager.setManagerEmailId("akhil@gmail.com");
		manager.setManagerId(897);
		manager.setManagerPassword("Manager1@");
		MANAGER_INFOS.add(manager);

		

	}
}
