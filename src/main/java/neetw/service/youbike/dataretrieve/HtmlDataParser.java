package neetw.service.youbike.dataretrieve;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class HtmlDataParser {

	/**
	 * Returns needed htnl data
	 * 
	 * @param html row data
	 * @return String html data if YouBike website has been changed, this method
	 *         should be modified
	 */
	@Deprecated
	public String spiltHtmlData(String orgiHTMLData) {
		String spiltHTMLData[] = orgiHTMLData.split("arealist=");
		String parsedHTMLData = spiltHTMLData[1].replace("'", "").replace(";", "");
		return parsedHTMLData;
	}

	/**
	 * Returns a JsonArray contains info of all YouBike station in selected area
	 * 
	 * @param JSON String Data
	 * @return JsonArray of all stations in request location if YouBike website has
	 *         been changed, this method should be modified
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
			JsonReader jsonReader = Json.createReader(new StringReader(temp));
			JsonArray jarray = jsonReader.readArray();
			jsonReader.close();
			JsonObject jobj = jarray.getJsonObject(0);
			JsonObject jsonOb = jobj.getJsonObject("resdata");

			// retrieve all sub JsonObject and build a JsonArray
			JsonArrayBuilder resultJsonArrayBuilder = Json.createArrayBuilder();
			for (Object key : jsonOb.keySet()) {
				JsonObject jobj2 = jsonOb.getJsonObject(key.toString());
				resultJsonArrayBuilder.add(jobj2);
				jsonReader.close();
			}
			resultJsonArray = resultJsonArrayBuilder.build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultJsonArray;
	}

	public String decodeUnicode(String str) {
		str = str.replace("\\/", "/");
		Charset set = Charset.forName("UTF-16");
		Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
		Matcher m = p.matcher(str);
		int start = 0;
		int start2 = 0;
		StringBuffer sb = new StringBuffer();
		while (m.find(start)) {
			start2 = m.start();
			if (start2 > start) {
				String seg = str.substring(start, start2);
				sb.append(seg);
			}
			String code = m.group(1);
			int i = Integer.valueOf(code, 16);
			byte[] bb = new byte[4];
			bb[0] = (byte) ((i >> 8) & 0xFF);
			bb[1] = (byte) (i & 0xFF);
			ByteBuffer b = ByteBuffer.wrap(bb);
			sb.append(String.valueOf(set.decode(b)).trim());
			start = m.end();
		}
		start2 = str.length();
		if (start2 > start) {
			String seg = str.substring(start, start2);
			sb.append(seg);
		}
		return sb.toString();
	}
}
