package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChooseIdentityPanel extends JPanel{
	/**该类用于身份的选择，完善了登录效果
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Toolkit tk=Toolkit.getDefaultToolkit();
	MainFrame mFrame;
	
	//选择身份的组件的声明
	ButtonGroup bGroup=new ButtonGroup();
	JRadioButton jrBtn1,jrBtn2;
	JButton jBtn=new JButton();
	
	JLabel jLab1,jLab2;
	
	private String identity=null;
	private boolean isSure=false;
	
	ChooseIdentityPanel(MainFrame mFrame){
		this.mFrame=mFrame;
		this.setBounds(0, 0, 940, 680);
		this.setBackground(Color.pink);
		this.setLayout(null);
		this.setVisible(true);
	}
	void setIsSure(boolean isSure){
		this.isSure=isSure;
	}
	void setIdentity(String id){
		this.identity=id;
	}
	String getIdentity(){
		return identity;
	}
	boolean getIsSure(){
		return isSure;
	}
	
	//相应的组件初始化
	private void initComponent(){
		
		jLab1=new JLabel("欢迎来到连锁商店系统----总服务器");
		jLab1.setIcon(new ImageIcon("src/image/symbol.gif"));
		jLab1.setFont(getFont().deriveFont(Font.BOLD,30));
		jLab1.setBounds(150, 20, 640, 80);
		this.add(jLab1);
		
		jLab2=new JLabel("请选择你的身份");
		jLab2.setFont(getFont().deriveFont(Font.BOLD,20));
		jLab2.setBounds(250, 220, 200, 30);
		this.add(jLab2);
		
		jrBtn1=new JRadioButton("总经理");
		jrBtn2=new JRadioButton("管理员");
		bGroup.add(jrBtn1);
		bGroup.add(jrBtn2);
		this.add(jrBtn1);
		this.add(jrBtn2);
		jrBtn1.setBounds(250, 280, 200, 40);
		jrBtn2.setBounds(250, 350, 200, 40);
		jrBtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					identity="general manager";
			}
		});
		jrBtn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				identity="administrator";
			}
		});
		jrBtn1.setVisible(true);
		jrBtn2.setVisible(true);
		
		jBtn=new JButton("确定");
		jBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				isSure=true;
				mFrame.loadLoginPanel();
			}
		});
		this.add(jBtn);
		jBtn.setBounds(370, 400, 80, 30);
		jBtn.setVisible(true);
	}
	public void showPanel(){
		initComponent();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	//	Image image=new ImageIcon("src/image/shopCar.png").getImage();
		Image image=ChooseIdentityPanel.tk.getImage(ChooseIdentityPanel.class.getResource("/image/shopCar.png"));
		g.drawImage(image, 360, 240,600,480,Color.PINK,this);
	}
}
