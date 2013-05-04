package JUnit.Controlers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Goods;
import data.user.VIPCustomer;

import Controlers.GiveGiftControler;
import DataOperation.GetData;

public class GiveGiftControlerTest extends TestCase{
	GetData getData;
	VIPCustomer vip;
	Goods goods;
	GiveGiftControler controler ;
	

	@Before
	public void setUp() throws Exception {
		getData=new GetData();
		vip=getData.getVIPs().get(0);
		goods=getData.getGoods().get(0);
		controler = new GiveGiftControler();
	}

	

	@Test
	public void testSearchGiftVIP() {
		assertNotNull(controler.searchGiftVIP());
	}
	
	@Test
	public void testSearchGift() {
		assertNotNull(controler.searchGifts());
	}
	@Test
	public void testGiveGift() {
		testSearchGiftVIP();
		testSearchGift();
		if(vip.getGift()==null){
			assertTrue(controler.giveGift(vip.getID(),goods.getID()));
		}
		else{
			assertFalse(controler.giveGift(vip.getID(),goods.getID()));
		}
	}
	@After
	public void tearDown() throws Exception {
		
	}
}
