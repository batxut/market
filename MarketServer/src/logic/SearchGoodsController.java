package logic;

import java.util.ArrayList;
import server_interface.SearchGoods;
import data.Goods;
import dataOperation.GetData;
import dataOperation.SaveData;

public class SearchGoodsController implements SearchGoods
{
	ArrayList<Goods> goodsList;

	public SearchGoodsController()
	{
		goodsList=new GetData().getGoodsList();
	}
	
	public ArrayList<Goods> getGoodsList()
	{
		return goodsList;
	}
	
	public Goods searchGood(String GID) 
	{
		for(int i=0;i<goodsList.size();i++)
		{
			Goods temp=goodsList.get(i);
			if(temp.getID().equals(GID))
				return temp;
		}
		return null;
	}
	
	public void refreshGoodsInfo(ArrayList<Goods> modgoodlist)
	{
		goodsList=new GetData().getGoodsList();
		for(int j=0;j<modgoodlist.size();j++)
		{
			Goods good=modgoodlist.get(j);
			
			for(int i=0;i<goodsList.size();i++)
			{
				if(goodsList.get(i).getID().equals(good.getID()))
					goodsList.remove(i);
			}
			if(good.getShopNum()==1)
				goodsList.add(0, good);
			else
				goodsList.add(good);
		}
		new SaveData().saveGoodsList(goodsList);
	}
	
/*	public static void main(String[] args)
	{
		System.out.println(new Controll2().searchGood("00001").getName());
	}
*/
}
