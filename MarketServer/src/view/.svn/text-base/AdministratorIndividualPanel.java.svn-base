package view;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import view.admin.AdministratorAddUserPanel;
import view.admin.AdministratorDeleteUserPanel;
import view.admin.AdministratorModUserPanel;

import data.user.Administrator;;

public class AdministratorIndividualPanel extends IndividualPanel{
	/**该类是管理员的个人页面，继承了个人页面，实现了代码复用，又保证了管理员的相关操作
	 * 
    */
	private static final long serialVersionUID = 1L;
	
	Administrator admin;

	AdministratorAddUserPanel addUserPanel; 
	AdministratorDeleteUserPanel deleteUserPanel;
	AdministratorModUserPanel modUserPanel;
	
	//查看个人信息，并修改密码的组件的声明
	private JPanel watchSelfInfoPanel,changePasswordPanel;
	
	private JLabel ID, password;
	private JLabel IDInfo,passwordInfo;
	private JButton changeInfo;

	private JLabel oldPassword,firstPassword,secondPassword;
	private JPasswordField oldInput,firstInput,secondInput;
	private JButton sureChange,cancelChange;
	
	public AdministratorIndividualPanel(Administrator admin) {
		super();
		this.admin=admin;
	}
	
	//初始化相应的组件
	void initComponent(){		
		tabPane.setBounds(0, 10, 940, 680);
		tabPane.setTabPlacement(JTabbedPane.TOP);
		addUserPanel=new AdministratorAddUserPanel();
		deleteUserPanel=new AdministratorDeleteUserPanel();
		modUserPanel=new AdministratorModUserPanel();
		//选项卡的设计
		tabPane.setFont(getFont().deriveFont(Font.BOLD,16));
		tabPane.addTab("增加用户",addUserPanel);
		tabPane.addTab("解雇用户",deleteUserPanel);
		tabPane.addTab("员工变迁", modUserPanel);
		tabPane.addTab("管理员信息",selfInfoPanel);
		
		
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
		loadPanel4();
		this.repaint();
	}
	void loadPanel1(){
		addUserPanel.showPanel();
	}
	void loadPanel2(){
		deleteUserPanel.showPanel();
	}
	void loadPanel3(){
		super.loadPanel3();
		loadSelfInfo();
	}
	void loadPanel4()
	{
		modUserPanel.showPanel();
	}
	
	
	//加载个人信息
	private void loadSelfInfo(){
		watchSelfInfoPanel=new JPanel();
		watchSelfInfoPanel.setLayout(null);
		watchSelfInfoPanel.setBounds(0, 0, 940, 680);
		
		ID=new JLabel("用户名");
		ID.setBounds(200, 40, 160, 30);
		watchSelfInfoPanel.add(ID);
		
		IDInfo=new JLabel("admin");
		IDInfo.setBounds(360, 40, 160, 30);
		watchSelfInfoPanel.add(IDInfo);
		
		password=new JLabel("密码");
		password.setBounds(200, 80, 160, 30);
		watchSelfInfoPanel.add(password);
		
		passwordInfo=new JLabel("********");
		passwordInfo.setBounds(360, 80, 160, 30);
		watchSelfInfoPanel.add(passwordInfo);
		
		changeInfo=new JButton("【修改密码】");
		changeInfo.setBounds(540, 80, 120, 30);
		changeInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				changePassword();
			}
		});
		watchSelfInfoPanel.add(changeInfo);
		
		selfInfoPanel.add(watchSelfInfoPanel);
	}
	
	//修改密码的代码实现
	private void changePassword(){
		changePasswordPanel=new JPanel();
		changePasswordPanel.setLayout(null);
		changePasswordPanel.setBounds(0, 0, 940, 680);
		
		oldPassword=new JLabel("请输入旧密码：");
		oldPassword.setBounds(200, 40, 160, 30);
		changePasswordPanel.add(oldPassword);
		
		firstPassword=new JLabel("请输入新密码：");
		firstPassword.setBounds(200, 80, 160, 30);
		changePasswordPanel.add(firstPassword);
		
		secondPassword=new JLabel("请再次确认新密码：");
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
		
		sureChange=new JButton("确定");
		sureChange.setBounds(360, 160, 70, 30);
/*		sureChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				if(String.valueOf(oldInput.getPassword()).equals(admin.getPassword())){
					if(String.valueOf(firstInput.getPassword()).equals("")||String.valueOf(secondInput.getPassword()).equals("")){
						oldInput.setText(null);
						firstInput.setText(null);
						secondInput.setText(null);	
						JOptionPane.showMessageDialog(AdministratorIndividualPanel.this,"新密码不能为空，请您重新输入","警告",2);
					}
					else{
						if(String.valueOf(firstInput.getPassword()).equals(String.valueOf(secondInput.getPassword()))){
							admin.setPassword(String.valueOf(secondInput.getPassword()));
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							JOptionPane.showMessageDialog(AdministratorIndividualPanel.this,"密码修改成功~","提示",1);
							backUserInfo();
						}
						else{
							oldInput.setText(null);
							firstInput.setText(null);
							secondInput.setText(null);	
							JOptionPane.showMessageDialog(AdministratorIndividualPanel.this,"新密码前后两次不一致，请您重新输入","警告",2);
						}
					}
				}
				else{
					oldInput.setText(null);
					firstInput.setText(null);
					secondInput.setText(null);		
					JOptionPane.showMessageDialog(AdministratorIndividualPanel.this,"旧密码错误，请您重新输入","错误",0);
				}
			}
		});
		*/
		changePasswordPanel.add(sureChange);
		
		cancelChange=new JButton("取消");
		cancelChange.setBounds(450, 160, 70, 30);
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