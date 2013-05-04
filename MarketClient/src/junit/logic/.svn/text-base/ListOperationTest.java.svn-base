package junit.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import logic.ListOperationControll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;
import dataOperation.GetData;

public class ListOperationTest extends TestCase{
    GetData data;
    Goods good1,good2;
    ArrayList<Goods>goods;
    ListOperationControll listOpera;
	@Before
	public void setUp() throws Exception {
		data=new GetData();
		ArrayList<Goods>OriginalGoods=data.getGoodsList();
		listOpera=new ListOperationControll();
		goods=new ArrayList<Goods>();
		goods.add(OriginalGoods.get(0));
		goods.add(OriginalGoods.get(1));
	    good1=OriginalGoods.get(2);
	    good2=OriginalGoods.get(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteGoods() {
		listOpera.deleteGoods(goods, good2);
		assertTrue(goods.size()==1);
	}

	@Test
	public void testAddGoods() {
		listOpera.addGoods(goods, good1, 1);
		assertTrue(goods.size()==3);
	}

}
