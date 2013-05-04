package JUnit.server.GUI;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.GUI.VIPManagePanel;

public class VIPManagePanelTest extends TestCase{
    VIPManagePanel panel ;
	@Before
	public void setUp() throws Exception {
		panel = new VIPManagePanel();
	}

	@After
	public void tearDown() throws Exception {
	}
/*
	@Test
	public void testVIPManagePanel() {
	//	fail("Not yet implemented")
	}
*/
	@Test
	public void testShowPanel() {
	//fail("Not yet implemented");
	     panel.showPanel();
	}

}
