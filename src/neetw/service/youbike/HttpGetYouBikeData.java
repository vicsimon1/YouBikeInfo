package neetw.service.youbike;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;

public class HttpGetYouBikeData { 

	public Hashtable<String, YouBikeHttpUnit> getYouBikeData(String inputUrl) {
		//"http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
		Hashtable<String, YouBikeHttpUnit> YouBikeHttpData = new Hashtable<String, YouBikeHttpUnit>(); 
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
			for(int temp_a=1; temp_a<httpgetBikeUnit.length; temp_a++) { 
				try {
					String[] httpgetBikeUnit_spilt = 
							httpgetBikeUnit[temp_a].split("</td><td style=\"width:20%\">"); 
					YouBikeHttpUnit temp_obj = new YouBikeHttpUnit();
					 
					temp_obj.setStationName(httpgetBikeUnit_spilt[1]);
					temp_obj.setAvailNum(Integer.parseInt(httpgetBikeUnit_spilt[2]));  
					temp_obj.setEmptyNum(Integer.parseInt(httpgetBikeUnit_spilt[3].replace("</td></tr>", ""))); 
					
					YouBikeHttpData.put(httpgetBikeUnit_spilt[1], temp_obj); 
					/*System.out.println(httpgetBikeUnit_spilt[1] + ";" + 
					httpgetBikeUnit_spilt[2] + ";" +
					httpgetBikeUnit_spilt[3].replace("</td></tr>", "") ); */
				} catch (Exception e) { 
					System.out.println("[HttpGetYouBikeData]err in YouBikeHttpData.put(): " + e.toString());
				} 
			} 
			br.close();
			huc.disconnect();
		} catch (Exception e) { 
			System.out.println("[HttpGetYouBikeData]err gernal: "  + e.toString());
		} 
		return YouBikeHttpData; 
	}

}

