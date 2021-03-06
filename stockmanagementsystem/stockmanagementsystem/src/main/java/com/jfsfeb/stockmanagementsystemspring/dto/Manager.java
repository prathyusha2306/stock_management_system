package com.jfsfeb.stockmanagementsystemspring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Data
@SuppressWarnings("serial")
@Entity
@Table(name="user_info")
public class Manager implements Serializable {
	
	@Column(name = "Name")
	private String managerName;
	@Column(name = "Emailid")
	private String managerEmailId;
	@ToString.Exclude
	@Column(name = "password")	
	private String managerPassword;
    @Id	
    @Column(name="user_id")
    private int managerId;
	

}
