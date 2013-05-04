package data.strategy;

import java.io.Serializable;

import data.MyDate;

public class AmountGiftStra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyDate startDate;
	private MyDate endDate;
	private MyDate currentDate;
	private double amount;
	
	private String giftgoodID;
	private String giftgoodname;
	private int giftGoodNum;
	
	public static int n;
	private int mark;
	
	public AmountGiftStra(double amount,String giftgoodID,String giftgoodname,int giftGoodNum,MyDate startDate,MyDate endDate)
	{
		this.amount=amount;
		this.giftgoodID=giftgoodID;
		this.giftgoodname=giftgoodname;
		this.giftGoodNum=giftGoodNum;
		this.startDate=startDate;
		this.endDate=endDate;
		n++;
		mark=4000+n;
	}
	public int getMark()
	{
		return mark;
	}
	
	public MyDate getStartDate() {
		return startDate;
	}

	public MyDate getEndDate() {
		return endDate;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public boolean IsStraEffective()
	{
		currentDate=MyDate.getDate();
		if(currentDate.compare(startDate)>=0&&currentDate.compare(endDate)<=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getgiftGoodNum()
	{
		return giftGoodNum;
	}
	
	public String getgiftgoodID()
	{
		return giftgoodID;
	}
	
	public String getgiftgoodname()
	{
		return giftgoodname;
	}
	
	public int compareTo(AmountGiftStra stra)
	{
		if(amount<stra.amount)
			return -1;
		else if(amount>stra.amount)
			return 1;
		else
			return 0;
	}
}
