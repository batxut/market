package server.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlers.CheckGoodsControler;
import data.Goods;
import Interface.CheckGoodsInterface;

public class CheckGoodsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList <Goods> goods;
	ArrayList <Goods> goodsOfCheck=new ArrayList<Goods>();
	
	JButton check;
	JLabel title;
	JTable goodsInfo;
	JScrollPane goodsInfoPane;

	
	private String []columnNames={"ID","名称","价格","数量","预计天数","预计报废率"};
	private String [][]rowData;
	DefaultTableModel mod=new DefaultTableModel(null,columnNames);
	
	public CheckGoodsPanel(ArrayList <Goods> goods){
		this.goods=goods;
		this.setLayout(null);
	}
	
	//初始化相应的组件
	private void initComponent(){
		check=new JButton("查询");
		check.setBounds(440, 15, 80, 30);
		check.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				CheckGoodsInterface controler=new CheckGoodsControler();
				goodsOfCheck=controler.analyseStorage();
				if(goodsOfCheck!=null){
					rowData=showGoodsInfo();
					mod = new DefaultTableModel(rowData,columnNames);
					remove(goodsInfoPane);
					loadGoodsInfo();
				}
				else{
					JOptionPane.showMessageDialog(CheckGoodsPanel.this, "库存中没有商品！",
							"提示", 1);
				}
			}
		});
		this.add(check);
		
		this.loadGoodsInfo();
		
		title=new JLabel("库存分析列表");
		title.setBounds(300,20,100,20);
		this.add(title);
		
	}
	private void loadGoodsInfo(){
		goodsInfo=new JTable(mod);
		goodsInfo.setEnabled(false);
		
		goodsInfoPane=new JScrollPane(goodsInfo);
		goodsInfoPane.setBounds(30, 70, 745, 420);
		this.add(goodsInfoPane);
	}
	public void showPanel() {
		initComponent();
	}
	
	private String[][] showGoodsInfo(){//ID","名称","数量","价格","预计天数","预计报废率"
		String[][] rowData = new String[goodsOfCheck.size()][6];
		for (int i = 0; i < goodsOfCheck.size(); i++) {
			Goods goods =   goodsOfCheck.get(i);
			rowData[i][0] = goods.getID();
			rowData[i][1] = goods.getName();
			rowData[i][2] = Double.toString(goods.getOriginalCost());
			rowData[i][3] = String.valueOf(goods.getPresentNum());
			if(goods.getPredict_days()!=-1)
				rowData[i][4] = ""+goods.getPredict_days();  
			else
				rowData[i][4] = "-";
			if(goods.getPredict_Scrap_Rate()!=-1)
				rowData[i][5] = ""+goods.getPredict_Scrap_Rate();
			else
				rowData[i][4] = "-";
		}
		return rowData;
	}
}
