package logic;

import java.util.ArrayList;

import server_interface.SearchSalesman;

import data.user.*;
import dataOperation.*;

public class SearchSalesmanController implements SearchSalesman
{

	ArrayList<Salesman> SalesmanList;

	public SearchSalesmanController(){}
	
	public Salesman searchSalesman(String ID)
	{
		SalesmanList=new GetData().getSalesmans();
		for(int i=0;i<SalesmanList.size();i++)
		{
			Salesman temp=SalesmanList.get(i);
			if(temp.getID().equals(ID))
				return temp;
		}
		return null;
	}

/*	public ArrayList<Salesman> getsalesmanList()
	{	
		return SalesmanList;
	}
*/
	@Override
	public void delete(Salesman temp)
	{
		SalesmanList=new GetData().getSalesmans();
		for(int i=0;i<SalesmanList.size();i++)
		{
			if(SalesmanList.get(i).getID().equals(temp.getID()))
			{
				SalesmanList.remove(i);
				break;
			}
		}
		new SaveData().saveSalesmansInfo(SalesmanList);
	}

	@Override
	public void deleteSalesmanList(ArrayList<Salesman> list)
	{
		SalesmanList=new GetData().getSalesmans();
		for(int i=0;i<list.size();i++)
		{
			Salesman temp=list.get(i);
	//		delete(temp);
			for(int j=0;j<SalesmanList.size();j++)
			{
				if(SalesmanList.get(j).getID().equals(temp.getID()))
				{
					SalesmanList.remove(j);
					break;
				}
			}
		}
		new SaveData().saveSalesmansInfo(SalesmanList);
	}
}
