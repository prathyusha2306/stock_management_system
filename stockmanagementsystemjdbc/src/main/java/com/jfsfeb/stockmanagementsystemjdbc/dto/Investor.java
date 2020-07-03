package com.jfsfeb.stockmanagementsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@SuppressWarnings("serial")
public class Investor implements Serializable{
	private int UserId;
	private String name;
	private String emailId;
	@ToString.Exclude
	private String password;
	private Long mobileNumber;
	private String Role;
}
