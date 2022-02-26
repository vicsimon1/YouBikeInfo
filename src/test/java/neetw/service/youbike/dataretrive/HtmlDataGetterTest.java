package neetw.service.youbike.dataretrive;

import static org.junit.Assert.*;

import org.junit.Test;

import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.dataretrieve.HtmlDataGetter;
import neetw.service.youbike.dataretrieve.HtmlDataParser;

public class HtmlDataGetterTest {

	HtmlDataGetter hg = new HtmlDataGetter(); 
	@Test
	public void testGetYouBikeData() {
		String tmp = hg.getYouBikeData(YouBikeConstant.YOUBIKE_TAIPEI); 
		assertNotNull(tmp);   
	}

}
