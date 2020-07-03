package com.jfsfeb.stockmanagementsystemcollections.dto;

import java.io.Serializable;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class DetailsOfStock implements Serializable {

	private int stockId;
	private String stockName;
	private String stockType;
	private double stockPrice;

}
