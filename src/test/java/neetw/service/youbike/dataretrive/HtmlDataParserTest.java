package neetw.service.youbike.dataretrive;

import static org.junit.Assert.*;

import org.junit.Test;

import neetw.service.youbike.dataretrieve.HtmlDataParser;

public class HtmlDataParserTest {
	HtmlDataParser hp = new HtmlDataParser();
	@Test
	public void test() {
		String tmp = hp.decodeUnicode("\\u967d\\u5149\\u8857321\\u5df7");
		System.out.println(tmp);
		assertEquals(tmp, "陽光街321巷");
	}

}
