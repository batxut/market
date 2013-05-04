package server.GUI;

import javax.swing.JOptionPane;

import server.connect.ConnectServer;
import data.user.StoreManager;

public class StoreManagerLoginPanel extends LoginPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StoreManager storeManager;
	StoreManagerIndividualPanel storeManagerIndivPanel;
	ConnectServer connectServer;

	public StoreManagerLoginPanel(StoreServer storeServer) {
		super(storeServer);
		String IP=JOptionPane.showInputDialog(null,"请输入总店服务器IP地址","127.0.0.1");
		ConnectServer.IP=IP;
		connectServer = new ConnectServer();
	}

	private void connectLogin() {
		if(connectServer.connect()){
			isConnect=true;
		};
		connectServer.sendRequest(1);
		storeManager = connectServer.receiveStoreManager();
		connectServer.stopConnect();
	}

	private void receiveRelatedData(int request) {
		connectServer.connect();
		connectServer.sendRequest(request);
		switch (request) {
		case 2:
			connectServer.receiveGoods();
			break;
		case 3:
			connectServer.receiveSalesman();
			break;
		case 4:
			connectServer.receiveStrategy();
			break;
		}
		connectServer.stopConnect();
	}

	// 覆盖了父类相应的方法，实现页面跳转
	void checkInfo() {
		connectLogin();
		try{
			if (name.equals(storeManager.getID())&& password.equals(storeManager.getPassword())) {
				isLoginSucessful = true;
				receiveRelatedData(2);
				receiveRelatedData(3);
				receiveRelatedData(4);
				relatedConduct();
			}
		} catch(Exception e){
//			e.printStackTrace();
		}
	}

	void loadIndividualPanel() {
		super.loadIndividualPanel();
		storeManagerIndivPanel = new StoreManagerIndividualPanel(storeManager);
		this.add(storeManagerIndivPanel);
		storeManagerIndivPanel.showPanel();
	}
}
