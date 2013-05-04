package JUnit.Controlers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlers.CountVIPControler;

public class CountVIPControlerTest extends TestCase{
	CountVIPControler controler ;

	@Before
	public void setUp() throws Exception {
		controler = new CountVIPControler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountByGrade() {
	//	fail("Not yet implemented");
		assertNotNull(controler.countByGrade());
	}

	@Test
	public void testCountByPoint() {
	//	fail("Not yet implemented");
		assertNotNull(controler.countByPoint());
	}

}
