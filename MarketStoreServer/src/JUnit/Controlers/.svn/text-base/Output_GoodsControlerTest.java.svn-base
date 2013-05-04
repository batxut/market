package JUnit.Controlers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;

import Controlers.Output_GoodsControler;
import DataOperation.GetData;

public class Output_GoodsControlerTest extends TestCase{
	ArrayList<Goods> goodslist;
	GetData getData;
	Goods goods;
	Output_GoodsControler controler;
	

	@Before
	public void setUp() throws Exception {
		goodslist = new ArrayList<Goods> ();
		getData=new GetData();
		goods=getData.getGoods().get(0);
		controler = new Output_GoodsControler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchByType() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchByType(goods.getName()));
	}

	@Test
	public void testSearchByID() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchByID(goods.getID()));
	}

	@Test
	public void testSearchByPrice() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchByPrice(goods.getOriginalCost()));
	}

	@Test
	public void testSearchByNumber() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchByNumber(goods.getInputNum()));
	}

	@Test
	public void testDeleteGoods() {
	//	fail("Not yet implemented");
		assertTrue(controler.deleteGoods(goodslist));
	}

	@Test
	public void testSearchGifts() {
	//	fail("Not yet implemented");
		assertNotNull(controler.searchGifts());
	}

}
