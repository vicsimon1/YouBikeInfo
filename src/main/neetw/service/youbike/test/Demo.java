package neetw.service.youbike.test;

import java.util.Hashtable;
import javax.json.JsonArray;
import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.service.YouBikeInfoEmitter;
import neetw.service.youbike.test.DaoExample;

public class Demo {

	public static void main(String[] args) {

        YouBikeInfoEmitter youBikeInfoEmitter = new YouBikeInfoEmitter();
 
        // add any custom Observer
        DaoExample daoExample = new DaoExample();
        youBikeInfoEmitter.addObserver(daoExample);

        // call this to update data from official YouBike website
        youBikeInfoEmitter.updateData(YouBikeConstant.YOUBIKE_TAICHUNG);

        // Other data retrive utils
        Hashtable<String, Integer> table = youBikeInfoEmitter.getYouBikeAvailNum();
        System.out.println("AvailNum: " + table);

        Hashtable<String, Integer> table2 = youBikeInfoEmitter.getYouBikeEmptyNum();
        System.out.println("EmptyNum: " + table2);

        Hashtable<String, String> table3 = youBikeInfoEmitter.getYouBikeZoneName();
        System.out.println("ZoneName: " + table3);

        JsonArray array1 = youBikeInfoEmitter.getYouBikeJsonArray(YouBikeConstant.YOUBIKE_TAICHUNG);
        System.out.println("JsonArray: " + array1);

	}

}
