package junit.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import logic.CalculateControll;
import logic.ListOperationControll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;
import dataOperation.GetData;

public class CalculateControllTest extends TestCase{
    Goods good1,good2;
    ArrayList<Goods>goods; 
    CalculateControll calculate;
	
	@Before
	public void setUp() throws Exception {
		calculate=new CalculateControll();
		good1=new Goods("ÍÞ¹þ¹þ", "00001", 4.5, 20, null, null, null, 0);
		good1.setNumBought(2);
		good2=new Goods("Ãæ°ü", "00002", 2.2, 20, null, null, null, 0);
		good2.setNumBought(1);
		goods=new ArrayList<Goods>();
		goods.add(good1);
		goods.add(good2);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateDue() {
		assertTrue(calculate.calculateDue(goods)==11.2);
	}

	@Test
	public void testOverflow() {
		
		assertTrue(calculate.overflow(20,goods, good2));
		
	}


}
