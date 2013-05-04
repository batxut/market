package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.user.Salesman;

public class IndividualPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 选项卡的设计
	JTabbedPane tabPane = new JTabbedPane();
	SellGoodsPanel sellPanel;
	ReturnGoodsPanel returnGoodsPanel;
	JPanel selfInfoPanel = new JPanel();

	IndividualPanel() {
		this.setBounds(0, 100, 940, 580);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
	}

	void initComponent() {
		tabPane.setBounds(0, 10, 940, 570);
		tabPane.setTabPlacement(JTabbedPane.TOP);
		sellPanel = new SellGoodsPanel();
		returnGoodsPanel=new ReturnGoodsPanel();
		tabPane.setFont(getFont().deriveFont(Font.BOLD, 16));
		tabPane.addTab("销售处理", sellPanel);
		tabPane.addTab("退货处理", returnGoodsPanel);
		tabPane.addTab("收银员信息", selfInfoPanel);
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
	}

	void loadPanel1() {
		;
	}

	void loadPanel2() {
		;
	}

	void loadPanel3() {
		selfInfoPanel.setLayout(null);
		JLabel jLab3 = new JLabel("收银员的基本信息如下：");
		jLab3.setBounds(20, 15, 160, 30);
		selfInfoPanel.add(jLab3);
	}

	void showPanel() {
		initComponent();
	}
}
