package JUnit.logic;

import static org.junit.Assert.*;
import logic.SearchStraController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchStraControllerTest {

	SearchStraController search;
	@Before
	public void setUp() throws Exception
	{
		search=new SearchStraController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchAmountGiftStra() {
	//	fail("Not yet implemented");
		assertNotNull(search.searchAmountGiftStra(4001));
	}

	@Test
	public void testSearchAmountOnSaleStra() {
	//	fail("Not yet implemented");
		assertNull(search.searchAmountOnSaleStra(3001));
	}

	@Test
	public void testSearchGoodsGiftStra() {
	//	fail("Not yet implemented");
		assertNull(search.searchGoodsGiftStra(2001));
	}

	@Test
	public void testSearchGoodsOnSaleStra() {
	//	fail("Not yet implemented");
		assertNotNull(search.searchGoodsOnSaleStra(1001));
	}

}
