package Interface;

import java.util.ArrayList;

import data.Goods;

public interface Output_GoodsInterface {
	public ArrayList<Goods> searchByType(String Gname);
	public ArrayList<Goods> searchByID(String GID);
	public ArrayList<Goods> searchByPrice(double price);
	public ArrayList<Goods> searchByNumber(int number);
    public boolean deleteGoods(ArrayList<Goods> goods_to_del);

}
