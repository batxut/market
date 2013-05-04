package data.user;

import java.io.Serializable;
import java.util.ArrayList;

import data.Goods;
import data.MyDate;

public class VIPCustomer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private int point;
	private int grade;
	private String name;
	private int left_point;
	private MyDate birthday;
	private String telephone;
	private Goods gift;
	
	ArrayList<Goods>myGoods=new ArrayList<Goods>();
	
	public VIPCustomer() {
	}
	
	public VIPCustomer(String ID,String name,int level, int point,int leftpoint,MyDate birthday,String tele){
		this.ID=ID;
		this.name=name;
		this.grade=level;
		this.point=point;
		this.left_point=leftpoint;
		this.birthday=birthday;
		this.telephone=tele;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public int getPoint() {
		return point;
	}
	public int getleft_point(){
		return left_point;
	}

	public void setPoint(int point) {
		this.point=point;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
	}

	public int getGrade() {
		return grade;
	}

	public void setSgrade(int grade) {
		this.grade=grade;
	}
	
	public String getTele(){
		return this.telephone;
	}
	public void setTele(String tele){
		this.telephone=tele;
	}
	
	public MyDate getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday(MyDate birth){
		this.birthday=birth;
	}
	
	public Goods getGift(){
		return gift;
	}
	
	public void setGift(Goods gift){
		this.gift=gift;
	}
}
