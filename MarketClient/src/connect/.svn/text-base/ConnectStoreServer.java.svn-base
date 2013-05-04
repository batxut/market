package connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Goods;
import data.user.Salesman;
import data.user.VIPCustomer;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import dataOperation.SaveData;

public class ConnectStoreServer {
	Socket socket;
	public static String IP="127.0.0.1";
	SaveData saveData=new SaveData();
	
	public void connect(){
		try {
			socket=new Socket(IP,9000);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "未知主机位置！","提示", 1);
//			System.out.println("Unknown host exception ! ");
//			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "网络故障！","提示", 1);
//			System.out.println("IO exception !");
//			e.printStackTrace();
		}
	}
	
	public void sendRequest(int request){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.write(request);
			oos.flush();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
//receiveData=========
	public Salesman receiveSalesman(){
		Salesman salesman=null;
		try{
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			salesman=(Salesman)ois.readObject();
		}
		catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return salesman;
	}
	
	@SuppressWarnings("unchecked")
	public void receiveGoods(){
		ArrayList<Goods> goods=null;
		try{
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			goods=(ArrayList<Goods>)ois.readObject();
			
			saveData.saveGoodsList(goods);
		}
		catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<VIPCustomer> receiveVIPs(){
		ArrayList<VIPCustomer> VIPs=null;
		try{
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			VIPs=(ArrayList<VIPCustomer>)ois.readObject();
			
			saveData.saveVIPList(VIPs);
		}
		catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return VIPs;
	}
	
	//===
	@SuppressWarnings("unchecked")
	public ArrayList<AmountGiftStra> receiveStrategy() {
		ArrayList<AmountGiftStra> amountGiftStra=null;
		ArrayList<AmountOnSaleStra> amountOnSaleStra=null;
		ArrayList<GoodsGiftStra> goodsGiftStra=null;
		ArrayList<GoodsOnSaleStra> goodsOnSaleStra=null;
		
		try {
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			amountGiftStra=(ArrayList<AmountGiftStra>)ois.readObject();
			amountOnSaleStra=(ArrayList<AmountOnSaleStra>)ois.readObject();
			goodsGiftStra=(ArrayList<GoodsGiftStra>)ois.readObject();
			goodsOnSaleStra=(ArrayList<GoodsOnSaleStra>)ois.readObject();
			
			saveData.saveAmountGiftStra(amountGiftStra);
			saveData.saveAmountOnSaleStra(amountOnSaleStra);
			saveData.saveGoodsGiftStra(goodsGiftStra);
			saveData.saveGoodsOnSaleStra(goodsOnSaleStra);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return amountGiftStra;
		
	}

//updateData=======
	public void uploadSalesman(Salesman salesman){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(salesman);
			oos.flush();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void uploadGoods(ArrayList<Goods> goods){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(goods);
			oos.flush();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	//断开连接
	public void stopConnect(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
