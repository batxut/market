package JUnit.Controlers;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;

import Controlers.Input_GoodsControler;
import DataOperation.GetData;

public class Input_GoodsControlerTest extends TestCase{
	ArrayList<Goods>  goodslist;
	Input_GoodsControler controler ;
	

	@Before
	public void setUp() throws Exception {
		goodslist = new ArrayList<Goods>();
		controler = new Input_GoodsControler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddGoods() {
	//	fail("Not yet implemented");
		assertTrue(controler.addGoods(goodslist));
	}

	@Test
	public void testGetStored_goods() {
	//	fail("Not yet implemented");
		assertNotNull(controler.getStored_goods());
	}

}
