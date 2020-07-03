package com.jfsfeb.stockmanagementsystemjdbc.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class StockRequestInfo implements Serializable{ 

	private int requestId;
	private int id;
	private int stockId;
}
