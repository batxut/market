package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import view.gm.ModGoodsPanel;
import view.gm.OnSalesStrategy;

public class IndividualPanel extends JPanel{
	/**�����Ǹ���ҳ��ľ���ʵ�֣���������������ҳ��ĸ���
	 * �������ṩ�˸���ҳ����ͬ��ģ��
	 */
	private static final long serialVersionUID = 1L;
	

	JTabbedPane tabPane=new JTabbedPane();

	ModGoodsPanel modifyGoodsPanel;
	OnSalesStrategy onSalesPanel;


	JPanel selfInfoPanel=new JPanel();

	IndividualPanel(){
		this.setBounds(0, 100, 940, 680);
		this.setBackground(Color.pink);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	
	void initComponent(){		
		tabPane.setBounds(0,10, 940, 680);
		tabPane.setTabPlacement(JTabbedPane.TOP);

		modifyGoodsPanel=new ModGoodsPanel();
		onSalesPanel=new OnSalesStrategy();
		tabPane.setFont(getFont().deriveFont(Font.BOLD,16));
		tabPane.addTab("������Ʒ",modifyGoodsPanel);
		tabPane.addTab("�ƶ�����",onSalesPanel);
		
		tabPane.addTab("������Ϣ",selfInfoPanel);
		this.add(tabPane);
		tabPane.setVisible(true);
		loadPanel1();
		loadPanel2();
		loadPanel3();
	
		this.repaint();
	}
	

	void loadPanel1(){
		
	}
	void loadPanel2(){
	
	}
	void loadPanel3(){
		selfInfoPanel.setLayout(null);
		JLabel jLab3=new JLabel("���Ļ�����Ϣ���£�");
		jLab3.setBounds(20, 15, 160, 30);
		selfInfoPanel.add(jLab3);
	}
	
	void showPanel(){
		initComponent();
	}
}