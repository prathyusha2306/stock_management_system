package com.jfsfeb.stockmanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jfsfeb.stockmanagementsystemjdbc.controller.SMSControllerJdbc;
import com.jfsfeb.stockmanagementsystemjdbc.dto.AdminInfo;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Investor;
import com.jfsfeb.stockmanagementsystemjdbc.dto.Manager;
import com.jfsfeb.stockmanagementsystemjdbc.exception.ExceptionSMS;
import com.jfsfeb.stockmanagementsystemjdbc.utility.DBConnection;

public class AdminDAOImple implements AdminDAO {
	DBConnection dbConnector = new DBConnection();

	@Override
	public boolean authenticateAdmin(String email, String password) {
		AdminInfo info = new AdminInfo();

		try (Connection connection = dbConnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(dbConnector.getQuery("loginCheckAdmin"));) {
			statement.setString(1, email);
			statement.setString(2, password);
			try (ResultSet result = statement.executeQuery();) {
				while (result.next()) {
					info.setEmail(result.getString("Emailid"));
					info.setPassword(result.getString("password"));

					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new ExceptionSMS("Invalid Login Credentials, Please Enter Correctly");
	}

	@Override
	public boolean addInvestor(Investor investor) {
		try (Connection connection = dbConnector.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(dbConnector.getQuery("addInvestor"));) {
			pstmt.setInt(1, investor.getUserId());
			pstmt.setString(2, investor.getName());
			pstmt.setLong(3, investor.getMobileNumber());
			pstmt.setString(4, investor.getPassword());
			pstmt.setString(5, investor.getEmailId());
			pstmt.setString(6, investor.getRole());
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ExceptionSMS("Can't Add New User, as User Already Exists");
		}
		return true;
	}

	@Override
	public boolean addCompanyManager(Manager manager) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addManager"));) {
			pstmt.setString(1, manager.getEmail());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getPassword());
			pstmt.setInt(4, manager.getManagerId());
			pstmt.setLong(5, manager.getMobileNumber());
			pstmt.setString(6, manager.getRole());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ExceptionSMS("Can't Add New User, as User Already Exists");
		}
		return true;
	}

	@Override
	public List<Investor> viewInvestors() {
		List<Investor> userList = new LinkedList<Investor>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showUsers"))) {
			while (resultSet.next()) {
				Investor info = new Investor();
				info.setUserId(resultSet.getInt("user_id"));
				info.setName(resultSet.getString("Name"));
				info.setMobileNumber(resultSet.getLong("MobileNumber"));
				info.setPassword(resultSet.getString("password"));
				info.setEmailId(resultSet.getString("Emailid"));
				info.setRole(resultSet.getString("Role"));
				userList.add(info);
			}
			if (userList.isEmpty()) {
				throw new ExceptionSMS("No Users Present");
			} else {
				return userList;
			}
		} catch (Exception e) {
			throw new ExceptionSMS(e.getMessage());
		}

	}

	@Override
	public boolean issueStock(int requestId) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement getReqPstmt = conn.prepareStatement(dbConnector.getQuery("getRequest"));
				PreparedStatement getUserPstmt = conn.prepareStatement(dbConnector.getQuery("getUser"));
				PreparedStatement issuePstmt = conn.prepareStatement(dbConnector.getQuery("issueStock"));) {
			getReqPstmt.setInt(1, requestId);
			try (ResultSet getReqSet = getReqPstmt.executeQuery();) {
				if (getReqSet.next()) {
					int requestUserId = getReqSet.getInt("id");
					int requestStockId = getReqSet.getInt("stock_id");
					getUserPstmt.setInt(1, requestUserId);

					try (ResultSet getUserSet = getUserPstmt.executeQuery();) {

					}

				} else {
					throw new ExceptionSMS("Request not Found with Matching StockId (or) UserId ");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionSMS(e.getMessage());

		}
		return true;
	}
}
