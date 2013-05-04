package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import connect.ConnectStoreServer;
import data.user.Salesman;
import dataOperation.GetData;

public class SalesmanLoginPanel extends LoginPanel{

	private static final long serialVersionUID = 1L;
	private Salesman salesman;
	ConnectStoreServer connectStoreServer;
	
	public SalesmanLoginPanel(MainFrame mFrame){
		super(mFrame);
		String IP=JOptionPane.showInputDialog(null,"请输入分店服务器IP地址","127.0.0.1");
		ConnectStoreServer.IP=IP;
		connectStoreServer = new ConnectStoreServer();
	}
	
	private void connectLogin(){
		connectStoreServer.connect();
		connectStoreServer.sendRequest(1);
		salesman=connectStoreServer.receiveSalesman();
		connectStoreServer.stopConnect();
	}
	
	private void receiveRelatedData(int request) {
		connectStoreServer.connect();
		connectStoreServer.sendRequest(request);
		switch (request) {
		case 2:
			connectStoreServer.receiveGoods();
			break;
		case 3:
			connectStoreServer.receiveVIPs();
			break;
		case 4:
			connectStoreServer.receiveStrategy();
			break;
		}
		connectStoreServer.stopConnect();
	}
	
	public int  checkInfo(){
		connectLogin();
		if (name.equals(salesman.getID())
				&& password.equals(salesman.getPassword())) {
			isLoginSucessful = true;
			receiveRelatedData(2);
			receiveRelatedData(3);
			receiveRelatedData(4);
			relatedConduct();
		}
		return 0;
	}
	void loadIndividualPanel(){
		super.loadIndividualPanel();
		SalesmanIndividualPanel salPanel=new SalesmanIndividualPanel(salesman);
		this.add(salPanel);
		salPanel.showPanel();
	}
	
	void backToLogin(){
		super.backToLogin();
		//
		connectStoreServer.connect();
		connectStoreServer.sendRequest(6);
		GetData getData=new GetData();
		connectStoreServer.uploadGoods(getData.getGoodsList());
		connectStoreServer.stopConnect();
		//
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image image=new ImageIcon("src/image/shopCar.png").getImage();
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
}
