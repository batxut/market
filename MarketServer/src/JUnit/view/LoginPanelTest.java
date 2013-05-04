package JUnit.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.LoginPanel;

public class LoginPanelTest {
    LoginPanel p;
	@Before
	public void setUp() throws Exception 
	{
		p=new LoginPanel(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(p);
	//	fail("Not yet implemented");
	}

}
