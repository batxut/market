package Controlers;

import java.util.ArrayList;

import data.user.VIPCustomer;
import DataOperation.GetData;
import Interface.CheckVIPInterface;

public class CheckVIPControler implements CheckVIPInterface {
	private ArrayList<VIPCustomer> vips_searched = new ArrayList<VIPCustomer>();
	private ArrayList<VIPCustomer> vip_read = new ArrayList<VIPCustomer>();
	
	public ArrayList<VIPCustomer> searchVIPByID(String ID){
		this.readVIPs();
		if (vip_read!=null) {
			for (int i = 0; i < vip_read.size(); i++) {
				if (vip_read.get(i).getID().equals(ID)) {
					vips_searched.add(vip_read.get(i));
				}
			}
				
		}
		return vips_searched;
	}
	
	
	public ArrayList<VIPCustomer> searchVIPByLevel(int level){
		this.readVIPs();
		if (vip_read!=null) {
			for (int i = 0; i < vip_read.size(); i++) {
				if (vip_read.get(i).getGrade()==level) {
					vips_searched.add(vip_read.get(i));
				}
			}
		}
		return vips_searched;
	}
	
	
	public ArrayList<VIPCustomer> searchVIPByName(String name){
		this.readVIPs();
		if (vip_read!=null) {
			for (int i = 0; i < vip_read.size(); i++) {
				if (vip_read.get(i).getName().equals(name)) {
					vips_searched.add(vip_read.get(i));
				}
			}
		}
		return vips_searched;
	}
	
	
	public ArrayList<VIPCustomer> generalSearch(){
		this.readVIPs();
		if (vip_read!=null) {
			for (int i = 0; i < vip_read.size(); i++) {
					vips_searched.add(vip_read.get(i));
			}
		}
		return vips_searched;
	}
	
	private void readVIPs() {
		GetData geter = new GetData();
		vip_read = geter.getVIPs();
	}

}

