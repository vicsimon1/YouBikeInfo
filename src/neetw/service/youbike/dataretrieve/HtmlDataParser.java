package neetw.service.youbike.dataretrieve;

import java.io.StringReader;
import java.net.URLDecoder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;

import neetw.service.youbike.model.YouBikeConstent;


public class HtmlDataParser {
	
	/**
	 * Returns needed htnl data
	 * @param html row data  
	 * @return String html data 
	 * if YouBike website has been changed, this method should be modified
	 */
	public String spiltHtmlData(String orgiHTMLData) {
		String spiltHTMLData[] = orgiHTMLData.split("arealist=");
		String parsedHTMLData = spiltHTMLData[1].replace("'", "").replace(";", "");
		return parsedHTMLData;
	}

	/**
	 * Returns a JsonArray contains info of all YouBike station in selected area 
	 * @param JSON String Data  
	 * @return JsonArray of all stations in request location
	 * if YouBike website has been changed, this method should be modified
	 */
	public JsonArray parseJsonData(String parsedHTMLData) {
		// decode the html data
		URLDecoder decoder = new URLDecoder();
		JsonArray resultJsonArray = null;
		try {
			String temp = decoder.decode(parsedHTMLData, "UTF-8");

			// parse JsonArray into JsonObject
			// (original is a single JsonObject with each value a sub
			// JsonObject(in String))
			JsonReader jsonReader = Json.createReader(new StringReader("[" + temp + "]"));
			JsonArray jarray = jsonReader.readArray();
			jsonReader.close();
			JsonObject jobj = jarray.getJsonObject(0);
			
			// retrieve all sub JsonObject and build a JsonArray
			JsonArrayBuilder resultJsonArrayBuilder = Json.createArrayBuilder();
			for (Object key : jobj.keySet()) {
				JsonObject jobj2 = jobj.getJsonObject(key.toString());
				resultJsonArrayBuilder.add(jobj2);
				jsonReader.close();
			}
			resultJsonArray = resultJsonArrayBuilder.build();
			JsonObject newObj = resultJsonArray.getJsonObject(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultJsonArray;
	}

}
