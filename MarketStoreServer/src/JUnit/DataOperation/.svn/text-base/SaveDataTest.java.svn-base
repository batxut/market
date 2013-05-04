package JUnit.DataOperation;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.VIPCustomer;

import DataOperation.GetData;
import DataOperation.SaveData;

public class SaveDataTest extends TestCase{
	GetData getData;
	SaveData saveData ;
	ArrayList<Goods> goodslist;
	ArrayList<VIPCustomer> viplist;
	ArrayList<Salesman> salesmanlist;
	ArrayList<AmountGiftStra> amountGiftStralist;
	ArrayList<AmountOnSaleStra> amountOnSaleStralist;
	ArrayList<GoodsGiftStra> goodsgiftstra ;
	ArrayList<GoodsOnSaleStra> goodsonsale;
	//Goods goodsA;

	@Before
	public void setUp() throws Exception {
		getData=new GetData();
		saveData = new SaveData();
		goodslist = getData.getGoods();
		viplist = getData.getVIPs();
		salesmanlist=getData.getSalesmans();
		amountGiftStralist = getData.getAmountGiftStralist();
		amountOnSaleStralist = getData.getAmountOnSaleStraList();
		goodsgiftstra = getData.getGoodsGiftStralist();
		goodsonsale = getData.getGoodsOnSaleStraList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveGoodsInfo() {
	//	fail("Not yet implemented");
		saveData.saveGoodsInfo(goodslist);
	
	}

	@Test
	public void testSaveVIPInfo() {
	//	fail("Not yet implemented");
		saveData.saveVIPInfo(viplist);
	}

	@Test
	public void testSaveSalesmanInfo() {
	//	fail("Not yet implemented");
		saveData.saveSalesmanInfo(salesmanlist);
	}

	@Test
	public void testSaveAmountGiftStra() {
	//	fail("Not yet implemented");
		saveData.saveAmountGiftStra(amountGiftStralist);
	}

	@Test
	public void testSaveAmountOnSaleStra() {
	//	fail("Not yet implemented");
		saveData.saveAmountOnSaleStra(amountOnSaleStralist);
	}

	@Test
	public void testSaveGoodsGiftStra() {
	//	fail("Not yet implemented");
		saveData.saveGoodsGiftStra(goodsgiftstra);
	}

	@Test
	public void testSaveGoodsOnSaleStra() {
	//	fail("Not yet implemented");
		saveData.saveGoodsOnSaleStra(goodsonsale);
	}

}
