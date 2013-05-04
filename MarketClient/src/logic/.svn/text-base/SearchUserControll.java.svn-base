package logic;

import java.util.ArrayList;

import client_interface.SearchUser;
import data.*;
import data.user.*;
import dataOperation.*;

public class SearchUserControll implements SearchUser {
	ArrayList<Salesman> salesmanList;
	ArrayList<VIPCustomer> VIPList;

	public Salesman searchSalesman(String ID, String password) {
		salesmanList = new GetData().getSalesmans();
		for (int i = 0; i < salesmanList.size(); i++) {
			Salesman temp = salesmanList.get(i);
			if (temp.getID().equals(ID) && temp.getPassword().equals(password))
				return temp;
		}
		return null;
	}

	public VIPCustomer searchVIP(String ID) {
		VIPList = new GetData().getVIPList();
		for (int i = 0; i < VIPList.size(); i++) {
			VIPCustomer temp = VIPList.get(i);
			if (temp.getID().equals(ID))
				return temp;
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * Controll1().searchVIP("111").getID()); }
	 */
}
