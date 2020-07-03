package com.jfsfeb.stockmanagementsystemjdbc.dto;

import lombok.ToString;
import java.io.Serializable;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class Manager implements Serializable {
	private String name;
	private String email;
	@ToString.Exclude
	private String password;
	private int managerId;
	private long MobileNumber;
	private String Role;

}
