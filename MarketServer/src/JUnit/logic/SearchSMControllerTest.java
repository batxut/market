package JUnit.logic;

import static org.junit.Assert.*;
import logic.SearchSMController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchSMControllerTest {

	SearchSMController con;
	@Before
	public void setUp() throws Exception 
	{
		con=new SearchSMController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchSMController() {
	//	fail("Not yet implemented");
		assertNotNull(con);
	}

	@Test
	public void testSearchSM() {
	//	fail("Not yet implemented");
		assertNotNull(con.searchSM("1001"));
	}

}
