package dataOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.LoginPanel;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.GeneralManager;
import data.user.Salesman;
import data.user.StoreManager;

public class SaveData 
{
	String goodsListFile = "related data/Goods.txt";
	String salesmanListFile="related data/Salesman.txt";
	String GmListFile="related data/GeneralManager.txt";
	String smListFile="related data/storeManager.txt";
	
	String amountOnSaleStraFile="related data/stra/总额特价策略.txt";
	String GoodsOnSaleStraFile="related data/stra/商品特价策略.txt";
	String GoodsGiftStraFile="related data/stra/商品赠送策略.txt";
	String AmountGiftStraFile="related data/stra/总价赠送策略.txt";
	
	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	public void saveSalesmansInfo(ArrayList<Salesman> salesmanList ) {
		try {
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream(path+salesmanListFile));

			out.writeObject(salesmanList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void saveGoodsList(ArrayList<Goods> goodsList) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+goodsListFile));
			out.writeObject(goodsList);
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveGMList(ArrayList<GeneralManager> gmList)
	{
		File f=new File(path+GmListFile);
//		JOptionPane.showMessageDialog(null,f.getAbsoluteFile());
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+GmListFile));
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
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+smListFile));
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
		for(int i=0;i<amountOnSalelist.size();i++)
		{
			for(int j=amountOnSalelist.size()-1;j>i;j--)
			{
				if(amountOnSalelist.get(j).compareTo(amountOnSalelist.get(j-1))>0)
				{
					AmountOnSaleStra temp=amountOnSalelist.get(j);
					amountOnSalelist.set(j, amountOnSalelist.get(j-1));
					amountOnSalelist.set(j-1,temp);
				}
			}
		}
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+amountOnSaleStraFile));
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
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+GoodsGiftStraFile));
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
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+GoodsOnSaleStraFile));
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
		for(int i=0;i<amountGiftlist.size();i++)
		{
			for(int j=amountGiftlist.size()-1;j>i;j--)
			{
				if(amountGiftlist.get(j).compareTo(amountGiftlist.get(j-1))>0)
				{
					AmountGiftStra temp=amountGiftlist.get(j);
					amountGiftlist.set(j, amountGiftlist.get(j-1));
					amountGiftlist.set(j-1,temp);
				}
			}
		}
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+AmountGiftStraFile));
			out.writeObject(amountGiftlist);
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
