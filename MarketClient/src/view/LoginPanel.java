package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
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

import connect.ConnectStoreServer;

import data.user.Salesman;

public class LoginPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static final Toolkit tk=Toolkit.getDefaultToolkit();
	MainFrame mFrame;
	ArrayList<Salesman> Salesmans;

	private JLabel title, user;
	private JLabel userLabel, passLabel;
	private JButton back, login;
	private JTextField userName;
	private JPasswordField userPassword;
	protected String name, password;
	boolean isLoginSucessful = false;

	public LoginPanel(MainFrame mFrame) {
		this.mFrame = mFrame;
		this.setBounds(0, 0, 940, 680);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
	}

	void initComponent() {
		title = new JLabel("欢迎来到连锁商店系统----客户端");
		title.setIcon(new ImageIcon("image/symbol.gif"));
		title.setFont(getFont().deriveFont(Font.BOLD, 30));
		title.setBounds(170, 20, 700, 80);
		this.add(title);

		user = new JLabel("尚未登录");
		this.add(user);
		user.setBounds(615, 77, 150, 30);

		back = new JButton("");
		back.setVisible(false);
		this.add(back);
		back.setBounds(685, 77, 60, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int a;
				a = JOptionPane.showConfirmDialog(LoginPanel.this, "是否确定注销",
						"提示", JOptionPane.YES_NO_OPTION);
				switch (a) {
				case -1:
					break;
				case 0:
					backToLogin();
					isLoginSucessful = false;
					break;
				case 1:
					break;
				}

			}
		});

		userLabel = new JLabel("工    号:");
		userLabel.setFont(getFont().deriveFont(Font.BOLD,16));
		this.add(userLabel);
		userLabel.setBounds(250, 290, 80, 40);

		passLabel = new JLabel("密    码:");
		passLabel.setFont(getFont().deriveFont(Font.BOLD,16));
		this.add(passLabel);
		passLabel.setBounds(250, 350, 80, 40);

		userName = new JTextField();
		this.add(userName);
		userName.setBounds(340, 290, 120, 40);

		userPassword = new JPasswordField();
		userPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					login.doClick();
				}
			}
		});
		this.add(userPassword);
		userPassword.setBounds(340, 350, 120, 40);

		login = new JButton("登录");
		this.add(login);
		login.setBounds(370, 400, 80, 40);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name = userName.getText().trim();
				password = new String(userPassword.getPassword());
				if (name.length() == 0 || password.length() == 0) {
					JOptionPane.showMessageDialog(LoginPanel.this,
							"用户名或密码不能为空，请您重新输入", "警告", 2);
					return;
				}
				checkInfo();
				if (!isLoginSucessful) {
					userName.setText(null);
					userPassword.setText(null);
					JOptionPane.showMessageDialog(LoginPanel.this,
							"用户名或密码错误，请您重新输入", "错误", 0);
					return;
				}
			}
		});
	}

	int checkInfo() {
		return 0;
	}

	public void showPanel() {
		initComponent();
	}

	void relatedConduct() {
		this.loadIndividualPanel();
	}

	void loadIndividualPanel() {
		this.remove(login);
		this.remove(userLabel);
		this.remove(passLabel);
		this.remove(userName);
		this.remove(userPassword);
		user.setText("用户名:" + name);
		back.setVisible(true);
		back.setText("注销");
	}

	void backToLogin() {
		this.removeAll();
		initComponent();
		this.repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image image=LoginPanel.tk.getImage(LoginPanel.class.getResource("/image/shopCar.png"));
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
	
}
