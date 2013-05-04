package server_interface;

import java.util.ArrayList;

import data.user.GeneralManager;

public interface SearchGM 
{
	public GeneralManager searchGM(String ID);
	
//	public ArrayList<GeneralManager> getGMList();

	public void deleteGM(ArrayList<GeneralManager> list);
	
	public void delete(GeneralManager temp);
}
