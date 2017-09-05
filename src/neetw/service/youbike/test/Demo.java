package neetw.service.youbike;

import java.util.Hashtable;
import javax.json.JsonArray;
import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.service.YouBikeInfoEmitter;
import neetw.service.youbike.service.YouBikeInfoViewer;

public class Demo {

	public static void main(String[] args) {

        YouBikeInfoEmitter youBikeInfoEmitter = new YouBikeInfoEmitter();

        DaoExample daoExample = new DaoExample();
        youBikeInfoEmitter.addObserver(daoExample);

        youBikeInfoEmitter.updateData(YouBikeConstant.YOUBIKE_TAICHUNG);

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
