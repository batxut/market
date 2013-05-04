package JUnit.logic;

import static org.junit.Assert.*;
import logic.SearchGoodsController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchGoodsControllerTest {
	
	SearchGoodsController con;
	
	@Before
	public void setUp() throws Exception
	{
		con=new SearchGoodsController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetGoodsList() {
//		fail("Not yet implemented");
		assertNotNull(con.getGoodsList());
	}

	@Test
	public void testSearchGood() {
//		fail("Not yet implemented");
		assertNotNull(con.searchGood("00001"));
	}

}
