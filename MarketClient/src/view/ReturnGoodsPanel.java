package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import connect.ConnectStoreServer;

import logic.*;

import client_interface.Calculate;
import client_interface.ListOperation;
import client_interface.SaveInfo;
import client_interface.SearchBill;
import client_interface.SearchGoods;


import data.*;
import data.user.Salesman;

public class ReturnGoodsPanel extends JPanel {
	/**
	 * 
	 */			
	private static final long serialVersionUID = 1L;
	private ListOperation listOperation;
	private SaveInfo saveInfo = new SaveInfoControll();
	int selIndex = -1;

	Salesman sal;
	public ArrayList<Goods> goodsList, goodsReturnList;
	Bill bill;
	Goods good;

	JLabel inputGoods;
	JLabel goodsType, goodsNum, goodsPrice;
	JTextField searchBox, numBox;
	JButton checkItem, returnItem, addItem, deleteItem, endItem;

	JLabel goodsInfoShow;
	JTable billsInfo, goodsInfo;
	JScrollPane goodsInfoPane, billInfoPane;

	JLabel returnGoodsInfoShow, returnListShow;
	JTable returnGoodsInfo;
	JScrollPane returnGoodsInfoPane;

	private String[] columnNames = { "商品标识", "描述", "数量", "价格", "特价", "本项商品总价" };
	private String[] columnNames1 = { "商品标识", "描述", "购买数量", "价格", "特价",
			"本项商品总价" };
	private String[][] rowData;

	MyTableModel mod = new MyTableModel(null, columnNames);
	DefaultTableModel returnListMod = new DefaultTableModel(null, columnNames1);
	public ReturnGoodsPanel() {
		this.setLayout(null);
	}

	// 初始化相应的组件
	private void initComponent() {

		inputGoods = new JLabel("退货操作：");
		inputGoods.setBounds(20, 0, 100, 30);
		this.add(inputGoods);

		goodsType = new JLabel("销售记录号：");
		goodsType.setBounds(20, 30, 80, 30);
		this.add(goodsType);

		searchBox = new JTextField();
		searchBox.setBounds(90, 35, 100, 30);
		this.add(searchBox);

		checkItem = new JButton("查询");
		checkItem.setBounds(200, 35, 90, 30);
		checkItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (searchBox.getText().equals(""))
					JOptionPane.showMessageDialog(ReturnGoodsPanel.this, "不能为空");
				else {
					listOperation = new ListOperationControll();
					SearchBill searchBill = new SearchBillControll();
					String ID = searchBox.getText();
					bill = searchBill.searchBill(ID);
					
					if (bill != null) {
						goodsList = bill.getGoods();
						for(int i=0;i<goodsList.size();i++){
							int num=goodsList.get(i).getNumBought();
							goodsList.get(i).setPresentNum(num);
							goodsList.get(i).setNumBought(0);
						}
						
						goodsReturnList = new ArrayList<Goods>();
						mod = new MyTableModel(showGoodsInfo(goodsList,1),
								columnNames);
						removeAll();
						initComponent();
						searchBox.setText(ID);
					} else {
						JOptionPane.showMessageDialog(ReturnGoodsPanel.this,
								"没有对应的账单", "提示", 1);
						searchBox.setText(null);
					}
				}
			}
		});
		this.add(checkItem);

		goodsNum = new JLabel("商品数量");
		goodsNum.setBounds(520, 235, 90, 30);
		this.add(goodsNum);

		numBox = new JTextField("1");
		numBox.setBounds(610, 235, 90, 30);
		this.add(numBox);

		addItem = new JButton("确定添加");
		addItem.setBounds(720, 235, 90, 30);
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (selIndex == -1) {
					JOptionPane.showMessageDialog(ReturnGoodsPanel.this,
							"请先选中列表中的一行再添加", "警告", 2);
				} else {
					String ID = goodsList.get(selIndex).getID();
					selIndex = -1;
					good = searchInBill(ID, goodsList);// 账单中的搜索出来的商品
						// removeAll();
						// initComponent();
						int number = Integer.parseInt(numBox.getText());
						if ((number-good.getNumBought() )> good.getPresentNum()) {
							numBox.setText("");
							JOptionPane.showMessageDialog(
									ReturnGoodsPanel.this,
									"你输入的商品数量超出购买数量，请您重新设置数量", "警告", 2);
							// removeAll();
							// initComponent();
						} else {
							listOperation.addGoods(goodsReturnList, good,
									-number);
							// System.out.print(good.getNumber());
						}

						returnListMod = new DefaultTableModel(
								showGoodsInfo(goodsReturnList,2), columnNames1);
						removeAll();
						initComponent();
						numBox.setText("1");

				}
			}

		});
		this.add(addItem);

		deleteItem = new JButton("确定删除");
		deleteItem.setBounds(820, 235, 90, 30);
		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (selIndex == -1) {
					JOptionPane.showMessageDialog(ReturnGoodsPanel.this,
							"请先选中上面列表中的一行再删除", "警告", 2);
				} else {
					int originalSize = goodsReturnList.size();
					String ID = goodsList.get(selIndex).getID();
					selIndex = -1;
					good = searchInBill(ID, goodsList);
					goodsReturnList = listOperation.deleteGoods(
							goodsReturnList, good);
					if (goodsReturnList.size() == originalSize) {
						JOptionPane.showMessageDialog(ReturnGoodsPanel.this,
								"你找的商品不在退货列表中，请您重新输入", "警告", 2);
						repaint();
					}
					rowData = showGoodsInfo(goodsReturnList,2);
					returnListMod = new DefaultTableModel(rowData, columnNames1);
					removeAll();
					initComponent();
				}
			}
		});
		this.add(deleteItem);

		endItem = new JButton("确定退货");
		endItem.setBounds(820, 455, 90, 30);
		endItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Calculate calculateDue = new CalculateControll();
				double returnMoney = calculateDue.calculateDue(goodsReturnList);
				if (returnMoney < 0)
					returnMoney = -returnMoney;
				DecimalFormat df = new DecimalFormat("#.00");
				String s = "库存更新成功，应该找零： " + df.format(returnMoney);
				JOptionPane
						.showMessageDialog(ReturnGoodsPanel.this, s, "提示", 1);
				SearchGoods searchGoods=new SearchGoodsControll();
				for(int i=0;i<goodsReturnList.size();i++){
					String ID=goodsReturnList.get(i).getID();
					Goods good=searchGoods.searchGood(ID);
					good.setNumBought(goodsReturnList.get(i).getNumBought());
				}
				saveInfo.refreshStroge(searchGoods.getGoodsList());
				for(int i=0;i<goodsList.size();i++){
				  int num=goodsList.get(i).getPresentNum()+goodsList.get(i).getNumBought();
				  goodsList.get(i).setNumBought(num);
				}
				saveInfo.saveBillInfo(bill);
				
			    goodsList=null;
			    goodsReturnList=null;
				bill=null;
				good=null;
				ReturnGoodsPanel.this.remove(goodsInfoPane);
				ReturnGoodsPanel.this.remove(billInfoPane);
				mod = new MyTableModel(null, columnNames);
				returnListMod = new DefaultTableModel(null, columnNames1);
				loadBillInfo();
				loadGoodsInfo();
				repaint();
			}
		});
		this.add(endItem);
		//
		goodsInfoShow = new JLabel("符合退货商品信息显示：");
		goodsInfoShow.setBounds(20, 65, 160, 30);
		this.add(goodsInfoShow);

		returnListShow = new JLabel("退货列表：");
		returnListShow.setBounds(20, 270, 160, 30);
		this.add(returnListShow);

		this.loadBillInfo();
		this.loadGoodsInfo();

	}

	private void loadGoodsInfo() {
		goodsInfo = new JTable(returnListMod);
		goodsInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		goodsInfoPane = new JScrollPane(goodsInfo);
		goodsInfoPane.setBounds(20, 300, 890, 150);
		goodsInfoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		goodsInfoPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(goodsInfoPane);

	}

	void showPanel(Salesman sal) {
		this.sal = sal;
		initComponent();
	}

	private void loadBillInfo() {
		billsInfo = new JTable(mod);
		billsInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		billsInfo.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						selIndex = billsInfo.getSelectedRow();
					}

				});
		billInfoPane = new JScrollPane(billsInfo);
		billInfoPane.setBounds(20, 100, 890, 130);
		billInfoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		billInfoPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(billInfoPane);
	}

	private String[][] showGoodsInfo(ArrayList<Goods> goodsList,int sign) {
		String[][] rowData = new String[goodsList.size()][6];
		for (int i = 0; i < goodsList.size(); i++) {

			Goods good = goodsList.get(i);
			int number ;
			if(sign==1)
		    number=goodsList.get(i).getPresentNum(); 
			else
				number=goodsList.get(i).getNumBought();
			if (number < 0)
				number = -number;
			DecimalFormat df = new DecimalFormat("#.00");

			rowData[i][0] = good.getID();
			rowData[i][1] = good.getName();
			rowData[i][2] = Integer.toString(number);
			rowData[i][3] = df.format(good.getOriginalCost());
			rowData[i][4] = df.format(good.getSalesCost());
			rowData[i][5] = df.format(number
					* (Double.parseDouble(rowData[i][4])));
		}
		return rowData;
	}

	private Goods searchInBill(String ID, ArrayList<Goods> goodsInBill) {
		for (int i = 0; i < goodsInBill.size(); i++) {
			Goods temp = goodsInBill.get(i);
			if (temp.getID().equals(ID))
				return temp;
		}
		return null;
	}
}

class MyTableModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTableModel(String[][] rowData2, String[] columnNames1) {
		super(rowData2, columnNames1);
	}

	public boolean isCellEditable(int row, int col) {

		return false;

	}
}