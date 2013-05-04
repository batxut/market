package view.admin;

import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SaveInfoController;
import logic.Controll4;
import logic.SearchSMController;
import logic.SearchSalesmanController;
import logic.SearchGMController;

import server_interface.IsIDRepeated;
import server_interface.SaveInfo;
import server_interface.SearchGM;
import server_interface.SearchSM;
import server_interface.SearchSalesman;

import view.MyTableModel;

import data.user.*;

public class AdministratorModUserPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonGroup bg;
	JRadioButton cashier,branchManager,gmanager;
	JTextField IDField;
	JButton sureButton;
	JSpinner sp;
	JComboBox box;
	
	JTable userInfo;
	MyTableModel mod;
	JScrollPane personInfoPane;
	
	JTable modUserInfo;
	MyTableModel mod1;
	JScrollPane modUserInfoPane;
	
	ArrayList<NewSalesman> salesmanlist;
	ArrayList<NewStoreManager> smlist;
	ArrayList<NewGeneralManager> gmlist;
	
	ArrayList<Salesman> listsalesman;
	ArrayList<StoreManager> listsm;
	ArrayList<GeneralManager> listgm;
	
	GeneralManager gmtemp;
	StoreManager smtemp;
	Salesman salesmantemp;
	
	int selIndex=-1;
	int flag=0;
	
	SearchSalesman inter8;
	SearchGM inter7;
	SearchSM searchsm;
	
	public AdministratorModUserPanel()
	{
		setLayout(null);
		salesmanlist=new ArrayList<NewSalesman>();
		gmlist=new ArrayList<NewGeneralManager>();
		smlist=new ArrayList<NewStoreManager>();
		
		inter8=new SearchSalesmanController();
		inter7=new SearchGMController();
		searchsm=new SearchSMController();
		
		listsalesman=new ArrayList<Salesman>();
		listsm=new ArrayList<StoreManager>();
		listgm=new ArrayList<GeneralManager>();
	}
	
	public void showPanel()
	{
		JLabel jlb1=new JLabel("请选择要修改的用户:");
		jlb1.setBounds(100,30,150,30);
		jlb1.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlb1);
		cashier=new JRadioButton("收银员");
		branchManager=new JRadioButton("分店经理");
		gmanager=new JRadioButton("总经理");
		
		cashier.setBounds(110, 70, 100, 30);
		branchManager.setBounds(110, 110, 100,30);
		gmanager.setBounds(110,150,100,30);
		
		add(cashier);
		add(branchManager);
		add(gmanager);
		
		bg=new ButtonGroup();
		bg.add(cashier);
		bg.add(branchManager);
		bg.add(gmanager);	
		cashier.setSelected(true);
		
		JLabel jlb2=new JLabel("请输入要修改用户的工号：");
		jlb2.setBounds(250,30,160,30);
		add(jlb2);
		
		IDField=new JTextField(10);
		add(IDField);
		IDField.setBounds(280,80,100,30);
		
		IDField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				IDField.selectAll();
			}
		});
		
		sureButton=new JButton("确定");
		sureButton.setBounds(280,140,100,30);
		add(sureButton);
		
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ID=IDField.getText().trim();
				if(ID.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请输入要变迁的用户ID!");
					return;
				}
				IsIDRepeated inter5=new Controll4();
				if(cashier.isSelected())
				{
					flag=inter5.isSalesmanIDRepeated(ID);
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的收银员账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					salesmantemp=inter8.searchSalesman(ID);
				
					mod=paintUserInfoTable(null,null,salesmantemp);
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
				else if(branchManager.isSelected())
				{
					flag=inter5.isSMIDrepeated(ID);
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的分店经理账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					smtemp=searchsm.searchSM(ID);
					mod=paintUserInfoTable(null,smtemp,null);
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
				else
				{
					flag=inter5.isGMIDrepeated(ID);
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null, "不存在这样的总经理账号，请检查输入或搜索类型!");
						IDField.setText(null);
						return;
					}
					gmtemp=inter7.searchGM(ID);
					
					mod=paintUserInfoTable(gmtemp,null,null);
					remove(personInfoPane);
					loadPersonInfoPane();
					IDField.setText(null);
				}
			}
		});
	
		mod=paintUserInfoTable(null,null,null);
		loadPersonInfoPane();
		
		JLabel jlb3=new JLabel("请选择新岗位");
		JLabel jlb4=new JLabel("请输入新店铺号");
		
		box=new JComboBox();
		box.addItem("收银员");
		box.addItem("分店经理");
		box.addItem("总经理");
		
		SpinnerNumberModel numModel=new SpinnerNumberModel(1,1,null,1);
		sp=new JSpinner(numModel);
		
		box.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getItem().equals("总经理"))
					sp.setEnabled(false);
				else
					sp.setEnabled(true);
			}
		});
		
		add(jlb3);
		jlb3.setBounds(120,200,120,30);
		add(box);
		box.setBounds(280,200,100,30);
	
		add(jlb4);
		jlb4.setBounds(420,200,120,30);
		add(sp);
		sp.setBounds(540,200,100,30);
		
		JButton sure=new JButton("确认");
		add(sure);
		sure.setBounds(650,200,100,30);
		sure.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String newIdentity=(String) box.getSelectedItem();
				int newShopNum=(Integer) sp.getValue();
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null,"请先输入要变迁用户ID后再进行本次操作");
					return;
				}
				else if(flag==2)
				{
					if(isSalesmanInTable(salesmantemp.getID()))
					{
						JOptionPane.showMessageDialog(null,"该用户已添加！");
						
						mod=paintUserInfoTable(null,null,null);
						remove(personInfoPane);
						loadPersonInfoPane();
						return;
					}
					NewSalesman temp=new NewSalesman();
					temp.salesman=salesmantemp;
					temp.newIdentity=newIdentity;
					temp.newShopNum=newShopNum;
					salesmanlist.add(temp);
				}
				else if(flag==3)
				{
					if(isSMInTable(smtemp.getID()))
					{
						JOptionPane.showMessageDialog(null,"该用户已添加！");
						
						mod=paintUserInfoTable(null,null,null);
						remove(personInfoPane);
						loadPersonInfoPane();
						return;
					}
					NewStoreManager temp=new NewStoreManager();
					temp.sm=smtemp;
					temp.newIdentity=newIdentity;
					temp.newShopNum=newShopNum;
					smlist.add(temp);
				}
				else if(flag==4)
				{
					if(isGMInTable(gmtemp.getID()))
					{
						JOptionPane.showMessageDialog(null,"该用户已添加！");
						
						mod=paintUserInfoTable(null,null,null);
						remove(personInfoPane);
						loadPersonInfoPane();
						return;
					}
					NewGeneralManager temp=new NewGeneralManager();
					temp.gm=gmtemp;
					temp.newIdentity=newIdentity;
					temp.newShopNum=newShopNum;
					gmlist.add(temp);
				}
				flag=0;
				mod=paintUserInfoTable(null,null,null);
				remove(personInfoPane);
				loadPersonInfoPane();
				
				mod1=paintModUserTable();
				remove(modUserInfoPane);
				loadModUserInfoPane();
			}
		});
		
		mod1=paintModUserTable();
		loadModUserInfoPane();
		
		JButton cancelButton,confirmButton;
		cancelButton=new JButton("取消变迁");
		confirmButton=new JButton("确认修改");
		add(cancelButton);
		add(confirmButton);
		cancelButton.setBounds(530,440,100,40);
		confirmButton.setBounds(650,440,100,40);
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"没有待变迁用户");
					return;
				}
				
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要变迁的用户再进行本次操作");
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
				
				mod1=paintModUserTable();
				remove(modUserInfoPane);
				loadModUserInfoPane();
			}
		});
		
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入解雇用户信息再进行本次操作");
					return;
				}
				getnewList();
				
				SaveInfo inter=new SaveInfoController();
				
				inter.addGM(listgm);
				inter.addSalesman(listsalesman);
				inter.addSM(listsm);
				
				listgm.clear();
				listsalesman.clear();
				listsm.clear();
				
				for(int i=0;i<gmlist.size();i++)
					inter7.delete(gmlist.get(i).gm);
				for(int i=0;i<salesmanlist.size();i++)
					inter8.delete(salesmanlist.get(i).salesman);
				for(int i=0;i<smlist.size();i++)
					searchsm.delete(smlist.get(i).sm);
				
				JOptionPane.showMessageDialog(null,"成功变迁用户！");
				
				inter8=new SearchSalesmanController();
				inter7=new SearchGMController();
				searchsm=new SearchSMController();
				
				gmlist.clear();
				salesmanlist.clear();
				smlist.clear();
				
				mod1=paintModUserTable();
				remove(modUserInfoPane);
				loadModUserInfoPane();
			}
		});
	}
	
	private void getnewList()
	{
		for(int i=0;i<salesmanlist.size();i++)
		{
			NewSalesman Newtemp=salesmanlist.get(i);
			if(Newtemp.newIdentity.equals("收银员"))
			{
				Salesman temp=new Salesman(Newtemp.salesman.getName(),Newtemp.salesman.getID(),Newtemp.newShopNum);
				temp.setPassword(Newtemp.salesman.getPassword());
				listsalesman.add(temp);
			}
			else if(Newtemp.newIdentity.equals("分店经理"))
			{
				StoreManager temp=new StoreManager(Newtemp.salesman.getID(),
						Newtemp.salesman.getPassword(),Newtemp.salesman.getName(),Newtemp.newShopNum);
				listsm.add(temp);
			}
			else
			{
				GeneralManager temp=new GeneralManager(Newtemp.salesman.getID(),
						Newtemp.salesman.getPassword(),Newtemp.salesman.getName());
				listgm.add(temp);
			}
		}
		for(int i=0;i<smlist.size();i++)
		{
			NewStoreManager Newtemp=smlist.get(i);
			if(Newtemp.newIdentity.equals("收银员"))
			{
				Salesman temp=new Salesman(Newtemp.sm.getName(),Newtemp.sm.getID(),Newtemp.newShopNum);
				temp.setPassword(Newtemp.sm.getPassword());
				listsalesman.add(temp);
			}
			else if(Newtemp.newIdentity.equals("分店经理"))
			{
				StoreManager temp=new StoreManager(Newtemp.sm.getID(),
						Newtemp.sm.getPassword(),Newtemp.sm.getName(),Newtemp.newShopNum);
				listsm.add(temp);
			}
			else
			{
				GeneralManager temp=new GeneralManager(Newtemp.sm.getID(),
						Newtemp.sm.getPassword(),Newtemp.sm.getName());
				listgm.add(temp);
			}
		}
		for(int i=0;i<gmlist.size();i++)
		{
			NewGeneralManager Newtemp=gmlist.get(i);
			if(Newtemp.newIdentity.equals("收银员"))
			{
				Salesman temp=new Salesman(Newtemp.gm.getName(),Newtemp.gm.getID(),Newtemp.newShopNum);
				temp.setPassword(Newtemp.gm.getPassword());
				listsalesman.add(temp);
			}
			else if(Newtemp.newIdentity.equals("分店经理"))
			{
				StoreManager temp=new StoreManager(Newtemp.gm.getID(),
						Newtemp.gm.getPassword(),Newtemp.gm.getName(),Newtemp.newShopNum);
				listsm.add(temp);
			}
			else
			{
				GeneralManager temp=new GeneralManager(Newtemp.gm.getID(),
						Newtemp.gm.getPassword(),Newtemp.gm.getName());
				listgm.add(temp);
			}
		}
	}
	
	private boolean isSalesmanInTable(String ID)
	{
		for(int i=0;i<salesmanlist.size();i++)
		{
			if(salesmanlist.get(i).salesman.getID().equals(ID))
				return true;
		}
		return false;
	}
	
	private boolean isSMInTable(String ID)
	{
		for(int i=0;i<smlist.size();i++)
		{
			if(smlist.get(i).sm.getID().equals(ID))
				return true;
		}
		return false;
	}
	
	private boolean isGMInTable(String ID)
	{
		for(int i=0;i<gmlist.size();i++)
		{
			if(gmlist.get(i).gm.getID().equals(ID))
				return true;
		}
		return false;
	}
	
	private MyTableModel paintUserInfoTable(GeneralManager gm,StoreManager sm,Salesman salesman)
	{
		String []columnNames={"工号","姓名","职位","店铺号"};
		String [][]rowData=new String[1][4];
		if(gm!=null)
		{
			rowData[0][0]=gm.getID();
			rowData[0][1]=gm.getName();
			rowData[0][2]="总经理";
			rowData[0][3]="\\";
		}
		else if(sm!=null)
		{
			rowData[0][0]=sm.getID();
			rowData[0][1]=sm.getName();
			rowData[0][2]="分店经理";
			rowData[0][3]=String.valueOf(sm.getShopNum());
		}
		else if(salesman!=null)
		{
			rowData[0][0]=salesman.getID();
			rowData[0][1]=salesman.getName();
			rowData[0][2]="收银员";
			rowData[0][3]=String.valueOf(salesman.getStore());
		}
		else
			rowData=new String[0][0];	
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
		
		personInfoPane=new JScrollPane(userInfo);
		personInfoPane.setBounds(420, 30, 360, 150);
		add(personInfoPane);
	}
	
	private MyTableModel paintModUserTable()
	{
		int n1= salesmanlist.size(),n2=smlist.size(),n3=gmlist.size();
		int total=n1+n2+n3;
		String []columnNames={"工号","姓名","原职位","原店铺号","新职位","新店铺号"};
		String [][]rowData=new String[total][6];
		int i=0;
		for(i=0;i<n1;i++)
		{
			NewSalesman temp=salesmanlist.get(i);
			rowData[i][0]=temp.salesman.getID();
			rowData[i][1]=temp.salesman.getName();
			rowData[i][2]="收银员";
			rowData[i][3]=String.valueOf(temp.salesman.getStore());
			rowData[i][4]=temp.newIdentity;
			rowData[i][5]=String.valueOf(temp.newShopNum);
		}
		int j=i;
		for(;j<n1+n2;j++)
		{
			NewStoreManager temp=smlist.get(j-i);
			rowData[j][0]=temp.sm.getID();
			rowData[j][1]=temp.sm.getName();
			rowData[j][2]="分店经理";
			rowData[j][3]=String.valueOf(temp.sm.getShopNum());
			rowData[j][4]=temp.newIdentity;
			rowData[j][5]=String.valueOf(temp.newShopNum);
		}
		i=j;
		for(;i<total;i++)
		{
			NewGeneralManager temp=gmlist.get(i-j);
			rowData[i][0]=temp.gm.getID();
			rowData[i][1]=temp.gm.getName();
			rowData[i][2]="总经理";
			rowData[i][3]="\\";
			rowData[i][4]=temp.newIdentity;
			rowData[i][5]=String.valueOf(temp.newShopNum);
		}
		MyTableModel mod1=new MyTableModel(rowData,columnNames);
		return mod1;
	}
	
	public void loadModUserInfoPane()
	{	
		modUserInfo=new JTable(mod1);
		modUserInfo.getTableHeader().setReorderingAllowed(false);
		modUserInfo.getTableHeader().setResizingAllowed(false);
		modUserInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		modUserInfo.setDefaultRenderer(Object.class,r);
		
		modUserInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e) {
				selIndex=modUserInfo.getSelectedRow();
			}
		});
		
		modUserInfoPane=new JScrollPane(modUserInfo);
		modUserInfoPane.setBounds(130,260,650,170);
		add(modUserInfoPane);
	}
}

class NewSalesman
{
	Salesman salesman;
	String newIdentity;
	int newShopNum;
}

class NewStoreManager
{
	StoreManager sm;
	String newIdentity;
	int newShopNum;
}

class NewGeneralManager
{
	GeneralManager gm;
	String newIdentity;
	int newShopNum;
}
