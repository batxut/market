package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class MainFrame extends JFrame{
	/**该类是client程序的入口
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Toolkit tk=Toolkit.getDefaultToolkit();
	
	//相应的页面的声明
	SalesmanLoginPanel salLogPanel;
	
	public MainFrame(){
		this.setBounds(200,10,940+6, 680+28);
		this.setTitle("连锁商店购物系统----南京大学软件学院");
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
		try {

//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif风格，外观接近windows经典，但宽宽大大，而且不是黑灰主色，而是蓝黑
			} catch (Exception e) {
			e.printStackTrace();
			}
		MainFrame mf= new MainFrame();
		mf.loadLoginPanel();
	}
	
	
	//下面的代码实现了页面跳转
	public int loadLoginPanel(){
			salLogPanel=new SalesmanLoginPanel(this);
			this.add(salLogPanel);
			salLogPanel.showPanel();
			return 1;
		
	}

}
