package neetw.service.youbike;

import java.util.Hashtable; 

public class Demo { 
	
	public static void main(String[] args) {   
		
		YouBikeStationViewer youbikeViewer = new YouBikeStationViewer();
 
		Hashtable<String, Integer> table1 = 
				youbikeViewer.getYouBikeAvailNum(YouBikeConstent.YOUBIKE_TAIPEI);
		System.out.println("AvailNum: " + table1);
		
		Hashtable<String, Integer> table2 = 
				youbikeViewer.getYouBikeEmptyNum(YouBikeConstent.YOUBIKE_TAIPEI);
		System.out.println("EmptyNum: " + table2);
		
		Hashtable<String, String> table3 = 
				youbikeViewer.getYouBikeZoneName(YouBikeConstent.YOUBIKE_TAIPEI);
		System.out.println("ZoneName: " + table3);
		
	}

}
