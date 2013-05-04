package server_interface;

import java.util.ArrayList;

import data.user.StoreManager;

public interface SearchSM 
{
	public StoreManager searchSM(String ID);
	
//	public ArrayList<GeneralManager> getGMList();

	public void deleteSM(ArrayList<StoreManager> list);
	
	public void delete(StoreManager temp);
}
