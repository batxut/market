package connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.StoreManager;
import dataOperation.GetData;
import dataOperation.SaveData;

public class ConnectStoreServer implements Runnable {
	private boolean isConnect = true;
	ServerSocket serverSocket;
	Socket socket;
	GetData getData = new GetData();
	SaveData saveData =new SaveData();
	public ConnectStoreServer() {
		try {
			serverSocket = new ServerSocket(8000);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public void setIsConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}

	public boolean getIsConnect() {
		return isConnect;
	}

	public void beginConnect() {
		try {
			socket = serverSocket.accept();
		} catch (IOException e1) {
			// e1.printStackTrace();
		}
	}

	public int receiveRequest() {
		int request = 0;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			request = ois.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return request;
	}

	public void transferStoreManager() {
		ArrayList<StoreManager> storeManagers = null;
		try {
			storeManagers = getData.getSMList();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(storeManagers.get(0));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transferGoods() {
		ArrayList<Goods> goods = null;
		try {
			goods = getData.getGoodsList();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(goods);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transferSalesman() {
		ArrayList<Salesman> salesmans = null;
		try {
			salesmans = getData.getSalesmans();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(salesmans);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transferStrategy() {
		ArrayList<AmountGiftStra> amountGiftStra = null;
		ArrayList<AmountOnSaleStra> amountOnSaleStra = null;
		ArrayList<GoodsGiftStra> goodsGiftStra = null;
		ArrayList<GoodsOnSaleStra> goodsOnSaleStra = null;
		try {
			amountGiftStra = getData.getAmountGiftStralist();
			amountOnSaleStra = getData.getAmountOnSaleStraList();
			goodsGiftStra = getData.getGoodsGiftStralist();
			goodsOnSaleStra = getData.getGoodsOnSaleStraList();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(amountGiftStra);
			oos.writeObject(amountOnSaleStra);
			oos.writeObject(goodsGiftStra);
			oos.writeObject(goodsOnSaleStra);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//receiveData===========
	public void receiveStoreManager(){
		ArrayList<StoreManager> storeManagers=null;
		try {
			storeManagers=getData.getSMList();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			try {
				StoreManager storeManager=(StoreManager)ois.readObject();
				for(int i=0;i<storeManagers.size();i++){
					if(storeManagers.get(i).getID().equals(storeManager.getID())){
						storeManagers.get(i).setPassword(storeManager.getPassword());
						break;
					}
				}
				saveData.saveSMList(storeManagers);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveSalesman(){
		ArrayList<Salesman> salesmans=null;
		try {
			salesmans=getData.getSalesmans();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			try {
				Salesman salesman=(Salesman)ois.readObject();
				for(int i=0;i<salesmans.size();i++){
					if(salesmans.get(i).getID().equals(salesman.getID())){
						salesmans.get(i).setPassword(salesman.getPassword());
						break;
					}
				}
				saveData.saveSalesmansInfo(salesmans);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void receiveGoods(){
		ArrayList<Goods> goods=null;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			try {
				goods=(ArrayList<Goods>)ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			saveData.saveGoodsList(goods);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stopConnect() {
		try {
			socket.close();
//			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		beginConnect();
		int request = receiveRequest();
		switch (request) {
		case 1:
			transferStoreManager();
			break;
		case 2:
			transferGoods();
			break;
		case 3:
			transferSalesman();
			break;
		case 4:
			transferStrategy();
			break;
//
		case 5:
			receiveStoreManager();
			break;
		case 6:
			receiveSalesman();
			break;
		case 7:
			receiveGoods();
			break;
		}
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
		if (isConnect) {
			run();
		}
		else{
			stopConnect();
		}
	}
}
