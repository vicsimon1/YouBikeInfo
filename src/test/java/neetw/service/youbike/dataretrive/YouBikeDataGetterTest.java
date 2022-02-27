package neetw.service.youbike.dataretrive;

import java.util.Map;
import neetw.service.youbike.model.YouBikeStation;
import org.junit.Test;
import neetw.service.youbike.dataretrieve.YouBikeDataGetter;
import static org.junit.Assert.assertTrue;

public class YouBikeDataGetterTest {
	YouBikeDataGetter youBikeDataGetter = new YouBikeDataGetter();
	
	@Test
	public void test() {
		Map<String, YouBikeStation> result =  youBikeDataGetter.getAllYouBikeStations();
		assertTrue(result.size()>10);
	}

}
