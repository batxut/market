package server.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.Goods;

public class GoodsManagePanel extends JPanel {
	/**该类用于管理员检查商品，并进行入库出库的管理的操作
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Goods> goods;

	// 选项卡的设计
	JTabbedPane tabPane = new JTabbedPane();
	CheckGoodsPanel checkGoodsPanel=new CheckGoodsPanel(null);
	InputGoodsPanel inputGoodsPanel = new InputGoodsPanel(null);
	OutputGoodsPanel outputGoodsPanel=new OutputGoodsPanel(null);

	public GoodsManagePanel() {
		this.setBounds(0, 0, 940, 580);
		this.setBackground(Color.white);
		this.setVisible(true);
		this.setLayout(null);
	}

	private void initComponent() {
		tabPane.setBounds(0, 10, 900, 520);
		tabPane.setTabPlacement(JTabbedPane.LEFT);
		tabPane.setFont(getFont().deriveFont(Font.PLAIN, 16));
		tabPane.addTab("库存分析", checkGoodsPanel);
		tabPane.addTab("商品入库", inputGoodsPanel);
		tabPane.addTab("商品出库", outputGoodsPanel);
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
		this.repaint();
	}
	
	void loadPanel1() {
		checkGoodsPanel.showPanel();
	}

	void loadPanel2() {
		inputGoodsPanel.showPanel();
	}

	void loadPanel3() {
		outputGoodsPanel.showPanel();
	}
	public void showPanel() {
		initComponent();
	}
}
