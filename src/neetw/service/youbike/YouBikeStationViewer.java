package neetw.service.youbike;
 
import java.util.Hashtable;
import java.util.Set;

public class YouBikeStationViewer { 
	
	HttpGetYouBikeData myBike = new HttpGetYouBikeData(); 
	
	public Hashtable<String, YouBikeStationUnit> getYouBikeStations(String inputUrl) {  
		Hashtable<String, YouBikeStationUnit> table = 
				myBike.getYouBikeData(inputUrl); 
		return table; 
	}
	
	public Hashtable<String, Integer> getYouBikeAvailNum(String inputUrl) { 
		Hashtable<String, YouBikeStationUnit> table = 
				myBike.getYouBikeData(inputUrl); 	
		
		Hashtable<String, Integer> temp_table = new Hashtable<String, Integer>(); 
		Set<String> keys = table.keySet();
        for(String key: keys) {
        	temp_table.put(key, table.get(key).availNum); 
        } 
		return temp_table; 
	}
	
	public Hashtable<String, String> getYouBikeEmptyNum(String inputUrl) {
		
		return null; 
	}
	
}
