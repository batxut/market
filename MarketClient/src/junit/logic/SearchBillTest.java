package junit.logic;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import logic.SearchBillControll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Bill;
import dataOperation.GetData;

public class SearchBillTest extends TestCase{
	SearchBillControll searchBill;
	GetData data;
	Bill bill;
	@Before
	public void setUp() throws Exception {
		searchBill=new SearchBillControll();
		data=new GetData ();
		bill=data.getBillList().get(0);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchBill() {
		assertNotNull(searchBill.searchBill(String.valueOf(bill.getID())));
	}

	@Test
	public void testGetBills() {
		assertNotNull(searchBill.getBills());
	}
	@Test
	public void testSearchBillControll() {
		assertNotNull(searchBill);
	}

}
