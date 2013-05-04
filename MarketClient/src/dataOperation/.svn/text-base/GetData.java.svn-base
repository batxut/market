package dataOperation;

import java.io.FileInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import data.*;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.*;

public class GetData {
	ArrayList<Salesman> salesmans=null;
	ArrayList<Goods> goodsList=null;
	ArrayList<GeneralManager> gmlist=null;
	ArrayList<StoreManager> smlist=null;
	ArrayList<VIPCustomer> VIPList=null;
	ArrayList<Bill> billList=null;
	
	ArrayList<AmountOnSaleStra> AmountOnSalelist=null;
	ArrayList<GoodsOnSaleStra> goodOnSalelist=null;
	ArrayList<GoodsGiftStra> goodsGiftlist=null;
	ArrayList<AmountGiftStra> amountGiftlist=null;
	
	String goodsListFile = "related data/Goods.txt";
	String salesmanListFile="related data/Salesman.txt";
	String GmListFile="related data/GeneralManager.txt";
	String smListFile="related data/storeManager.txt";
	String VIPListFile="related data/VIP.txt";
	String billListFile="related data/bill.txt";
	
	String GoodsOnSaleStraFile="related data/stra/商品特价策略.txt";
	String amountOnSaleStraFile="related data/stra/总额特价策略.txt";
	String GoodsGiftStraFile="related data/stra/商品赠送策略.txt";
	String AmountGiftStraFile="related data/stra/总价赠送策略.txt";
	
	String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	@SuppressWarnings("unchecked")
	public ArrayList<Salesman> getSalesmans() 
	{
		File f=new File(path+"/"+salesmanListFile);
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
			salesmans=new ArrayList<Salesman>();
		return salesmans;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Goods> getGoodsList()
	{
		File f=new File(path+"/"+goodsListFile);
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
		File f=new File(path+"/"+GmListFile);
		if(f.exists())
		{
			try
			{
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(f));
				gmlist=(ArrayList<GeneralManager>) is.readObject();
				is.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			gmlist=new ArrayList<GeneralManager>();
		return gmlist;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StoreManager> getSMList()
	{
		File f=new File(path+"/"+smListFile);
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
		File f=new File(path+"/"+amountOnSaleStraFile);
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
		File f=new File(path+"/"+GoodsOnSaleStraFile);
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
		File f=new File(path+"/"+GoodsGiftStraFile);
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
		File f=new File(path+"/"+AmountGiftStraFile);
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
	@SuppressWarnings("unchecked")
	public ArrayList<VIPCustomer> getVIPList()
	{
		File f=new File(path+"/"+VIPListFile);
		if(f.exists())
		{
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(f));
				VIPList = (ArrayList<VIPCustomer>) in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
			VIPList=new ArrayList<VIPCustomer>();
		return VIPList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bill> getBillList()
	{   
		File f=new File(path+"/"+billListFile);
		if(f.exists()){
		try
		{
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
			billList=(ArrayList<Bill>)in.readObject();
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else{
			billList=new ArrayList<Bill>();
		}
		return billList;
	}

//	public static void main(String[] args)
//	{
//		ArrayList<Salesman> list=new GetClientData().getSalesmans();
//		for(Salesman temp:list)
//		{
//			System.out.println(temp.getName()+"	"+temp.getID()+"	"+temp.getPassword());
//		}
//		
//		ArrayList<Goods> goods=new GetClientData().getGoodsList();
//		System.out.println(goods.get(2).getGoodGiftStra().getgiftGoodNum());
//	}
	
/*	
	public static void main(String[] args)
	{
		ArrayList<Goods> list=new GetClientData().getGoodsList();
		System.out.println(list.get(4).getID());
		System.out.println(list.get(4).getOnsaleStrategy().getBargainPrice());
//		System.out.println(list.get(0).getGoodGiftStra().getgiftgoodID());
	}
*/	
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
					new FileOutputStream(goodsListFile));
			os.writeObject(goodsList);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		goodsList = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(goodsListFile));
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
