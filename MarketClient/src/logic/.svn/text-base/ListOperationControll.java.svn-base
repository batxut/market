package logic;

import java.util.ArrayList;

import client_interface.ListOperation;

import data.Goods;

public class ListOperationControll implements ListOperation{

	@Override
	public ArrayList<Goods> deleteGoods(ArrayList<Goods> goodsList, Goods good) {
		// TODO Auto-generated method stub
		int index = searchInList(goodsList,good);
		if (index == -1) {
		} else {
			goodsList.remove(index);
			good.recoverNumBought();
		}
		return goodsList;
	}

	@Override
	public ArrayList<Goods> addGoods(ArrayList<Goods> goodsList, Goods good,
			int numBought) {
		// TODO Auto-generated method stub
//		int originalNum=good.getNumber();
//		good.setNumber(originalNum-numBought);
		boolean whetherInList=false;
		for(int i=0;i<goodsList.size();i++){
			if(goodsList.get(i).getID().equals(good.getID())){
				goodsList.get(i).setNumBought(numBought+goodsList.get(i).getNumBought());
				whetherInList=true;
			}
		}
		if (!whetherInList) {
			good.setNumBought(numBought);
			goodsList.add(good);
		}
		return goodsList;
	}

	private int searchInList(ArrayList<Goods> goodsList,Goods good) {
		int index = -1;
		for (int i = 0; i < goodsList.size(); i++)
			if (good.getID().equals(goodsList.get(i).getID()))
				index = i;
		return index;
	}
}
