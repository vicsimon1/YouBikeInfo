package neetw.service.youbike;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpGetYouBikeData { 
	
	/**
	 * Returns a Hashtable contains info of all YouBike station in selected area
	 * @param  inputUrl for example: "http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
	 * @return Hashtable of all stations in request location
	 * if YouBike website has been changed, this method should be modified
	 */ 
	public Hashtable<String, YouBikeStationUnit> getYouBikeData(String inputUrl) { 
		Hashtable<String, YouBikeStationUnit> YouBikeHttpData = new Hashtable<String, YouBikeStationUnit>(); 
		try { 
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
			String[] spilt_xmlResponse = xmlResponse.split("<noscript>¥i°±ªÅ¦ì</noscript>");
			String[] spilt_xmlResponse2 = spilt_xmlResponse[1].split("			</noscript>");
			
			String[] httpgetBikeUnit = spilt_xmlResponse2[0].split("<tr>"); 
			
			for(int temp_i=1; temp_i<httpgetBikeUnit.length; temp_i++) {  
				try {
					String[] httpgetBikeUnit_spilt = 
							httpgetBikeUnit[temp_i].split("</td><td style=\"width:20%\">"); 
					YouBikeStationUnit temp_obj = new YouBikeStationUnit(); 
					temp_obj.setZoneName(httpgetBikeUnit_spilt[0].replace("<td style=\"width:20%\">", "")); 
					temp_obj.setStationName(httpgetBikeUnit_spilt[1]);
					temp_obj.setAvailNum(Integer.parseInt(httpgetBikeUnit_spilt[2]));  
					temp_obj.setEmptyNum(Integer.parseInt(httpgetBikeUnit_spilt[3].replace("</td></tr>", "")));  
					YouBikeHttpData.put(httpgetBikeUnit_spilt[1], temp_obj); 
					 
				} catch (Exception e) {  
					Logger log = Logger.getLogger(HttpGetYouBikeData.class.getName()); 
					log.log(Level.SEVERE, e.toString(), e);
					return null;
				}  
			} 
			br.close();
			huc.disconnect();
			
		} catch (Exception e) {   
			Logger log = Logger.getLogger(HttpGetYouBikeData.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			return null; 
		} 
		return YouBikeHttpData; 
	}

}
