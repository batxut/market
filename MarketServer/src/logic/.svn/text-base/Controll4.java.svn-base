package logic;

import java.util.ArrayList;

import data.user.GeneralManager;
import data.user.Salesman;
import data.user.StoreManager;
import dataOperation.GetData;
import server_interface.IsIDRepeated;

public class Controll4 implements IsIDRepeated
{
	GetData getdata;
	
	public Controll4()
	{
		getdata=new GetData();
	}
	
	public int isIDrepeated(String ID) 
	{
		return isGMIDrepeated(ID)+isSalesmanIDRepeated(ID)+isSMIDrepeated(ID);
	}
	
	public int isGMIDrepeated(String ID)
	{
		ArrayList<GeneralManager> gmlist=getdata.getGMList();
		for(int i=0;i<gmlist.size();i++)
		{
			if(gmlist.get(i).getID().equals(ID))
				return 4;
		}
		return 0;
	}
	
	public int isSalesmanIDRepeated(String ID)
	{
		ArrayList<Salesman> salesmanlist=getdata.getSalesmans();
		for(int i=0;i<salesmanlist.size();i++)
		{
			if(salesmanlist.get(i).getID().equals(ID))
				return 2;
		}
		return 0;
	}
	
	public int isSMIDrepeated(String ID)
	{
		ArrayList<StoreManager> smlist=getdata.getSMList();
		for(int i=0;i<smlist.size();i++)
		{
			if(smlist.get(i).getID().equals(ID))
				return 3;
		}
		return 0;
	}
/*	
	public static void main(String[] args)
	{
		System.out.println(new Controll4().isGMIDrepeated("gm"));
		System.out.println(new Controll4().isSalesmanIDRepeated("00001"));
	}
*/
}
