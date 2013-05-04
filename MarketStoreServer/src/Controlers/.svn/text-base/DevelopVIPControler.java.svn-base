package Controlers;

import java.util.ArrayList;

import data.user.VIPCustomer;
import DataOperation.GetData;
import DataOperation.SaveData;
import Interface.DevelopVIPInterface;

public class DevelopVIPControler implements DevelopVIPInterface {
	private ArrayList<VIPCustomer> VIP_stored = new ArrayList<VIPCustomer>();// 原来文件中保存的那个数组
    private GetData getData = new GetData(); 
    private SaveData saveData = new SaveData();
    
	public boolean addVIPs(ArrayList<VIPCustomer> vips) {
		VIP_stored = getData.getVIPs();
		if(VIP_stored!=null){
		for(int i = 0; i < vips.size() ; i++)
			VIP_stored.add(vips.get(i));
		SaveData saver = new SaveData();
		return saver.saveVIPInfo(VIP_stored);
		}
		else{
			return saveData.saveVIPInfo(vips);
		}
	}
	
	public int getPresentNum(){
		VIP_stored = getData.getVIPs();
		if(VIP_stored!=null){
			return VIP_stored.size();
		}else{
			return 0;
		}
	}

}
