package view;

import java.awt.event.*;
import javax.swing.*;

import view.gm.NetConnectPanel;

import logic.SearchGMController;
import data.user.GeneralManager;

public class GManagerIndividualPanel extends IndividualPanel {
	private static final long serialVersionUID = 1L;

	private GeneralManager gm;;

	private JPanel watchSelfInfoPanel, changePasswordPanel;

	private JLabel ID, password;
	private JLabel IDInfo, passwordInfo,maxBookNumberInfo;
	private JButton changeInfo;

	private JLabel oldPassword, firstPassword, secondPassword;
	private JPasswordField oldInput, firstInput, secondInput;
	private JButton sureChange, cancelChange;
	
	NetConnectPanel connectPanel=new NetConnectPanel();
	
	public GManagerIndividualPanel(GeneralManager gm) {
		super();
		this.gm = gm;
	}
	void initComponent(){
		super.initComponent();
		tabPane.addTab("网络连接",connectPanel);
		loadPanel4();
	}
	void loadPanel1() {
		modifyGoodsPanel.showPanel();
	}
	void loadPanel2() {
		onSalesPanel.showPanel();
	}

	void loadPanel3() {
		super.loadPanel3();
		loadSelfInfo();
	}
	
	void loadPanel4(){
		connectPanel.showPanel();
	}
	// 加载个人信息
	private void loadSelfInfo() {
		watchSelfInfoPanel = new JPanel();
		watchSelfInfoPanel.setLayout(null);
		watchSelfInfoPanel.setBounds(0, 0, 940, 680);

		ID = new JLabel("用户名");
		ID.setBounds(200, 40, 160, 30);
		watchSelfInfoPanel.add(ID);

		IDInfo = new JLabel(gm.getID());
		IDInfo.setBounds(360, 40, 160, 30);
		watchSelfInfoPanel.add(IDInfo);

		password = new JLabel("密码");
		password.setBounds(200, 80, 160, 30);
		watchSelfInfoPanel.add(password);

		passwordInfo = new JLabel(gm.getPassword());
		passwordInfo.setBounds(360, 80, 160, 30);
		watchSelfInfoPanel.add(passwordInfo);

		changeInfo = new JButton("修改密码");
		changeInfo.setBounds(540, 80, 120, 30);
		changeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				changePassword();
			}
		});
		watchSelfInfoPanel.add(changeInfo);

		maxBookNumberInfo = new JLabel();
		maxBookNumberInfo.setBounds(360, 200, 160, 30);
		watchSelfInfoPanel.add(maxBookNumberInfo);

		selfInfoPanel.add(watchSelfInfoPanel);
	}

	// 修改密码的代码实现
	private void changePassword() {
		changePasswordPanel = new JPanel();
		changePasswordPanel.setLayout(null);
		changePasswordPanel.setBounds(0, 0, 940, 680);

		oldPassword = new JLabel("请输入旧密码：");
		oldPassword.setBounds(200, 40, 160, 30);
		changePasswordPanel.add(oldPassword);

		firstPassword = new JLabel("请输入新密码：");
		firstPassword.setBounds(200, 80, 160, 30);
		changePasswordPanel.add(firstPassword);

		secondPassword = new JLabel("请再次确认新密码：");
		secondPassword.setBounds(200, 120, 160, 30);
		changePasswordPanel.add(secondPassword);

		oldInput = new JPasswordField();
		oldInput.setBounds(360, 40, 160, 30);
		changePasswordPanel.add(oldInput);

		firstInput = new JPasswordField();
		firstInput.setBounds(360, 80, 160, 30);
		changePasswordPanel.add(firstInput);

		secondInput = new JPasswordField();
		secondInput.setBounds(360, 120, 160, 30);
		changePasswordPanel.add(secondInput);

		sureChange = new JButton("确定");
		sureChange.setBounds(360, 160, 70, 30);
		
		sureChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				
				if(String.valueOf(oldInput.getPassword()).equals(gm.getPassword())){
					if(String.valueOf(firstInput.getPassword()).equals("")||String.valueOf(secondInput.getPassword()).equals("")){
						oldInput.setText(null);
						firstInput.setText(null);
						secondInput.setText(null);	
						JOptionPane.showMessageDialog(null,"新密码不能为空，请您重新输入","警告",2);
					}
					else{
						if(String.valueOf(firstInput.getPassword()).equals(String.valueOf(secondInput.getPassword()))){
							gm.setPassword(String.valueOf(secondInput.getPassword()));
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							new SearchGMController().refreshGMInfo(gm);
							JOptionPane.showMessageDialog(null,"密码修改成功~","提示",1);
							passwordInfo.setText(gm.getPassword());
							backUserInfo();
						}
						else{
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							JOptionPane.showMessageDialog(null,"新密码前后两次不一致，请您重新输入","警告",2);
						}
					}
				}
				else{
					oldInput.setText(null);
					firstInput.setText(null);
					secondInput.setText(null);		
					JOptionPane.showMessageDialog(null,"旧密码错误，请您重新输入","错误",0);
				}
			}
		});
		 
		changePasswordPanel.add(sureChange);

		cancelChange = new JButton("取消");
		cancelChange.setBounds(450, 160, 70, 30);
		cancelChange.addActionListener(new ActionListener() {
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

	private void backUserInfo() {
		changePasswordPanel.setVisible(false);
		selfInfoPanel.remove(changePasswordPanel);
		watchSelfInfoPanel.setVisible(true);
		selfInfoPanel.add(watchSelfInfoPanel);
	}
}
