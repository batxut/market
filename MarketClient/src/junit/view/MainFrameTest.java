package junit.view;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.MainFrame;

public class MainFrameTest extends TestCase{
	MainFrame mainFrame;
	@Before
	public void setUp() throws Exception {
		mainFrame=new MainFrame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		assertNotNull(mainFrame);
//		fail("Not yet implemented");
	}

}
