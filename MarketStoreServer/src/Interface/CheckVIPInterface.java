package Interface;

import java.util.ArrayList;

import data.user.VIPCustomer;


public interface CheckVIPInterface {
	public ArrayList<VIPCustomer> searchVIPByID(String ID);
	public ArrayList<VIPCustomer> searchVIPByLevel(int level);
	public ArrayList<VIPCustomer> searchVIPByName(String name);
	public ArrayList<VIPCustomer> generalSearch();
}

