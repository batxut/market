package data.strategy;

import java.io.Serializable;

import data.MyDate;

public class GoodsOnSaleStra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double bargainPrice;
	private MyDate startDate;
	private MyDate endDate;
	private MyDate currentDate;
	private String bindingGoodsID;
	
	public static int n=0;
	private int mark;
	
	public GoodsOnSaleStra(double bargainPrice,MyDate startDate,
			MyDate endDate,String bindingGoodsID)
	{
		this.bargainPrice=bargainPrice;
		this.startDate=startDate;
		this.endDate=endDate;
		this.bindingGoodsID=bindingGoodsID;
		n++;
		mark=1000+n;
	}
	
	public int getMark()
	{
		return mark;
	}

	public double getBargainPrice() {
		return bargainPrice;
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