package com.app.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.stock.model.ReqStockModel;
import com.app.stock.model.ResStockModel;
import com.app.stock.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Stock")
@RestController
@RequestMapping(value="/stock")
public class StockController {
	@Autowired
	private StockService service; 
	
	@ApiOperation(value="종목 조회", responseContainer="List", response=ResStockModel.class)
	@GetMapping(value="/list")
	public ResponseEntity<Object> getStockList(
		HttpServletRequest request, 
		HttpServletResponse response,
		@ApiParam(value="검색어", required=true) @RequestParam(required=true) String searchValue
	) throws Exception {
		ReqStockModel model = new ReqStockModel();
		
		model.setSearchValue(searchValue);
		
		return new ResponseEntity<Object>(service.getStockList(model), HttpStatus.OK);
	}
}
