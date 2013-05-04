package data;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import data.user.VIPCustomer;
import logic.*;

public class Bill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ID;
	MyDate date;
	ArrayList<Goods> goodsList, presentList;
	int numShop, totalgrade;
	String salesmanID, VIPID;
	VIPCustomer VIP;

	public VIPCustomer getVIP() {
		return VIP;
	}

	public void setVIP(VIPCustomer vIP) {
		VIP = vIP;
	}

	public MyDate getDate() {
		return date;
	}

	public int getNumShop() {
		return numShop;
	}

	public int getTotalgrade() {
		return totalgrade;
	}

	public String getSalesmanID() {
		return salesmanID;
	}

	public String getVIPID() {
		return VIPID;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public double getPayment() {
		return payment;
	}

	public boolean isPaymentByCredits() {
		return isPaymentByCredits;
	}

	public boolean isBoughtByVIP() {
		return isBoughtByVIP;
	}

	double totalAmount, payment;
	boolean isPaymentByCredits, isBoughtByVIP,isDiscount;

	public boolean isDiscount() {
		return isDiscount;
	}

	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Bill(ArrayList<Goods> goodList, int numShop, String salesmanID,
			boolean isPaymentByCredits, double payment, boolean isBoughtByVIP,
			int totalgrade, String VIPID) {
		this.ID = ID;
		this.goodsList = goodList;
		this.presentList = new ArrayList<Goods>();
		initPresentList();
		this.numShop = numShop;
		this.salesmanID = salesmanID;
		this.isPaymentByCredits = isPaymentByCredits;
		this.isBoughtByVIP = isBoughtByVIP;
		this.totalgrade = totalgrade;
		this.VIPID = VIPID;
		this.payment = payment;
		date = MyDate.getDate();
	}

	private void initPresentList() {
		for (int i = 0; i < goodsList.size(); i++) {
			if (goodsList.get(i).getGoodGiftStra() != null) {
				String ID = goodsList.get(i).getGoodGiftStra().getgiftgoodID();
				Goods good = (new SearchGoodsControll()).searchGood(ID);
				presentList.add(good);
				int number = (goodsList.get(i).getNumBought())
						* (goodsList.get(i).getGoodGiftStra().getgiftGoodNum());
				good.setNumBought(number + good.getNumBought());
			}
		}
	}

	public ArrayList<Goods> getGoods() {
		return goodsList;
	}

	public String toString() {
		String str = "";
		str = date.toString() + "\n" + "卖出店铺号:" + numShop + "\n收银员编号:"
				+ salesmanID + "\n";
		DecimalFormat df = new DecimalFormat("#.00");
		;
		for (int i = 0; i < goodsList.size(); i++) {
			Goods good = goodsList.get(i);
			double unit = 0;
			if (good.getOnsaleStrategy() != null)
				unit = good.getOnsaleStrategy().getBargainPrice();
			else
				unit = good.getOriginalCost();
			double amount = unit * good.getNumBought();
			str = str + good.getID() + "\t" + good.getName() + "\t" + unit
					+ "\t" + good.getNumBought() + "\t" + df.format(amount)
					+ "\n";
			totalAmount += amount;
		}
		totalAmount*=new SalesStra().getAmountDiscount(totalAmount);
		if (!isPaymentByCredits)
			str = str + "应付总额:" + df.format(totalAmount) + "\n实付金额:" + payment
					+ "\n找零:" + df.format(payment - totalAmount) + "\n";
		else{
			str = str + "应付积分:" + totalgrade+ "\nVIP总积分:" + VIP.getleft_point()
				+ "\n剩余积分:" + (VIP.getleft_point() - totalgrade);
			
		}
		return str;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	// public static void main(String[] args)
	// {
	// ArrayList<Goods> goodList=new GetClientData().getGoodsList();
	// ArrayList<Goods> good=new ArrayList<Goods>();
	// Goods g=goodList.get(0);
	// g.setNumBought(2);
	// good.add(g);
	// g=goodList.get(1);
	// g.setNumBought(1);
	// good.add(g);
	// g=goodList.get(2);
	// g.setNumBought(3);
	// good.add(g);
	// Bill bill=new Bill(good,1,"00001",false,100,false,0,"");
	// System.out.println(bill);
	// }
}
