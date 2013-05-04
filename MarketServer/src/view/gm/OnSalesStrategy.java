package view.gm;

import java.awt.Font;

import javax.swing.*;


public class OnSalesStrategy extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsOnSale p2;
	AmountOnSale p3;
	GoodsSaleGiftPanel p4;
	AmountGift p5;
	RemoveStrategy p6;
	
	public OnSalesStrategy()
	{
		setLayout(null);
		p2=new GoodsOnSale();
		p3=new AmountOnSale();
		p4=new GoodsSaleGiftPanel();
		p5=new AmountGift();
		p6=new RemoveStrategy();
	}
	
	public void showPanel()
	{
		JTabbedPane tabPane1=new JTabbedPane();
		tabPane1.setTabPlacement(JTabbedPane.LEFT);
		tabPane1.setFont(getFont().deriveFont(Font.PLAIN, 16));
		tabPane1.addTab(" ��Ʒ�ؼ۴��� ",p2); 
		tabPane1.addTab(" �ܶ��ؼ۴��� ",p3);
		tabPane1.addTab(" ��Ʒ���ʹ��� ",p4);
		tabPane1.addTab(" �ܶ����ʹ��� ", p5);
		tabPane1.addTab("�Ƴ����д�������",p6);
		add(tabPane1);
		tabPane1.setBounds(0,20,960,540);
		tabPane1.setVisible(true);

		repaint();
	}
}
