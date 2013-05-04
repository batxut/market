package server.GUI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import server.connect.ConnectServer;

import data.user.StoreManager;


public class StoreManagerInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StoreManager storeManager;
	
	JLabel selfInfo;
	JLabel name,nameInfo,ID,IDInfo,password,passwordInfo;
	JButton changeInfo;
	
	private JPanel changePasswordPanel;
	private JLabel oldPassword,firstPassword,secondPassword;
	private JPasswordField oldInput,firstInput,secondInput;
	private JButton sureChange,cancelChange;
	
	StoreManagerInfoPanel(StoreManager storeManager){
		this.setLayout(null);
		this.setVisible(true);
		this.storeManager=storeManager;
		
	}
	private void initComponent(){
		selfInfo = new JLabel("���Ļ�����Ϣ���£�");
		selfInfo.setBounds(20, 15, 160, 30);
		this.add(selfInfo);
		
		ID=new JLabel("��   ��   �� :");
		ID.setBounds(200, 40, 160, 30);
		this.add(ID);
		
		IDInfo=new JLabel(storeManager.getID());
		IDInfo.setBounds(360, 40, 160, 30);
		this.add(IDInfo);
		
		password=new JLabel("��        �� :");
		password.setBounds(200, 80, 160, 30);
		this.add(password);
		
		passwordInfo=new JLabel("********");
		passwordInfo.setBounds(360, 80, 160, 30);
		this.add(passwordInfo);
		
		changeInfo=new JButton("�޸�����");
		changeInfo.setBounds(540, 80, 100, 30);
		changeInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				changePassword();
			}
		});
		this.add(changeInfo);
	}
	void showPanel(){
		initComponent();
	}
	
	private void changePassword(){
		this.removeAll();
		
		changePasswordPanel=new JPanel();
		changePasswordPanel.setLayout(null);
		changePasswordPanel.setBounds(0, 0, 800, 500);
		
		oldPassword=new JLabel("����������룺");
		oldPassword.setBounds(200, 40, 160, 30);
		changePasswordPanel.add(oldPassword);
		
		firstPassword=new JLabel("�����������룺");
		firstPassword.setBounds(200, 80, 160, 30);
		changePasswordPanel.add(firstPassword);
		
		secondPassword=new JLabel("���ٴ�ȷ�������룺");
		secondPassword.setBounds(200, 120, 160, 30);
		changePasswordPanel.add(secondPassword);
		
		oldInput=new JPasswordField();
		oldInput.setBounds(360, 40, 160, 30);
		changePasswordPanel.add(oldInput);
		
		firstInput=new JPasswordField();
		firstInput.setBounds(360, 80, 160, 30);
		changePasswordPanel.add(firstInput);
		
		secondInput=new JPasswordField();
		secondInput.setBounds(360, 120, 160, 30);
		changePasswordPanel.add(secondInput);
		
		sureChange=new JButton("ȷ��");
		sureChange.setBounds(360, 160, 70, 30);
		sureChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				if(String.valueOf(oldInput.getPassword()).equals(storeManager.getPassword())){
					if(String.valueOf(firstInput.getPassword()).equals("")||String.valueOf(secondInput.getPassword()).equals("")){
						oldInput.setText(null);
						firstInput.setText(null);
						secondInput.setText(null);	
						JOptionPane.showMessageDialog(StoreManagerInfoPanel.this,"�����벻��Ϊ�գ�������������","����",2);
					}
					else{
						if(String.valueOf(firstInput.getPassword()).equals(String.valueOf(secondInput.getPassword()))){
							storeManager.setPassword(String.valueOf(secondInput.getPassword()));
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);
							//
							ConnectServer connectServer=new ConnectServer(); 
							connectServer.connect();
							connectServer.sendRequest(5);
							connectServer.updateStoreManager(storeManager);
							System.out.println(storeManager.getPassword());
							connectServer.stopConnect();
							//
							JOptionPane.showMessageDialog(StoreManagerInfoPanel.this,"�����޸ĳɹ�~","��ʾ",1);
							backSelfInfo();
						}
						else{
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							JOptionPane.showMessageDialog(StoreManagerInfoPanel.this,"������ǰ�����β�һ�£�������������","����",2);
						}
					}
				}
				else{
					oldInput.setText(null);
					firstInput.setText(null);
					secondInput.setText(null);		
					JOptionPane.showMessageDialog(StoreManagerInfoPanel.this,"���������������������","����",0);
				};
			}
		});
		changePasswordPanel.add(sureChange);
		
		cancelChange=new JButton("ȡ��");
		cancelChange.setBounds(450, 160, 70, 30);
		cancelChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				backSelfInfo();
			}
		});
		changePasswordPanel.add(cancelChange);
		
		this.setVisible(false);
		changePasswordPanel.setVisible(true);
		this.add(changePasswordPanel);

	}
	private void backSelfInfo(){
		this.remove(changePasswordPanel);
		this.initComponent();
		this.repaint();
	}
}
