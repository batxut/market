package JUnit.Controlers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.user.VIPCustomer;

import Controlers.DevelopVIPControler;
import DataOperation.GetData;

public class DevelopVIPControlerTest extends TestCase{
	DevelopVIPControler controler ;
	ArrayList<VIPCustomer> vips;

	@Before
	public void setUp() throws Exception {
		vips =  new ArrayList<VIPCustomer>();
		controler = new DevelopVIPControler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddVIPs() {
	///	fail("Not yet implemented");
		assertTrue(controler.addVIPs(vips));
	}

	@Test
	public void testGetPresentNum() {
	//	fail("Not yet implemented");
		assertTrue(controler.getPresentNum()>=0);
	}

}
