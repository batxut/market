package junit.DataOperation;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataOperation.GetData;

public class GetDataTest extends TestCase{
	GetData getData ;
	@Before
	public void setUp() throws Exception {
		getData = new GetData();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSalesmans() {
		assertNotNull(getData.getSalesmans());
	}

	@Test
	public void testGetGoodsList() {
		assertNotNull(getData.getGoodsList());
	}

	@Test
	public void testGetGMList() {
		assertNotNull(getData.getGMList());
	}

	@Test
	public void testGetSMList() {
		assertNotNull(getData.getSMList());
	}

	@Test
	public void testGetAmountOnSaleStraList() {
		assertNotNull(getData.getAmountOnSaleStraList());
	}

	@Test
	public void testGetGoodsOnSaleStraList() {
		assertNotNull(getData.getGoodsOnSaleStraList());
	}

	@Test
	public void testGetGoodsGiftStralist() {
		assertNotNull(getData.getGoodsGiftStralist());
	}

	@Test
	public void testGetAmountGiftStralist() {
		assertNotNull(getData.getAmountGiftStralist());
	}

	@Test
	public void testGetVIPList() {
		assertNotNull(getData.getVIPList());
	}

	@Test
	public void testGetBillList() {
		assertNotNull(getData.getBillList());
	}

}
