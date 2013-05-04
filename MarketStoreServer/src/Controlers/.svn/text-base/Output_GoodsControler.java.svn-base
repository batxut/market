package Controlers;

import java.util.ArrayList;

import data.Goods;
import DataOperation.GetData;
import DataOperation.SaveData;
import Interface.Output_GoodsInterface;

public class Output_GoodsControler implements Output_GoodsInterface {
	private ArrayList<Goods> goods_searched = new ArrayList<Goods>();
	ArrayList<Goods> goods_read = new ArrayList<Goods>();

	public ArrayList<Goods> searchByType(String Gname) {
		this.readGoods();
		if (goods_read!=null) {
			for (int i = 0; i < goods_read.size(); i++) {
				if (goods_read.get(i).getName().equals(Gname)) {
					goods_searched.add(goods_read.get(i));
				}
			}
		}
		return goods_searched;
	}

	public ArrayList<Goods> searchByID(String GID) {
		this.readGoods();
		if (goods_read!=null) {
			for (int i = 0; i < goods_read.size(); i++) {
				if (goods_read.get(i).getID().equals(GID)) {
					goods_searched.add(goods_read.get(i));
				}
			}
		}
		return goods_searched;
	}

	public ArrayList<Goods> searchByPrice(double price) {
		this.readGoods();
		if (goods_read!=null) {
			for (int i = 0; i < goods_read.size(); i++) {
				if (goods_read.get(i).getOriginalCost() == price) {
					goods_searched.add(goods_read.get(i));
				}
			}
		}
		return goods_searched;
	}

	public ArrayList<Goods> searchByNumber(int number) {
		this.readGoods();
		if (goods_read!=null) {
			for (int i = 0; i < goods_read.size(); i++) {
				if (goods_read.get(i).getPresentNum() == number) {
					goods_searched.add(goods_read.get(i));
				}
			}
		}
		return goods_searched;
	}

	public boolean deleteGoods(ArrayList<Goods> goods_to_del) {
		this.readGoods();
		if (goods_to_del!=null) {
			for (int i = 0; i < goods_to_del.size(); i++) {
				for (int j = 0; j < goods_read.size(); j++) {
					if (goods_read.get(j).getID().equals(goods_to_del.get(i).getID())) {
						if(goods_to_del.get(i).getPresentNum()==0){
						goods_read.remove(goods_read.get(j));
						}else{
							goods_read.remove(goods_read.get(j));
							goods_read.add(goods_to_del.get(i));
						}
					}
				}
			}
			return writeGoods();
		} else
			return false;
	}
	public ArrayList<Goods> searchGifts() {
		this.readGoods();
		if (goods_read!=null) {
			for (int i = 0; i < goods_read.size(); i++) {
//				if (goods_read.get(i).getPrice()>20) {
					goods_searched.add(goods_read.get(i));
//				}
			}
		}
		return goods_searched;
	}
	
	private void readGoods(){
		GetData getData = new GetData();
		goods_read = getData.getGoods();
	}

	private boolean writeGoods() {
		SaveData saveData = new SaveData();
		return saveData.saveGoodsInfo(goods_read);
	}
		
}

