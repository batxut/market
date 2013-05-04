package JUnit.server.GUI;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;

import server.GUI.OutputGoodsPanel;

public class OutputGoodsPanelTest extends TestCase{
    OutputGoodsPanel panel ;
    ArrayList<Goods> goodslist;
	@Before
	public void setUp() throws Exception {
		goodslist = new ArrayList<Goods>();
	   panel = new OutputGoodsPanel(goodslist);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowPanel() {
		//fail("Not yet implemented");
		panel.showPanel();
	}

}
