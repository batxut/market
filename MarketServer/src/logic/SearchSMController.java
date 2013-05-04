package logic;

import java.util.ArrayList;

import data.user.*;
import dataOperation.*;
import server_interface.SearchSM;

public class SearchSMController implements SearchSM
{
	ArrayList<StoreManager> SMList;

	public SearchSMController(){}

	@Override
	public StoreManager searchSM(String ID)
	{
		SMList=new GetData().getSMList();
		for(int i=0;i<SMList.size();i++)
		{
			StoreManager temp=SMList.get(i);
			if(temp.getID().equals(ID))
				return temp;
		}		
		return null;
	}

	@Override
	public void deleteSM(ArrayList<StoreManager> list)
	{
		SMList=new GetData().getSMList();
		for(int i=0;i<list.size();i++)
		{
			StoreManager temp=list.get(i);
//			delete(temp);
			for(int j=0;j<SMList.size();j++)
			{
				if(SMList.get(j).getID().equals(temp.getID()))
				{
					SMList.remove(j);
					break;
				}
			}
		}
		new SaveData().saveSMList(SMList);		
	}

	@Override
	public void delete(StoreManager temp)
	{
		SMList=new GetData().getSMList();
		
		for(int i=0;i<SMList.size();i++)
		{
			if(SMList.get(i).getID().equals(temp.getID()))
			{
				SMList.remove(i);
				break;
			}
		}
		new SaveData().saveSMList(SMList);		
	}
}
