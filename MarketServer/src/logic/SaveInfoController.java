package logic;

import java.util.ArrayList;

import data.Goods;
import data.user.GeneralManager;
import data.user.Salesman;
import data.user.StoreManager;
import dataOperation.GetData;
import dataOperation.SaveData;

import server_interface.SaveInfo;


public class SaveInfoController implements SaveInfo
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

	public void addGM(ArrayList<GeneralManager> gmlist)
	{
		ArrayList<GeneralManager> list=new GetData().getGMList();
		list.addAll(gmlist);
		new SaveData().saveGMList(list);
	}


	public void addSM(ArrayList<StoreManager> smlist) 
	{
		ArrayList<StoreManager> list=new GetData().getSMList();
		list.addAll(smlist);
		new SaveData().saveSMList(list);
	}

	public void addSalesman(ArrayList<Salesman> salesmanlist)
	{
		ArrayList<Salesman> list=new GetData().getSalesmans();
		list.addAll(salesmanlist);
		new SaveData().saveSalesmansInfo(list);
	}
	
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
