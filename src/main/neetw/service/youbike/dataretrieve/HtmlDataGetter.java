package neetw.service.youbike.dataretrieve;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import neetw.service.youbike.config.YouBikeConstant;

public class HtmlDataGetter { 
	
	/**
	 * Returns row data from html
	 * @param  inputUrl for example: "http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc"
	 * @return String row data from html
	 * if YouBike website has been changed, this method should be modified
	 */ 
	public String getYouBikeData(String inputUrl) { 
		String urlParameters =
		        "action=" + YouBikeConstant.YOUBIKE_API_ACTION +
		        "&datas[lang]=" + YouBikeConstant.YOUBIKE_APILANG +
		        "&datas[loc]=" + inputUrl;
	    URL url;
	    HttpURLConnection connection = null;  
	    try {
	      //Create connection
	      url = new URL(YouBikeConstant.YOUBIKE_APIURL);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", 
	           "application/x-www-form-urlencoded");
				
	      connection.setRequestProperty("Content-Length", "" + 
	               Integer.toString(urlParameters.getBytes().length));
	      connection.setRequestProperty("Content-Language", "en-US");  
				
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      //Get Response	
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      return response.toString();

	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    } finally {
	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
	}

}
