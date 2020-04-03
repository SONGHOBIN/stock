package com.app.stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.stock.model.ReqStockModel;
import com.app.stock.model.ResStockModel;

@Mapper
public interface StockMapper {
	List<ResStockModel> selectStockList(ReqStockModel req); //종목 목록 조회

}
