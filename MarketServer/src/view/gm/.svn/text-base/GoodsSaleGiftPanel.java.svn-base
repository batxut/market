package view.gm;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SearchGoodsController;

import dataOperation.*;
import data.Goods;
import data.MyDate;
import data.strategy.GoodsGiftStra;


import server_interface.SearchGoods;
import view.MyTableModel;

public class GoodsSaleGiftPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField IDField;
	JTextField freeIDField;
	Choice freenum;
	
	JSpinner startDayField;
	JSpinner startMonthField;
	JSpinner startYearField;
	
	JSpinner endDayField;
	JSpinner endMonthField;
	JSpinner endYearField;
	MyDate currentDate;
	
	JTable goodInfo;
	MyTableModel mod;
	JScrollPane goodInfoPane;
	Goods temp;
	
	JTable freegoodInfo;
	MyTableModel mod1;
	JScrollPane freegoodInfoPane;
	Goods temp1;
	
	JTable total;
	MyTableModel mod2;
	JScrollPane totalInfoPane;
	
	ArrayList<Goods> goodlist;
	ArrayList<GoodsGiftStra> stralist;
	ArrayList<Goods> AllGoodsList;
	ArrayList<GoodsGiftStra> list;
	int selIndex;
	
	SearchGoods inter1;
	
	public GoodsSaleGiftPanel()
	{
		selIndex=-1;
		inter1=new SearchGoodsController();
		currentDate=MyDate.getDate();
		goodlist=new ArrayList<Goods>();
		stralist=new ArrayList<GoodsGiftStra>();
		list=new GetData().getGoodsGiftStralist();
		if(list.size()>0)
			GoodsGiftStra.n=list.get(list.size()-1).getMark()-3000;
		init();
	}
	
	void init()
	{
		setLayout(null);
		JLabel jlb1=new JLabel("请输入商品标识");
		JLabel jlb2=new JLabel("请输入赠送商品标识");
		IDField=new JTextField(10);
		freeIDField=new JTextField(10);
		JButton sureButton=new JButton("确定");
		JButton sure1Button=new JButton("确定");
	
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=IDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要赠送的商品ID!");
					return;
				}
				temp=inter1.searchGood(ID);
				if(temp==null)
				{
					JOptionPane.showMessageDialog(null, "不存在这样的商品ID!");
					IDField.setText(null);
					return;
				}	
				mod=paintGoodInfoTable(temp);
				
				remove(goodInfoPane);
				loadGoodInfoPane();
				IDField.setText(null);
			}
		});
		add(jlb1);
		add(jlb2);
		add(IDField);
		add(freeIDField);
		add(sureButton);
		add(sure1Button);
		
		sure1Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=freeIDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要赠送的商品ID!");
					return;
				}
				temp1=inter1.searchGood(ID);
				if(temp1==null)
				{
					JOptionPane.showMessageDialog(null, "不存在这样的商品ID!");
					freeIDField.setText(null);
					return;
				}	
				mod1=paintGoodInfoTable(temp1);
				
				remove(freegoodInfoPane);
				loadFreeGoodInfoPane();
				freeIDField.setText(null);
			}
		});
		
		jlb1.setBounds(30,20,120,30);
		IDField.setBounds(150,20,100,30);
		sureButton.setBounds(270,20,80,30);
		
		jlb2.setBounds(410,20,120,30);
		freeIDField.setBounds(540,20,100,30);
		sure1Button.setBounds(660,20,80,30);
		
		mod=paintGoodInfoTable(null);
		loadGoodInfoPane();
		
		mod1=paintGoodInfoTable(null);
		loadFreeGoodInfoPane();
		
		startYearField=new JSpinner(new SpinnerNumberModel(2011,2011,null,1));
		startMonthField=new JSpinner(new SpinnerNumberModel(currentDate.getMonth(),1,12,1));
		startDayField=new JSpinner(new SpinnerNumberModel(currentDate.getDay(),1,31,1));
		startYearField.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				updateDate();
			}
		});
		
		startMonthField.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				updateDate();
			}
		});
		
		endYearField=new JSpinner(new SpinnerNumberModel(2011,2011,null,1));
		endMonthField=new JSpinner(new SpinnerNumberModel(currentDate.getMonth(),1,12,1));
		endDayField=new JSpinner(new SpinnerNumberModel(currentDate.getDay(),1,31,1));
		endYearField.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				updateEndDate();
			}
		});
		
		endMonthField.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				updateEndDate();
			}
		});
		
		add(startYearField);
		startYearField.setBounds(180,190,60,30);
		add(startMonthField);
		startMonthField.setBounds(250,190,40,30);
		add(startDayField);
		startDayField.setBounds(300,190,40,30);
		
		add(endYearField);
		add(endMonthField);
		add(endDayField);
		endYearField.setBounds(420,190,60,30);
		endMonthField.setBounds(490,190,40,30);
		endDayField.setBounds(540,190,40,30);
		
		JLabel jlb3=new JLabel("请输入赠送数量");
		JLabel jlb4=new JLabel("请输入开始日期");
		JLabel jlb5=new JLabel("请输入结束日期");
		
		freenum=new Choice();
		freenum.add("1");
		freenum.add("2");
		freenum.add("3");
		add(jlb3);
		jlb3.setBounds(30,150,100,30);
		add(freenum);
		freenum.setBounds(30,190,70,40);
		add(jlb4);
		jlb4.setBounds(210,150,100,30);	
		
		add(jlb5);
		jlb5.setBounds(450,150,100,30);

		JButton sureButton3=new JButton("确定");
		add(sureButton3);
		sureButton3.setBounds(630,180,90,40);
		
		sureButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(temp==null||temp1==null)
				{
					JOptionPane.showMessageDialog(null,"请先输入赠送商品ID和被赠送商品ID\n查找商品后再进行本次操作");
					return ;
				}
				int num=0;
				try
				{
					num=Integer.parseInt(freenum.getSelectedItem());
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
				
				int year=(Integer)startYearField.getValue();
				int month=(Integer)startMonthField.getValue();
				int day =(Integer)startDayField.getValue();
				MyDate startDate=new MyDate(year,month,day);
				
				year=(Integer)endYearField.getValue();
				month=(Integer)endMonthField.getValue();
				day =(Integer)endDayField.getValue();
				MyDate endDate=new MyDate(year,month,day);
				if(currentDate.compare(endDate)>0)
				{
					JOptionPane.showMessageDialog(null," 策略有效结束时间在今天前!");
					return;
				}
				if(endDate.compare(startDate)<0)
				{
					JOptionPane.showMessageDialog(null," 策略有效结束时间在开始时间前!");
					return;
				}	
				GoodsGiftStra stra=new GoodsGiftStra(temp1.getID(),num,temp1.getName(),
						startDate,endDate,temp.getID());
				temp.setGoodGiftStra(stra);
				
				goodlist.add(temp);
				stralist.add(stra);
				
				temp1=null;
				temp=null;
				
				mod=paintGoodInfoTable(null);
				remove(goodInfoPane);
				loadGoodInfoPane();
			
				mod1=paintGoodInfoTable(null);
				remove(freegoodInfoPane);
				loadFreeGoodInfoPane();
			
				remove(totalInfoPane);
				paintTotalTable();
				loadTotalInfoPane();
			}
		});
		
		paintTotalTable();
		loadTotalInfoPane();
		
		JButton addButton=new JButton("确认策略制订");
		add(addButton);
		addButton.setBounds(600,420,120,40);
		
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				AllGoodsList=inter1.getGoodsList();
				
				if(goodlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入促销策略信息再进行本次操作");
					return;
				}
				list=new GetData().getGoodsGiftStralist();
				list.addAll(stralist);
				new SaveData().saveGoodsGiftStra(list);
				new SaveData().saveGoodsList(AllGoodsList);
				
				stralist.clear();
				goodlist.clear();
				
				remove(totalInfoPane);
				paintTotalTable();
				loadTotalInfoPane();
				
				JOptionPane.showMessageDialog(null,"成功制订策略");
			}
		});
		
		JButton cancelButton=new JButton("取消");
		add(cancelButton);
		cancelButton.setBounds(440,420,120,40);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(goodlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"没有待删除的策略");
					return;
				}
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要删除的策略再进行本次操作");
					return;
				}
				goodlist.remove(selIndex);
				stralist.remove(selIndex);
				selIndex=-1;
				
				remove(totalInfoPane);
				paintTotalTable();
				loadTotalInfoPane();
			}
		});
	}
	
	private MyTableModel paintGoodInfoTable(Goods good)
	{
		String []columnNames={"商品标识","商品描述","商品价钱","店铺号"};
		String [][]rowData=new String[1][4];
		if(good!=null)
		{
			rowData[0][0]=good.getID();
			rowData[0][1]=good.getName();
			rowData[0][2]=String.valueOf(good.getOriginalCost());
			rowData[0][3]=String.valueOf(good.getShopNum());
		}
		else
			rowData=new String[0][0];
		MyTableModel mod=new MyTableModel(rowData,columnNames);
		return mod;
	}
	
	public void loadGoodInfoPane()
	{
		goodInfo=new JTable(mod);
		goodInfo.getTableHeader().setReorderingAllowed(false);
		goodInfo.getTableHeader().setResizingAllowed(false);
		goodInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		goodInfo.setDefaultRenderer(Object.class,r);
		
		goodInfoPane=new JScrollPane(goodInfo);
		goodInfoPane.setBounds(30, 60, 350, 80);
		add(goodInfoPane);
	}
	
	public void loadFreeGoodInfoPane()
	{
		freegoodInfo=new JTable(mod1);
		freegoodInfo.getTableHeader().setReorderingAllowed(false);
		freegoodInfo.getTableHeader().setResizingAllowed(false);
		freegoodInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		freegoodInfo.setDefaultRenderer(Object.class,r);
		
		freegoodInfoPane=new JScrollPane(freegoodInfo);
		freegoodInfoPane.setBounds(410,60,350,80);
		add(freegoodInfoPane);
	}
	
	private void paintTotalTable()
	{
		String []columnNames={"策略代号","商品标识","商品描述","商品价钱","赠送商品标识","赠送商品描述","赠送数量","开始日期","结束日期"};
		String [][]rowData=new String[goodlist.size()][9];
		for(int i=0;i<goodlist.size();i++)
		{
			Goods temp=goodlist.get(i);
			rowData[i][0]=String.valueOf(temp.getGoodGiftStra().getMark());
			rowData[i][1]=temp.getID();
			rowData[i][2]=temp.getName();
			rowData[i][3]=String.valueOf(temp.getOriginalCost());
			rowData[i][4]=temp.getGoodGiftStra().getgiftgoodID();
			rowData[i][5]=temp.getGoodGiftStra().getgiftgoodname();
			rowData[i][6]=String.valueOf(temp.getGoodGiftStra().getgiftGoodNum());
			rowData[i][7]=temp.getGoodGiftStra().getStartDate().toString();
			rowData[i][8]=temp.getGoodGiftStra().getEndDate().toString();
		}
		mod2=new MyTableModel(rowData,columnNames);	
	}
	
	public void loadTotalInfoPane()
	{	
		total=new JTable(mod2);
		total.getTableHeader().setReorderingAllowed(false);
		total.getTableHeader().setResizingAllowed(false);
		total.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		total.setDefaultRenderer(Object.class,r);
		
		total.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=total.getSelectedRow();
			}
		});
		
		totalInfoPane=new JScrollPane(total);
		totalInfoPane.setBounds(20, 230, 740, 170);
		add(totalInfoPane);
	}
	
	public void updateDate()
	{
		int month=(Integer)startMonthField.getValue();
		int year=(Integer)startYearField.getValue();
		SpinnerNumberModel numberModel=(SpinnerNumberModel)startDayField.getModel();
		numberModel.setMaximum(MyDate.monthDays(year, month));
		if((Integer)numberModel.getValue()>MyDate.monthDays(year, month))
			numberModel.setValue(MyDate.monthDays(year, month));
	}
	
	public void updateEndDate()
	{
		int month=(Integer)endMonthField.getValue();
		int year=(Integer)endYearField.getValue();
		SpinnerNumberModel numberModel=(SpinnerNumberModel)endDayField.getModel();
		numberModel.setMaximum(MyDate.monthDays(year, month));
		if((Integer)numberModel.getValue()>MyDate.monthDays(year, month))
			numberModel.setValue(MyDate.monthDays(year, month));
	}
}
