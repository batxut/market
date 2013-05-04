package JUnit;

import JUnit.Controlers.*;
import JUnit.DataOperation.*;
import JUnit.server.GUI.*;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for JUnit");
		//$JUnit-BEGIN$
		
		//ControlersTest
		suite.addTestSuite(CheckGoodsControlerTest.class);
		suite.addTestSuite(Input_GoodsControlerTest.class);
		suite.addTestSuite(Output_GoodsControlerTest.class);
		
		suite.addTestSuite(CheckVIPControlerTest.class);
		suite.addTestSuite(CountVIPControlerTest.class);
		suite.addTestSuite(DevelopVIPControlerTest.class);
		suite.addTestSuite(GiveGiftControlerTest.class);
		
		
		//DataOperationTest
		suite.addTestSuite(GetDataTest.class);
		suite.addTestSuite(SaveDataTest.class);
		
		//server.GUITest
		suite.addTestSuite(StoreServerTest.class);
		suite.addTestSuite(LoginPanelTest.class);
		suite.addTestSuite(StoreManagerLoginPanelTest.class);
		suite.addTestSuite(StoreManagerIndividualPanelTest.class);
		
		suite.addTestSuite(GoodsManagePanelTest.class);
		suite.addTestSuite(CheckGoodsPanelTest.class);
		suite.addTestSuite(InputGoodsPanelTest.class);
		suite.addTestSuite(OutputGoodsPanelTest.class);
		
		suite.addTestSuite(VIPManagePanelTest.class);
		suite.addTestSuite(CheckVIPPanelTest.class);
		suite.addTestSuite(CountVIPPanelTest.class);
		suite.addTestSuite(DevelopVIPPanelTest.class);
		suite.addTestSuite(GiveGiftPanelTest.class);
		
		suite.addTestSuite(NetConnectPanelTest.class);
		suite.addTestSuite(ConnectClientPanelTest.class); 
		
		//$JUnit-END$
		return suite;
	}

}
