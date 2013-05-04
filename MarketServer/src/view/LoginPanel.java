package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import data.user.Administrator;

public class LoginPanel extends JPanel{
	/**�����ǵ�¼ҳ��ľ���ʵ�֣�������������¼ҳ��ĸ���
	 * �������ṩ�˵�¼ҳ����ͬ��ģ��
	 */
	private static final long serialVersionUID = 1L;
	public static final Toolkit tk=Toolkit.getDefaultToolkit();
	MainFrame mFrame;

	Administrator admin;
	
	//��¼���������
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
		title=new JLabel("��ӭ���������̵�ϵͳ----�ܷ�����");
		title.setIcon(new ImageIcon("src/image/symbol.gif"));
		title.setFont(getFont().deriveFont(Font.BOLD,30));
		title.setBounds(150, 20, 640, 80);
		this.add(title);
		
		user=new JLabel("��δ��¼");
		this.add(user);
		user.setBounds(570, 85, 150, 30);
		
		back=new JButton("����");
		this.add(back);
		back.setBounds(720, 80, 80, 30);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(back.getText().equals("����")){
					isBack=true;
					relatedConduct();
				}
				else if(back.getText().equals("ע��")){
					int a;
					a=JOptionPane.showConfirmDialog(LoginPanel.this,"�Ƿ�ȷ��ע��","��ʾ",JOptionPane.YES_NO_OPTION);
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
		
		userLabel =new JLabel("�û���:");
		userLabel.setFont(getFont().deriveFont(Font.BOLD,16));
		this.add(userLabel);
		userLabel.setBounds(250, 290, 80, 40);
		
		passLabel =new JLabel("��  ��:");
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
		
		login=new JButton("��¼");
		this.add(login);
		login.setBounds(370, 400, 80, 30);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ID=userID.getText().trim();
				password=new String(userPassword.getPassword());
				if(ID.length()==0||password.length()==0){
					JOptionPane.showMessageDialog(LoginPanel.this,"�û��������벻��Ϊ�գ�������������","����",2);
					return ;
				}
				checkInfo();
				if(!isLoginSucessful){
					userID.setText(null);
					userPassword.setText(null);
					JOptionPane.showMessageDialog(LoginPanel.this, "�û������������������������","����",0);
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
	
	//���ػ���ע���Ĺ���ʵ��
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
		user.setText("�û��˺�:"+ID);
		back.setText("ע��");
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
//		Image image=new ImageIcon("src/image/shopCar.png").getImage();
		Image image=LoginPanel.tk.getImage(LoginPanel.class.getResource("/image/shopCar.png"));
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
}