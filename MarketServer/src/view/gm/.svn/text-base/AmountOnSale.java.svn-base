package view.gm;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;

import dataOperation.*;
import data.MyDate;
import data.strategy.AmountOnSaleStra;

import view.MyTableModel;

public class AmountOnSale extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MyDate currentDate;
	
	JSpinner costField;
	JSpinner discountField;
	
	JSpinner startDayField;
	JSpinner startMonthField;
	JSpinner startYearField;
	
	JSpinner endDayField;
	JSpinner endMonthField;
	JSpinner endYearField;
	
	JScrollPane straInfoPane;
	JTable straInfo;
	MyTableModel mod;
	
	int selIndex;
	
	ArrayList<AmountOnSaleStra> stralist;
	ArrayList<AmountOnSaleStra> list;
	public AmountOnSale()
	{
		selIndex=-1;
		currentDate=MyDate.getDate();
		stralist=new ArrayList<AmountOnSaleStra>();
		list=new GetData().getAmountOnSaleStraList();
		if(list.size()>0)
			AmountOnSaleStra.n=list.get(list.size()-1).getMark()-2000;
		init();
	}
	
	void init()
	{
		setLayout(null);
		
		JLabel jlb1=new JLabel("输入额度");
		JLabel jlb2=new JLabel("请输入折扣");
		JLabel jlb3=new JLabel("开始日期");
		JLabel jlb4=new JLabel("结束日期");
		
		costField=new JSpinner(new SpinnerNumberModel(100,100,null,50));
		discountField=new JSpinner(new SpinnerNumberModel(0.95,0.1,1,0.01));
		
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
		add(endYearField);
		add(endMonthField);
		add(endDayField);
		
		add(startYearField);
		add(startMonthField);
		add(startDayField);
		
		add(jlb1);
		add(jlb2);
		add(jlb3);
		add(jlb4);
		add(costField);
		add(discountField);
		
		jlb1.setBounds(60,30,120,30);
		costField.setBounds(200,30,100,30);
		jlb2.setBounds(350,30,120,30);
		discountField.setBounds(470,30,100,30);
		jlb3.setBounds(60,100,120,30);
		startYearField.setBounds(160,100,60,30);
		startMonthField.setBounds(230,100,40,30);
		startDayField.setBounds(280,100,40,30);

		jlb4.setBounds(350,100,130,30);
		endYearField.setBounds(430,100,60,30);
		endMonthField.setBounds(500,100,40,30);
		endDayField.setBounds(550,100,40,30);
	
		MyButton sureButton=new MyButton();
		sureButton.setBounds(640,40,50,80);
		add(sureButton);
		
		sureButton.addActionListener(new ActionListener()
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
				int amount=(Integer)costField.getValue();
				double discount=(Double)discountField.getValue();
				AmountOnSaleStra stra=new AmountOnSaleStra(startDate,endDate,amount,discount);
				stralist.add(stra);
				
				remove(straInfoPane);
				paintTable();
				loadPersonInfoPane();
			}
		});
		
		paintTable();
		loadPersonInfoPane();
	
		JButton addButton=new JButton("确认制订");
		add(addButton);
		addButton.setBounds(570,400,100,40);
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(stralist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入促销策略信息再进行本次操作");
					return;
				}
				list=new GetData().getAmountOnSaleStraList();
				list.addAll(stralist);
				new SaveData().saveAmountOnSaleStra(list);
				stralist.clear();
				remove(straInfoPane);
				paintTable();
				loadPersonInfoPane();
				
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
				loadPersonInfoPane();
			}
		});
	}
	
	public void loadPersonInfoPane()
	{
		straInfo=new JTable(mod);
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
		straInfoPane.setBounds(60, 180, 640, 200);
		add(straInfoPane);
	}
	
	private void paintTable()
	{
		String []columnNames={"策略代号","额度","折扣率","开始日期","结束日期"};
		String [][]rowData=new String[stralist.size()][5];
		for(int i=0;i<stralist.size();i++)
		{
			rowData[i][0]=String.valueOf(stralist.get(i).getMark());
			rowData[i][1]=String.valueOf(stralist.get(i).getAmount());
			rowData[i][2]=String.valueOf(stralist.get(i).getDiscount());
			rowData[i][3]=stralist.get(i).getStartDate().toString();
			rowData[i][4]=stralist.get(i).getEndDate().toString();
		}
		mod=new MyTableModel(rowData,columnNames);
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
	
	class MyButton extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g)
		{
			super.paint(g);
			g.drawString("确",20,30);
			g.drawString("定",20,55);
		}
	}
}