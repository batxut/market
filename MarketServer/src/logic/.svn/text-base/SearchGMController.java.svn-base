package logic;

import java.util.ArrayList;

import data.user.GeneralManager;
import dataOperation.GetData;
import dataOperation.SaveData;

import server_interface.SearchGM;

public class SearchGMController implements SearchGM
{
	ArrayList<GeneralManager> GMList;

	public SearchGMController(){}

	public GeneralManager searchGM(String ID) 
	{
		GMList=new GetData().getGMList();
		for(int i=0;i<GMList.size();i++)
		{
			GeneralManager temp=GMList.get(i);
			if(temp.getID().equals(ID))
				return temp;
		}
		return null;
	}

/*	public ArrayList<GeneralManager> getGMList()
	{
		return GMList;
	}
*/	
	public void deleteGM(ArrayList<GeneralManager> list)
	{
		GMList=new GetData().getGMList();
		for(int i=0;i<list.size();i++)
		{
			GeneralManager temp=list.get(i);
//			delete(temp);
			for(int j=0;j<GMList.size();j++)
			{
				if(GMList.get(j).getID().equals(temp.getID()))
				{
					GMList.remove(j);
					break;
				}
			}
		}
		new SaveData().saveGMList(GMList);
	}
	
	public void delete(GeneralManager temp)
	{
		GMList=new GetData().getGMList();
		
		for(int i=0;i<GMList.size();i++)
		{
			if(GMList.get(i).getID().equals(temp.getID()))
			{
				GMList.remove(i);
				break;
			}
		}
		new SaveData().saveGMList(GMList);
	}
	
	public void refreshGMInfo(GeneralManager gm)
	{
		GMList=new GetData().getGMList();
		for(int i=0;i<GMList.size();i++)
		{
			if(GMList.get(i).getID().equals(gm.getID()))
				GMList.remove(i);
		}
		GMList.add(gm);
		new SaveData().saveGMList(GMList);
	}
}
