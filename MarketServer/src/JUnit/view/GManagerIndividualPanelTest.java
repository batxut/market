package JUnit.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.GManagerIndividualPanel;

public class GManagerIndividualPanelTest {
	GManagerIndividualPanel p;
	@Before
	public void setUp() throws Exception
	{
		p=new GManagerIndividualPanel(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
		assertNotNull(p);
	}

}
