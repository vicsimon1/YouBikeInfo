package neetw.service.youbike.service;

import static org.junit.Assert.*;

import javax.json.JsonArray;

import org.junit.Before;
import org.junit.Test;

import neetw.service.youbike.config.YouBikeConstant;
import neetw.service.youbike.service.YouBikeInfoEmitter;

public class YouBikeInfoEmitterTest {
	YouBikeInfoEmitter ye = new YouBikeInfoEmitter();
	
	@Before
	public void init() {
		ye.updateData(YouBikeConstant.YOUBIKE_TAIPEI);
	}
	
	@Test
	public void testGetYouBikeStations() { 
		assertTrue(ye.getYouBikeStations().size()>10); 
	}
	
	@Test
	public void testGetYouBikeAvailNum() { 
		assertTrue(ye.getYouBikeAvailNum().size()>10);
	}
	
	@Test
	public void testGetYouBikeEmptyNum() { 
		assertTrue(ye.getYouBikeEmptyNum().size()>10);
	}
	
	@Test
	public void testGetYouBikeZoneName() { 
		assertTrue(ye.getYouBikeZoneName().size()>10);
	}
	
	@Test
	public void testGetYouBikeJsonArray() { 
		JsonArray ja = ye.getYouBikeJsonArray(YouBikeConstant.YOUBIKE_TAIPEI);
		assertTrue(ja.size()>10);
	}

}
