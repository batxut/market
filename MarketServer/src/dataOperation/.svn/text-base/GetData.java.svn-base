package dataOperation;

import java.io.FileInputStream;
import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import data.MyDate;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Goods;

import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.GeneralManager;
import data.user.Salesman;
import data.user.StoreManager;

public class GetData {
	ArrayList<Salesman> salesmans=null;
	ArrayList<Goods> goodsList=null;
	ArrayList<GeneralManager> gmlist=null;
	ArrayList<StoreManager> smlist=null;
	
	ArrayList<AmountOnSaleStra> AmountOnSalelist=null;
	ArrayList<GoodsOnSaleStra> goodOnSalelist=null;
	ArrayList<GoodsGiftStra> goodsGiftlist=null;
	ArrayList<AmountGiftStra> amountGiftlist=null;
	
//	String path = System.getProperty("user.dir");
	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

	//static 
	String goodsListFile = "MarketServerData/Goods.txt";
	String salesmanListFile="MarketServerData/Salesman.txt";
	String GMListFile="MarketServerData/GeneralManager.txt";
	String smListFile="MarketServerData/storeManager.txt";
	
	String GoodsOnSaleStraFile="MarketServerData/stra/商品特价策略.txt";
	String amountOnSaleStraFile="MarketServerData/stra/总额特价策略.txt";
	String GoodsGiftStraFile="MarketServerData/stra/商品赠送策略.txt";
	String AmountGiftStraFile="MarketServerData/stra/总价赠送策略.txt";
	
//	path+;
	@SuppressWarnings("unchecked")
	public ArrayList<Salesman> getSalesmans() 
	{
		File f=new File(path+salesmanListFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				salesmans = (ArrayList<Salesman>) is.readObject();
				is.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			salesmans=new ArrayList<Salesman>();
		}
		return salesmans;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Goods> getGoodsList()
	{
		File f=new File(path+goodsListFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				goodsList = (ArrayList<Goods>) is.readObject();
				is.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			goodsList=new ArrayList<Goods>();
		return goodsList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GeneralManager> getGMList()
	{
		File f=new File(path+GMListFile);
//		File f=new File("src/MarketServerData/GeneralManager.txt");
		if(f.exists())
		{
//			JOptionPane.showMessageDialog(null, f.getAbsolutePath());
			try
			{
//				ClassLoader.getSystemClassLoader().getResourceAsStream();
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
//				ObjectInputStream is=new ObjectInputStream
//						(ClassLoader.getSystemClassLoader().getResourceAsStream(GMListFile));
				gmlist=(ArrayList<GeneralManager>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
//			System.out.println(path);
//			JOptionPane.showMessageDialog(null, "File not found\n"+f.getAbsolutePath());
			gmlist=new ArrayList<GeneralManager>();
		}
		return gmlist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StoreManager> getSMList()
	{
		File f=new File(path+smListFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				smlist=(ArrayList<StoreManager>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			smlist=new ArrayList<StoreManager>();
		return smlist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AmountOnSaleStra> getAmountOnSaleStraList()
	{
	//	path+;
		File f=new File(path+amountOnSaleStraFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				AmountOnSalelist=(ArrayList<AmountOnSaleStra>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			AmountOnSalelist=new ArrayList<AmountOnSaleStra>();
		return AmountOnSalelist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GoodsOnSaleStra> getGoodsOnSaleStraList()
	{
		File f=new File(path+GoodsOnSaleStraFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				goodOnSalelist=(ArrayList<GoodsOnSaleStra>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			goodOnSalelist=new ArrayList<GoodsOnSaleStra>();
		return goodOnSalelist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GoodsGiftStra> getGoodsGiftStralist()
	{
		File f=new File(path+GoodsGiftStraFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				goodsGiftlist=(ArrayList<GoodsGiftStra>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			goodsGiftlist=new ArrayList<GoodsGiftStra>();
		return goodsGiftlist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<AmountGiftStra> getAmountGiftStralist()
	{
		File f=new File(path+AmountGiftStraFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				amountGiftlist=(ArrayList<AmountGiftStra>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			amountGiftlist=new ArrayList<AmountGiftStra>();
		return amountGiftlist;
	}
/*
	public static void main(String[] args)
	{
//		ArrayList<Salesman> list=new GetClientData().getSalesmans();
//		for(Salesman temp:list)
//		{
//			System.out.println(temp.getName()+"	"+temp.getID()+"	"+temp.getPassword());
//		}
		
//		GetClientData getdata=new GetClientData();
//		ArrayList<Goods> goodslist=getdata.getGoodsList();
//		System.out.println(goodslist.get(2).getGoodGiftStra());
//		System.out.println(goodslist.get(2).getGoodGiftStra().getgiftgoodID());
//		System.out.println(goodslist.get(2).getGoodGiftStra().getBindingGoodsID());
//		System.out.println(goodslist.get(0).getOnsaleStrategy());
//		System.out.println(goodslist.get(0).getOnsaleStrategy().getBargainPrice());
//		ArrayList<GoodsOnSaleStra> stralist=getdata.getGoodsOnSaleStraList();
//		System.out.println(stralist.size());
//		for(GoodsOnSaleStra stra:stralist)
//		{
//			System.out.println(stra);
//			System.out.println(stra.getBargainPrice());
//			System.out.println(stra.getBindingGoodsID());
//		}
		GetData getdata=new GetData();
		ArrayList<GoodsGiftStra> strali=getdata.getGoodsGiftStralist();
		System.out.println(strali.get(0).getBindingGoodsID());
		strali.remove(0);
		new SaveData().saveGoodsGiftStra(strali);
//		for(GoodsGiftStra stra:strali)
//		{
//			System.out.println(stra);
//			System.out.println(stra.getBindingGoodsID());
//			System.out.println(stra.getgiftgoodID());
//		}
	}
*/
	
//	public static void main(String[] args)
//	{
//		ArrayList<Goods> list=new GetClientData().getGoodsList();
//		System.out.println(list.get(0).getID());
//		System.out.println(list.get(0).getOnsaleStrategy().getBargainPrice());
////		System.out.println(list.get(0).getGoodGiftStra().getgiftgoodID());
//	}
	
	/*public void creatFile(){
		ArrayList<VIP> vip=new ArrayList<VIP>();
		VIP a = new VIP("000");
		VIP b = new VIP("111");
		vip.add(a);
		vip.add(b);
        try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(VIPListFile));
			os.writeObject(vip);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
*/
/*
	public void creatFile(){
		ArrayList<Salesman> salesmans=new ArrayList<Salesman>();
		Salesman a = new Salesman("安波", "00001", 1);
		Salesman b = new Salesman("安江", "00002", 1);
		salesmans.add(a);
		salesmans.add(b);
        try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(salesmanListFile));
			os.writeObject(salesmans);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
	//	System.out.println(new SalesmanClientData().getVIPList().get(0).getID());
		new GetClientData().creatFile();
	}
	
*/
	/*
	public static void main(String[] args) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		MyDate currentDate=MyDate.getDate();
		MyDate producedDate=new MyDate(2011,11,11);
		MyDate scrapDate=new MyDate(2011,12,30);
		goodsList.add(new Goods("聚利蛋糕","00001",4.00,10,producedDate,scrapDate,currentDate,1));
		goodsList.add( new Goods( "娃哈哈营养快线","00002", 3.90,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("蒙牛冠益乳", "00003", 5.90,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("聚利现烤面包","00004",  2.80, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods( "统一汤达人碗面","00005", 7.80, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("可口可乐","00007",  3.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("益达口香糖","00008",  3.60, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("好丽友蛋黄派","00009", 3.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("伊利金典牛奶","00010",  55.60, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("黑人牙膏","00011",  7.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("高露洁牙刷","00012",  3.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("海飞丝去屑洗发露","00013",  18.60,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("乐亿多水杯","00014",  13.50,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("潘婷护发素","00015",  23.50,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("舒洁沐浴露","00016",  13.60, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("一家人抱枕","00017",  34.20,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("七彩虹拖把","00018",  20.40, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("台灯","00019",  43.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("保鲜膜","00020",  3.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("罗技鼠标", "00021", 63.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("微软键盘", "00022", 67.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods( "金士顿U盘","00023",83.50,10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("sony耳机","00024",  23.60, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods( "键盘膜","00025", 23.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("鼠标垫","00026",  13.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("读卡器","00027", 13.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("电池","00028",  5.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("手表","00029",  23.50, 10,producedDate,scrapDate,currentDate,1));
		goodsList.add(new Goods("清洁套装","00030",  43.50, 10,producedDate,scrapDate,currentDate,1));

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("src/"+goodsListFile));
			os.writeObject(goodsList);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		goodsList = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/"+goodsListFile));
			goodsList = (ArrayList<Goods>) is.readObject();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		Goods good=goodsList.get(0);
		System.out.print(good.getName()+good.getNumBought());
	}
	*/
}
