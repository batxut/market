package junit.logic;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import logic.SearchGoodsControll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;
import dataOperation.GetData;

public class SearchGoodsTest extends TestCase{
	 SearchGoodsControll searchGoods;
	 GetData data;
	 Goods good;
	@Before
	public void setUp() throws Exception {
		searchGoods=new SearchGoodsControll();
		data=new GetData();
		good=data.getGoodsList().get(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchGoodsControll() {
		assertNotNull(searchGoods);
	}

	@Test
	public void testGetGoodsList() {
		assertNotNull(searchGoods.getGoodsList());
	}

	@Test
	public void testSearchGood() {
		assertNotNull(searchGoods.searchGood(good.getID()));
	}

}
