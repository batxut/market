package client_interface;

import java.util.ArrayList;

import data.Bill;
import data.Goods;
import data.user.Salesman;
import data.user.VIPCustomer;

public interface SaveInfo {
	public void refreshStroge(ArrayList<Goods> goodList);
	public void saveBillInfo(Bill bill);
	public void refreshVIPInfo(VIPCustomer vip);
//	public void refreshSalesmanInfo(Salesman sal);

}
