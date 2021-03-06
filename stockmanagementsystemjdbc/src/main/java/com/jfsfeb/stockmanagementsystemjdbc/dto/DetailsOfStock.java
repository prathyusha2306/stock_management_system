package com.jfsfeb.stockmanagementsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class DetailsOfStock implements Serializable{

	private int stockId;
	private String stockName;
	private String stockType;
	private double stockPrice;
	private boolean isAvailable;
}
