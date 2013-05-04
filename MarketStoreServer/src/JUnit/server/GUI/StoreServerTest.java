package JUnit.server.GUI;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.GUI.StoreServer;

public class StoreServerTest extends TestCase{
	StoreServer storeServer;
	@Before
	public void setUp() throws Exception {
		storeServer=new StoreServer();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		assertNotNull(storeServer);
	}

}
