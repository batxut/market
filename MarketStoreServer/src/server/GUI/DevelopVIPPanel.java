package server.GUI;

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
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Controlers.DevelopVIPControler;
import data.MyDate;
import data.user.VIPCustomer;
import Interface.DevelopVIPInterface;

public class DevelopVIPPanel extends JPanel{
	private static final long serialVersionUID = 1L;
    ArrayList<VIPCustomer> VIPs;
    MyDate current =MyDate.getDate();
    private boolean info_right = true;
    ArrayList<VIPCustomer> VIPlist=new ArrayList<VIPCustomer>();
    JLabel VIPname,VIPlevel,VIPpoint,leftPoint,VIPbirthday,VIPtele;
    JTextField nameInput,levelInput,pointInput,leftpointInput,teleInput;//birthdayInput,teleInput;
    JButton addItem, renewItem, sureAddItem, deleteLastItem;
    
    JSpinner birth_year;
    JSpinner birth_month;
    JSpinner birth_day;
    
    JLabel inputVIPsInfoShow;
	JTable newVIPsInfo;
	JScrollPane VIPsInfoPane;
	
	private String[] columnNames = { "ID", "姓名", "等级", "积分","积分余额","生日","联系方式" };
	private String[][] rowData;
	DefaultTableModel mod = new DefaultTableModel(rowData, columnNames);

	DevelopVIPInterface controler=new DevelopVIPControler();

	public DevelopVIPPanel(ArrayList<VIPCustomer> vips) {
		this.VIPs = vips;
		this.setLayout(null);
	}
	
	//初始化响应的组件
	private void initComponent() {
		VIPname = new JLabel("会员姓名：");
		VIPname.setBounds(30, 25, 80, 30);
		this.add(VIPname);

		leftPoint = new JLabel("积分余额：");
		leftPoint.setBounds(30, 70, 80, 30);
		this.add(leftPoint);
		
		VIPlevel = new JLabel("会员等级：");
		VIPlevel.setBounds(270, 25, 80, 30);
		this.add(VIPlevel);

		VIPpoint = new JLabel("会员积分：");
		VIPpoint.setBounds(510, 25, 80, 30);
		this.add(VIPpoint);
		
		VIPbirthday = new JLabel("会员生日：");
		VIPbirthday.setBounds(270, 70, 80, 30);
		this.add(VIPbirthday);
		
		VIPtele = new JLabel("联系方式：");
		VIPtele.setBounds(510, 70, 80, 30);
		this.add(VIPtele);

		nameInput = new JTextField();
		nameInput.setBounds(100, 25, 100, 30);
		this.add(nameInput);

		leftpointInput = new JTextField();
		leftpointInput.setBounds(100, 75, 100, 30);
		this.add(leftpointInput);
		
		levelInput = new JTextField();
		levelInput.setBounds(350, 25, 100, 30);
		this.add(levelInput);

		birth_year = new JSpinner(new SpinnerNumberModel(current.getYear(),1911,current.getYear(),1));
		birth_year.setBounds(350,75,60,30);
		birth_month = new JSpinner(new SpinnerNumberModel(current.getMonth(),1,12,1));
		birth_month.setBounds(410,75,35,30);
		birth_day = new JSpinner(new SpinnerNumberModel(current.getDay(),1,31,1));
		birth_day.setBounds(445,75,35,30);
		this.add(birth_year);
		this.add(birth_month);
		this.add(birth_day);
		
		pointInput=new JTextField();
		pointInput.setBounds(570, 25, 100, 30);
		this.add(pointInput);
		
		teleInput=new JTextField();
		teleInput.setBounds(570, 75, 100, 30);
		this.add(teleInput);
		
		
		addItem = new JButton("生成会员信息");
		addItem.setBounds(220, 115, 120, 30);
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String VIPname = nameInput.getText().trim();
				String levelstr = levelInput.getText().trim();
				String pointstr = pointInput.getText().trim();
				String leftpstr=leftpointInput.getText().trim();
				String tele=teleInput.getText().trim();
				int level = 0;
				int point = 0;
				int left_point = 0;
				
				if(VIPname.equals("")||levelstr.equals("")||pointstr.equals("")||leftpstr.equals("")||tele.equals("")){
					JOptionPane.showMessageDialog(DevelopVIPPanel.this, "会员信息不完整！","提示",1);
					info_right = false;
				}else{
				 level=Integer.parseInt(levelstr);
				 point =Integer.parseInt(pointstr);
				 left_point = Integer.parseInt(leftpstr);
				 if(left_point > point || level < 1 || point < 0 || left_point <0){
					 JOptionPane.showMessageDialog(DevelopVIPPanel.this,"会员信息有误！","提示",1);
					 info_right = false;
				 }
				    
				}
				
				int year = (Integer)birth_year.getValue();
				int month = (Integer)birth_month.getValue();
				int day =(Integer)birth_day.getValue();
				MyDate birthday = new MyDate(year,month,day);
				
				
				// 生成会员
				if (info_right ==true) {
					System.out.println(info_right);
					String VIPID = getVIPID();
					VIPCustomer avip = new VIPCustomer(VIPID, VIPname, level, point, left_point,birthday, tele);
					VIPlist.add(avip);
					rowData = showVIPInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(VIPsInfoPane);
					loadNewVIPInfo();
				}
				
			}
		});
		this.add(addItem);

		renewItem = new JButton("重置信息"); // 清空当前Text中的文本
		renewItem.setBounds(360, 115, 100, 30);
		renewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				renewVIPsInfo();
			}
		});
		this.add(renewItem);

		inputVIPsInfoShow = new JLabel("新增会员信息显示：");
		inputVIPsInfoShow.setBounds(30, 150, 140, 30);
		this.add(inputVIPsInfoShow);

		sureAddItem = new JButton("确定增加");
		sureAddItem.setBounds(220, 395, 100, 30);
		sureAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (VIPlist.size() > 0) {
					boolean add_success = controler.addVIPs(VIPlist);
					if (add_success) {
						JOptionPane.showMessageDialog(DevelopVIPPanel.this,"增加会员成功！", "提示", 1);
					} 
					else {
						JOptionPane.showMessageDialog(DevelopVIPPanel.this,"增加会员失败！请重新输入", "警告", 2);
					}
					VIPlist.removeAll(VIPlist);
					rowData = showVIPInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(VIPsInfoPane);
					loadNewVIPInfo();
				} else {
					JOptionPane.showMessageDialog(DevelopVIPPanel.this,
							"请填写完整会员信息！", "警告", 2);
				}
			}
		});
		this.add(sureAddItem);

		deleteLastItem = new JButton("删除上一个顾客"); // 删除最后一条信息
		deleteLastItem.setBounds(340, 395, 140, 30);
		deleteLastItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int size = VIPlist.size();
				if (size > 0) {
					VIPlist.remove(size - 1);
					rowData = showVIPInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(VIPsInfoPane);
					loadNewVIPInfo();
				}
			}
		});
		this.add(deleteLastItem);

		this.loadNewVIPInfo();
	}

	public void showPanel() {
		initComponent();
	}

	private void renewVIPsInfo() {
		nameInput.setText("");
		levelInput.setText("");
		pointInput.setText("");
		leftpointInput.setText("");
		birth_year.setValue(current.getYear());
		birth_month.setValue(current.getMonth());
		birth_day.setValue(current.getDay());
		teleInput.setText("");
		
	}

	private void loadNewVIPInfo() {
		newVIPsInfo = new JTable(mod);
		newVIPsInfo.setEnabled(false);

		VIPsInfoPane = new JScrollPane(newVIPsInfo);
		VIPsInfoPane.setBounds(30, 180, 720, 200);
		this.add(VIPsInfoPane);
	}

	private String[][] showVIPInfo() {
		String[][] rowData = new String[VIPlist.size()][7];
		for (int i = 0; i < VIPlist.size(); i++) {
			rowData[i][0] = VIPlist.get(i).getID();
			rowData[i][1] = VIPlist.get(i).getName();
			rowData[i][2] =""+ VIPlist.get(i).getGrade();
			rowData[i][3] =Integer.toString(VIPlist.get(i).getPoint());
			rowData[i][4] =Integer.toString(VIPlist.get(i).getleft_point());
			rowData[i][5] =VIPlist.get(i).getBirthday().toString();
			rowData[i][6] =VIPlist.get(i).getTele();
		}
		return rowData;
	}
	
	private String getVIPID(){
		DevelopVIPInterface controler2=new DevelopVIPControler();
		int present_num = controler2.getPresentNum();
		int ID=present_num+VIPlist.size()+1;
		String IDstr = Integer.toString(ID);
		return IDstr;
	}
}

