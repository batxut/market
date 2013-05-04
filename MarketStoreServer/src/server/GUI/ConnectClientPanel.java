package server.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import server.connect.ConnectClient;

	public class ConnectClientPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		JLabel connect, connectState;
		JButton sureConnect,sureStopConnect;
		public JTextArea showConnectState;
		
		ConnectClient connectClient=new ConnectClient();
		Thread thread;
		
		public ConnectClientPanel() {
			this.setLayout(null);
		}

		private void initComponent() {
			connect = new JLabel("���ӿͻ������ݣ�");
			connect.setBounds(30, 0, 120, 30);
			this.add(connect);

			sureConnect = new JButton("ȷ������");
			sureConnect.setBounds(150, 5, 120, 30);
			sureConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					showConnectState.setText("������ ... ...");
					setState();
					connectClient.setIsConnect(true);
					thread = new Thread(connectClient);
					thread.start();
				}
			});
			this.add(sureConnect);
			sureConnect.setEnabled(true);
			
			sureStopConnect = new JButton("�Ͽ�����");
			sureStopConnect.setBounds(290, 5, 120, 30);
			sureStopConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					showConnectState.setText("���ӶϿ� ... ...");
					resetState();
					connectClient.setIsConnect(false);
				}
			});
			this.add(sureStopConnect);
			sureStopConnect.setVisible(false);
			
			connectState = new JLabel("����״̬��ʾ��");
			connectState.setBounds(30, 40, 100, 30);
			this.add(connectState);
			sureConnect.setVisible(true);

			showConnectState = new JTextArea();
			showConnectState.setBounds(30, 80, 500, 300);
			showConnectState.setEditable(false);
			showConnectState.setText("��δ����");
			this.add(showConnectState);
		}

		public void showPanel() {
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
