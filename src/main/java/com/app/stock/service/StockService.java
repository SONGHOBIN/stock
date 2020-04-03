package com.app.stock.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.stock.mapper.StockMapper;
import com.app.stock.model.ReqStockModel;
import com.app.stock.model.ResStockModel;

@Service
public class StockService {
	private final StockMapper mapper;
	
	@Autowired
	StockService(StockMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<ResStockModel> getStockList(ReqStockModel req) throws Exception {
		List<ResStockModel> list = mapper.selectStockList(req);
		String url;
		
		if(list.size() > 0) {
			int index = 0;
			
			for(ResStockModel item : list) {
				url = "https://finance.naver.com/item/main.nhn?code=" + item.getIdx(); 
				Document doc = Jsoup.connect(url).get();
				
				Elements element = doc.select("div.new_totalinfo > dl.blind");
				
				int elementIdx = 0;
				for(Element dd : element.select("dd")) {
					String[] value = dd.text().split(" ");
					
					switch (elementIdx) {
						case 0 :
							list.get(index).setDateTime(
								  value[0] + " " 
								+ value[1] + " " 
								+ value[2] + " " 
								+ value[3] + " " 
								+ value[4]
							);
							
							break;
						case 3 :
							list.get(index).setTodayPriceStr(value[1] + "원");
							list.get(index).setContrastPriceStr(value[4] + "원");
							
							if("보합".equals(value[3])) {
								
								list.get(index).setContrastPriceStr(value[5] + "%");
							} else {
								String sign = "";
								
								if("플러스".equals(value[5])) {
									sign = "+";
								} else if("마이너스".equals(value[5])) {
									sign = "-";
								}
								
								list.get(index).setContrastPriceStr(sign + value[6] + "%");
							}
							
							break;
						case 4 :
							list.get(index).setBeforeDayPriceStr(value[1] + "원");
							
							break;
						case 8 :
							list.get(index).setDealPriceStr(value[1] + "원");
							
							break;
					}
					
					elementIdx++;
				}
				
				index++;
			}
		}
		
		return list;
	}

}