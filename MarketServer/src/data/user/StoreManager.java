package data.user;

import java.io.Serializable;

public class StoreManager implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String ID;
	private int shopNum;

	public StoreManager(String name, String ID,String password,int shopNum) {
		this.name = name;
		this.password = password;
		this.shopNum = shopNum;
		this.ID=ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) 
	{
		this.password=password;
	}

	public String getID() {
		return ID;
	}

	public int getShopNum() {
		return shopNum;
	}
}

