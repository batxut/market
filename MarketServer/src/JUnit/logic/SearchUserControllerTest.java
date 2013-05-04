package JUnit.logic;

import static org.junit.Assert.*;
import logic.SearchUserController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchUserControllerTest {

	SearchUserController con;
	@Before
	public void setUp() throws Exception 
	{
		con=new SearchUserController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchSalesman() {
//		fail("Not yet implemented");
		assertNotNull(con.searchSalesman("0001","0001"));
	}

	@Test
	public void testSearchGM() {
//		fail("Not yet implemented");
		assertNotNull(con.searchGM("2001","2001"));
	}

}
