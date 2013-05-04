package view.admin;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import logic.SaveInfoController;
import logic.Controll4;

import server_interface.IsIDRepeated;
import server_interface.SaveInfo;
import view.MyTableModel;

import data.user.*;

public class AdministratorAddUserPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonGroup bg;
	JRadioButton cashier, branchManager, gmanager;
	JTextField nameField, IDField, shopNumField;
	JPasswordField passwordField;
	
	MyTableModel mod;
	JTable userInfo;
	JScrollPane personInfoPane;
	
	ArrayList<Salesman> salesmanlist;
	ArrayList<StoreManager> smlist;
	ArrayList<GeneralManager> gmlist;
	
	int selIndex=-1;
	
	public AdministratorAddUserPanel() 
	{
		setLayout(null);
		salesmanlist=new ArrayList<Salesman>();
		gmlist=new ArrayList<GeneralManager>();
		smlist=new ArrayList<StoreManager>();
	}

	public void showPanel() {
		
		String []columnNames={"工号","姓名","职位","店铺号","密码"};
		String [][]rowData={};
	
		mod=new MyTableModel(rowData,columnNames);
		loadPersonInfoPane();
		
		JLabel jlb1 = new JLabel("请选择要创建的用户:");
		jlb1.setBounds(120, 30, 150, 30);
		jlb1.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlb1);
		cashier = new JRadioButton("收银员");
		branchManager = new JRadioButton("分店经理");
		gmanager = new JRadioButton("总经理");
		
		cashier.setBounds(140, 70, 100, 20);
		branchManager.setBounds(140, 100, 100, 20);
		gmanager.setBounds(140, 130, 100, 20);

		add(cashier);
		add(branchManager);
		add(gmanager);

		bg = new ButtonGroup();
		bg.add(cashier);
		bg.add(branchManager);
		bg.add(gmanager);
		cashier.setSelected(true);

		nameField = new JTextField(10);
		IDField = new JTextField(10);
		passwordField = new JPasswordField(10);
		shopNumField = new JTextField(10);

		add(nameField);
		add(IDField);
		add(passwordField);
		add(shopNumField);
		
		nameField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				nameField.selectAll();
				nameField.setForeground(null);
			}
		});
		
		IDField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				IDField.selectAll();
				IDField.setForeground(null);
			}
		});
		
		passwordField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				passwordField.selectAll();
			}
		});
		
		shopNumField.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				shopNumField.selectAll();
			}
		});

		JLabel jlb2 = new JLabel("请输入姓名");
		JLabel jlb3 = new JLabel("请输入工号");
		JLabel jlb4 = new JLabel("请输入密码");
		JLabel jlb5 = new JLabel("所属店铺号");

		add(jlb2);
		add(jlb3);
		add(jlb4);
		add(jlb5);
		
		jlb2.setBounds(260, 60, 100, 30);
		nameField.setBounds(350, 60, 100, 30);
		
		jlb3.setBounds(470, 60, 100, 30);
		IDField.setBounds(580, 60, 100, 30);
		
		jlb4.setBounds(260, 120,100, 30);
		passwordField.setBounds(350, 120, 100,30);
		
		jlb5.setBounds(470, 120, 100,30);
		shopNumField.setBounds(580, 120, 100, 30);

		MyButton sureButton = new MyButton();
		add(sureButton);
		sureButton.setBounds(710, 70, 50, 70);
		
		cashier.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e) {
				shopNumField.setEditable(true);
			}
		});

		branchManager.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e) {
				shopNumField.setEditable(true);
			}
		});

		gmanager.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e) {
				shopNumField.setEditable(false);
			}
		});
		
		
		sureButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name=nameField.getText();
				String ID=IDField.getText();
				String password=new String(passwordField.getPassword());
				try
				{
					Integer.parseInt(ID);
				}
				catch(Exception ee)
				{
					IDField.setText("必须是数字串");
					IDField.setForeground(Color.RED);
					return;
				}
				if(name.equals("")||password.equals(""))
				{
					nameField.setText("不能为空");
					nameField.setForeground(Color.RED);
					passwordField.setText(null);
				}
				else
				{
					IsIDRepeated inter=new Controll4();
					if(inter.isIDrepeated(ID)>0)
					{
						JOptionPane.showMessageDialog(null, "该账号已存在!");
						IDField.setText(null);
						return;
					}
					if(isSalesmanInTable(ID)||isSMInTable(ID)||isGMInTable(ID))
					{
						JOptionPane.showMessageDialog(null, "该账号已在列表中!");
						IDField.setText(null);
						return;
					}
					if(cashier.isSelected())
					{
						try
						{
							int n=Integer.parseInt(shopNumField.getText());	
							Salesman salesman=new Salesman(name,ID,n);
							salesman.setPassword(password);
							salesmanlist.add(salesman);
							mod=paintTable();
							remove(personInfoPane);
							loadPersonInfoPane();
							
							nameField.setText(null);
							IDField.setText(null);
							passwordField.setText(null);
							shopNumField.setText(null);
							
						}
						catch(Exception ee)
						{
							shopNumField.setText("输入不合法");
						}
					}
					else if(branchManager.isSelected())
					{
						try
						{
							int n=Integer.parseInt(shopNumField.getText());	
							StoreManager sm=new StoreManager(name,ID,password,n);
							smlist.add(sm);
							mod=paintTable();
							remove(personInfoPane);
							loadPersonInfoPane();
							
							nameField.setText(null);
							IDField.setText(null);
							passwordField.setText(null);
							shopNumField.setText(null);
						}
						catch(Exception ee)
						{
							shopNumField.setText("输入不合法");
						}
					}
					else if(gmanager.isSelected())
					{
						GeneralManager gm=new GeneralManager(ID,password,name);
						gmlist.add(gm);
						mod=paintTable();
						remove(personInfoPane);
						loadPersonInfoPane();
						
						nameField.setText(null);
						IDField.setText(null);
						passwordField.setText(null);
					}
				}
			}
		});
		
		JButton cancelButton,confirmButton;
		cancelButton=new JButton("取消雇佣");
		confirmButton=new JButton("确认雇佣");
		add(cancelButton);
		add(confirmButton);
		
		cancelButton.setBounds(670,400,100,40);
		confirmButton.setBounds(550,400,100,40);
		
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请先输入雇佣者信息再进行本次操作");
					return;
				}
				SaveInfo inter=new SaveInfoController();
				inter.addGM(gmlist);
				inter.addSalesman(salesmanlist);
				inter.addSM(smlist);
				gmlist.clear();
				salesmanlist.clear();
				smlist.clear();
				
				JOptionPane.showMessageDialog(null,"成功雇佣新用户！");
				
				mod=paintTable();
				remove(personInfoPane);
				loadPersonInfoPane();
				
			}
		});
		
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(gmlist.isEmpty()&&salesmanlist.isEmpty()&&smlist.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"没有待雇佣用户");
					return;
				}
				if(selIndex==-1)
				{
					JOptionPane.showMessageDialog(null,"请先选择要取消雇佣的用户再进行本次操作");
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
		personInfoPane.setBounds(140, 200, 650, 190);
		add(personInfoPane);
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
			rowData[j][3]=String.valueOf(smlist.get(i).getShopNum());
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
	
	private boolean isSalesmanInTable(String ID)
	{
		for(int i=0;i<salesmanlist.size();i++)
		{
			if(salesmanlist.get(i).getID().equals(ID))
				return true;
		}
		return false;
	}
	
	private boolean isSMInTable(String ID)
	{
		for(int i=0;i<smlist.size();i++)
		{
			if(smlist.get(i).getID().equals(ID))
				return true;
		}
		return false;
	}
	
	private boolean isGMInTable(String ID)
	{
		for(int i=0;i<gmlist.size();i++)
		{
			if(gmlist.get(i).getID().equals(ID))
				return true;
		}
		return false;
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
			g.drawString("确",20,25);
			g.drawString("定",20,50);
		}
	}
}