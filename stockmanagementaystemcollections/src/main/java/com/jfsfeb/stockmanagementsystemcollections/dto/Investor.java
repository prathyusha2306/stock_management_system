package com.jfsfeb.stockmanagementsystemcollections.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings("serial")
@Data
public class Investor implements  Serializable {
	
	private int investorId;
	private String investorName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private Long mobileNumber;
	private String itemTaken;

}
