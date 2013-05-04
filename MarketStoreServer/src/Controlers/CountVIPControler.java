package Controlers;

import java.util.ArrayList;


import data.user.VIPCustomer;
import DataOperation.GetData;
import Interface.CountVIPInterface;

public class CountVIPControler implements CountVIPInterface{
	
	GetData getData = new GetData();
	
	public ArrayList<VIPCustomer> countByGrade(){
		return getData.getVIPs();
	}
	
	public ArrayList<VIPCustomer> countByPoint(){
		return getData.getVIPs();
	}

}
