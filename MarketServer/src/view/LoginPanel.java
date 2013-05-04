package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import data.user.Administrator;

public class LoginPanel extends JPanel{
	/**该类是登录页面的具体实现，是其他三个登录页面的父类
	 * 功能是提供了登录页面相同的模版
	 */
	private static final long serialVersionUID = 1L;
	public static final Toolkit tk=Toolkit.getDefaultToolkit();
	MainFrame mFrame;

	Administrator admin;
	
	//登录组件的声明
	private JLabel title, user;
	private JLabel userLabel, passLabel;
	private JButton back,login;
	private JTextField userID;
	private JPasswordField userPassword;
	protected String ID,password;
	 
	boolean isBack=false;
	boolean isLoginSucessful=false;
	
	public LoginPanel(MainFrame mFrame){
		this.mFrame=mFrame;
		this.setBounds(0, 0, 940, 680);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
	}
	void initComponent(){
		title=new JLabel("欢迎来到连锁商店系统----总服务器");
		title.setIcon(new ImageIcon("src/image/symbol.gif"));
		title.setFont(getFont().deriveFont(Font.BOLD,30));
		title.setBounds(150, 20, 640, 80);
		this.add(title);
		
		user=new JLabel("尚未登录");
		this.add(user);
		user.setBounds(570, 85, 150, 30);
		
		back=new JButton("返回");
		this.add(back);
		back.setBounds(720, 80, 80, 30);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(back.getText().equals("返回")){
					isBack=true;
					relatedConduct();
				}
				else if(back.getText().equals("注销")){
					int a;
					a=JOptionPane.showConfirmDialog(LoginPanel.this,"是否确定注销","提示",JOptionPane.YES_NO_OPTION);
					switch (a){
					case -1:
						break;
					case 0:
						isBack=true;
						relatedConduct();
						isLoginSucessful=false;
						break;
					case 1:
						break;
					}	
				}
			}
		});
		
		userLabel =new JLabel("用户名:");
		userLabel.setFont(getFont().deriveFont(Font.BOLD,16));
		this.add(userLabel);
		userLabel.setBounds(250, 290, 80, 40);
		
		passLabel =new JLabel("密  码:");
		passLabel.setFont(getFont().deriveFont(Font.BOLD,16));
		this.add(passLabel);		
		passLabel.setBounds(250, 350, 80, 40);
		
		userID=new JTextField();
		this.add(userID);
		userID.setBounds(340, 290, 120, 40);
		
		userPassword=new JPasswordField();
		userPassword.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==10){
					login.doClick();
				}
			}
		});
		this.add(userPassword);
		userPassword.setBounds(340, 350, 120, 40);
		
		login=new JButton("登录");
		this.add(login);
		login.setBounds(370, 400, 80, 30);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ID=userID.getText().trim();
				password=new String(userPassword.getPassword());
				if(ID.length()==0||password.length()==0){
					JOptionPane.showMessageDialog(LoginPanel.this,"用户名或密码不能为空，请您重新输入","警告",2);
					return ;
				}
				checkInfo();
				if(!isLoginSucessful){
					userID.setText(null);
					userPassword.setText(null);
					JOptionPane.showMessageDialog(LoginPanel.this, "用户名或密码错误，请您重新输入","错误",0);
					return ;
				}
			}
		});
	}
	void checkInfo(){
		;
	}
	public void showPanel(){

		initComponent();		
	}
	
	//返回或是注销的功能实现
	void relatedConduct(){
		if(isBack){
			isBack=false;

			mFrame.backChooseIdPanel();
		}
		if(isLoginSucessful){
			this.loadIndividualPanel();
		}
	}
	void loadIndividualPanel(){
		this.remove(login);
		this.remove(userLabel);
		this.remove(passLabel);
		this.remove(userID);
		this.remove(userPassword);
		user.setText("用户账号:"+ID);
		back.setText("注销");
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//		Image image=new ImageIcon("src/image/shopCar.png").getImage();
		Image image=LoginPanel.tk.getImage(LoginPanel.class.getResource("/image/shopCar.png"));
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
}