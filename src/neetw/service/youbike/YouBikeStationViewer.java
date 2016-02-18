package neetw.service.youbike;
 
import java.util.Hashtable;
import java.util.Set;

public class YouBikeStationViewer { 
	
	HttpGetYouBikeData myBike = new HttpGetYouBikeData(); 
	
	/**
	 * Returns the Hashtable of YouBikeStationUnit that contains all info of the stations 
	 * @param  inputUrl
	 * @return Hashtable<String, YouBikeStationUnit>
	 * @see    YouBikeStationUnit
	 */
	public Hashtable<String, YouBikeStationUnit> getYouBikeStations(String inputUrl) {  
		Hashtable<String, YouBikeStationUnit> table = 
				myBike.getYouBikeData(inputUrl); 
		return table; 
	}
	
	/**
	 * Returns the Hashtable of YouBike station's available number for renting bikes 
	 * @param  inputUrl
	 * @return Hashtable<String, Integer> 
	 */
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
	
	/**
	 * Returns the Hashtable of YouBike station's empty number for returning bikes 
	 * @param  inputUrl
	 * @return Hashtable<String, Integer> 
	 */
	public Hashtable<String, Integer> getYouBikeEmptyNum(String inputUrl) {
		Hashtable<String, YouBikeStationUnit> table = 
				myBike.getYouBikeData(inputUrl); 	
		
		Hashtable<String, Integer> temp_table = new Hashtable<String, Integer>(); 
		Set<String> keys = table.keySet();
        for(String key: keys) {
        	temp_table.put(key, table.get(key).emptyNum); 
        } 
		return temp_table; 
	}
	
	/**
	 * Returns the Hashtable of YouBike station's zone name
	 * @param  inputUrl
	 * @return Hashtable<String, String> 
	 */
	public Hashtable<String, String> getYouBikeZoneName(String inputUrl) {
		Hashtable<String, YouBikeStationUnit> table = 
				myBike.getYouBikeData(inputUrl); 	
		
		Hashtable<String, String> temp_table = new Hashtable<String, String>(); 
		Set<String> keys = table.keySet();
        for(String key: keys) {
        	temp_table.put(key, table.get(key).zoneName); 
        } 
		return temp_table; 
	}
	
}
