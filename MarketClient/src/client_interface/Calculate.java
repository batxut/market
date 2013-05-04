package client_interface;

import java.util.ArrayList;

import data.Goods;

public interface Calculate {
	public double calculateDue(ArrayList<Goods> goodsList);

	public void calculatepresentNum(ArrayList<Goods> goodsList,
			SearchGoods searchGoods);
}
