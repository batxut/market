package view.gm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SearchGoodsController;

import server_interface.SearchGoods;
import view.MyTableModel;
import data.*;
import data.strategy.GoodsOnSaleStra;
import dataOperation.GetData;
import dataOperation.SaveData;

public class GoodsOnSale extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MyDate currentDate;
	
	JTextField IDField;
	JTextField priceField;
	
	JTable goodInfo;
	MyTableModel mod;
	JScrollPane goodInfoPane;
	
	JTable modgoodsInfo;
	MyTableModel mod1;
	JScrollPane modgoodInfoPane;
	
	Goods temp;
	ArrayList<Goods> goodlist;
	ArrayList<GoodsOnSaleStra> stralist;
	ArrayList<Goods> AllGoodsList;
	ArrayList<GoodsOnSaleStra> list;
	int selIndex;
	
	JSpinner startDayField;
	JSpinner startMonthField;
	JSpinner startYearField;
	
	JSpinner endDayField;
	JSpinner endMonthField;
	JSpinner endYearField;
	
	SearchGoods searchGood;
	
	public GoodsOnSale()
	{
		list=new GetData().getGoodsOnSaleStraList();
		if(list.size()>0)
			GoodsOnSaleStra.n=list.get(list.size()-1).getMark()-1000;
		selIndex=-1;
		searchGood=new SearchGoodsController();
		currentDate=MyDate.getDate();
		goodlist=new ArrayList<Goods>();
		stralist=new ArrayList<GoodsOnSaleStra>();
		init();
	}
	
	void init()
	{
		setLayout(null);
		
		JLabel jlb1=new JLabel("请输入要促销的商品ID");
		IDField=new JTextField(10);
		
		add(jlb1);
		add(IDField);
		
		IDField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				IDField.selectAll();
			}
		});

		jlb1.setBounds(60,20,150,30);
		IDField.setBounds(70,60,110,30);
		
		JButton sureButton=new JButton("确定");
		sureButton.setBounds(80,100,90,30);
		add(sureButton);
		
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=IDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要促销的商品ID!");
					return;
				}
				temp=searchGood.searchGood(ID);
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
		
		mod=paintGoodInfoTable(null);
		loadGoodInfoPane();
	
		priceField=new JTextField(10);
		add(priceField);
		priceField.setBounds(80,190,80,30);
		
		JLabel jlb2=new JLabel("请输入商品特价");
		add(jlb2);
		jlb2.setBounds(80,150,100,30);
		
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
		JLabel jlb3=new JLabel("开始日期");
		JLabel jlb4=new JLabel("结束日期");
		add(jlb3);
		add(jlb4);
		jlb3.setBounds(270,150,100,30);
		
		add(startYearField);
		startYearField.setBounds(220,190,60,30);
		add(startMonthField);
		startMonthField.setBounds(290,190,40,30);
		add(startDayField);
		startDayField.setBounds(340,190,40,30);
		
		jlb4.setBounds(450,150,100,30);
		add(endYearField);
		add(endMonthField);
		add(endDayField);
		endYearField.setBounds(400,190,60,30);
		endMonthField.setBounds(470,190,40,30);
		endDayField.setBounds(520,190,40,30);
		
		JButton jbt1=new JButton("确认");
		add(jbt1);
		jbt1.setBounds(580,180,90,40);
		
		jbt1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(temp==null)
				{
					JOptionPane.showMessageDialog(null,"请先输入促销商品ID查找商品再进行本次操作");
					return ;
				}
				double specialprice;
				try
				{
					specialprice=Double.parseDouble(priceField.getText());
				}
				catch(Exception ee)
				{
					priceField.setText("输入不合法");
					return;
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
				GoodsOnSaleStra stra=new GoodsOnSaleStra(specialprice,
						startDate,endDate,temp.getID());
				temp.setGoodsOnSaleStra(stra);
				goodlist.add(temp);
				stralist.add(stra);
				
				priceField.setText(null);
				remove(goodInfoPane);
				mod=paintGoodInfoTable(null);
				loadGoodInfoPane();
				
				remove(modgoodInfoPane);
				mod1=paintModUserTable();
				loadModGoodInfoPane();
			}
		});
		
		mod1=paintModUserTable();
		loadModGoodInfoPane();
		
		JButton addButton=new JButton("确认制订");
		add(addButton);
		addButton.setBounds(570,400,100,40);
		
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				AllGoodsList=searchGood.getGoodsList();
				if(goodlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入促销策略信息再进行本次操作");
					return;
				}
				list=new GetData().getGoodsOnSaleStraList();
				list.addAll(stralist);
				new SaveData().saveGoodsOnSaleStra(list);
				new SaveData().saveGoodsList(AllGoodsList);
				
				stralist.clear();
				goodlist.clear();
				temp=null;
				remove(modgoodInfoPane);
				mod1=paintModUserTable();
				loadModGoodInfoPane();
				JOptionPane.showMessageDialog(null,"成功制订策略");
			}
		});
		
		JButton cancelButton=new JButton("取消");
		add(cancelButton);
		cancelButton.setBounds(430,400,100,40);
		
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
				
				remove(modgoodInfoPane);
				mod1=paintModUserTable();
				loadModGoodInfoPane();
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
		goodInfoPane.setBounds(220, 40, 480, 90);
		add(goodInfoPane);
	}
	
	private MyTableModel paintModUserTable()
	{
		String []columnNames={"策略代号","商品标识","商品描述","商品原价","商品特价","开始日期","结束日期"};
		String [][]rowData=new String[goodlist.size()][7];
		int i=0;
		for(i=0;i<goodlist.size();i++)
		{
			Goods temp=goodlist.get(i);
			rowData[i][0]=String.valueOf(temp.getOnsaleStrategy().getMark());
			rowData[i][1]=temp.getID();
			rowData[i][2]=temp.getName();
			rowData[i][3]=String.valueOf(temp.getOriginalCost());
			rowData[i][4]=String.valueOf(temp.getOnsaleStrategy().getBargainPrice());
			rowData[i][5]=temp.getOnsaleStrategy().getStartDate().toString();
			rowData[i][6]=temp.getOnsaleStrategy().getEndDate().toString();
		}
		MyTableModel mod1=new MyTableModel(rowData,columnNames);
		return mod1;
	}
	
	public void loadModGoodInfoPane()
	{	
		modgoodsInfo=new JTable(mod1);
		modgoodsInfo.getTableHeader().setReorderingAllowed(false);
		modgoodsInfo.getTableHeader().setResizingAllowed(false);
		modgoodsInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		modgoodsInfo.setDefaultRenderer(Object.class,r);
		
		modgoodsInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=modgoodsInfo.getSelectedRow();
			}
		});
		
		modgoodInfoPane=new JScrollPane(modgoodsInfo);
		modgoodInfoPane.setBounds(60, 240, 650, 150);
		add(modgoodInfoPane);
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
