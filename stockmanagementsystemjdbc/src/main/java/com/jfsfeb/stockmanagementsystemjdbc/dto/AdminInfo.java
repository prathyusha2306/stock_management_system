package com.jfsfeb.stockmanagementsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings("serial")
@Data
public class AdminInfo implements Serializable{
	private String email;
	@ToString.Exclude
	private String password;
}
