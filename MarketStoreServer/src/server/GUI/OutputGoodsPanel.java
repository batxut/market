package server.GUI;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlers.Output_GoodsControler;
import data.Goods;
import data.MyDate;
import Interface.Output_GoodsInterface;

public class OutputGoodsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private ArrayList<Goods> goods_searched=new ArrayList<Goods>();
	private ArrayList<Goods> goods_deleted=new ArrayList<Goods>();
	private Output_GoodsInterface controler =  new Output_GoodsControler();

	JLabel outputGoods;
	JLabel checkWay;
	Choice choice;
	JTextField checkBox;
	JButton check;

	JLabel goodsInfoShow;
	JTable goodsInfo;
	JScrollPane goodsInfoPane;
	JButton delItem;

	JLabel outputGoodsInfoShow;
	JTable outputGoodsInfo;
	JScrollPane outputGoodsInfoPane;
	
	JLabel outputNumshow;
	JTextField outputNumBox;
	
	JLabel reason;
	 
	JCheckBox reason1=new JCheckBox("转移到其他店铺",false);
	JCheckBox reason2=new JCheckBox("到期报废",false);
	JCheckBox reason3=new JCheckBox("个别残次品",false);
	JCheckBox reason4=new JCheckBox("批次质量缺陷",false);

	private String nameCheck = "名称查询", IDCheck = "ID查询", priceCheck = "价格查询",numberCheck="数量查询";
	private String[] searched_columnNames = { "名称", "ID", "价格","库存数量" };
	private String[] delete_columnNames = {"名称","ID","价格","出库数量"};
	private String[][] goodsInfo_rowData;
	private String[][] output_goodInfo_rowData;
	DefaultTableModel goodsInfoMod = new DefaultTableModel(null,searched_columnNames);
	DefaultTableModel outputGoodsInfoMod=new DefaultTableModel(null,delete_columnNames);

	public OutputGoodsPanel(ArrayList<Goods> goods) {
		this.goods_searched = goods;
		this.setLayout(null);
	}

	// 初始化相应的组件
	private void initComponent() {
		checkWay = new JLabel("请选择查询方式：");
		checkWay.setBounds(30, 10, 120, 30);
		this.add(checkWay);

		choice = new Choice();
		choice.add(nameCheck);
		choice.add(IDCheck);
		choice.add(priceCheck);
		choice.add(numberCheck);
		choice.setBounds(150, 18,80,30);
		this.add(choice);

		checkBox = new JTextField();
		checkBox.setBounds(260, 15, 120, 30);
		this.add(checkBox);
		
		outputNumshow = new JLabel("出库数量:");
		outputNumshow.setBounds(540,80,80,20);
		this.add(outputNumshow);
		
		outputNumBox = new JTextField();
		outputNumBox.setBounds(620,75,80,30);
		this.add(outputNumBox);
		
		reason = new JLabel("出库原因:");
		reason.setBounds(540,105,120,20);
		this.add(reason);
		
		reason1.setBounds(540,130,120,20);
		this.add(reason1);
		reason2.setBounds(660,130,120,20);
		this.add(reason2);
		reason3.setBounds(540,155,120,20);
		this.add(reason3);
		reason4.setBounds(660,155,120,20);
		this.add(reason4);

		check = new JButton("查询");
		check.setBounds(420, 15, 80, 30);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Output_GoodsInterface controler=new Output_GoodsControler();
				String selected_item=choice.getSelectedItem();
				String input=checkBox.getText().trim();
				if(selected_item.equals(nameCheck)) goods_searched=controler.searchByType(input);
				if(selected_item.equals(IDCheck))  goods_searched=controler.searchByID(input);
				if(selected_item.equals(priceCheck)) goods_searched=controler.searchByPrice(Double.parseDouble(input));
				if(selected_item.equals(numberCheck)) goods_searched=controler.searchByNumber(Integer.parseInt(input));
				goodsInfo_rowData=showGoodsInfo();
				goodsInfoMod=new DefaultTableModel(goodsInfo_rowData, searched_columnNames);
				remove(goodsInfoPane);
				loadGoodsInfo();
			}
		});
		this.add(check);
		
		//
		goodsInfoShow = new JLabel("查询商品信息显示：");
		goodsInfoShow.setBounds(30, 40, 120, 30);
		this.add(goodsInfoShow);
		
		loadGoodsInfo();
		
		delItem = new JButton("确定出库");
		delItem.setBounds(540, 190, 100, 30);
		delItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(goods_searched!=null){
					for(int i=0;i<goods_searched.size();i++){
				goods_searched.get(i).setOutputDate(MyDate.getDate());
				goods_searched.get(i).setOutputNums(Integer.parseInt(outputNumBox.getText().trim()));
				goods_searched.get(i).setPresentNum(goods_searched.get(i).getPresentNum()-goods_searched.get(i).getOutputNums());
				goods_searched.get(i).setOutput_reason(reason1.isSelected(),reason2.isSelected(),reason3.isSelected(),reason4.isSelected());
					}
				}else{
					JOptionPane.showMessageDialog(OutputGoodsPanel.this, "没有找到相应商品！","提示", 1);
				}
				
				
				
				
				boolean delete_success=controler.deleteGoods(goods_searched);
				if(delete_success){
					goods_deleted.addAll(goods_searched);
					output_goodInfo_rowData=showOutputGoodsInfo();
					outputGoodsInfoMod=new DefaultTableModel(output_goodInfo_rowData, delete_columnNames);
					remove(outputGoodsInfoPane);
					loadOutputGoodsInfo();;
				}
			}
		});
		this.add(delItem);
		
		//
		outputGoodsInfoShow = new JLabel("出库商品信息显示：");
		outputGoodsInfoShow.setBounds(30, 220, 120, 30);
		this.add(outputGoodsInfoShow);

		this.loadOutputGoodsInfo();

	}

	private void loadGoodsInfo() {
		goodsInfo = new JTable(goodsInfoMod);
		goodsInfo.setEnabled(false);

		goodsInfoPane = new JScrollPane(goodsInfo);
		goodsInfoPane.setBounds(30, 80, 480, 120);
		this.add(goodsInfoPane);
	}
	
	private void loadOutputGoodsInfo() {
		outputGoodsInfo = new JTable(outputGoodsInfoMod);
		outputGoodsInfo.setEnabled(false);

		outputGoodsInfoPane = new JScrollPane(outputGoodsInfo);
		outputGoodsInfoPane.setBounds(30, 260, 720, 240);
		this.add(outputGoodsInfoPane);
	}
	public void showPanel() {
		initComponent();
	}
	
	private String[][] showGoodsInfo(){
		String[][] rowData;
		if(goods_searched==null) {
			rowData=new String[0][4];
			JOptionPane.showMessageDialog(OutputGoodsPanel.this, "没有找到相应商品！","提示", 1);
		}
		else{
			rowData = new String[goods_searched.size()][4];
			for (int i = 0; i < goods_searched.size(); i++) {
				Goods agoods =   goods_searched.get(i);
				rowData[i][0] = agoods.getName();
				rowData[i][1] = agoods.getID();
				rowData[i][2] = Double.toString(agoods.getOriginalCost());
				rowData[i][3] = Integer.toString(agoods.getPresentNum());    
			}
		}
		return rowData;
	}
	
	private String[][] showOutputGoodsInfo(){
		if(goods_deleted!=null){
			String[][] rowData = new String[goods_deleted.size()][4];
			for(int i=0; i<goods_deleted.size();i++){
				Goods agoods = goods_deleted.get(i);
				rowData[i][0] = agoods.getName();
				rowData[i][1] = agoods.getID();
				rowData[i][2] = Double.toString(agoods.getOriginalCost());
				rowData[i][3] = Integer.toString(agoods.getOutputNums());
			}
			return rowData;
		}
		else{
			JOptionPane.showMessageDialog(OutputGoodsPanel.this, "没有可出库商品！","提示", 1);
			return null;
		}
	}
	
}
