package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import connect.ConnectStoreServer;

import data.user.Salesman;

public class SalesmanIndividualPanel extends IndividualPanel{

	private static final long serialVersionUID = 1L;
	
	private Salesman salesman;
	
	//�鿴������Ϣ�����޸���������������
	private JPanel watchSelfInfoPanel,changePasswordPanel;
	
	private JLabel ID, password,store;
	private JLabel IDInfo, passwordInfo,storeInfo;
	private JButton changeInfo;

	private JLabel oldPassword,firstPassword,secondPassword;
	private JPasswordField oldInput,firstInput,secondInput;
	private JButton sureChange,cancelChange;
	
	public SalesmanIndividualPanel(Salesman salesman){
		super();
		this.salesman=salesman;
	}
	void loadPanel1(){
		sellPanel.showPanel(salesman);
	}
	
	void loadPanel2(){
		returnGoodsPanel.showPanel(salesman);
	}
	
	void loadPanel3(){
		super.loadPanel3();
		loadSelfInfo();
	}
	
	//���ظ�����Ϣ
	private void loadSelfInfo(){
		watchSelfInfoPanel=new JPanel();
		watchSelfInfoPanel.setLayout(null);
		watchSelfInfoPanel.setBounds(0, 0, 800, 500);
		
		ID=new JLabel("�û���");
		ID.setBounds(270, 40, 160, 30);
		watchSelfInfoPanel.add(ID);
		
		IDInfo=new JLabel(salesman.getID());
		IDInfo.setBounds(430, 40, 160, 30);
		watchSelfInfoPanel.add(IDInfo);
		
		password=new JLabel("����");
		password.setBounds(270, 80, 160, 30);
		watchSelfInfoPanel.add(password);
		
		passwordInfo=new JLabel("********");
		passwordInfo.setBounds(430, 80, 160, 30);
		watchSelfInfoPanel.add(passwordInfo);
		
		changeInfo=new JButton("�޸�����");
		changeInfo.setBounds(610, 80, 120, 30);
		changeInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				changePassword();
			}
		});
		
		store=new JLabel("���̺�");
		store.setBounds(270, 120, 160, 30);
		watchSelfInfoPanel.add(store);
		
		storeInfo=new JLabel(Integer.toString(salesman.getStore()));
		storeInfo.setBounds(430, 120, 160, 30);
		watchSelfInfoPanel.add(storeInfo);
		
		watchSelfInfoPanel.add(changeInfo);
		selfInfoPanel.add(watchSelfInfoPanel);
	}
	
	//�޸�����Ĵ���ʵ��
	private void changePassword(){
		changePasswordPanel=new JPanel();
		changePasswordPanel.setLayout(null);
		changePasswordPanel.setBounds(0, 0, 800, 500);
		
		oldPassword=new JLabel("����������룺");
		oldPassword.setBounds(270, 40, 160, 30);
		changePasswordPanel.add(oldPassword);
		
		firstPassword=new JLabel("�����������룺");
		firstPassword.setBounds(270, 80, 160, 30);
		changePasswordPanel.add(firstPassword);
		
		secondPassword=new JLabel("���ٴ�ȷ�������룺");
		secondPassword.setBounds(270, 120, 160, 30);
		changePasswordPanel.add(secondPassword);
		
		oldInput=new JPasswordField();
		oldInput.setBounds(430, 40, 160, 30);
		changePasswordPanel.add(oldInput);
		
		firstInput=new JPasswordField();
		firstInput.setBounds(430, 80, 160, 30);
		changePasswordPanel.add(firstInput);
		
		secondInput=new JPasswordField();
		secondInput.setBounds(430, 120, 160, 30);
		changePasswordPanel.add(secondInput);
		
		sureChange=new JButton("ȷ��");
		sureChange.setBounds(430, 160, 70, 30);
		sureChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				if(String.valueOf(oldInput.getPassword()).equals(salesman.getPassword())){
					if(String.valueOf(firstInput.getPassword()).equals("")||String.valueOf(secondInput.getPassword()).equals("")){
						oldInput.setText(null);
						firstInput.setText(null);
						secondInput.setText(null);	
						JOptionPane.showMessageDialog(SalesmanIndividualPanel.this,"�����벻��Ϊ�գ�������������","����",2);
					}
					else{
						if(String.valueOf(firstInput.getPassword()).equals(String.valueOf(secondInput.getPassword()))){
							salesman.setPassword(String.valueOf(secondInput.getPassword()));
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);
							//
							ConnectStoreServer connectStore=new ConnectStoreServer(); 
							connectStore.connect();
							connectStore.sendRequest(5);
							connectStore.uploadSalesman(salesman);
							connectStore.stopConnect();
							//
							JOptionPane.showMessageDialog(SalesmanIndividualPanel.this,"�����޸ĳɹ�~","��ʾ",1);
							backUserInfo();
						}
						else{
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							JOptionPane.showMessageDialog(SalesmanIndividualPanel.this,"������ǰ�����β�һ�£�������������","����",2);
						}
					}
				}
				else{
					oldInput.setText(null);
					firstInput.setText(null);
					secondInput.setText(null);		
					JOptionPane.showMessageDialog(SalesmanIndividualPanel.this,"���������������������","����",0);
				}
			}
		});
		changePasswordPanel.add(sureChange);
		
		cancelChange=new JButton("ȡ��");
		cancelChange.setBounds(520, 160, 70, 30);
		cancelChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				backUserInfo();
			}
		});
		changePasswordPanel.add(cancelChange);
		
		watchSelfInfoPanel.setVisible(false);
		selfInfoPanel.remove(watchSelfInfoPanel);
		changePasswordPanel.setVisible(true);
		selfInfoPanel.add(changePasswordPanel);

	}
	private void backUserInfo(){
		changePasswordPanel.setVisible(false);
		selfInfoPanel.remove(changePasswordPanel);
		watchSelfInfoPanel.setVisible(true);
		selfInfoPanel.add(watchSelfInfoPanel);
	}
}
