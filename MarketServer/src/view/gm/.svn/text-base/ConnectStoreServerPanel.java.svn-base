package view.gm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import connect.ConnectStoreServer;

class ConnectStoreServerPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		JLabel connect, stopConnect, connectState;
		JButton sureConnect,sureStopConnect;
		JTextArea showConnectState;
		ConnectStoreServer connectStore=new ConnectStoreServer();
		Thread thread;
		
		ConnectStoreServerPanel() {
			this.setLayout(null);
		}

		private void initComponent() {
			connect = new JLabel("连接分店数据：");
			connect.setBounds(10, 0, 100, 30);
			this.add(connect);

			sureConnect = new JButton("确定连接");
			sureConnect.setBounds(130, 5, 120, 30);
			sureConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					showConnectState.setText("连接中 ... ...");
					setState();
					connectStore.setIsConnect(true);
					thread=new Thread(connectStore);
					thread.start();
				}
			});
			this.add(sureConnect);
			sureConnect.setEnabled(true);
			
			sureStopConnect = new JButton("断开连接");
			sureStopConnect.setBounds(270, 5, 120, 30);
			sureStopConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					showConnectState.setText("连接断开 ... ...");
					resetState();
					connectStore.setIsConnect(false);
//					connectStore.stopConnect();
				}
			});
			this.add(sureStopConnect);
			sureStopConnect.setVisible(false);
			
			connectState = new JLabel("连接状态显示：");
			connectState.setBounds(10, 40, 100, 30);
			this.add(connectState);

			showConnectState = new JTextArea();
			showConnectState.setBounds(10, 80, 500, 300);
			showConnectState.setEditable(false);
			showConnectState.setText("尚未连接");
			this.add(showConnectState);
		}

		void showPanel() {
			initComponent();
		}
		private void setState(){
			sureConnect.setEnabled(false);
			sureStopConnect.setVisible(true);
		}
		private void resetState(){
			sureConnect.setEnabled(true);
			sureStopConnect.setVisible(false);
		}
	}