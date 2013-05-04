package view.gm;

import java.awt.Choice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SearchGoodsController;

import server_interface.SearchGoods;
import view.MyTableModel;
import data.Goods;
import data.MyDate;
import data.strategy.AmountGiftStra;
import dataOperation.GetData;
import dataOperation.SaveData;

public class AmountGift extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyDate currentDate;
	JTextField freeIDField;
	Choice freenum;
	
	JTable goodInfo;
	MyTableModel mod;
	JScrollPane goodInfoPane;
	JScrollPane straInfoPane;
	JTable straInfo;
	MyTableModel mod1;
	
	JSpinner costField;
	JSpinner startDayField;
	JSpinner startMonthField;
	JSpinner startYearField;
	
	JSpinner endDayField;
	JSpinner endMonthField;
	JSpinner endYearField;
	
	SearchGoods inter1;
	Goods temp;
	
	int selIndex;
	ArrayList<AmountGiftStra> stralist;
	ArrayList<AmountGiftStra> list;
	
	public AmountGift()
	{
		selIndex=-1;
		stralist=new ArrayList<AmountGiftStra>();
		list=new GetData().getAmountGiftStralist();
		if(list.size()>0)
			AmountGiftStra.n=list.get(list.size()-1).getMark()-4000;
		inter1=new SearchGoodsController();
		currentDate=MyDate.getDate();
		init();
	}
	
	void init()
	{
		setLayout(null);
		JLabel jlb1=new JLabel("请输入总额额度");
		JLabel jlb2=new JLabel("请输入赠送商品标识");
		freeIDField=new JTextField(10);
		JButton sureButton=new JButton("确定");
	
		add(jlb1);
		add(jlb2);
		add(freeIDField);
		add(sureButton);
		
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=freeIDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要促销的商品ID!");
					return;
				}
				temp=inter1.searchGood(ID);
				if(temp==null)
				{
					JOptionPane.showMessageDialog(null, "不存在这样的商品ID!");
					freeIDField.setText(null);
					return;
				}	
				paintGoodInfoTable(temp);
				remove(goodInfoPane);
				loadGoodInfoPane();
				freeIDField.setText(null);
			}
		});
		
		jlb1.setBounds(20,40,120,30);
		costField=new JSpinner(new SpinnerNumberModel(100,100,null,50));
		add(costField);
		costField.setBounds(150,40,120,30);
		jlb2.setBounds(320,20,120,30);
		freeIDField.setBounds(460,20,100,30);
		sureButton.setBounds(570,20,70,30);

		paintGoodInfoTable(null);
		loadGoodInfoPane();
		
		JLabel jlb3=new JLabel("请输入赠送数量");
		JLabel jlb4=new JLabel("请输入开始日期");
		JLabel jlb5=new JLabel("请输入结束日期");
	
		freenum=new Choice();
		freenum.add("1");
		freenum.add("2");
		freenum.add("3");
		
		add(jlb3);
		jlb3.setBounds(20,90,120,30);
		add(freenum);
		freenum.setBounds(150,95,100,40);
		
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
	
		jlb4.setBounds(30,170,100,30);
		startYearField.setBounds(130,170,60,30);
		startMonthField.setBounds(200,170,40,30);
		startDayField.setBounds(250,170,40,30);

		jlb5.setBounds(300,170,100,30);
		endYearField.setBounds(400,170,60,30);
		endMonthField.setBounds(470,170,40,30);
		endDayField.setBounds(520,170,40,30);
		add(jlb4);
		add(jlb5);
		add(startYearField);
		add(startMonthField);
		add(startDayField);
		add(endYearField);
		add(endMonthField);
		add(endDayField);
		
		JButton sureButton3=new JButton("确定");
		add(sureButton3);
		sureButton3.setBounds(570,170,70,30);
		
		sureButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
				int amount=0;
				try
				{
					amount=Integer.parseInt(freenum.getSelectedItem());
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
				int num=(Integer)costField.getValue();
				AmountGiftStra stra=new AmountGiftStra(num,temp.getID(),
						temp.getName(),amount,startDate,endDate);
				stralist.add(stra);
				temp=null;
				paintGoodInfoTable(null);
				remove(goodInfoPane);
				loadGoodInfoPane();
				
				remove(straInfoPane);
				paintTable();
				loadStraInfoPane();
			}
		});
		paintTable();
		loadStraInfoPane();
		
		JButton addButton=new JButton("确认策略制订");
		add(addButton);
		addButton.setBounds(520,400,120,30);
		
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(stralist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入促销策略信息再进行本次操作");
					return;
				}
				list=new GetData().getAmountGiftStralist();
				list.addAll(stralist);
				new SaveData().saveAmountGiftStra(list);
				stralist.clear();
				
				remove(straInfoPane);
				paintTable();
				loadStraInfoPane();
				
				JOptionPane.showMessageDialog(null,"成功制订策略");
			}
		});
		
		JButton cancelButton=new JButton("取消");
		add(cancelButton);
		cancelButton.setBounds(390,400,120,30);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(stralist.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"没有待删除的策略");
					return;
				}
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要删除的策略再进行本次操作");
					return;
				}
				stralist.remove(selIndex);
				selIndex=-1;
	
				remove(straInfoPane);
				paintTable();
				loadStraInfoPane();
			}
		});
	}
	
	private void paintGoodInfoTable(Goods good)
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
		mod=new MyTableModel(rowData,columnNames);
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
		goodInfoPane.setBounds(320,60,300,100);
		add(goodInfoPane);
	}
	
	public void loadStraInfoPane()
	{
		straInfo=new JTable(mod1);
		straInfo.getTableHeader().setReorderingAllowed(false);
		straInfo.getTableHeader().setResizingAllowed(false);
		straInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		straInfo.setDefaultRenderer(Object.class,r);
		
		straInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=straInfo.getSelectedRow();
			}
		});
		
		straInfoPane=new JScrollPane(straInfo);
		straInfoPane.setBounds(20, 210, 610, 170);
		add(straInfoPane);
	}
	
	private void paintTable()
	{
		String []columnNames={"策略代号","总额额度","赠送商品标识","赠送商品描述","赠送数量","开始日期","结束日期"};
		String [][]rowData=new String[stralist.size()][7];
		for(int i=0;i<stralist.size();i++)
		{
			rowData[i][0]=String.valueOf(stralist.get(i).getMark());
			rowData[i][1]=String.valueOf(stralist.get(i).getAmount());
			rowData[i][2]=stralist.get(i).getgiftgoodID();
			rowData[i][3]=stralist.get(i).getgiftgoodname();
			rowData[i][4]=String.valueOf(stralist.get(i).getgiftGoodNum());
			rowData[i][5]=stralist.get(i).getStartDate().toString();
			rowData[i][6]=stralist.get(i).getEndDate().toString();
		}
		mod1=new MyTableModel(rowData,columnNames);
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
