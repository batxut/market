package logic;

import java.util.ArrayList;

import server_interface.SearchUser;
import data.user.*;
import dataOperation.*;


public class SearchUserController implements SearchUser
{
	ArrayList<Salesman> salesmanList;
	ArrayList<GeneralManager> gmlist;
	
	public Salesman searchSalesman(String ID, String password) 
	{
		salesmanList=new GetData().getSalesmans();
		for(int i=0;i<salesmanList.size();i++)
		{
			Salesman temp=salesmanList.get(i);
			if(temp.getID().equals(ID)&&temp.getPassword().equals(password))
				return temp;
		}
		return null;
	}

	public GeneralManager searchGM(String ID, String password)
	{
		gmlist=new GetData().getGMList();
		for(int i=0;i<gmlist.size();i++)
		{
			GeneralManager temp=gmlist.get(i);
			if(temp.getID().equals(ID)&&temp.getPassword().equals(password))
				return temp;
		}
		return null;
	}
	
/*	public static void main(String[] args)
	{
		System.out.println(new Controll1().searchVIP("111").getID());
	}
*/
}
