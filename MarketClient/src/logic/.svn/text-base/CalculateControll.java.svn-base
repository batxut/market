package logic;

import java.util.ArrayList;

import client_interface.Calculate;
import client_interface.SearchGoods;

import data.Goods;

public class CalculateControll implements Calculate{
	public double calculateDue(ArrayList<Goods>goodsList) {
		double totalPrice = 0;
		for (int i = 0; i < goodsList.size(); i++) {
			double unitPrice;
			if(goodsList.get(i).getOnsaleStrategy()!=null)
				unitPrice = goodsList.get(i).getOnsaleStrategy().getBargainPrice();
			else
				unitPrice = (goodsList.get(i).getOriginalCost());
			int number = goodsList.get(i).getNumBought();
			totalPrice += (number * unitPrice);
		}
		return totalPrice;
	}

	public boolean overflow(int num,ArrayList<Goods> goodsList,Goods good){
		boolean overflow=false;
		for(int i=0;i<goodsList.size();i++){
			if(goodsList.get(i).getID().equals(good.getID())){
				if(goodsList.get(i).getNumBought() + num > goodsList.get(i).getPresentNum())
					overflow=true;
			}
		}
		return overflow;
		
	}
	
	@Override
	public void calculatepresentNum(ArrayList<Goods> goodsList,SearchGoods searchGoods) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<goodsList.size();i++){
			if(goodsList.get(i).getGoodGiftStra()!=null){
				String ID=goodsList.get(i).getGoodGiftStra().getgiftgoodID();
				int number=(goodsList.get(i).getNumBought())*(goodsList.get(i).getGoodGiftStra().getgiftGoodNum());
				Goods good=searchGoods.searchGood(ID);
				good.setNumBought(number+good.getNumBought());
		    }
	    }
		
		for(int i=0;i<goodsList.size();i++){
			String ID=goodsList.get(i).getID();
			Goods good=searchGoods.searchGood(ID);
			good.setNumBought(goodsList.get(i).getNumBought()+good.getNumBought());
		}
	}
}
