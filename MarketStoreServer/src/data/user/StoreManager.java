package data.user;

import java.io.Serializable;

public class StoreManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String password;
	String ID;
	int shopNum;
	
	public StoreManager(){
		
	}
	public StoreManager(String name, String password) {
		this.name = name;
		this.password = password;
		shopNum = 1;
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

	public void setPassword(String password) {
		this.password=password;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
	}

	public int getShopNum() {
		return shopNum;
	}

	
	/*
	public boolean importGoods(ArrayList<Goods> goods) {
		Input_GoodsInterface controler2=new Input_GoodsControler();
		boolean add_success=controler2.addGoods(goods);
		return add_success;
	}

	public boolean exportGoods(ArrayList<Goods> goods_to_del) {
		Output_GoodsInterface controler2=new Output_GoodsControler();
		boolean delete_success=controler2.deleteGoods(goods_to_del);
		return delete_success;
	}



	public boolean addNewVIPCustomer(ArrayList<VIPCustomer> vips) {
		DevelopVIPInterface controler2=new DevelopVIPControler();
		boolean add_success=controler2.addVIPs(vips);
		return add_success;
		
	}

	public void deleteOldVIPCustomer() {
		//editVIPCustomer();
	}
	
	public ArrayList<VIPCustomer> searchVIPByID(String ID){
	    CheckVIPInterface controler2=new CheckVIPControler();
	    ArrayList<VIPCustomer> vip_searched=controler2.searchVIPByID(ID);
	    return vip_searched;
	}
	
	public ArrayList<VIPCustomer> searchVIPByName(String name){
		CheckVIPInterface controler2=new CheckVIPControler();
	    ArrayList<VIPCustomer> vip_searched=controler2.searchVIPByName(name);
	    return vip_searched;
	}
	
	public ArrayList<VIPCustomer> searchVIPByLevel(int level){
		CheckVIPInterface controler2=new CheckVIPControler();
	    ArrayList<VIPCustomer> vip_searched=controler2.searchVIPByLevel(level);
	    return vip_searched;
	}
	
	public ArrayList<VIPCustomer> generalSearch(){
		CheckVIPInterface controler2=new CheckVIPControler();
	    ArrayList<VIPCustomer> vip_searched=controler2.generalSearch();
	    return vip_searched;
	}
	
	public ArrayList<VIPCustomer> searchGiftVIP(){
		CheckVIPInterface controler2=new CheckVIPControler();
		ArrayList<VIPCustomer> giftVIPs=controler2.searchGiftVIP();
		return giftVIPs;
	}
	
	public ArrayList<Goods> searchGifts(){
		Output_GoodsInterface controler2=new Output_GoodsControler();
		ArrayList<Goods> gifts=controler2.searchGifts();
		return gifts;
	}
	
	public boolean giveGift(String VIPID, String giftID){
		GiveGiftInterface giveGiftControler2=new GiveGiftControler();
		boolean isGive=giveGiftControler2.giveGift(VIPID, giftID);
		return isGive;
	}
	
	*/
}

