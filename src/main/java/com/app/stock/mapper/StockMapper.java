package com.app.stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.stock.model.ReqStockModel;
import com.app.stock.model.ResStockModel;

@Mapper
public interface StockMapper {
	//종목 목록 조회
	List<ResStockModel> selectStockList(ReqStockModel req);

}
