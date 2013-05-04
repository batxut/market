package server.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataOperation.GetData;

import server.connect.ConnectServer;

import data.*;


public class LoginPanel extends JPanel {
	/**
	 * �����ǵ�¼ҳ��ľ���ʵ�֣���������¼ҳ��ĸ��� �������ṩ�˵�¼ҳ����ͬ��ģ��
	 */
	private static final long serialVersionUID = 1L;
	public final static Toolkit tk=Toolkit.getDefaultToolkit();
	
	StoreServer storeServer;
	ArrayList<Goods> goods = new ArrayList<Goods>();
	
	// ��¼���������
	private JLabel title,user;
	private JLabel userLabel, passLabel;
	private JButton back;

	private JButton login;
	private JTextField userName;
	private JPasswordField userPassword;
	protected String name, password;

	boolean isBack = false;
	boolean isConnect=false;
	boolean isLoginSucessful = false;

	public LoginPanel(StoreServer storeServer) {
		this.storeServer = storeServer;
		this.setBounds(0, 0, 940, 680);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	void initComponent() {
		title = new JLabel("��ӭ���������̵�ϵͳ----�ֵ������");
		title.setIcon(new ImageIcon("src/image/symbol.gif"));
		title.setFont(getFont().deriveFont(Font.BOLD, 30));
		title.setBounds(150, 20, 640, 80);
		this.add(title);
		
		user = new JLabel("��δ��¼");
		this.add(user);
		user.setBounds(570, 85, 150, 20);

		back = new JButton("ע��");
		this.add(back);
		back.setVisible(false);
		back.setBounds(720, 80, 80, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int a;
				a = JOptionPane.showConfirmDialog(LoginPanel.this, "�Ƿ�ȷ��ע��",
						"��ʾ", JOptionPane.YES_NO_OPTION);
				switch (a) {
				case -1:
					break;
				case 0:
					isBack = true;
					backLoginPanel();
					break;
				case 1:
					break;
				}
			}
		});

		userLabel = new JLabel("�� �� ��:");
		userLabel.setFont(getFont().deriveFont(Font.BOLD, 16));
		this.add(userLabel);
		userLabel.setBounds(250, 240, 80, 30);

		passLabel = new JLabel("��    ��:");
		passLabel.setFont(getFont().deriveFont(Font.BOLD, 16));
		this.add(passLabel);
		passLabel.setBounds(250, 280, 80, 30);

		userName = new JTextField();
		this.add(userName);
		userName.setBounds(350, 240, 120, 30);

		userPassword = new JPasswordField();
		userPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					login.doClick();
				}
			}
		});
		this.add(userPassword);
		userPassword.setBounds(350, 280, 120, 30);

		login = new JButton("��¼");
		this.add(login);
		login.setBounds(390, 320, 80, 30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name = userName.getText().trim();
				password = new String(userPassword.getPassword());
				if (name.length() == 0 || password.length() == 0) {
					JOptionPane.showMessageDialog(LoginPanel.this,
							"�û��������벻��Ϊ�գ�������������", "����", 2);
					return;
				}
				checkInfo();
				if (!isLoginSucessful&&isConnect) {
						userName.setText(null);
						userPassword.setText(null);
						JOptionPane.showMessageDialog(LoginPanel.this,"�û������������������������", "����", 0);
					return;
				}
			}
		});
	}

	
	
	void checkInfo() {
		;
	}

	public void showPanel() {
		initComponent();
	}
	// ���ػ���ע���Ĺ���ʵ��
	void relatedConduct() {
		if (isLoginSucessful) {
			this.loadIndividualPanel();
		}
	}

	void loadIndividualPanel() {
		this.remove(login);
		this.remove(userLabel);
		this.remove(passLabel);
		this.remove(userName);
		this.remove(userPassword);
		user.setText("�û������ֵ꾭��:" + name);
		back.setVisible(true);
	}

	void backLoginPanel() {
//		
		ConnectServer connectServer=new ConnectServer();
		connectServer.connect();
		connectServer.sendRequest(7);
		GetData getData=new GetData();
		connectServer.uploadGoods(getData.getGoods());
		connectServer.stopConnect();
//		
		this.removeAll();
		initComponent();
		isBack=false;
		isConnect=false;
		isLoginSucessful=false;
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image image=LoginPanel.tk.getImage(LoginPanel.class.getResource("/image/shopCar.png"));
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
}
