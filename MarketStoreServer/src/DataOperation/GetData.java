package DataOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.VIPCustomer;

public class GetData {
	private ArrayList<Salesman> salesmansList = null;
	private ArrayList<Goods> goodsList = null;
	private ArrayList<VIPCustomer> vipsList = null;

	private ArrayList<AmountGiftStra> amountGiftList = null;
	private ArrayList<AmountOnSaleStra> amountOnSaleList = null;
	private ArrayList<GoodsGiftStra> goodsGiftList = null;
	private ArrayList<GoodsOnSaleStra> goodsOnSaleList = null;

	String salesmanListFile = "related data/userData/salesmans.txt";
	String goodsListFile = "related data/goodsData/Goods.txt";
	String VIPListfile = "related data/userData/VIPs.txt";

	String amountGiftStraListFile = "related data/strategyData/amountGiftStra.txt";
	String amountOnSaleStraListFile = "related data/strategyData/amountOnSaleStra.txt";
	String goodsGiftStraListFile = "related data/strategyData/goodsGiftStra.txt";
	String goodsOnSaleStraListFile = "related data/strategyData/goodsOnSaleStra.txt";

	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	// ========================================================================
	@SuppressWarnings("unchecked")
	public ArrayList<Salesman> getSalesmans() {
		File f=new File(path+"/"+salesmanListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				salesmansList = (ArrayList<Salesman>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else{
			salesmansList = new ArrayList<Salesman>();
		}
		return salesmansList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Goods> getGoods() {
		File f=new File(path+"/"+goodsListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				goodsList = (ArrayList<Goods>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
			goodsList = new ArrayList<Goods>();
		}
		return goodsList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<VIPCustomer> getVIPs() {
		File f=new File(path+"/"+VIPListfile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				vipsList = (ArrayList<VIPCustomer>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			vipsList = new ArrayList<VIPCustomer>();
		return vipsList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AmountGiftStra> getAmountGiftStralist() {
		File f=new File(path+"/"+amountGiftStraListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				amountGiftList = (ArrayList<AmountGiftStra>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			amountGiftList = new ArrayList<AmountGiftStra>();
		return amountGiftList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AmountOnSaleStra> getAmountOnSaleStraList() {
		File f=new File(path+"/"+amountOnSaleStraListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream
						(new FileInputStream(f));
				amountOnSaleList = (ArrayList<AmountOnSaleStra>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			amountOnSaleList = new ArrayList<AmountOnSaleStra>();
		return amountOnSaleList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<GoodsGiftStra> getGoodsGiftStralist() {
		File f=new File(path+"/"+goodsGiftStraListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				goodsGiftList = (ArrayList<GoodsGiftStra>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			goodsGiftList = new ArrayList<GoodsGiftStra>();
		return goodsGiftList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GoodsOnSaleStra> getGoodsOnSaleStraList() {
		File f=new File(path+"/"+goodsOnSaleStraListFile);
		if (f.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(f));
				goodsOnSaleList = (ArrayList<GoodsOnSaleStra>) is.readObject();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			goodsOnSaleList = new ArrayList<GoodsOnSaleStra>();
		return goodsOnSaleList;
	}

}
