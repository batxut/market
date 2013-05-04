package logic;

import java.util.ArrayList;

import client_interface.SearchBill;

import data.*;
import dataOperation.*;


public class SearchBillControll implements SearchBill{
    ArrayList<Bill>BillList;
	public Bill searchBill(String ID) {
			BillList=new GetData().getBillList();
			for(int i=0;i<BillList.size();i++)
			{
				Bill bill=BillList.get(i);
				int intID=Integer.parseInt(ID);
				if(bill.getID()==intID)
					return bill;
			}
			return null;
		
	}
	public ArrayList<Bill> getBills() {
		return new GetData().getBillList();
	}

}
