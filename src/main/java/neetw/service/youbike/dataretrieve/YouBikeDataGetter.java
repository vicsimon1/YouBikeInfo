package neetw.service.youbike.dataretrieve;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.model.YouBikeStation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YouBikeDataGetter {

	/**
	 * Returns a Map contains info of all YouBike stations
	 */ 
	public Map<String, YouBikeStation> getAllYouBikeStations() {
		Map<String, YouBikeStation> tp = getTaipeiYouBikeStations();
		Map<String, YouBikeStation> ntp = getNewTaipeiYouBikeStations();
		tp.putAll(ntp);
		return tp;
	}

	public Map<String, YouBikeStation> getAllYouBike2Stations() {
		Map<String, YouBikeStation> tp = getTaipeiYouBike2Stations();
		Map<String, YouBikeStation> ntp = getNewTaipeiYouBike2Stations();
		tp.putAll(ntp);
		return tp;
	}

	public Map<String, YouBikeStation> getTaipeiYouBikeStations() {
		Map<String, YouBikeStation> result = new HashMap<>();
		String jsonData = getHttpData(YouBikeConstant.TAIPEI_APIURL);
		JsonElement jsonElement = new JsonParser().parse(jsonData);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonObject mJson = jsonObject.getAsJsonObject("retVal");
		Set<Map.Entry<String, JsonElement>> entries = mJson.entrySet();
		for (Map.Entry<String, JsonElement> entry: entries) {
			Gson gson = new Gson();
			YouBikeStation youBikeStation = gson.fromJson(entry.getValue(), YouBikeStation.class);
			result.put(youBikeStation.getSno(), youBikeStation);
		}
		return result;
	}

	public Map<String, YouBikeStation> getTaipeiYouBike2Stations() {
		return getFromJSONArrayResponse(YouBikeConstant.TAIPEI_2_APIURL);
	}

	public Map<String, YouBikeStation> getNewTaipeiYouBikeStations() {
		return getFromJSONArrayResponse(YouBikeConstant.NEW_TAIPEI_APIURL);
	}

	public Map<String, YouBikeStation> getNewTaipeiYouBike2Stations() {
		return getFromJSONArrayResponse(YouBikeConstant.NEW_TAIPEI_2_APIURL);
	}

	private String getHttpData(String url) {
		String jsonData = "";
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(url).build();
			Response responses = client.newCall(request).execute();
			jsonData = responses.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}

	private Map<String, YouBikeStation> getFromJSONArrayResponse(String url) {
		Map<String, YouBikeStation> result = new HashMap<>();
		String jsonData = getHttpData(url);
		JsonElement jsonElement = new JsonParser().parse(jsonData);
		com.google.gson.JsonArray jsonArr = jsonElement.getAsJsonArray();
		for (int i = 0; i < jsonArr.size(); i++) {
			JsonObject mJson = jsonArr.get(i).getAsJsonObject();
			Gson gson = new Gson();
			YouBikeStation youBikeStation = gson.fromJson(mJson, YouBikeStation.class);
			result.put(youBikeStation.getSno(), youBikeStation);
		}
		return result;
	}

}
