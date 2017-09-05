package neetw.service.youbike.dataretrieve;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.JsonArray;

import neetw.service.youbike.model.YouBikeStation;

public class YouBikeDataGetter {

	HtmlDataGetter htmlDataGetter = new HtmlDataGetter();
	HtmlDataParser htmlParser = new HtmlDataParser();

	/**
	 * Returns a Hashtable contains info of all YouBike station in selected area
	 * @param  inputUrl for example: "http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
	 * @return Hashtable of all stations in request location
	 */ 
	public Hashtable<String, YouBikeStation> getYouBikeData(String inputUrl) {
		Hashtable<String, YouBikeStation> YouBikeHttpData = new Hashtable<String, YouBikeStation>();
		try { 
		 
			String orgiHTMLData = htmlDataGetter.getYouBikeData(inputUrl);
			String parsedHTMLData = htmlParser.spiltHtmlData(orgiHTMLData);
			JsonArray resultJsonArray = htmlParser.parseJsonData(parsedHTMLData);	 
			
			for(int temp_i=1; temp_i<resultJsonArray.size(); temp_i++) {  
				try {
					String sna = resultJsonArray.getJsonObject(temp_i).getString("sna");
					String sarea = resultJsonArray.getJsonObject(temp_i).getString("sarea");
					String sbi = resultJsonArray.getJsonObject(temp_i).getString("sbi");
					String tot = resultJsonArray.getJsonObject(temp_i).getString("tot");
					 
					YouBikeStation temp_obj = new YouBikeStation();
					temp_obj.setZoneName(sarea); 
					temp_obj.setStationName(sna);
					temp_obj.setAvailNum(Integer.parseInt(sbi));  
					temp_obj.setEmptyNum(Integer.parseInt(tot)-Integer.parseInt(sbi));  
					YouBikeHttpData.put(sna, temp_obj); 
					 
				} catch (Exception e) {  
					Logger log = Logger.getLogger(YouBikeDataGetter.class.getName());
					log.log(Level.SEVERE, e.toString(), e);
					return null;
				}  
			}  
			
		} catch (Exception e) {   
			Logger log = Logger.getLogger(YouBikeDataGetter.class.getName());
			log.log(Level.SEVERE, e.toString(), e);
			return null; 
		} 
		return YouBikeHttpData; 
	}

    public JsonArray getYouBikeJsonArray(String inputUrl) {
        String orgiHTMLData = htmlDataGetter.getYouBikeData(inputUrl);
        String parsedHTMLData = htmlParser.spiltHtmlData(orgiHTMLData);
        JsonArray resultJsonArray = htmlParser.parseJsonData(parsedHTMLData);

        return resultJsonArray;
    }

}
