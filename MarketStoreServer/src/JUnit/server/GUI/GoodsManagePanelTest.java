package JUnit.server.GUI;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.GUI.GoodsManagePanel;

public class GoodsManagePanelTest extends TestCase{
	GoodsManagePanel panel ;

	@Before
	public void setUp() throws Exception {
		panel = new GoodsManagePanel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowPanel() {
	//	fail("Not yet implemented");
		panel.showPanel();
	}

}
