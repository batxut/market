package server.GUI;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlers.CheckVIPControler;
import data.user.VIPCustomer;
import Interface.CheckVIPInterface;

public class CheckVIPPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<VIPCustomer> VIP_searched = new ArrayList<VIPCustomer>();
	ArrayList<VIPCustomer> VIPsOfCheck = new ArrayList<VIPCustomer>();

	JLabel checkWay;
	Choice choice;
	JTextField checkBox;
	JButton check;
	JTable VIPInfo;
	JScrollPane VIPInfoPane;

	private String typeCheck = "ID查询", IDCheck = "等级查询", priceCheck = "姓名查询",
			wholeCheck = "全局查询";
	private String[] columnNames = { "ID", "姓名", "等级", "积分总额", "积分余额", "生日",
			"联系方式" };
	private String[][] rowData;
	DefaultTableModel mod = new DefaultTableModel(null, columnNames);

	public CheckVIPPanel(ArrayList<VIPCustomer> VIP) {
		this.VIP_searched = VIP;
		this.setLayout(null);
	}

	// 初始化相应的组件
	private void initComponent() {
		checkWay = new JLabel("请选择查询方式：");
		checkWay.setBounds(30, 15, 120, 20);
		this.add(checkWay);

		choice = new Choice();
		choice.add(typeCheck);
		choice.add(IDCheck);
		choice.add(priceCheck);
		choice.add(wholeCheck);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				if (choice.getSelectedItem().equals("全局查询")) {
					checkBox.setEditable(false);
				}
				else{
					checkBox.setEditable(true);
				}
			}
		});
		choice.setLocation(150, 18);
		this.add(choice);

		checkBox = new JTextField();
		checkBox.setBounds(240, 15, 120, 30);
		this.add(checkBox);

		check = new JButton("查询");
		check.setBounds(380, 15, 80, 30);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (checkBox.getText().equals("")
						&& !choice.getSelectedItem().equals("全局查询"))
					JOptionPane.showMessageDialog(CheckVIPPanel.this, "输入不能为空~");
				else {
					CheckVIPInterface controler = new CheckVIPControler();
					String selected_item = choice.getSelectedItem();
					String input = checkBox.getText().trim();
					if (selected_item.equals("ID查询"))
						VIP_searched = controler.searchVIPByID(input);
					if (selected_item.equals("等级查询"))
						VIP_searched = controler.searchVIPByLevel(Integer
								.parseInt(input));
					if (selected_item.equals("姓名查询"))
						VIP_searched = controler.searchVIPByName(input);
					if (selected_item.equals("全局查询")) {
						VIP_searched = controler.generalSearch();
					}

					if (VIP_searched.size() != 0) {
						rowData = showOriginalInfo();
						mod = new DefaultTableModel(rowData, columnNames);
						remove(VIPInfoPane);
						loadVIPsInfo();

					} else {
						JOptionPane.showMessageDialog(CheckVIPPanel.this,
								"没有对应的会员！", "提示", 1);
						checkBox.setText(null);
					}
				}
			}
		});
		this.add(check);

		this.loadVIPsInfo();
	}

	private void loadVIPsInfo() {
		VIPInfo = new JTable(mod);
		VIPInfo.setEnabled(false);

		VIPInfoPane = new JScrollPane(VIPInfo);
		VIPInfoPane.setBounds(30, 70, 745, 240);
		this.add(VIPInfoPane);
	}

	public void showPanel() {
		initComponent();
	}

	private String[][] showOriginalInfo() {
		String[][] rowData1 = new String[VIP_searched.size()][7];
		for (int i = 0; i < VIP_searched.size(); i++) {
			rowData1[i][0] = VIP_searched.get(i).getID();
			rowData1[i][1] = VIP_searched.get(i).getName();
			rowData1[i][2] = "" + (VIP_searched.get(i).getGrade());
			rowData1[i][3] = "" + VIP_searched.get(i).getPoint();
			rowData1[i][4] = "" + VIP_searched.get(i).getleft_point();
			rowData1[i][5] = VIP_searched.get(i).getBirthday().toString();
			rowData1[i][6] = VIP_searched.get(i).getTele();
		}
		return rowData1;
	}
}
