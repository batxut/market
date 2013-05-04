package JUnit.logic;

import static org.junit.Assert.*;
import logic.Controll4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Controll4Test {

	Controll4 con;
	@Before
	public void setUp() throws Exception
	{
		con=new Controll4();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsGMIDrepeated() {
		assertTrue(con.isGMIDrepeated("2001")==4);
//		fail("Not yet implemented");
	}

	@Test
	public void testIsSalesmanIDRepeated() {
		assertTrue(con.isSMIDrepeated("1001")==3);
//		fail("Not yet implemented");
	}

	@Test
	public void testIsSMIDrepeated() {
		assertTrue(con.isSalesmanIDRepeated("0001")==2);
//		fail("Not yet implemented");
	}

}
