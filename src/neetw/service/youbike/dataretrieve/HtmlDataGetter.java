package neetw.service.youbike.dataretrieve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import neetw.service.youbike.YouBikeDataSetter;
import neetw.service.youbike.model.YouBikeStationUnit;

public class HtmlDataGetter { 
	
	/**
	 * Returns row data from html
	 * @param  inputUrl for example: "http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
	 * @return String row data from html
	 * if YouBike website has been changed, this method should be modified
	 */ 
	public String getYouBikeData(String inputUrl) { 
		Hashtable<String, YouBikeStationUnit> YouBikeHttpData = new Hashtable<String, YouBikeStationUnit>(); 
		try { 
			//retrieve HTML row data
			URL url = new URL(inputUrl);
			HttpURLConnection huc = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "UTF-8"));
			String str = ""; 
			StringBuffer sb = new StringBuffer();
			while(null != ((str=br.readLine()))) {
				sb.append(str);
			}
			br.close(); 
			String xmlResponse = sb.toString(); 
			
			return xmlResponse;
			
		} catch (Exception e) {   
			Logger log = Logger.getLogger(YouBikeDataSetter.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			
		} 
		return ""; 
	}

}
