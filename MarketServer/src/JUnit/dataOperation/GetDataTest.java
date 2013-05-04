package JUnit.dataOperation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataOperation.GetData;

public class GetDataTest {
	GetData getdata;
	@Before
	public void setUp() throws Exception
	{
		getdata=new GetData();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSalesmans() {
//		fail("Not yet implemented");
		assertNotNull(getdata.getSalesmans());
	}

	@Test
	public void testGetGoodsList() {
//		fail("Not yet implemented");
		assertNotNull(getdata.getGoodsList());
	}

	@Test
	public void testGetAmountOnSaleStraList() {
//		fail("Not yet implemented");
		assertNotNull(getdata.getAmountOnSaleStraList());
	}

	@Test
	public void testGetGoodsGiftStralist() {
//		fail("Not yet implemented");
		assertNotNull(getdata.getGoodsGiftStralist());
	}

}
