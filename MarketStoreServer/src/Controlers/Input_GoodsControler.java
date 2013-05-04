package Controlers;

import java.util.ArrayList;

import data.Goods;
import DataOperation.GetData;
import DataOperation.SaveData;
import Interface.Input_GoodsInterface;

public class Input_GoodsControler implements Input_GoodsInterface {
	private ArrayList<Goods> goods_stored = new ArrayList<Goods>();// 原来文件中保存的那个数组
    private GetData getData = new GetData();
    private SaveData saveData = new SaveData();

	public boolean addGoods(ArrayList<Goods> goods) {
		goods_stored = getData.getGoods();
		if(goods_stored!=null){
		for(int i=0;i<goods.size();i++){
			goods_stored.add(goods.get(i));
		}
		return saveData.saveGoodsInfo(goods_stored);
		}else{
		return 	saveData.saveGoodsInfo(goods);
		}
	}
	
	public ArrayList<Goods> getStored_goods(){
		GetData geter = new GetData();
		return geter.getGoods();
	}
}
