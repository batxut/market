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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import connect.ConnectStoreServer;

import logic.*;

import client_interface.Calculate;
import client_interface.ListOperation;
import client_interface.SaveInfo;
import client_interface.SearchBill;
import client_interface.SearchGoods;
import client_interface.SearchUser;


import data.*;
import data.strategy.AmountGiftStra;
import data.user.Salesman;
import data.user.VIPCustomer;

public class SellGoodsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Bill bill_;
	Goods good;
	Goods presentGood=null;//CHANGE
	AmountGiftStra stra;
	private ListOperation listOperation;
	private Calculate calculate;
    //private SearchGoods searchGoods;
	private SearchBill searchBill = new SearchBillControll();
	private SaveInfo saveInfo = new SaveInfoControll();
	private SearchUser searchUser = new SearchUserControll();
	ArrayList<Goods> goodsList = new ArrayList<Goods>();
	Salesman sal;
	VIPCustomer vip = null;

	JLabel list, present, bill, wayOfPay, productID, productNumber, due,
			actualPay;
	JTextField searchBox, searchVIPBox, goodsNumber, cashContent, dueContent,
			changeContent;
	JButton searchVIP, search, add, delete, back, endEnter, wayOfPay0,
			wayOfPay1, endTask, change;
	JTable goodInfo, goodListInfo, presentListInfo;
	JScrollPane goodInfoPane, goodListInfoPane, presentListInfoPane,
			billInfoPane;
	JTextArea billBox;

	private String[] columnNames = { "商品标识", "描述", "库存数量", "价格", "特价" };
	private String[] columnNames1 = { "商品标识", "描述", "购买数量", "价格", "特价",
			"本项商品总价" };
	private String[] columnNames2 = { "商品标识", "描述", "数量", "赠送方式" };
	private String[][] rowData1;
	private String[][] rowData2;
	private String[][] rowData3;
	DefaultTableModel mod = new DefaultTableModel(rowData1, columnNames);
	DefaultTableModel goodListMod = new DefaultTableModel(rowData2,
			columnNames1);
	DefaultTableModel presentListMod = new DefaultTableModel(rowData3,
			columnNames2);

	public SellGoodsPanel() {
		this.setLayout(null);
	}

	// 相应组件的初始化
	public int initComponent() {  
		
		list = new JLabel("商品列表");
		list.setBounds(440, 175, 100, 30);
		this.add(list);

		searchVIPBox = new JTextField();
		searchVIPBox.setBounds(20, 20, 120, 30);
		this.add(searchVIPBox);

		searchBox = new JTextField();
		searchBox.setBounds(730, 20, 120, 30);
		this.add(searchBox);

		goodsNumber = new JTextField("1");
		goodsNumber.setBounds(110, 140, 120, 30);
		this.add(goodsNumber);

		searchVIP = new JButton("标记会员");
		searchVIP.setBounds(140, 20, 90, 30);
		searchVIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				vip = searchUser.searchVIP(searchVIPBox.getText());
				if (vip != null) {
					new VIPDialog(vip);
				} else {
					JOptionPane.showMessageDialog(SellGoodsPanel.this,
							"没有对应的VIP", "提示", 1);
				}
			}
		});
		this.add(searchVIP);

		productID = new JLabel("商品ID");
		productID.setBounds(670, 20, 90, 30);
		this.add(productID);

		productNumber = new JLabel("商品数量");
		productNumber.setBounds(20, 140, 90, 30);
		this.add(productNumber);

		search = new JButton("检索");
		search.setBounds(850, 20, 60, 30);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (searchBox.getText().equals(""))
					JOptionPane.showMessageDialog(SellGoodsPanel.this, "不能为空");
				else {
					SearchGoods searchGoods=new SearchGoodsControll();//CHANGE
					String ID = searchBox.getText().trim();
					good = searchGoods.searchGood(ID);
					if (good != null) {
						// good.setNumBought(0);
						mod = showOriginalInfo();
						searchBox.setText("");
						int num = Integer.parseInt(goodsNumber.getText());
						removeAll();
						initComponent();
						repaint();
						goodsNumber.setText(Integer.toString(num));
					} else {
						JOptionPane.showMessageDialog(SellGoodsPanel.this,
								"没有对应的商品", "提示", 1);
						searchBox.setText(null);
					}
				}
			}
		});

		this.add(search);

		endEnter = new JButton("结束输入");
		endEnter.setBounds(430, 480, 90, 30);
		endEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showPresentContent();
				endEnter();
				showBillContent();
			}
		});
		this.add(endEnter);

		add = new JButton("确认添加");
		add.setBounds(230, 140, 100, 30);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int numBought = Integer.parseInt(goodsNumber.getText());
				if (good == null) {
					JOptionPane.showMessageDialog(null, "请先检索后添加");
				} else {
					int number = Integer.parseInt(goodsNumber.getText());
					boolean overflow=new CalculateControll().overflow(number,goodsList,good);
					if (overflow) {
						searchBox.setText("");
						JOptionPane.showMessageDialog(SellGoodsPanel.this,
								"你输入的商品数量超出库存，请您重新输入", "警告", 2);
						removeAll();
						initComponent();
					} else {
						listOperation.addGoods(goodsList, good, numBought);
						// System.out.print(good.getNumber());
					}

					rowData2 = showGoodsInfo();
					goodListMod = new DefaultTableModel(rowData2, columnNames1);
					removeAll();
					initComponent();
				}
			}
		});
		this.add(add);

		delete = new JButton("确认删除");
		delete.setBounds(810, 140, 100, 30);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int originalSize = goodsList.size();
				goodsList = listOperation.deleteGoods(goodsList, good);
				if (goodsList.size() == originalSize) {
					JOptionPane.showMessageDialog(SellGoodsPanel.this,
							"你找的商品不在商品列表中，请您重新输入", "警告", 2);
					repaint();
				}
				rowData2 = showGoodsInfo();
				goodListMod = new DefaultTableModel(rowData2, columnNames1);
				removeAll();
				initComponent();
			}
		});
		this.add(delete);

		loadGoodsInfo();

		return 1;
	}

	void initsaleComponent() {
		this.removeAll();
		initComponent();
		this.repaint();
	}

	int initEndComponent() {
		present = new JLabel("赠品列表");
		present.setBounds(440, 20, 100, 30);
		this.add(present);

		bill = new JLabel("账单信息");
		bill.setBounds(230, 160, 100, 30);
		this.add(bill);

		wayOfPay = new JLabel("支付方式");
		wayOfPay.setBounds(580, 160, 100, 30);
		this.add(wayOfPay);

		wayOfPay0 = new JButton("现金支付");
		wayOfPay0.setBounds(550, 270, 100, 30);
		wayOfPay0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showPayPanel(0);
			}
		});
		this.add(wayOfPay0);

		wayOfPay1 = new JButton("积分兑换");
		wayOfPay1.setBounds(550, 350, 100, 30);
		wayOfPay1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (vip == null) {
					JOptionPane.showMessageDialog(SellGoodsPanel.this,
							"由于销售开始没有标记会员，只能选择现金支付", "警告", 2);
					repaint();
				} else
					showPayPanel(1);
			}
		});
		this.add(wayOfPay1);

		endTask = new JButton("结束销售");
	    endTask.setBounds(810, 485, 100, 30);
		endTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (changeContent != null&&(changeContent.getText().equals("")==false)) {
					if(presentGood!=null)
						listOperation.addGoods(goodsList, presentGood, 1);
					SearchGoods searchGoods=new SearchGoodsControll();
					calculate.calculatepresentNum(goodsList, searchGoods);
					if (vip != null) {
						saveInfo.refreshVIPInfo(vip);
					}
					saveInfo.saveBillInfo(bill_);
					saveInfo.refreshStroge(searchGoods.getGoodsList());
				}
				else{
					JOptionPane.showMessageDialog(SellGoodsPanel.this,
							"由于交易没有结束，此次数据将不会进行·保存", "警告", 2);
				}
				removeAll();
				rowData1 = null;
				rowData2 = null;
				rowData3 = null;
				if (changeContent != null)
					changeContent.setText("");
				mod = new DefaultTableModel(rowData1, columnNames);
				goodListMod = new DefaultTableModel(rowData2, columnNames1);
				presentListMod = new DefaultTableModel(rowData3, columnNames2);
				goodsList.clear();
				initComponent();
				repaint();
				good = null;
				vip = null;
			}
		});
		this.add(endTask);

		billBox = new JTextArea();
		billInfoPane = new JScrollPane(billBox);
		billInfoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		billInfoPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		billInfoPane.setBounds(20, 190, 440, 330);
		billBox.setEditable(false);
		this.add(billInfoPane);

		loadPresentInfo();

		return 1;
	}

	private void loadGoodsInfo() {
		goodInfo = new JTable(mod);
		goodInfo.setEnabled(false);

		goodListInfo = new JTable(goodListMod);
		goodListInfo.setEnabled(false);

		goodInfoPane = new JScrollPane(goodInfo);
		goodInfoPane.setBounds(20, 55, 890, 80);
		this.add(goodInfoPane);

		goodListInfoPane = new JScrollPane(goodListInfo);
		goodListInfoPane.setBounds(20, 215, 890, 250);
		goodListInfoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		goodListInfoPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(goodListInfoPane);
	}

	private void loadPresentInfo() {
		presentListInfo = new JTable(presentListMod);
		presentListInfo.setEnabled(false);

		presentListInfoPane = new JScrollPane(presentListInfo);
		presentListInfoPane.setBounds(20, 50, 890, 100);
		presentListInfoPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		presentListInfoPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(presentListInfoPane);
	}

	private void showPayPanel(int i) {

		if (i == 0) {
			if (change != null) {
				this.remove(change);
				this.remove(due);
				this.remove(actualPay);
				this.remove(changeContent);
				this.remove(dueContent);
				this.remove(cashContent);
			}
			change = new JButton();
			due = new JLabel();
			actualPay = new JLabel();
			due.setText("应付");
			actualPay.setText("实付");
			due.setBounds(680, 190, 70, 30);
			this.add(due);
			this.add(change);
			actualPay.setBounds(680, 270, 70, 30);
			this.add(actualPay);
			change.setText("找零");
			change.setBounds(680, 350, 70, 30);
			change.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					calculateChange();
					double cash = Double.parseDouble(cashContent.getText());
					if (vip == null)
						bill_ = new Bill(goodsList, 1, sal.getID(), false,
								cash, false, 0, "");
					else {
						bill_ = new Bill(goodsList, 1, sal.getID(), false,
								cash, true, 0, vip.getID());
						int point = (int) Double.parseDouble(dueContent
								.getText());
						vip.setlift_point(vip.getleft_point() + point);
						vip.setPoint(vip.getPoint() + point);
					}
					int bill_ID = searchBill.getBills().size() + 1;
					bill_.setID(bill_ID);
					// ArrayList<Bill>bills=new ArrayList<Bill>();
					// bills.add(bill_);
					// try {
					// ObjectOutputStream os = new ObjectOutputStream(
					// new FileOutputStream("src/related data/bill.txt"));
					// os.writeObject(bills);
					// os.close();
					// } catch (IOException ex) {
					// ex.printStackTrace();
					// }
					String s = bill_.toString();
					billBox.setText(s);
				}
			});
			dueContent = new JTextField("");
			dueContent.setEditable(false);
			dueContent.setBounds(750, 190, 100, 30);
			this.add(dueContent);

			cashContent = new JTextField("");
			cashContent.setBounds(750, 270, 100, 30);
			this.add(cashContent);

			changeContent = new JTextField("");
			changeContent.setEditable(false);
			changeContent.setBounds(750, 350, 100, 30);
			this.add(changeContent);
			DecimalFormat df = new DecimalFormat("#.00");
			double totalmoney = calculate.calculateDue(goodsList);
			double discount = new SalesStra().getAmountDiscount(totalmoney);
			if (discount != 1) {
				String info = "此次购物原价  " + df.format(totalmoney) + "元，"
						+ "\n可以享受" + df.format(discount * 10) + "折优惠，\n"
						+ "打折后价格： " + df.format(discount * totalmoney) + "元";
				JOptionPane.showMessageDialog(SellGoodsPanel.this, info,
						"提示", 1);
			}
			dueContent.setText(df.format(totalmoney * discount));

			repaint();

		} else {
			if (change != null) {
				this.remove(change);
				this.remove(due);
				this.remove(actualPay);
				this.remove(changeContent);
				this.remove(dueContent);
				this.remove(cashContent);
			}
			change = new JButton();
			due = new JLabel();
			actualPay = new JLabel();
			due.setText("应付积分");
			actualPay.setText("现有积分");
			due.setBounds(680, 280, 70, 20);
			this.add(due);
			this.add(change);
			actualPay.setBounds(680, 350, 70, 30);
			this.add(actualPay);

			change.setText("剩余积分");
			change.setBounds(660, 420, 80, 30);
			change.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					double totalmoney = calculate.calculateDue(goodsList);
					double afterdiscount = totalmoney
							* new SalesStra().getAmountDiscount(totalmoney);
					int point = (int) afterdiscount * 50;
					int left_point = vip.getleft_point() - point;
					if (left_point < 0)
						JOptionPane.showMessageDialog(SellGoodsPanel.this,
								"积分余额不足", "提示", 1);
					else {
						changeContent.setText(String.valueOf(left_point));
						bill_ = new Bill(goodsList, 1, sal.getID(), true, 0,
								true, point, vip.getID());
						bill_.setVIP(vip);
						int bill_ID = searchBill.getBills().size() + 1;
						bill_.setID(bill_ID);

						String s = bill_.toString();
						billBox.setText(s);
						vip.setlift_point(left_point);
					}

				}
			});
			this.add(change);

			double totalmoney = calculate.calculateDue(goodsList);
			double afterdiscount = totalmoney
					* new SalesStra().getAmountDiscount(totalmoney);
			int point = (int) afterdiscount * 50;
			dueContent = new JTextField(String.valueOf(point));
			dueContent.setEditable(false);
			dueContent.setBounds(750, 280, 100, 30);
			this.add(dueContent);

			cashContent = new JTextField(String.valueOf(vip.getleft_point()));
			cashContent.setBounds(750, 350, 100, 30);
			cashContent.setEditable(false);
			this.add(cashContent);

			changeContent = new JTextField("");
			changeContent.setEditable(false);
			changeContent.setBounds(750, 420, 100, 30);
			this.add(changeContent);
			repaint();
		}

	}

	void showPanel(Salesman sal) {
		this.sal = sal;
		listOperation = new ListOperationControll();
		calculate = new CalculateControll();
		initComponent();
	}

	int endEnter() {
		this.removeAll();
		initEndComponent();
		this.repaint();
		return 1;
	}

	private void calculateChange() {
		double due = Double.parseDouble(this.dueContent.getText());
		double cash = Double.parseDouble(this.cashContent.getText());
		double change=cash -due;
		DecimalFormat df = new DecimalFormat("#.00");
		if (change >= 0)
			changeContent.setText(df.format(change));
		else{
			JOptionPane.showMessageDialog(SellGoodsPanel.this,
					"实付金额不足，请重新输入", "警告", 2);
		}
	}

	private void showBillContent() {
		String content = "购买的商品：" + "\n";
		DecimalFormat df = new DecimalFormat("#.00");
		for (int i = 0; i < goodsList.size(); i++) {
			Goods good = goodsList.get(i);
			String name = good.getName();
			String number = Integer.toString(goodsList.get(i).getNumBought());
			double unit = 0;
			if (good.getOnsaleStrategy() != null)
				unit = good.getOnsaleStrategy().getBargainPrice();
			else
				unit = good.getOriginalCost();
			String unitPrice = df.format(unit);
			String totalPrice = df.format((goodsList.get(i).getNumBought())
					* unit);
			String info = name + "\t" + unitPrice + "*" + number + "\t"
					+ totalPrice;
			content += info;
			content += "\n";
		}
		double totalmoney = calculate.calculateDue(goodsList);
		double afterdiscount = totalmoney
				* new SalesStra().getAmountDiscount(totalmoney);
		int point = (int) afterdiscount * 50;
		String due = df.format(afterdiscount);
		content += "应收：" + "\t" + due + "元" + "\n";
		content += "(积分支付：" + String.valueOf(point) + "点）";
		billBox.setText(content);
	}

	private String[][] showGoodsInfo() {
		String[][] rowData = new String[goodsList.size()][6];
		for (int i = 0; i < goodsList.size(); i++) {

			Goods good = goodsList.get(i);
			int number = goodsList.get(i).getNumBought();
			DecimalFormat df = new DecimalFormat("#.00");

			rowData[i][0] = good.getID();
			rowData[i][1] = good.getName();
			rowData[i][2] = Integer.toString(number);
			rowData[i][3] = df.format(good.getOriginalCost());
			if (good.getOnsaleStrategy() != null)
				rowData[i][4] = df.format(good.getOnsaleStrategy()
						.getBargainPrice());
			else
				rowData[i][4] = df.format(good.getOriginalCost());
			rowData[i][5] = df.format(number
					* (Double.parseDouble(rowData[i][4])));
		}
		return rowData;
	}

	private DefaultTableModel showOriginalInfo() {
		DecimalFormat df = new DecimalFormat("#.00");
		rowData1 = new String[1][5];
		rowData1[0][0] = good.getID();
		rowData1[0][1] = good.getName();
		rowData1[0][2] = Integer.toString(good.getPresentNum());
		rowData1[0][3] = df.format(good.getOriginalCost());
		if (good.getOnsaleStrategy() != null)
			rowData1[0][4] = df.format(good.getOnsaleStrategy()
					.getBargainPrice());
		else
			rowData1[0][4] = df.format(good.getOriginalCost());
		mod = new DefaultTableModel(rowData1, columnNames);
		return mod;
	}

	private void showPresentContent() {
		int presentNum = 0;
		for (int i = 0; i < goodsList.size(); i++) {
			if (goodsList.get(i).getGoodGiftStra() != null) {
				presentNum++;
			}
		}
		stra = new SalesStra().getAmountGiftStra(calculate
				.calculateDue(goodsList));
		if (stra != null) {
			presentNum++;
		}

		String[][] rowData3 = new String[presentNum][4];
		int index = 0;
		for (int i = 0; i < goodsList.size(); i++) {
			if (goodsList.get(i).getGoodGiftStra() != null) {
				rowData3[index][0] = goodsList.get(i).getGoodGiftStra()
						.getgiftgoodID();
				rowData3[index][1] = goodsList.get(i).getGoodGiftStra()
						.getgiftgoodname();
				rowData3[index][2] = Integer
						.toString((goodsList.get(i).getNumBought())
								* (goodsList.get(i).getGoodGiftStra()
										.getgiftGoodNum()));
				rowData3[index][3] = "商品赠送";
				index++;
			}
		}
		if (stra != null) {
			rowData3[presentNum - 1][0] = stra.getgiftgoodID();
			rowData3[presentNum - 1][1] = stra.getgiftgoodname();
			rowData3[presentNum - 1][2] = Integer.toString(stra
					.getgiftGoodNum());
			rowData3[presentNum - 1][3] = "总额赠送";
			SearchGoods searchGoods=new SearchGoodsControll();
			presentGood = searchGoods.searchGood(stra.getgiftgoodID());
			presentGood.setIsfreeGift(true);
		}
		presentListMod = new DefaultTableModel(rowData3, columnNames2);
	}

}
