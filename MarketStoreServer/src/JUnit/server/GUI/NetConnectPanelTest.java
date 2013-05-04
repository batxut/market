package JUnit.server.GUI;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.GUI.NetConnectPanel;

public class NetConnectPanelTest extends TestCase{
    NetConnectPanel panel ;
	@Before
	public void setUp() throws Exception {
		panel = new NetConnectPanel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowPanel() {
	//	fail("Not yet implemented");
//		panel.showPanel();
	}

}
