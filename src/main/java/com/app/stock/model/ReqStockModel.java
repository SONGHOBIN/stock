package com.app.stock.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqStockModel {
	@ApiModelProperty(value="검색어 (ex : 삼성전자)")
	private String searchValue;
}
