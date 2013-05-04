package DataOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.VIPCustomer;

public class SaveData {
	//=========================================================
	String goods_file = "related data/goodsData/Goods.txt";
	String vip_file = "related data/userData/VIPs.txt";
	String salesman_file="related data/userData/salesmans.txt";
	
	String amountGift_file="related data/strategyData/amountGiftStra.txt";
	String amountOnSale_file="related data/strategyData/amountOnSaleStra.txt";
	String goodsGift_file="related data/strategyData/goodsGiftStra.txt";
	String goodsOnSale_file="related data/strategyData/goodsOnSaleStra.txt";
	//=========================================================
	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	public boolean saveGoodsInfo(ArrayList<Goods> goods_list ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+goods_file));
			out.writeObject(goods_list);
			out.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean saveVIPInfo(ArrayList<VIPCustomer> vip_list ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+vip_file));
			out.writeObject(vip_list);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	 
	public boolean saveSalesmanInfo(ArrayList<Salesman>salesman_list){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+salesman_file));
			out.writeObject(salesman_list);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	//====
	public boolean saveAmountGiftStra(ArrayList<AmountGiftStra> amountGiftStra ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+amountGift_file));
			out.writeObject(amountGiftStra);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveAmountOnSaleStra(ArrayList<AmountOnSaleStra> amountOnSaleStra ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+amountOnSale_file));
			out.writeObject(amountOnSaleStra);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveGoodsGiftStra(ArrayList<GoodsGiftStra> goodsGiftStra ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+goodsGift_file));
			out.writeObject(goodsGiftStra);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean saveGoodsOnSaleStra(ArrayList<GoodsOnSaleStra> goodsOnSaleStra ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+goodsOnSale_file));
			out.writeObject(goodsOnSaleStra);
			out.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}

