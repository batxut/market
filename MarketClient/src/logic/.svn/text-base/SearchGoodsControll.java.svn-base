package logic;

import java.util.ArrayList;

import client_interface.SearchGoods;

import data.*;
import dataOperation.*;

public class SearchGoodsControll implements SearchGoods {
	ArrayList<Goods> goodsList;

	public SearchGoodsControll() {
		goodsList = new GetData().getGoodsList();
	}

	public ArrayList<Goods> getGoodsList() {
		return goodsList;
	}

	public Goods searchGood(String GID) {
		for (int i = 0; i < goodsList.size(); i++) {
			Goods temp = goodsList.get(i);
			if (temp.getID().equals(GID))
				return temp;
		}
		return null;
	}

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * Controll2().searchGood("00001").getName()); }
	 */
}
