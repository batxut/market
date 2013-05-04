package server.GUI;

import java.awt.Color;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class StoreServer extends JFrame {
	/**该类是StoreServer程序的入口
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StoreManagerLoginPanel storeManagerLogPanel;
	
	public StoreServer() {
		this.setBounds(200, 10, 940+6, 680+28);
		this.setTitle("连锁商店购物系统-----南京大学软件学院");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(Color.pink);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		StoreServer storeServer = new StoreServer();
		storeServer.loadPanel();
	}

	private void loadPanel() {
		storeManagerLogPanel = new StoreManagerLoginPanel(this);
		this.add(storeManagerLogPanel);
		storeManagerLogPanel.showPanel();
	}

}
