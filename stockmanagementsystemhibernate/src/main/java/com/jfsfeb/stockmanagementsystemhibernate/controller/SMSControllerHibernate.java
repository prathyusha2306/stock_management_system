package com.jfsfeb.stockmanagementsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.stockmanagementsystemhibernate.dto.DetailsOfStock;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Investor;
import com.jfsfeb.stockmanagementsystemhibernate.dto.Manager;
import com.jfsfeb.stockmanagementsystemhibernate.exception.ExceptionSMS;
import com.jfsfeb.stockmanagementsystemhibernate.factory.SMSFactory;
import com.jfsfeb.stockmanagementsystemhibernate.services.AdminService;
import com.jfsfeb.stockmanagementsystemhibernate.services.InvestorService;
import com.jfsfeb.stockmanagementsystemhibernate.services.ManagerService;

import lombok.extern.log4j.Log4j;
@Log4j
public class SMSControllerHibernate {
	private static AdminService service = SMSFactory.getAdminServicesInstance();
	private static InvestorService investorService =SMSFactory.getInvestorServiceInstance() ;
	private static ManagerService managerService = SMSFactory.getManagerServiceInstance();

	public static Scanner scanner = new Scanner(System.in);

	public static String checkRole() {
		String role = null;
		boolean flag = false;
		do {
			role = scanner.next();
			if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("manager")|| role.equalsIgnoreCase("investor")) {
				flag = true;
			} else {
				System.err.println("Enter role value either user or admin");
				flag = false;
			}
		} while (!flag);
		return role.toLowerCase();
	}

	public static int checkChoice() {
		boolean flag = false;
		int choice = 0;
		do {
			try {
				choice = scanner.nextInt();
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Invalid Choice, It Should Contain Only Digits");
				scanner.next();
			}	
		} while (!flag);
		return choice;
	}

	public static void stockMangement() {
		Manager manager;
		Investor investor;
		int choice = 0;
		String role = null;
		int adminchoice = 0;
		int investorChoice = 0;
		int managerChoice = 0;
		String adminEmail = null;
		String password = null;
		int investorId = 0;
		String investorName = null;
		String name = null;
		String emailId = null;
		String newPassword = null;
		Long mobileNumber = null;
		String managerName = null;
		int managerId = 0;
		String managerEmailId = null;
		String managerPassword = null;
		int stockId = 0;
		String stockName = null;
		DetailsOfStock stock;


		do

		{
			try {
				log.info(
						"-------------------------------------------------------WELCOME TO STOCK MAGANEMENT-------------------------------------------------------------------");
				log.info("[1] ADMIN PAGE");
				log.info("[2] INVESTOR PAGE");
				log.info("[3] MANAGER PAGE");
				log.info(
						"------------------------------------------------------------------------------------------------------------------------------------------------");
				choice = checkChoice();
				switch (choice) {

//				case 1:
//
//					do {
//
//						log.info(
//								"------------------------------------------------------------------------------------------------------------------------------------");
//						log.info("[1] ADMINISTRATION LOGIN");
//						log.info("[2] EXIT");
//						log.info(
//								"---------------------------------------------------------------------------------------------------------------------------------------");
//						choice = checkChoice();
//						switch (choice) {
//
//						case 1:
//							log.info("Enter registered email to login : ");
//							adminEmail = scanner.next();
//							log.info("Enter registered Password to login : ");
//							password = scanner.next();
//							try {
////								service.authenticateAdmin(adminEmail, password);
//								log.info("You have logged in successfully");
//								log.info("Now you can perform the following operations:-");
//								do {
//									try {
//										log.info(
//												"---------------------------------------------------------------------------------------------------------------------");
//										log.info("[1] ADD INVESTORS");
//										log.info("[2] ADD COMPANY MANAGER");
//										log.info("[3] VIEW ALL INVESTORS");
//										log.info("[4] LOGOUT");
//										log.info(
//												"----------------------------------------------------------------------------------------------------------------------");
//										adminchoice = checkChoice();
//										switch (adminchoice) {
//										case 1:
//											investor = new Investor();
//											log.info("Enter the Details to Register New User");
//											investorId = (int) (Math.random() * 1000);
//											if (investorId <= 100) {
//												investorId = investorId + 100;
//											}
//											scanner.nextLine();
//											log.info("Enter the User Name");
//											name = scanner.next();
//											log.info("Enter the Mobile Number");
//											mobileNumber = scanner.nextLong();
//											log.info("Enter The Password");
//											password = scanner.next();
//											log.info("Enter the Email Id");
//											emailId = scanner.next();
//											System.out.println("Enter the Role");
//											role = checkRole();
//																					
//											investor.setInvestorId(investorId);
//											investor.setInvestorName(name);
//											investor.setMobileNumber(mobileNumber);
//											investor.setPassword(password);
//											investor.setEmailId(emailId);
//											investor.setRole(role);
//
//											try {
//												boolean isInvestorAdded = service.addInvestor(investor);
//												if (isInvestorAdded) {
//													log.info("New User Added Successfully");
//												}
//											} catch (ExceptionSMS e) {
//												System.err.println(e.getMessage());
//											}
//											break;
//										case 2:
//											manager = new Manager();
//											log.info("Enter the Details to Register New manager");
//											managerId = (int) (Math.random() * 1000);
//											if (managerId <= 100) {
//												managerId = managerId + 100;
//											}
//											log.info("Enter the manager Name");
//											managerName = scanner.next();
//											log.info("Enter the Email Id");
//											emailId = scanner.next();
//											log.info("Enter The Password");
//											password = scanner.next();
//											manager.setManagerId(managerId);
//											manager.setManagerEmailId(managerEmailId);
//											manager.setManagerPassword(managerPassword);
//											manager.setManagerName(managerName);
//
//											try {
//												boolean isManagerAdded = service.addCompanyManager(manager);
//												if (isManagerAdded) {
//													log.info("New Manager Added Successfully");
//												}
//											} catch (ExceptionSMS e) {
//												System.err.println(e.getMessage());
//											}
//											break;
//
//										case 3:
//
//											try {
//												List<Investor> investorList = service.viewInvestors();
//												log.info("Investors Present in Database are:");
//
//												for (Investor investorInfo : investorList) {
//													log.info(investorInfo.toString());
//												}
//											} catch (ExceptionSMS e) {
//												System.err.println(e.getMessage());
//
//											}
//											break;
//
//										case 4:
//										default:
//											break;
//										}
//									} catch (InputMismatchException e) {
//
//										System.err.println("Invalid entry please provide only positive integer");
//
//									}
//								} while (true);
//							} catch (Exception e) {
//								log.info("Invalid Credentials");
//							}
//						}
//
//					} while (true);
//					
				
				
				case 1:

					do {

						log.info(
								"------------------------------------------------------------------------------------------------------------------------------------");
						log.info("[1] ADMINISTRATION LOGIN");
						log.info("[2] EXIT");
						log.info(
								"---------------------------------------------------------------------------------------------------------------------------------------");
						choice = checkChoice();
						switch (choice) {

						case 1:
							log.info("Enter registered email to login : ");
							adminEmail = scanner.next();
							log.info("Enter registered Password to login : ");
							password = scanner.next();
							try {
				//		service.authenticateAdmin( email, password);
								
								log.info("You have logged in successfully");
								log.info("Now you can perform the following operations:-");
								do {
									try {
										log.info(
												"---------------------------------------------------------------------------------------------------------------------");
										log.info("[1] ADD INVESTORS");
										log.info("[2] ADD COMPANY MANAGER");
										log.info("[3] VIEW ALL INVESTORS");
										log.info("[4] LOGOUT");
										log.info(
												"----------------------------------------------------------------------------------------------------------------------");
										adminchoice = checkChoice();
										switch (adminchoice) {
										case 1:
											investor = new Investor();
											log.info("Enter the Details to Register New User");
											investorId = (int) (Math.random() * 1000);
											if (investorId <= 100) {
												investorId = investorId + 100;
											}
											scanner.nextLine();
											log.info("Enter the User Name");
											name = scanner.next();
											log.info("Enter the Email Id");
											emailId = scanner.next();
											log.info("Enter the Mobile Number");
											mobileNumber = scanner.nextLong();
											log.info("Enter The Password");
											password = scanner.next();
											
											log.info("Enter the Role");
											role = checkRole();
											
											
											investor.setInvestorId(investorId);;
											investor.setInvestorName(investorName);
											investor.setEmailId(emailId);
											investor.setPassword(password);
											investor.setMobileNumber(mobileNumber);
											investor.setRole(role);

											try {
												boolean isInvestorAdded = service.addInvestor(investor);
												if (isInvestorAdded) {
													log.info("New investor Added Successfully");
												}
											} catch (ExceptionSMS e) {
												log.error(e.getMessage());
											}
											break;

										case 2:
											manager = new Manager();
											log.info("Enter the Details to Register New manager");
											managerId = (int) (Math.random() * 1000);
											if (managerId <= 100) {
												managerId = managerId + 100;
											}
											log.info("Enter the User Name");
											name = scanner.next();
											log.info("Enter the Email Id");
											emailId = scanner.next();
											log.info("Enter the Mobile Number");
											mobileNumber = scanner.nextLong();
											log.info("Enter The Password");
											password = scanner.next();
											log.info("Enter the Role");
											role = checkRole();
										
											manager.setManagerId(managerId);
											manager.setManagerEmailId(managerEmailId);
											manager.setManagerPassword(managerPassword);
											manager.setManagerName(managerName);

											manager.setRole(role);


											try {
												boolean isManagerAdded = service.addCompanyManager(manager);
												if (isManagerAdded) {
													log.info("New Manager Added Successfully");
												}
											} catch (ExceptionSMS e) {
												log.error(e.getMessage());
											}
											break;

										case 3:
											try {
											List<Investor> userList = service.viewInvestors();
											log.info("Users Present in Database are:");
											log.info(String.format("%-10s %-20s %-25s %-15s %-15s %-5s", "USER ID",
													"USER NAME","EMAIL ID","MOBILE NUMBER","PASSWORD" ,"ROLE"));

											for (Investor investorInfo : userList) {
												log.info(String.format("%-10s %-20s %-25s %-15s %-15s %-5s %-10s",
														investorInfo.getInvestorId(), investorInfo.getInvestorName(),investorInfo.getEmailId(),
														investorInfo.getMobileNumber(),investorInfo.getPassword(),investorInfo.getRole()));
											}
										} catch (ExceptionSMS e) {
											log.error(e.getMessage());
										}

											break;

										case 4:
											stockMangement();
										default:
											break;
										}
									} catch (InputMismatchException e) {

										log.error("Invalid entry please provide only positive integer");

									}
								} while (true);
							} catch (Exception e) {
								log.info("Invalid Credentials");
							}
						}

					} while (true);
				case 2:
					do {
						try {
							log.info(
									"------------------------------------------------------------------------------------------------------------------------------");
							log.info("[1] INVESTOR REGISTER");
							log.info("[2] INVESTOR LOGIN");
							log.info("[3] EXIT");
							log.info(
									"-------------------------------------------------------------------------------------------------------------------------------");
							investorChoice = checkChoice();
							switch (investorChoice) {

							case 1:
								log.info("Enter Name to Register : ");
								investorName = scanner.next();
								log.info("Enter MobileNumber to Register : ");
								mobileNumber = scanner.nextLong();
								log.info("Enter Email to Register : ");
								emailId = scanner.next();
								log.info("Enter Password :");
								password = scanner.next();

								Investor investorReg = new Investor();
								investorReg.setInvestorName(investorName);

								investorReg.setPassword(password);

								boolean check = investorService.registerInvestor(investorReg);
								if (check) {
									log.info("You have registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;
							case 2:
								log.info("Enter registered name to login : ");
								investorName = scanner.next();
								log.info("Enter registered Password to login : ");
								password = scanner.next();
								log.info("Logged in Successfully");
								log.info("Now you can perform the following operations:-");
								do {
									try {
										log.info(
												"<--------------------------------------------------------------------->");
										log.info("[1]   CHANGE PASSWORD");
										log.info("[2]  BUY STOCK");
										log.info("[3]  SELL STOCK");

										log.info("[4] LOGOUT");
										log.info(
												"<--------------------------------------------------------------------->");
										choice = checkChoice();
										switch (choice) {
										case 1:

											log.info("Change Password");
											log.info("-------------------------");
											log.info("Enter User Email Id");
											emailId = scanner.next();
											log.info("Enter Old Password");
											password = scanner.next();

											log.info("Enter New Password");
											newPassword = scanner.next();

											try {
												investorService.changePassword(emailId, password, newPassword);
												log.info("Password Changed Successfully");
											} catch (ExceptionSMS e) {
												System.err.println(e.getMessage());
											}
											break;

										case 2:
											log.info("Enter Stock Name to buy : ");

											stock = new DetailsOfStock();
											stock.setStockName(stockName);
											boolean buy = investorService.buyStock(stock);
											if (buy) {
												log.info("Stock Name= " + stockName);
											} else {
												log.info("Stock Name already exist= " + stockName);
											}

											break;

										case 3:
											log.info("Enter the Stock Id to delete : ");
											int stockId3 = scanner.nextInt();
											if (stockId3 == 0) {
												log.info("Please Enter the Valid Stock Id");
											} else {
												stock = new DetailsOfStock();
												stock.setStockId(stockId3);
												boolean remove = investorService.sellStock(stockId);
												if (remove) {
													log.info("The stock is removed of Id = " + stockId);
												} else {
													log.info("The stock is not removed of Id = " + stockId);
												}
											}
											break;

										case 4:
											break;

										default:
											log.info("Invalid Choice");
											break;
										}

									} catch (InputMismatchException e) {
										System.err.println("Invalid entry please provide only positive integer");
										scanner.nextLine();
									}
								} while (true);

							case 3:
								break;

							default:
								log.info("Invalid Choice");
								break;
							}
						} catch (InputMismatchException e) {
							System.err.println("Invalid entry please provide only positive integer");
							scanner.nextLine();
						}
					} while (true);

				case 3:
					do {
						try {
							log.info(
									"<--------------------------<<MANAGER PAGE>>------------------------------------------->");
							log.info("[1] MANAGER LOGIN");
							log.info("[2] EXIT");
							System.out
									.println("<--------------------------------------------------------------------->");
							managerChoice = checkChoice();
							switch (managerChoice) {

							case 1:
								log.info("Enter registered email to login : ");
								managerEmailId = scanner.next();
								log.info("Enter registered Password to login : ");
								managerPassword = scanner.next();
								try {
									managerService.authenticateManager(managerEmailId, managerPassword);
									;
									log.info("You have logged in successfully");
									log.info("Now you can perform the following operations:-");
									do {
										try {
											log.info(
													"<--------------------------------------------------------------------->");
											log.info("[1]  CHANGE PASSWORD");
											log.info("[2]  ADD STOCK");
											log.info("[3]  REMOVE STOCK");
											log.info("[4] LOGOUT");
											log.info(
													"<--------------------------------------------------------------------->");
											choice = scanner.nextInt();
											switch (choice) {
											case 1:

												log.info("Change Password");
												log.info("-------------------------");
												log.info("Enter User Email Id");	
												String emailId2 = scanner.nextLine();
												log.info("Enter Old Password");
												String password2 = scanner.nextLine();
												log.info("Enter New Password");
												String newPassword2 = scanner.next();

												try {
													managerService.changePassword(emailId2, password2, newPassword2);
													log.info("Password Changed Successfully");
												} catch (ExceptionSMS e) {
													System.err.println(e.getMessage());
												}
												break;

											case 2:

												log.info("Enter Stock Name to add : ");
												stockName = scanner.next();
												stock = new DetailsOfStock();
												stock.setStockName(stockName);
												boolean check = managerService.addStock(stock);
												if (check) {
													log.info("Stock added of name= " + stockName);
												} else {
													log.info("Stock already exist of name= " + name);
												}

							 					break;

											case 3:
												log.info("Enter the Stock Id to sell : ");
												stockId = scanner.nextInt();
												if (stockId == 0) {
													log.info("Please Enter the Valid StockId");
												} else {
													stock = new DetailsOfStock();
													stock.setStockId(stockId);
													boolean sell = managerService.removeStock(stockId);
													if (sell) {
														log.info("The stock is  selled of Id = " + stockId);
													} else {
														System.out
																.println("The stock is not selled of Id = " + stockId);
													}
												}
												break;

											case 4:
												break;

											default:
												log.info("Invalid Choice please provide 1 or 2 or 3 or 4 ");
												break;
											}
										} catch (InputMismatchException e) {
											System.err.println("Invalid entry please provide 1 or 2 ");
										} catch (Exception e) {
											log.info("Invalid Credentials");
										}
									} while (true);
								} catch (Exception e) {
									log.info("Invalid Credentials");
								}
								break;
							case 3:
								break;
 
							default:
								log.info("Invalid Choice please provide 1 or 2 or 3");
								break;
							}
						} catch (InputMismatchException e) {
							System.err.println("Invalid entry please provide 1 or 2 or 3");
							scanner.nextLine();
						}

					} while (true);
				default:
					System.err.println("choice should be in between 1 or 2 or 3");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid entry please provide 1 or 2 or 3");
				scanner.nextLine();
			}
		} while (true);

	}
}
