package junit.logic;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import logic.SaveInfoControll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaveInfoControllTest extends TestCase{
    SaveInfoControll saveInfo;
	@Before
	public void setUp() throws Exception {
		saveInfo=new SaveInfoControll();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(saveInfo);
	}

}
