package data.strategy;

import java.io.Serializable;
import data.MyDate;

public class AmountOnSaleStra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyDate startDate;
	private MyDate endDate;
	private MyDate currentDate;
	private double amount;
	private double discount;
	
	public static int n;
	private int mark;
	
	public AmountOnSaleStra(MyDate startDate,MyDate endDate,double amount,double discount)
	{
		this.startDate=startDate;
		this.endDate=endDate;
		this.amount=amount;
		this.discount=discount;
		n++;
		mark=2000+n;
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
	
	public double getDiscount()
	{
		return discount;
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

	public int compareTo(AmountOnSaleStra stra)
	{
		if(amount<stra.amount)
			return -1;
		else if(amount>stra.amount)
			return 1;
		else
			return 0;
	}
}
