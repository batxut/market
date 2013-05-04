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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;


import logic.SearchGoodsController;
import data.Goods;
import server_interface.SearchGoods;
import view.MyTableModel;

public class ModGoodsPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTable oldgoodsTable;
	MyTableModel mod;
	JScrollPane oldgoodsPane1;
	
	JTable newgoodsTable;
	MyTableModel mod1;
	JScrollPane newgoodsPanel;
	
	ArrayList<Goods> allGoodsList;
	ArrayList<Goods> modGoodsList;
	Goods temp;
	
	int selIndex ;
	
	SearchGoods searchGoods;
	
	JTextField IDField;
	Choice newShopNum;
	
	public ModGoodsPanel()
	{
		searchGoods=new SearchGoodsController();
		
	//	allGoodsList=searchGoods.getGoodsList();
		modGoodsList=new ArrayList<Goods>();
		setVisible(false);
		init();
	}
	
	void init()
	{
		setLayout(null);
		
		JLabel jlb1=new JLabel("������Ҫ�仯����ƷID");
		IDField=new JTextField(10);
		
		add(jlb1);
		add(IDField);

		jlb1.setBounds(120,30,150,30);
		IDField.setBounds(130,70,110,30);
		
		JButton sureButton=new JButton("ȷ��");
		sureButton.setBounds(140,110,90,40);
		add(sureButton);
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ID=IDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ID����Ϊ��");
					IDField.setText(null);
					return;
				}
				temp=searchGoods.searchGood(ID);
				if(temp==null)
				{
					JOptionPane.showMessageDialog(null,"����Ʒ������");
					IDField.setText(null);
					return;
				}
				IDField.setText(null);
				remove(oldgoodsPane1);
				paintOldGoodsTable(temp);
				loadOldGoodsInfoPane();
			}
		});
		
		
		paintOldGoodsTable(null);
		loadOldGoodsInfoPane();
		
		JLabel jlb=new JLabel("��ѡ������Ʒ���̺�");
		add(jlb);
		jlb.setBounds(130,180,150,40);
		newShopNum=new Choice();
		newShopNum.addItem("1");
		newShopNum.addItem("2");
		add(newShopNum);
		newShopNum.setBounds(330,190,100,40);
		
		JButton jbt1=new JButton("ȷ��");
		JButton jbt2=new JButton("ȡ��");
		add(jbt1);
		add(jbt2);
		jbt1.setBounds(700,170,100,40);
		jbt1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(temp==null)
				{
					JOptionPane.showMessageDialog(null,"����������Ʒ�ɣ��ٽ��б��β���");
					return ;
				}
				int newshopNum=Integer.parseInt(newShopNum.getSelectedItem());
				if(newshopNum==temp.getShopNum())
				{
					JOptionPane.showMessageDialog(null,"�µ��̺���ԭ���̺���ͬ��");
					return ;
				}
				temp.setShopNum(newshopNum);
				modGoodsList.add(temp);
				
				remove(newgoodsPanel);
				paintTable();
				loadNewGoodsInfoPane();
			}
			
		});
		jbt2.setBounds(580,170,100,40);
		jbt2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(temp!=null)
				{
					temp=null;
					remove(oldgoodsPane1);
					paintOldGoodsTable(null);
					loadOldGoodsInfoPane();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"��������Ʒ�ɣĺ��ٽ��б��β���");
				}
			}
		});
		
		
		JButton addButton=new JButton("ȷ���޸�");
		add(addButton);
		addButton.setBounds(700,430,100,40);
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(modGoodsList.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"û�д��޸ĵ���Ʒ");
					return;
				}
				searchGoods.refreshGoodsInfo(modGoodsList);
				temp=null;
				modGoodsList.clear();
				
				searchGoods=new SearchGoodsController();
				remove(oldgoodsPane1);
				paintOldGoodsTable(null);
				loadOldGoodsInfoPane();
				
				remove(newgoodsPanel);
				paintTable();
				loadNewGoodsInfoPane();
				JOptionPane.showMessageDialog(null,"�����ɹ�");
				
			}
		});
		
		JButton cancelButton=new JButton("ȡ��");
		add(cancelButton);
		cancelButton.setBounds(580,430,100,40);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(modGoodsList.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"û�д�ȡ���޸ĵ���Ʒ");
					return;
				}
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"����ѡ��Ҫ�޸ĵ���Ʒ�ٽ��б��β���");
					return;
				}
				modGoodsList.remove(selIndex);
				selIndex=-1;
				
				remove(newgoodsPanel);
				paintTable();
				loadNewGoodsInfoPane();
			}
		});
		
		paintTable();
		loadNewGoodsInfoPane();
	}

	public void showPanel()
	{
		setVisible(true);
	}
	
	public void loadOldGoodsInfoPane()
	{
		oldgoodsTable=new JTable(mod);
		oldgoodsTable.getTableHeader().setReorderingAllowed(false);
		oldgoodsTable.getTableHeader().setResizingAllowed(false);
		oldgoodsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		oldgoodsTable.setDefaultRenderer(Object.class,r);
		
		oldgoodsPane1=new JScrollPane(oldgoodsTable);
		oldgoodsPane1.setBounds(330, 30, 500, 130);
		add(oldgoodsPane1);
	}
	
	private void paintOldGoodsTable(Goods good)
	{
		String []columnNames={"��Ʒ��ʶ","��Ʒ����","��Ʒ��Ǯ","���̺�"};
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
	
	public void loadNewGoodsInfoPane()
	{
		newgoodsTable=new JTable(mod1);
		newgoodsTable.getTableHeader().setReorderingAllowed(false);
		newgoodsTable.getTableHeader().setResizingAllowed(false);
		newgoodsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		newgoodsTable.setDefaultRenderer(Object.class,r);
		
		newgoodsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=newgoodsTable.getSelectedRow();
			}
		});
		
		newgoodsPanel=new JScrollPane(newgoodsTable);
		newgoodsPanel.setBounds(100, 240, 730, 180);
		add(newgoodsPanel);
	}
	
	private void paintTable()
	{
		String []columnNames={"��Ʒ��ʶ","��Ʒ����","��Ʒ��Ǯ","�µ��̺�"};
		String [][]rowData=new String[modGoodsList.size()][5];
		for(int i=0;i<modGoodsList.size();i++)
		{
			rowData[i][0]=modGoodsList.get(i).getID();
			rowData[i][1]=modGoodsList.get(i).getName();
			rowData[i][2]=String.valueOf(modGoodsList.get(i).getOriginalCost());
			rowData[i][3]=String.valueOf(modGoodsList.get(i).getShopNum());
		}
		mod1=new MyTableModel(rowData,columnNames);
	}
	
}
