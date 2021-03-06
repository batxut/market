package server.GUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import data.Goods;


public class NetConnectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Goods> goods;

	JTabbedPane tabPane = new JTabbedPane();
	ConnectClientPanel connectClientPanel = new ConnectClientPanel();

	public NetConnectPanel() {
		this.setBounds(0, 0, 800, 500);
		this.setBackground(Color.white);
		this.setVisible(true);
		this.setLayout(null);
	}

	private void initComponent() {
		tabPane.setBounds(0, 10, 780, 450);
		tabPane.setTabPlacement(JTabbedPane.LEFT);
		tabPane.setFont(getFont().deriveFont(Font.PLAIN, 16));
		tabPane.addTab("���ӿͻ���", connectClientPanel);
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		this.repaint();
	}

	void loadPanel1() {
		connectClientPanel.showPanel();
	}

	public void showPanel() {
		initComponent();
	}
}
