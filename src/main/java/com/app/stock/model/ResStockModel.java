package com.app.stock.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResStockModel {
	@ApiModelProperty(value="종목코드")
	private String idx;
	@ApiModelProperty(value="구분 IDX (코스피 : 1, 코스닥 : 2)")
	private Integer divisionIdx;
	@ApiModelProperty(value="구분명 (코스피 / 코스닥)")
	private String divisionNm;
	@ApiModelProperty(value="종목명")
	private String nm;
	@ApiModelProperty(value="분야명")
	private String classNm;
	@ApiModelProperty(value="현재 날짜")
	private String dateTime;
	@ApiModelProperty(value="현재가")
	private String todayPriceStr;
	@ApiModelProperty(value="전일대시 상승가")
	private String contrastPriceStr;
	@ApiModelProperty(value="전일대시 상승률")
	private double contrastPercent;
	@ApiModelProperty(value="전일가")
	private String beforeDayPriceStr;
	@ApiModelProperty(value="상한가")
	private String maxPriceStr;
	@ApiModelProperty(value="하한가")
	private String minPriceStr;
	@ApiModelProperty(value="거래량")
	private String dealPriceStr;
}
