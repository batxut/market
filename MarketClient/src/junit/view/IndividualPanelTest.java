package junit.view;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndividualPanelTest extends TestCase{
	IndividualPanelTest p;
	@Before
	public void setUp() throws Exception {
		p=new IndividualPanelTest();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		assertNotNull(p);
	}

}
