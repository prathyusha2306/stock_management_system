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
public class AdminInfo implements Serializable {
	@Id
	@Column(name = "Emailid")
	private String adminEmail;
	@Column
	private String password;

}
