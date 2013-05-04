package data.user;

import java.io.Serializable;

public class Salesman implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ID;
	private int store;
	private String password="1";
	public Salesman(String name,String ID,int store){
		this.name=name;
		this.ID=ID;
		this.store=store;
	};
	public int getStore(){
		return store;
	}
	public String getName(){
		return name;
	}
	public String getID(){
		return ID;
	}
    public void setStore(int store){
    	this.store=store;
    }
    public void setPassword(String password){
    	this.password=password;
    }
    public String getPassword(){
    	return password;
    }

}

