package view.gm;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SearchGoodsController;
import logic.SearchStraController;

import dataOperation.*;
import data.Goods;

import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;


import server_interface.SearchGoods;
import server_interface.SearchStra;
import view.MyTableModel;

public class RemoveStrategy extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable total;
	MyTableModel mod;
	JScrollPane totalPane;
	
	JTable stratable;
	MyTableModel straMod;
	JScrollPane straPane;
	
	JButton refreshButton;
	JButton MoreInnfoButton;
	JButton cancelButton;
	JButton confirmButton; 
	JTextField IDField;
	
	int selIndex=-1;
	
	Goods temp;
	
	ArrayList<AmountOnSaleStra> amountOnSalelist;
	ArrayList<GoodsOnSaleStra> goodOnSalelist;
	ArrayList<GoodsGiftStra> goodsGiftlist;
	ArrayList<AmountGiftStra> amountGiftlist;
	
	GetData data;
	SearchGoods inter1;
	SearchStra search;
	GoodsOnSaleStra stra1;
	AmountOnSaleStra stra2;
	GoodsGiftStra stra3;
	AmountGiftStra stra4;
	
	public RemoveStrategy()
	{
		inter1=new SearchGoodsController();
		data=new GetData();
		search=new SearchStraController();
		amountOnSalelist=data.getAmountOnSaleStraList();
		goodOnSalelist=data.getGoodsOnSaleStraList();
		goodsGiftlist=data.getGoodsGiftStralist();
		amountGiftlist=data.getAmountGiftStralist();
		init();
	}
	
	void init()
	{
		setLayout(null);
		paintTable();
		loadStraInfoPane();
		
		refreshButton=new JButton("刷新列表");
		MoreInnfoButton=new JButton("详情");
		add(MoreInnfoButton);
		MoreInnfoButton.setBounds(610,160,100,40);
		add(refreshButton);
		refreshButton.setBounds(610,80,100,40);
		MoreInnfoButton.setEnabled(false);
		refreshButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refresh();
			}
		});
		MoreInnfoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要取消雇佣的用户再进行本次操作");
					return;
				}
				if(selIndex<goodOnSalelist.size())
				{
					stra1=goodOnSalelist.get(selIndex);
					remove(straPane);
					paintStraTable(stra1,null,null,null);
					loadSpecialStraInfoPane();
				}
				else if(selIndex<goodOnSalelist.size()+amountOnSalelist.size())
				{
					stra2=amountOnSalelist.get(selIndex-goodOnSalelist.size());
					remove(straPane);
					paintStraTable(null,stra2,null,null);
					loadSpecialStraInfoPane();
				}
				else if(selIndex<goodOnSalelist.size()+amountOnSalelist.size()+goodsGiftlist.size())
				{
					stra3=goodsGiftlist.get(selIndex-goodOnSalelist.size()-amountOnSalelist.size());
					remove(straPane);
					paintStraTable(null,null,stra3,null);
					loadSpecialStraInfoPane();
				}
				else
				{
					stra4=amountGiftlist.get(selIndex-goodOnSalelist.size()-
							amountOnSalelist.size()-goodsGiftlist.size());
					remove(straPane);
					paintStraTable(null,null,null,stra4);
					loadSpecialStraInfoPane();
				}
			}
		});
		JLabel jlb1=new JLabel("输入策略代号进行搜索");
		jlb1.setFont(getFont().deriveFont(20));
		IDField=new JTextField(10);
		JButton sureButton=new JButton("确定");
		
		add(jlb1);
		add(IDField);
		add(sureButton);
		
		jlb1.setBounds(40,230,170,30);
		IDField.setBounds(200,230,100,30);
		sureButton.setBounds(350,230,100,30);
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=IDField.getText();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要搜索的策略代号!");
					return;
				}
				int mark=0;
				try
				{
					mark=Integer.parseInt(ID);
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null,"输入不合法");
					IDField.setText(null);
				} 
				switch(mark/1000)
				{
				case 1:stra1=search.searchGoodsOnSaleStra(mark);
				if(stra1==null)
				{
					JOptionPane.showMessageDialog(null,"不存在与此代号相对应的策略!");
					IDField.setText(null);
					return;
				}
				System.out.println(stra1.getBindingGoodsID());
				
				IDField.setText(null);
				remove(straPane);
				paintStraTable(stra1,null,null,null);
				loadSpecialStraInfoPane();
				break;
				
				case 2:stra2=search.searchAmountOnSaleStra(mark);
				if(stra2==null)
				{
					JOptionPane.showMessageDialog(null,"不存在与此代号相对应的策略!");
					IDField.setText(null);
					return;
				}
				IDField.setText(null);
				remove(straPane);
				paintStraTable(null,stra2,null,null);
				loadSpecialStraInfoPane();
				break;
				
				case 3:stra3=search.searchGoodsGiftStra(mark);
				if(stra3==null)
				{
					JOptionPane.showMessageDialog(null,"不存在与此代号相对应的策略!");
					IDField.setText(null);
					return;
				}
				IDField.setText(null);
				remove(straPane);
				paintStraTable(null,null,stra3,null);
				loadSpecialStraInfoPane();
				break;
				
				case 4:stra4=search.searchAmountGiftStra(mark);
				if(stra4==null)
				{
					JOptionPane.showMessageDialog(null,"不存在与此代号相对应的策略!");
					IDField.setText(null);
					return;
				}
				IDField.setText(null);
				remove(straPane);
				paintStraTable(null,null,null,stra4);
				loadSpecialStraInfoPane();
				break;
				
				default:JOptionPane.showMessageDialog(null,"不存在与此代号相对应的策略!");
					IDField.setText(null);
				}
			}
		});
		
		JLabel jlb2=new JLabel("已有促销策略列表:");
		add(jlb2);
		jlb2.setBounds(40,20,200,30);
		
		straPane=new JScrollPane();
		add(straPane);
		straPane.setBounds(40,280,560,100);
		
		cancelButton=new JButton("取消");
		confirmButton=new JButton("确认删除");
		add(cancelButton);
		add(confirmButton);
		cancelButton.setBounds(380,390,100,40);
		confirmButton.setBounds(510,390,100,40);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				stra1=null;
				stra2=null;
				stra3=null;
				stra4=null;
				temp=null;
				remove(straPane);
				straPane=new JScrollPane();
				add(straPane);
				straPane.setBounds(40,280,560,100);
			}
		});
		
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(stra1!=null)
				{
					search.deleteGoodsOnSaleStra(stra1.getMark());
					temp.setGoodsOnSaleStra(null);
					ArrayList<Goods> goodsList=inter1.getGoodsList();
					new SaveData().saveGoodsList(goodsList);
				}
				else if(stra2!=null)
				{
					search.deleteAmountOnSaleStra(stra2.getMark());
				}
				else if(stra3!=null)
				{
					search.deleteGoodsGiftStra(stra3.getMark());
					temp.setGoodGiftStra(null);
					ArrayList<Goods> goodsList=inter1.getGoodsList();
					new SaveData().saveGoodsList(goodsList);
				}
				else if(stra4!=null)
				{
					search.deleteAmountGiftStra(stra4.getMark());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"请选择策略后再进行本次操作");
					return;
				}
				stra1=null;
				stra2=null;
				stra3=null;
				stra4=null;
				temp=null;
				
				JOptionPane.showMessageDialog(null,"成功移除该策略");
				refresh();
				remove(straPane);
				straPane=new JScrollPane();
				add(straPane);
				straPane.setBounds(40,280,560,100);
			}
		});
	}

	public void loadStraInfoPane()
	{
		total=new JTable(mod);
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
				MoreInnfoButton.setEnabled(true);
			}
		});
		
		totalPane=new JScrollPane(total);
		totalPane.setBounds(40, 50, 560, 170);
		add(totalPane);
	}
	
	private void paintTable()
	{
		int n1= goodOnSalelist.size(),n2=amountOnSalelist.size();
		int n3=goodsGiftlist.size(),n4=amountGiftlist.size();
		int total=n1+n2+n3+n4;
		String []columnNames={"策略代号","策略类型","开始日期","结束日期"};
		String [][]rowData=new String[total][4];
		int i=0;
		for(i=0;i<n1;i++)
		{
			rowData[i][0]=String.valueOf(goodOnSalelist.get(i).getMark());
			rowData[i][1]="商品特价策略";
			rowData[i][2]=goodOnSalelist.get(i).getStartDate().toString();
			rowData[i][3]=goodOnSalelist.get(i).getEndDate().toString();
		}
		int j=i;
		for(;j<n1+n2;j++)
		{
			rowData[j][0]=String.valueOf(amountOnSalelist.get(j-i).getMark());
			rowData[j][1]="总额特价策略";
			rowData[j][2]=amountOnSalelist.get(j-i).getStartDate().toString();
			rowData[j][3]=amountOnSalelist.get(j-i).getEndDate().toString();
		}
		i=j;
		for(;i<n1+n2+n3;i++)
		{
			rowData[i][0]=String.valueOf(goodsGiftlist.get(i-j).getMark());
			rowData[i][1]="商品赠送策略";
			rowData[i][2]=goodsGiftlist.get(i-j).getStartDate().toString();
			rowData[i][3]=goodsGiftlist.get(i-j).getEndDate().toString();
		}
		j=i;
		for(;j<total;j++)
		{
			rowData[j][0]=String.valueOf(amountGiftlist.get(j-i).getMark());
			rowData[j][1]="总额赠送策略";
			rowData[j][2]=amountGiftlist.get(j-i).getStartDate().toString();
			rowData[j][3]=amountGiftlist.get(j-i).getEndDate().toString();
		}
		mod=new MyTableModel(rowData,columnNames);
	}
	
	public void loadSpecialStraInfoPane()
	{
		stratable=new JTable(straMod);
		stratable.getTableHeader().setReorderingAllowed(false);
		stratable.getTableHeader().setResizingAllowed(false);
		stratable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		stratable.setDefaultRenderer(Object.class,r);
		
		straPane=new JScrollPane(stratable);
		straPane.setBounds(40,280,560,100);
		add(straPane);
	}
	
	private void paintStraTable(GoodsOnSaleStra GoodsOnSale,
			AmountOnSaleStra amountOnSale,GoodsGiftStra GoodsGift,
			AmountGiftStra AmountGift)
	{
		if(GoodsOnSale!=null)
		{
			temp=inter1.searchGood(GoodsOnSale.getBindingGoodsID());
			
			String []columnNames={"策略代号","商品标识","商品描述","商品原价","商品特价","开始日期","结束日期"};
			String [][]rowData=new String[1][7];
			rowData[0][0]=String.valueOf(temp.getOnsaleStrategy().getMark());
			rowData[0][1]=temp.getID();
			rowData[0][2]=temp.getName();
			rowData[0][3]=String.valueOf(temp.getOriginalCost());
			rowData[0][4]=String.valueOf(temp.getOnsaleStrategy().getBargainPrice());
			rowData[0][5]=temp.getOnsaleStrategy().getStartDate().toString();
			rowData[0][6]=temp.getOnsaleStrategy().getEndDate().toString();
		
			straMod=new MyTableModel(rowData,columnNames);
		}
		else if(amountOnSale!=null)
		{
			String []columnNames={"策略代号","额度","折扣率","开始日期","结束日期"};
			String [][]rowData=new String[1][5];
			
			rowData[0][0]=String.valueOf(amountOnSale.getMark());
			rowData[0][1]=String.valueOf(amountOnSale.getAmount());
			rowData[0][2]=String.valueOf(amountOnSale.getDiscount());
			rowData[0][3]=amountOnSale.getStartDate().toString();
			rowData[0][4]=amountOnSale.getEndDate().toString();
			
			straMod=new MyTableModel(rowData,columnNames);
		}
		else if(GoodsGift!=null)
		{
			String []columnNames={"策略代号","商品标识","商品描述","商品价钱","赠送商品标识","赠送商品描述","赠送数量","开始日期","结束日期"};
			String [][]rowData=new String[1][9];
			temp=inter1.searchGood(GoodsGift.getBindingGoodsID());
			rowData[0][0]=String.valueOf(temp.getGoodGiftStra().getMark());
			rowData[0][1]=temp.getID();
			rowData[0][2]=temp.getName();
			rowData[0][3]=String.valueOf(temp.getOriginalCost());
			rowData[0][4]=temp.getGoodGiftStra().getgiftgoodID();
			rowData[0][5]=temp.getGoodGiftStra().getgiftgoodname();
			rowData[0][6]=String.valueOf(temp.getGoodGiftStra().getgiftGoodNum());
			rowData[0][7]=temp.getGoodGiftStra().getStartDate().toString();
			rowData[0][8]=temp.getGoodGiftStra().getEndDate().toString();
			straMod=new MyTableModel(rowData,columnNames);	
		}
		else
		{
			String []columnNames={"策略代号","总额额度","赠送商品标识","赠送商品描述","赠送数量","开始日期","结束日期"};
			String [][]rowData=new String[1][7];
			rowData[0][0]=String.valueOf(AmountGift.getMark());
			rowData[0][1]=String.valueOf(AmountGift.getAmount());
			rowData[0][2]=AmountGift.getgiftgoodID();
			rowData[0][3]=AmountGift.getgiftgoodname();
			rowData[0][4]=String.valueOf(AmountGift.getgiftGoodNum());
			rowData[0][5]=AmountGift.getStartDate().toString();
			rowData[0][6]=AmountGift.getEndDate().toString();		
			straMod=new MyTableModel(rowData,columnNames);
		}
	}
	
	public void refresh()
	{
		amountOnSalelist=data.getAmountOnSaleStraList();
		goodOnSalelist=data.getGoodsOnSaleStraList();
		goodsGiftlist=data.getGoodsGiftStralist();
		amountGiftlist=data.getAmountGiftStralist();
		search=new SearchStraController();
		inter1=new SearchGoodsController();
		remove(totalPane);
		paintTable();
		loadStraInfoPane();
	}
}
