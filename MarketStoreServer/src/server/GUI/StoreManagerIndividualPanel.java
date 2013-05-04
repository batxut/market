package server.GUI;

import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.*;
import data.user.StoreManager;
import data.user.VIPCustomer;

public class StoreManagerIndividualPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Goods> goods;
	ArrayList<VIPCustomer> VIP;

	// 选项卡的设计
	JTabbedPane tabPane = new JTabbedPane();
	GoodsManagePanel GoodsManagePanel = new GoodsManagePanel();
	VIPManagePanel VIPManagePanel = new VIPManagePanel();
	StoreManagerInfoPanel selfInfoPanel ;
	
	NetConnectPanel connectPanel=new NetConnectPanel();
	
	public StoreManagerIndividualPanel(StoreManager storeManager) {
		this.setBounds(0, 100, 940, 580);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
		
		selfInfoPanel = new StoreManagerInfoPanel(storeManager);
	}

	private void initComponent() {
		tabPane.setBounds(0, 10, 940, 570);
		tabPane.setTabPlacement(JTabbedPane.TOP);
		tabPane.setFont(getFont().deriveFont(Font.BOLD, 16));
		tabPane.addTab("商品信息", GoodsManagePanel);
		tabPane.addTab("顾客信息", VIPManagePanel);
		tabPane.addTab("个人信息", selfInfoPanel);
		tabPane.addTab("网络连接", connectPanel);
		
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
		loadPanel4();
		this.repaint();
	}

	void loadPanel1() {
		GoodsManagePanel.showPanel();
	}

	void loadPanel2() {
		VIPManagePanel.showPanel();
	}

	void loadPanel3() {
		selfInfoPanel.showPanel();
	}
	void loadPanel4(){
		connectPanel.showPanel();
	}
	public void showPanel() {
		initComponent();
	}
}
