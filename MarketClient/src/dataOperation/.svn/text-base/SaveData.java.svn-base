package dataOperation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.*;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.*;


public class SaveData 
{
	String goodsListFile = "related data/Goods.txt";
	String salesmanListFile="related data/Salesman.txt";
	String GmListFile="related data/GeneralManager.txt";
	String smListFile="related data/storeManager.txt";
	String VIPListFile="related data/VIP.txt";
	String billListFile="related data/bill.txt";
	
	String amountOnSaleStraFile="related data/stra/总额特价策略.txt";
	String GoodsOnSaleStraFile="related data/stra/商品特价策略.txt";
	String GoodsGiftStraFile="related data/stra/商品赠送策略.txt";
	String AmountGiftStraFile="related data/stra/总价赠送策略.txt";
	
	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	public void saveSalesmansInfo(ArrayList<Salesman> salesmanList ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+salesmanListFile));
			out.writeObject(salesmanList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveGoodsList(ArrayList<Goods> gooodsList) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+goodsListFile));
			out.writeObject(gooodsList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveGMList(ArrayList<GeneralManager> gmList)
	{
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+GmListFile));
			out.writeObject(gmList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveSMList(ArrayList<StoreManager> smlist)
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+smListFile));
			out.writeObject(smlist);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveAmountOnSaleStra(ArrayList<AmountOnSaleStra> amountOnSalelist)
	{

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+amountOnSaleStraFile));
			out.writeObject(amountOnSalelist);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveGoodsGiftStra(ArrayList<GoodsGiftStra> goodsGiftlist)
	{

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+GoodsGiftStraFile));
			out.writeObject(goodsGiftlist);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveGoodsOnSaleStra(ArrayList<GoodsOnSaleStra> goodsOnSalelist)
	{

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+GoodsOnSaleStraFile));
			out.writeObject(goodsOnSalelist);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveAmountGiftStra(ArrayList<AmountGiftStra> amountGiftlist)
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+AmountGiftStraFile));
			out.writeObject(amountGiftlist);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveVIPList(ArrayList<VIPCustomer> VIPList)
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+VIPListFile));
			out.writeObject(VIPList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveBillList(ArrayList<Bill> billList)
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path+"/"+billListFile));
			out.writeObject(billList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

/*	
	public void createGMFile()
	{
		ArrayList<GeneralManager> al=new ArrayList<GeneralManager>();
		GeneralManager gm1=new GeneralManager("g","g","manager");
		GeneralManager gm2=new GeneralManager("gm","gm","manager");
		al.add(gm1);
		al.add(gm2);
		try
		{
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(GmListFile));
			os.writeObject(al);
			os.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new SaveClientData().createGMFile();
	}
*/
}
