package junit;

import junit.DataOperation.GetDataTest;
import junit.DataOperation.SaveDataTest;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.logic.CalculateControllTest;
import junit.logic.ListOperationTest;
import junit.logic.SaveInfoControllTest;
import junit.logic.SearchBillTest;
import junit.logic.SearchGoodsTest;
import junit.logic.SearchUserTest;
import junit.view.IndividualPanelTest;
import junit.view.LoginPanelTest;
import junit.view.MainFrameTest;
import junit.view.ReturnGoodsPanelTest;
import junit.view.SalesmanIndividualPanelTest;
import junit.view.SalesmanLoginPanelTest;
import junit.view.SellGoodsPanelTest;

public class AllTests {
	public static Test suite() {
		
		TestSuite suite = new TestSuite("Test for JUnit");
		//logic__test;
		
		suite.addTestSuite(CalculateControllTest.class);
		suite.addTestSuite(ListOperationTest.class);
		suite.addTestSuite(SaveInfoControllTest.class);
		suite.addTestSuite(SearchBillTest.class);
		suite.addTestSuite(SearchGoodsTest.class);
		suite.addTestSuite(SearchUserTest.class);
		
		//DataOperation__test;
		
		suite.addTestSuite(GetDataTest.class);
		suite.addTestSuite(SaveDataTest.class);
		
		//view__test;
		
		suite.addTestSuite(IndividualPanelTest.class);
		suite.addTestSuite(LoginPanelTest.class);
		suite.addTestSuite(MainFrameTest.class);
		suite.addTestSuite(ReturnGoodsPanelTest.class);
		suite.addTestSuite(SalesmanIndividualPanelTest.class);
		suite.addTestSuite(SalesmanLoginPanelTest.class);
		suite.addTestSuite(SellGoodsPanelTest.class);
		
		return suite;
	
	}
}
