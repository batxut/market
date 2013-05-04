package Interface;

import java.util.ArrayList;

import data.user.VIPCustomer;

public interface CountVIPInterface {
	public ArrayList<VIPCustomer> countByGrade();
	public ArrayList<VIPCustomer> countByPoint();

}
