package view.admin;

import java.awt.event.*;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import logic.Controll4;
import logic.SearchSMController;
import logic.SearchSalesmanController;
import logic.SearchGMController;

import server_interface.IsIDRepeated;
import server_interface.SearchGM;
import server_interface.SearchSM;
import server_interface.SearchSalesman;

import view.MyTableModel;

import data.user.*;

public class AdministratorDeleteUserPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonGroup bg;
	JRadioButton cashier,branchManager,gmanager;
	JTextField IDField;
	JButton sureButton;
	
	JTable userInfo;
	MyTableModel mod;
	JScrollPane personInfoPane;
	
	ArrayList<Salesman> salesmanlist;
	ArrayList<StoreManager> smlist;
	ArrayList<GeneralManager> gmlist;
	
	GeneralManager gmtemp;
	StoreManager smtemp;
	Salesman salesmantemp;
	
	int selIndex=-1;
	
	SearchSalesman inter8;
	SearchGM inter7;
	SearchSM searchsm;
	public AdministratorDeleteUserPanel()
	{
		setLayout(null);
		salesmanlist=new ArrayList<Salesman>();
		gmlist=new ArrayList<GeneralManager>();
		smlist=new ArrayList<StoreManager>();
		
		inter8=new SearchSalesmanController();
		inter7=new SearchGMController();
		searchsm=new SearchSMController();
	}
	
	public void showPanel()
	{
		JLabel jlb1=new JLabel("请选择要删除的用户:");
		jlb1.setBounds(130,30,150,30);
		jlb1.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlb1);
		cashier=new JRadioButton("收银员");
		branchManager=new JRadioButton("分店经理");
		gmanager=new JRadioButton("总经理");
	//	130, 200, 650, 190;
		
		cashier.setBounds(150, 70, 100, 30);
		branchManager.setBounds(150, 110, 100,30);
		gmanager.setBounds(150,150,100,30);
		
		add(cashier);
		add(branchManager);
		add(gmanager);

		bg=new ButtonGroup();
		bg.add(cashier);
		bg.add(branchManager);
		bg.add(gmanager);
		
		cashier.setSelected(true);
		
		JLabel jlb2=new JLabel("请输入要删除用户的工号：");
		jlb2.setBounds(400,50,200,30);
		add(jlb2);
		
		IDField=new JTextField(10);
		add(IDField);
		IDField.setBounds(580,50,100,30);
		
		IDField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				IDField.selectAll();
			}
		});
		sureButton=new JButton("确定");
		sureButton.setBounds(500,120,100,40);
		add(sureButton);
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=IDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要解雇用户ID!");
					return;
				}
				IsIDRepeated inter5=new Controll4();
				if(cashier.isSelected())
				{
					int n=inter5.isSalesmanIDRepeated(ID);
					if(n==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的收银员账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					salesmantemp=inter8.searchSalesman(ID);
					salesmanlist.add(salesmantemp);
					
					mod=paintTable();
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
				else if(branchManager.isSelected())
				{
					int n=inter5.isSMIDrepeated(ID);
					if(n==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的分店经理账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					smtemp=searchsm.searchSM(ID);
					smlist.add(smtemp);
					mod=paintTable();
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
				else
				{
					int n=inter5.isGMIDrepeated(ID);
					if(n==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的总经理账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					gmtemp=inter7.searchGM(ID);
					gmlist.add(gmtemp);
					
					mod=paintTable();
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
			}
		});
		
		String []columnNames={"工号","姓名","职位","店铺号"};
		String [][]rowData={};
		mod=new MyTableModel(rowData,columnNames);
		loadPersonInfoPane();

		JButton cancelButton,confirmButton;
		cancelButton=new JButton("取消解雇");
		confirmButton=new JButton("确认解雇");
		add(cancelButton);
		add(confirmButton);
//		130, 200, 650, 190;
		cancelButton.setBounds(530,400,100,40);
		confirmButton.setBounds(650,400,100,40);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"没有待解雇用户");
					return;
				}
				
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要解雇的用户再进行本次操作");
					return;
				}
				if(selIndex<salesmanlist.size())
				{
					salesmanlist.remove(selIndex);
				}
				else if(selIndex<salesmanlist.size()+smlist.size())
				{
					smlist.remove(selIndex-salesmanlist.size());
				}
				else
				{
					gmlist.remove(selIndex-salesmanlist.size()-smlist.size());
				}
				selIndex=-1;
				
				mod=paintTable();
				remove(personInfoPane);
				loadPersonInfoPane();
			}
		});
		
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入解雇用户信息再进行本次操作");
					return;
				}
				
				inter7.deleteGM(gmlist);
				inter8.deleteSalesmanList(salesmanlist);
				searchsm.deleteSM(smlist);
				
				gmlist.clear();
				salesmanlist.clear();
				smlist.clear();
				
				JOptionPane.showMessageDialog(null,"成功解雇用户！");
				
				inter8=new SearchSalesmanController();
				inter7=new SearchGMController();
				searchsm=new SearchSMController();
				
				mod=paintTable();
				remove(personInfoPane);
				loadPersonInfoPane();
			}
		});
	}
	
	private MyTableModel paintTable()
	{
		int n1= salesmanlist.size(),n2=smlist.size(),n3=gmlist.size();
		int total=n1+n2+n3;
		String []columnNames={"工号","姓名","职位","店铺号","密码"};
		String [][]rowData=new String[total][5];
		int i=0;
		for(i=0;i<n1;i++)
		{
			rowData[i][0]=salesmanlist.get(i).getID();
			rowData[i][1]=salesmanlist.get(i).getName();
			rowData[i][2]="收银员";
			rowData[i][3]=String.valueOf(salesmanlist.get(i).getStore());
			rowData[i][4]=salesmanlist.get(i).getPassword();
		}
		int j=i;
		for(;j<n1+n2;j++)
		{
			rowData[j][0]=smlist.get(j-i).getID();
			rowData[j][1]=smlist.get(j-i).getName();
			rowData[j][2]="分店经理";
			rowData[j][3]=String.valueOf(smlist.get(j-i).getShopNum());
			rowData[j][4]=smlist.get(j-i).getPassword();
		}
		i=j;
		for(;i<total;i++)
		{
			rowData[i][0]=gmlist.get(i-j).getID();
			rowData[i][1]=gmlist.get(i-j).getName();
			rowData[i][2]="总经理";
			rowData[i][3]="\\";
			rowData[i][4]=gmlist.get(i-j).getPassword();
		}
		MyTableModel mod=new MyTableModel(rowData,columnNames);
		return mod;
	}
	
	public void loadPersonInfoPane()
	{
		userInfo=new JTable(mod);
		userInfo.getTableHeader().setReorderingAllowed(false);
		userInfo.getTableHeader().setResizingAllowed(false);
		userInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		userInfo.setDefaultRenderer(Object.class,r);
		
		userInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=userInfo.getSelectedRow();
			}
		});
		
		personInfoPane=new JScrollPane(userInfo);
		personInfoPane.setBounds(130, 200, 650, 190);
		add(personInfoPane);
	}
}
