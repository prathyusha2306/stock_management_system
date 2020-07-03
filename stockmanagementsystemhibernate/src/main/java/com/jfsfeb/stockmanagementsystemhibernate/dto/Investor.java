package com.jfsfeb.stockmanagementsystemhibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "user_info")
public class Investor implements Serializable {
    @Id
	@Column(name = "user_Id")
	private int investorId;

    @Column(name = "Name")
	private String investorName;

    @Column(name = "MobileNumber")
	private Long mobileNumber;
	@Column
	
	private String password;
	@Column(name = "Emailid")
	
	private String emailId;
	
	@Column(name="Role")
    private String role;
}
