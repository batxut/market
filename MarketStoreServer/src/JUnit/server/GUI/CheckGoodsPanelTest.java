package JUnit.server.GUI;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;

import server.GUI.CheckGoodsPanel;

public class CheckGoodsPanelTest extends TestCase{
    CheckGoodsPanel panel;
    ArrayList<Goods>goods;
	@Before
	public void setUp() throws Exception {
		goods=new ArrayList<Goods>();
		panel = new CheckGoodsPanel(goods);
	}

	@After
	public void tearDown() throws Exception {
	}
//
	@Test
	public void testCheckGoodsPanel() {
		//fail("Not yet implemented");
		
	}
//
	@Test
	public void testShowPanel() {
	//	fail("Not yet implemented");
		panel.showPanel();
	}

}
