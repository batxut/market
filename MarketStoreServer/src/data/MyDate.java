package data;

import java.io.Serializable;
import java.util.Calendar;

public class MyDate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int year, month, day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	

	public MyDate() {
		this(0, 0, 0);
	}
	
	public static MyDate getDate()
	{
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		return new MyDate(year,month,day);
	}
	
	public static boolean isLeapYear(int year)
	{
		return (year%400==0||(year%100!=0&&year%4==0))?true:false;
	}
	
	public static int monthDays(int year,int month)
	{
		if(month==1||month==3||month==5||month==7||month==8||month==10|month==12)
			return 31;
		if(month==4||month==6||month==9||month==11)
			return 30;
		else
		{
			if(isLeapYear(year))
				return 29;
			else return 28;
		}
	}

	/**
	 * Returns if this year is a leap one.
	 * 
	 * @return whether this year is a leap one
	 */
	public boolean isLeapYear() {
		// YOU FILL THIS IN
		return (year%400==0||(year%100!=0&&year%4==0))?true:false;
	}

	/**
	 * Returns the number of days between this object and another MyDate object.
	 * If this date is the same as <code>another</code>, 0 is returned. If it is
	 * after <code>another</code>, then the returned value should be a positive
	 * number. Otherwise, this method returns a negative number.
	 * 
	 * @param another
	 *            a <code>MyDate</code> object
	 * @return the gap between two MyDate objects
	 */
	public int getDaysBetween(MyDate another) {
		// YOU FILL THIS IN
		int totalDays1=0,totalDays2=0;
		if(year==another.year&&month==another.month&&day==another.day)
			return 0;
		else if(year<another.year||(year==another.year&&month<another.month)||(year==another.year&&month==another.month&&day<another.day))
		{
			for(int i=year;i<another.year;i++)
			{
				if(isLeapYear(i))
					totalDays2+=366;
				else totalDays2+=365;
			}
			for(int i=1;i<another.month;i++)
				totalDays2+=monthDays(another.year,i);
			for(int i=1;i<month;i++)
				totalDays1+=monthDays(year,i);
			totalDays2+=(another.day-1);
			totalDays1+=(day-1);
			return totalDays1-totalDays2;
		}
		else 
		{
			for(int i=another.year;i<year;i++)
			{
				if(isLeapYear(i))
					totalDays2+=366;
				else totalDays2+=365;
			}
			for(int i=1;i<month;i++)
				totalDays2+=monthDays(year,i);
			for(int i=1;i<another.month;i++)
				totalDays1+=monthDays(another.year,i);
			totalDays2+=(day-1);
			totalDays1+=(another.day-1);
			return totalDays2-totalDays1;
		}
	}

	/**
	 * Calcuates the date that are <code>d</code> days after this date.
	 * 
	 * @param days
	 *            the number of days
	 * @return a new <code>MyDate</code> object
	 */
	public MyDate getDateAfter(int d) {
		// YOU FILL THIS IN
		MyDate myDate=new MyDate();
		int year1=year,month1=month,day1=day;
		for(int i=1;i<month;i++)
			d+=monthDays(year,i);
		d+=(day-1);
		while(d>=365)
		{
			if(isLeapYear(year1))
				d-=366;
			else d-=365;
			year1++;
		}
		if(d==-1)
		{
			year1--;
			month1=12;
			day1=31;
		}
		else
		{
			month1=1;
			for(int i=1;d-monthDays(year,i)>=0;i++,month1++)
			{
				d=d-monthDays(year,i);
			}
			day1=d+1;
		}
		myDate.year=year1;
		myDate.month=month1;
		myDate.day=day1;
		return myDate;
	}

	/**
	 * Tells which day of the week this date is. If it is Monday, 0 is returned.
	 * Tuesday gives a result of 1, and so forth.
	 * 
	 * @return the day of the week
	 */
	public int getDayOfWeek() {
		// YOU FILL THIS IN
		MyDate date=new MyDate(1970,1,1);
		int d=getDaysBetween(date);
		return (d+3)%7;
	}

	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	public int compare(MyDate another)
	{
		if(year<another.year||(year==another.year&&month<another.month)||
				(year==another.year&&month==another.month&&day<another.day))
			return -1;
		else if(year>another.year||(year==another.year&&month>another.month)||
				(year==another.year&&month==another.month&&day>another.day))
			return 1;
		else
			return 0;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	
	}
	
	public int getYear(){  //ÐÂ¼ÓµÄ£¡£¡
		return year;
	}
	
}