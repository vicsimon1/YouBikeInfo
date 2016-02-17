package neetw.service.youbike;

import java.util.Hashtable;

public class Demo {

	String[] Localtion = {"taipei", "ntpc", "taichung", "chcg", "tycg"};
	
	public static void main(String[] args) { 
		HttpGetYouBikeData myBike = new HttpGetYouBikeData();
		Hashtable<String, YouBikeHttpUnit> table = 
				myBike.getYouBikeData("http://taipei.youbike.com.tw/cht/f12.php?loc=ntpc");
		System.out.println(table);
		YouBikeHttpUnit u = table.get("·Ë¬w¤½¶é°±¨®³õ");
		System.out.println(u.getEmptyNum());
		
	}

}
