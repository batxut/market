package Controlers;

import java.util.ArrayList;

import data.Goods;
import data.user.VIPCustomer;
import DataOperation.GetData;
import DataOperation.SaveData;
import Interface.GiveGiftInterface;

public class GiveGiftControler implements GiveGiftInterface{
	private ArrayList<VIPCustomer> VIPs;
	private ArrayList<Goods> goods;
	private ArrayList<Goods> gifts=new ArrayList<Goods>();
    private GetData getData = new GetData();
    private SaveData saveData = new SaveData();
    
    public ArrayList<VIPCustomer> searchGiftVIP() {
		VIPs=getData.getVIPs();
		return VIPs;
	}
    
    public boolean checkVIPID(String VIPID){
    	boolean isCheck=false;
    	if(VIPs!=null){
	    	for(int i=0;i<VIPs.size();i++){
	    		if(VIPs.get(i).getID().equals(VIPID)){
	    			isCheck=true;
	    			break;
	    		}
	    	}
    	}
    	return isCheck;
    }
    public ArrayList<Goods> searchGifts() {
    	goods=getData.getGoods();
		if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				if(goods.get(i).getOriginalCost()<10){
					gifts.add(goods.get(i));
				}
			}
		}
		return gifts;
	}
    
	public boolean giveGift(String VIPID, String giftID) {
		boolean isGiveSuccessful=false;
			for (int i = 0; i < VIPs.size(); i++) {
				if (VIPs.get(i).getID().equals(VIPID)||VIPs.get(i).getGift()==null) {
					for(int j=0;j<gifts.size();j++){
						if(gifts.get(j).equals(giftID)){
							isGiveSuccessful=true;
							VIPs.get(i).setGift(gifts.get(j));
							updateGoods(gifts.get(j));
							break;
						}
					}
					break;
				}
			}
		return isGiveSuccessful;
	}
	
	private void updateGoods(Goods gift){
		for(int i=0;i<goods.size();i++){
			if(goods.get(i).getID().equals(gift.getID())){
				goods.get(i).setPresentNum(goods.get(i).getPresentNum()-1);
			}
		}
		saveData.saveVIPInfo(VIPs);
		saveData.saveGoodsInfo(goods);
	}
}

