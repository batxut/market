package data.strategy;
import java.io.Serializable;

import data.MyDate;

public class GoodsGiftStra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyDate startDate;
	private MyDate endDate;
	private MyDate currentDate;
	private String bindingGoodsID;
	private String giftgoodID;
	private String giftgoodname;
	private int giftGoodNum;
	
	public static int n;
	private int mark;
	
	public GoodsGiftStra(String giftgoodID,int giftGoodNum,String giftgoodname,
			MyDate startDate,MyDate endDate,String bindingGoodsID)
	{
		this.giftgoodID=giftgoodID;
		this.giftGoodNum=giftGoodNum;
		this.giftgoodname=giftgoodname;
		this.startDate=startDate;
		this.endDate=endDate;
		this.bindingGoodsID=bindingGoodsID;
		
		n++;
		mark=3000+n;
	}
	public int getMark()
	{
		return mark;
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
	
	public MyDate getStartDate() {
		return startDate;
	}

	public MyDate getEndDate() {
		return endDate;
	}

	public String getBindingGoodsID() {
		return bindingGoodsID;
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
}
