package data.user;

import java.io.Serializable;

public class GeneralManager implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String password;
	private String name;
	
	public GeneralManager(String ID,String password,String name)
	{
		this.ID=ID;
		this.password=password;
		this.name=name;
	}

	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String getPassword()
	{
		return password;
	}
}
