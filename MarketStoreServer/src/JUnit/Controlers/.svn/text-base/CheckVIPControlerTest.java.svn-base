package JUnit.Controlers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.user.VIPCustomer;

import Controlers.CheckVIPControler;
import DataOperation.GetData;

public class CheckVIPControlerTest extends TestCase{
	CheckVIPControler controler ;
	GetData getData;
	VIPCustomer vip;

	@Before
	public void setUp() throws Exception {
		controler = new CheckVIPControler();
		getData=new GetData();
		vip=getData.getVIPs().get(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchVIPByID() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchVIPByID(vip.getID()));
	}

	@Test
	public void testSearchVIPByLevel() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchVIPByLevel(vip.getGrade()));
	}

	@Test
	public void testSearchVIPByName() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchVIPByName(vip.getName()));
	}

	@Test
	public void testGeneralSearch() {
	//	fail("Not yet implemented");
		assertNotNull(controler.generalSearch());
	}

	

}
