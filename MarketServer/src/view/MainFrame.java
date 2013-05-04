package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;



public class MainFrame extends JFrame{
	/**������client��������
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Toolkit tk=Toolkit.getDefaultToolkit();
	
	//��Ӧ��ҳ�������
	ChooseIdentityPanel cPanel;
	GManagerLoginPanel gmLogPanel;
	AdministratorLoginPanel adminLogPanel;
	
	public MainFrame(){
		this.setBounds(200,10,946,708);
		this.setTitle("��ӭ���������̵�ϵͳ----�ܷ�����");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(Color.green);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//��ǰϵͳ���
		}catch(Exception e){
			e.printStackTrace();
		}
		MainFrame mf= new MainFrame();
		mf.loadPanel();
	}
	
	private void loadPanel(){
		cPanel=new ChooseIdentityPanel(this);
		this.add(cPanel);		
		cPanel.showPanel();
	}
	
	//����Ĵ���ʵ����ҳ����ת
	void loadLoginPanel(){
		if(cPanel.getIdentity()=="general manager"){
			gmLogPanel=new GManagerLoginPanel(this);
			this.cPanel.setVisible(false);
			this.remove(cPanel);
			this.add(gmLogPanel);
			gmLogPanel.showPanel();
		}
	
	    else if(cPanel.getIdentity()=="administrator"){
			adminLogPanel=new AdministratorLoginPanel(this);
			this.cPanel.setVisible(false);
			this.remove(cPanel);
			this.add(adminLogPanel);
			adminLogPanel.showPanel();
		}
	}
	void backChooseIdPanel(){
		if(cPanel.getIdentity()=="general manager"){
			cPanel.setIdentity("null");
			this.gmLogPanel.setVisible(false);
			this.remove(gmLogPanel);
		}
	
		else if(cPanel.getIdentity()=="administrator"){
			cPanel.setIdentity("null");
			this.adminLogPanel.setVisible(false);
			this.remove(adminLogPanel);
		}
		this.loadPanel();
	}
	
}

