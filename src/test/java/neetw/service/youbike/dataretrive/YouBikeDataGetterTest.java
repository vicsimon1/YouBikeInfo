package neetw.service.youbike.dataretrive;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.dataretrieve.YouBikeDataGetter;
import neetw.service.youbike.model.YouBikeStation;

public class YouBikeDataGetterTest {

	YouBikeDataGetter ydg = new YouBikeDataGetter();
	
	@Test
	public void test() {
		 Hashtable<String, YouBikeStation> rt = ydg.getYouBikeData(YouBikeConstant.YOUBIKE_TAIPEI);
		 assertTrue(rt.size()>10);
	}

}
