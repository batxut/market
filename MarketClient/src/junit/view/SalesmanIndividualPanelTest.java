package junit.view;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.SalesmanIndividualPanel;

public class SalesmanIndividualPanelTest extends TestCase{
	SalesmanIndividualPanel p;
	@Before
	public void setUp() throws Exception {
		p=new SalesmanIndividualPanel(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(p);
	}

}
