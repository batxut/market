package logic;

import java.util.ArrayList;

import client_interface.SaveInfo;

import data.Bill;
import data.Goods;
import data.user.Salesman;
import data.user.VIPCustomer;
import dataOperation.*;

public class SaveInfoControll implements SaveInfo
{ 
	public void refreshStroge(ArrayList<Goods> goodList) 
	{
		Goods good;
		for(int i=0;i<goodList.size();i++)
		{
			good=goodList.get(i);
			good.setPresentNum(good.getPresentNum()-good.getNumBought());
			good.recoverNumBought();
		}
		new SaveData().saveGoodsList(goodList);
	}

	public void saveBillInfo(Bill bill)
	{
		ArrayList<Bill> billList=new GetData().getBillList();
		for(int i=0;i<billList.size();i++){
			if(billList.get(i).getID()==bill.getID())
				billList.remove(i);
		}
		billList.add(bill);
		new SaveData().saveBillList(billList);
	}

	public void refreshVIPInfo(VIPCustomer vip) {
		ArrayList<VIPCustomer> VIPList=new GetData().getVIPList();
		for(int i=0;i<VIPList.size();i++){
			if(VIPList.get(i).getID().equals(vip.getID()))
				VIPList.remove(i);
		}
		VIPList.add(vip);
		new SaveData().saveVIPList(VIPList);
	}

	public void refreshSalesmanInfo(Salesman sal) {
		
	}

//	public void refreshSalesmanInfo(Salesman sal) {
//		ArrayList<Salesman> salesman=new GetData().getSalesmans();
//		for(int i=0;i<salesman.size();i++){
//			if(salesman.get(i).getID().equals(sal.getID()))
//				salesman.remove(i);
//		}
//		salesman.add(sal);
//		new SaveData().saveSalesmansInfo(salesman);
//	}
	
//	public static void main(String[] args)
//	{
//		ArrayList<Goods> goodlist=new GetClientData().getGoodsList();
//		Goods good=goodlist.get(0);
//		System.out.println(good.getNumber());
//		good.setNumBought(1);
//		new Controll3().refreshStroge(goodlist);
//		goodlist=new GetClientData().getGoodsList();
//		System.out.println(goodlist.get(0).getNumber());	
	//}

}
