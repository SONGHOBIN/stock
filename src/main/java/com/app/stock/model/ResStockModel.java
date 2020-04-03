package com.app.stock.model;

import lombok.Data;

@Data
public class ResStockModel {
	private String idx;
	private Integer divisionIdx;
	private String divisionNm;
	private String nm;
	private String classNm;
	private String dateTime;
	private String todayPriceStr;
	private String contrastPriceStr;
	private String beforeDayPriceStr;
	private String dealPriceStr;
}
