package neetw.service.youbike;

import java.util.Hashtable;

public class Demo {

	public static void main(String[] args) {   
		
		YouBikeStationViewer youbikeViewer = new YouBikeStationViewer();
		/*Hashtable<String, YouBikeStationUnit> table = 
				youbikeViewer.getYouBikeStations(YouBikeConstent.YOUBIKESITE[1]); 
		
		System.out.println(table);
		YouBikeStationUnit u = table.get("�ˬw���鰱����");
		System.out.println(u.getEmptyNum());*/
		 
		
		Hashtable<String, Integer> table2 = 
				youbikeViewer.getYouBikeAvailNum(YouBikeConstent.YOUBIKESITE[3]);
		System.out.println(table2);
		
	}

}
