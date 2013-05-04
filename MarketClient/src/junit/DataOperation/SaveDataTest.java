package junit.DataOperation;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataOperation.SaveData;

public class SaveDataTest extends TestCase{


	SaveData savedata;
	@Before
	public void setUp() throws Exception 
	{
		savedata=new SaveData();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
		assertNotNull(savedata);
	}

}
