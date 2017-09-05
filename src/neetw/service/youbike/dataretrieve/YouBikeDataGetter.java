package neetw.service.youbike.service;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.JsonArray;

import neetw.service.youbike.dataretrieve.HtmlDataGetter;
import neetw.service.youbike.dataretrieve.HtmlDataParser;
import neetw.service.youbike.model.YouBikeStationUnit;

public class YouBikeDataSetter { 
	
	/**
	 * Returns a Hashtable contains info of all YouBike station in selected area
	 * @param  inputUrl for example: "http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
	 * @return Hashtable of all stations in request location
	 */ 
	public Hashtable<String, YouBikeStationUnit> getYouBikeData(String inputUrl) { 
		Hashtable<String, YouBikeStationUnit> YouBikeHttpData = new Hashtable<String, YouBikeStationUnit>(); 
		try { 
		 
			String orgiHTMLData = new HtmlDataGetter().getYouBikeData(inputUrl); 
			HtmlDataParser htmlParser = new HtmlDataParser();
			String parsedHTMLData = htmlParser.spiltHtmlData(orgiHTMLData);
			JsonArray resultJsonArray = htmlParser.parseJsonData(parsedHTMLData);	 
			
			for(int temp_i=1; temp_i<resultJsonArray.size(); temp_i++) {  
				try {
					String sna = resultJsonArray.getJsonObject(temp_i).getString("sna");
					String sarea = resultJsonArray.getJsonObject(temp_i).getString("sarea");
					String sbi = resultJsonArray.getJsonObject(temp_i).getString("sbi");
					String tot = resultJsonArray.getJsonObject(temp_i).getString("tot");
					 
					YouBikeStationUnit temp_obj = new YouBikeStationUnit(); 
					temp_obj.setZoneName(sarea); 
					temp_obj.setStationName(sna);
					temp_obj.setAvailNum(Integer.parseInt(sbi));  
					temp_obj.setEmptyNum(Integer.parseInt(tot)-Integer.parseInt(sbi));  
					YouBikeHttpData.put(sna, temp_obj); 
					 
				} catch (Exception e) {  
					Logger log = Logger.getLogger(YouBikeDataSetter.class.getName()); 
					log.log(Level.SEVERE, e.toString(), e);
					return null;
				}  
			}  
			
		} catch (Exception e) {   
			Logger log = Logger.getLogger(YouBikeDataSetter.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			return null; 
		} 
		return YouBikeHttpData; 
	}

}
