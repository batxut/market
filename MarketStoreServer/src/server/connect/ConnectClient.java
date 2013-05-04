package server.connect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DataOperation.GetData;
import DataOperation.SaveData;

import data.Goods;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;
import data.user.Salesman;
import data.user.VIPCustomer;

public class ConnectClient implements Runnable {
	private boolean isConnect=true;
	ServerSocket serverSocket;
	Socket socket;
	GetData getData = new GetData();
	SaveData saveData = new SaveData();
	ConnectServer connectServer=new ConnectServer();

	public ConnectClient() {
		try {
			serverSocket = new ServerSocket(9000);
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	public void setIsConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}

	public void beginConnect() {
		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
//			e.printStackTrace();
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

	// transferData===========
	public void transferSalesman() {
		ArrayList<Salesman> salesmans = null;
		try {
			salesmans = getData.getSalesmans();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(salesmans.get(0));
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transferGoods() {
		ArrayList<Goods> goods = null;
		try {
			goods = getData.getGoods();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(goods);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transferVIPs() {
		ArrayList<VIPCustomer> vips = null;
		try {
			vips = getData.getVIPs();
			ObjectOutputStream oos = new ObjectOutputStream(socket
					.getOutputStream());
			oos.writeObject(vips);
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

	// receiveData===========
	public void receiveSalesman() {
		ArrayList<Salesman> salesmans = null;
		try {
			salesmans = getData.getSalesmans();
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			try {
				Salesman salesman = (Salesman) ois.readObject();
				for (int i = 0; i < salesmans.size(); i++) {
					if (salesmans.get(i).getID().equals(salesman.getID())) {
						salesmans.get(i).setPassword(salesman.getPassword());
						//
						connectServer.connect();
						connectServer.sendRequest(6);
						connectServer.uploadSalesman(salesman);
						connectServer.stopConnect();
						//
						break;
					}
				}
				saveData.saveSalesmanInfo(salesmans);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void receiveGoods() {
		ArrayList<Goods> goods = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(socket
					.getInputStream());
			try {
				goods = (ArrayList<Goods>) ois.readObject();
				//
				connectServer.connect();
				connectServer.sendRequest(7);
				connectServer.uploadGoods(goods);
				connectServer.stopConnect();
				//
				saveData.saveGoodsInfo(goods);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void stopConnect() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		beginConnect();
		int request = receiveRequest();
		switch (request) {
		case 1:
			transferSalesman();
			break;
		case 2:
			transferGoods();
			break;
		case 3:
			transferVIPs();
			break;
		case 4:
			transferStrategy();
			break;
		//
		case 5:
			receiveSalesman();
			break;
		case 6:
			receiveGoods();
			break;
		}

		if (isConnect) {
			run();
		} else {
			stopConnect();
		}
	}
}
