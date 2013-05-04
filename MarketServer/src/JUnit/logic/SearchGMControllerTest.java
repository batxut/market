package JUnit.logic;

import static org.junit.Assert.*;
import logic.SearchGMController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchGMControllerTest {

	SearchGMController con;
	@Before
	public void setUp() throws Exception
	{
		con=new SearchGMController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchGM() {
//		fail("Not yet implemented");
		assertNotNull(con.searchGM("2001"));
		
	}

}
