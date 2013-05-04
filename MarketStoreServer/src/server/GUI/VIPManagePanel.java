package server.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.user.VIPCustomer;

public class VIPManagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<VIPCustomer> VIP;

	// 选项卡的设计
	JTabbedPane tabPane = new JTabbedPane();
	CheckVIPPanel checkVIPPanel=new CheckVIPPanel(null);
	CountVIPPanel countVIPPanel = new CountVIPPanel();
    DevelopVIPPanel developVIPPanel=new DevelopVIPPanel(null);
    GiveGiftPanel giveGiftPanel=new GiveGiftPanel();
    
	public VIPManagePanel() {
		this.setBounds(0, 0, 940, 580);
		this.setBackground(Color.white);
		this.setVisible(true);
		this.setLayout(null);
	}

	private void initComponent() {
		tabPane.setBounds(0, 10, 900, 520);
		tabPane.setTabPlacement(JTabbedPane.LEFT);
		tabPane.setFont(getFont().deriveFont(Font.PLAIN, 16));
		tabPane.addTab("顾客查询", checkVIPPanel);
		tabPane.addTab("顾客统计", countVIPPanel);
		tabPane.addTab("发展会员",developVIPPanel);
		tabPane.addTab("礼品赠送", giveGiftPanel);
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
		loadPanel4();
		this.repaint();
	}
	
	void loadPanel1() {
		checkVIPPanel.showPanel();
	}

	void loadPanel2() {
		countVIPPanel.showPanel();
	}
	
	void loadPanel3(){
		developVIPPanel.showPanel();
	}
	
	void loadPanel4(){
		giveGiftPanel.showPanel();
	}
	
	public void showPanel() {
		initComponent(); 
	}
}
