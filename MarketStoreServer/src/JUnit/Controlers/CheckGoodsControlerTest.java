package JUnit.Controlers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlers.CheckGoodsControler;

public class CheckGoodsControlerTest extends TestCase{
	private CheckGoodsControler controler;

	@Before
	public void setUp() throws Exception {
		controler = new CheckGoodsControler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnalyseStorage() {
		//fail("Not yet implemented");
		assertNotNull(controler.analyseStorage());
		
	}

}
