package client_interface;

import java.util.ArrayList;

import data.Bill;
import data.Goods;

public interface SearchBill {
	public Bill searchBill(String ID);

	public ArrayList<Bill> getBills();
}
