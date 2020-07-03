package com.jfsfeb.stockmanagementsystemspring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Entity
@Table(name = "stock_info")
public class DetailsOfStock implements Serializable {
	@Column(name = "stock_id")
	@Id
	private int stockId;
	private String stockName;
	private String stockType;
	private double stockPrice;

}
