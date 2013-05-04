package server.connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DataOperation.SaveData;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.StoreManager;

public class ConnectServer {
	Socket socket;
	public static String IP="127.0.0.1";
	SaveData saveData = new SaveData();
	
	public boolean connect() {
		try {
			socket = new Socket(IP, 8000);
			return true;
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "主机位置未知！", "提示", 1);
			return false;
			// e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "网络故障！", "提示", 1);
			return false;
			// e.printStackTrace();
		}
	}

	public void sendRequest(int request) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.write(request);
			oos.flush();
		} catch (IOException e) {
			// System.out.println(e);
		} catch (Exception e) {
//			 e.printStackTrace();
		}
	}

	// receiveData========
	public StoreManager receiveStoreManager() {
		StoreManager storeManager = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			storeManager = (StoreManager) ois.readObject();
		} catch (IOException e) {
			// System.out.println(e);
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return storeManager;
	}

	@SuppressWarnings("unchecked")
	public void receiveGoods() {
		ArrayList<Goods> goods = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			goods = (ArrayList<Goods>) ois.readObject();

			saveData.saveGoodsInfo(goods);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Salesman> receiveSalesman() {
		ArrayList<Salesman> salesman = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			salesman = (ArrayList<Salesman>) ois.readObject();

			saveData.saveSalesmanInfo(salesman);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return salesman;
	}

	// ===
	@SuppressWarnings("unchecked")
	public ArrayList<AmountGiftStra> receiveStrategy() {
		ArrayList<AmountGiftStra> amountGiftStra = null;
		ArrayList<AmountOnSaleStra> amountOnSaleStra = null;
		ArrayList<GoodsGiftStra> goodsGiftStra = null;
		ArrayList<GoodsOnSaleStra> goodsOnSaleStra = null;

		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			amountGiftStra = (ArrayList<AmountGiftStra>) ois.readObject();
			amountOnSaleStra = (ArrayList<AmountOnSaleStra>) ois.readObject();
			goodsGiftStra = (ArrayList<GoodsGiftStra>) ois.readObject();
			goodsOnSaleStra = (ArrayList<GoodsOnSaleStra>) ois.readObject();

			saveData.saveAmountGiftStra(amountGiftStra);
			saveData.saveAmountOnSaleStra(amountOnSaleStra);
			saveData.saveGoodsGiftStra(goodsGiftStra);
			saveData.saveGoodsOnSaleStra(goodsOnSaleStra);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return amountGiftStra;

	}

	// updateData=======
	public void updateStoreManager(StoreManager storeManager) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(storeManager);
			oos.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void uploadSalesman(Salesman salesman) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(salesman);
			oos.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void uploadGoods(ArrayList<Goods> goods) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(goods);
			oos.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void stopConnect() {
		try {
			socket.close();
		} catch (IOException e) {
//			e.printStackTrace();
		} catch(Exception e){
//			e.printStackTrace();
		}
	}
}
