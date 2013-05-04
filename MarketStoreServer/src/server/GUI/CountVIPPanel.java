package server.GUI;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlers.CountVIPControler;
import data.user.VIPCustomer;
import Interface.CountVIPInterface;

public class CountVIPPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<VIPCustomer> VIPs;

	JLabel countVIP,countWay,detailShow,detail;
	Choice countChoice,checkChoice;
	JTextField checkBox;
	JButton count,check;

	JLabel VIPCountInfoShow;
	JTable VIPCountInfo;
	JScrollPane VIPCountInfoPane;

	JLabel VIPDetailInfoShow;
	JTable VIPDetailInfo;
	JScrollPane VIPDetailInfoPane;

	private String gradeCount = "�ȼ�ͳ��", pointCount = "����ͳ��";
	
	private String[] countColumnNames1={"�ȼ�","����"},countColumnNames2={"��������","����"};
	private String[][] VIPsCount_RowData;
	DefaultTableModel countMod = new DefaultTableModel(null, countColumnNames1);
	
	private String[] detailColumnNames1={"�ȼ�","����","ID","����"},detailColumnNames2={"����","����","ID","�ȼ�"} ;
	private String[][] VIPsDetail_RowData;
	DefaultTableModel detailMod = new DefaultTableModel(null, detailColumnNames1);
	
	public CountVIPPanel() {
		this.setLayout(null);
	}

	// ��ʼ����Ӧ�����
	private void initComponent() {
		countWay = new JLabel("��ѡ��ͳ�Ʒ�ʽ��");
		countWay.setBounds(30, 10, 120, 30);
		this.add(countWay);

		countChoice = new Choice();
		countChoice.add(gradeCount);
		countChoice.add(pointCount);
		countChoice.setLocation(160, 18);
		this.add(countChoice);

		count = new JButton("ͳ��");
		count.setBounds(260, 15, 80, 30);
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				CountVIPInterface countVIPControler=new CountVIPControler();
				String selected_item=countChoice.getSelectedItem();
				VIPs=countVIPControler.countByGrade();
				VIPsCount_RowData=showVIPsCountInfo();
				if(selected_item.equals(gradeCount)){
					detailShow.setText("�鿴������Ϣ:   ��ѡ���ض��ȼ��� ");
					countMod=new DefaultTableModel(VIPsCount_RowData, countColumnNames1);
				}
				else if(selected_item.equals(pointCount)){
					detailShow.setText("�鿴������Ϣ:   ��ѡ���ض��������Σ� ");
					countMod=new DefaultTableModel(VIPsCount_RowData, countColumnNames2);
				}
				remove(VIPCountInfoPane);
				loadVIPCountInfo();
			}
		});
		this.add(count);
		
		VIPCountInfoShow = new JLabel("�˿�ͳ����Ϣ��ʾ��");
		VIPCountInfoShow.setBounds(30, 40, 120, 20);
		this.add(VIPCountInfoShow);
		this.loadVIPCountInfo();
		
		detailShow = new JLabel("�鿴������Ϣ�� ");
		detailShow.setBounds(30, 200, 240, 20);
		this.add(detailShow);
		
		checkChoice = new Choice();
		checkChoice.setBounds(280, 198,80,20);
		this.add(checkChoice);
		
		check = new JButton("�鿴");
		check.setBounds(380, 195, 80, 30);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String selected_item=countChoice.getSelectedItem();
				VIPsDetail_RowData=showVIPsDetailInfo();
				if(selected_item.equals(gradeCount)){
					detailMod=new DefaultTableModel(VIPsDetail_RowData, detailColumnNames1);
				}
				else if(selected_item.equals(pointCount)){
					detailMod=new DefaultTableModel(VIPsDetail_RowData, detailColumnNames2);
				}
				remove(VIPDetailInfoPane);
				loadVIPDetailInfo();
			}
		});
		this.add(check);
		
		VIPDetailInfoShow = new JLabel("�˿���ϸ��Ϣ��ʾ��");
		VIPDetailInfoShow.setBounds(30,220, 120, 30);
		this.add(VIPDetailInfoShow);
		
		this.loadVIPDetailInfo();

	}
	
	public void showPanel() {
		initComponent();
	}
	
	private void loadVIPCountInfo() {
		VIPCountInfo = new JTable(countMod);
		VIPCountInfo.setEnabled(false);

		VIPCountInfoPane = new JScrollPane(VIPCountInfo);
		VIPCountInfoPane.setBounds(30, 80, 720, 100);
		this.add(VIPCountInfoPane);
	}
	
	private String[][] showVIPsCountInfo(){
		checkChoice.removeAll();
		int range=VIPs.size();
		int[][] countRowData=new int[VIPs.size()][2];
		for (int i = 0; i < VIPs.size(); i++) {
			VIPCustomer VIP =   VIPs.get(i);
			if(countChoice.getSelectedItem().equals(gradeCount)){
				countRowData[i][0] = VIP.getGrade();
				countRowData[i][1]=1;
			}
			else if(countChoice.getSelectedItem().equals(pointCount)){
				countRowData[i][0] = VIP.getPoint();
				countRowData[i][1]=1;
			}
		}
		for (int i=0; i<VIPs.size();i++){
			for(int j=i+1;j<VIPs.size();j++){
				if(countRowData[j][0]==countRowData[i][0]){
					if(countRowData[j][1]>0){
						countRowData[i][1]++;
						countRowData[j][1]--;
						range--;
					}
				}
			}
		}
		String [][] rowData = new String[range][2];
		int j=0;
		for(int i=0;i<range;i++){
			while(countRowData[j][1]<=0){
				j++;
			}
			rowData[i][0]=String.valueOf(countRowData[j][0]);
			rowData[i][1]=String.valueOf(countRowData[j][1]);
			checkChoice.add(rowData[i][0]);
			j++;
		}
		return rowData;
	}
	
	private void loadVIPDetailInfo() {
		VIPDetailInfo = new JTable(detailMod);
		VIPDetailInfo.setEnabled(false);

		VIPDetailInfoPane = new JScrollPane(VIPDetailInfo);
		VIPDetailInfoPane.setBounds(30, 260, 720, 180);
		this.add(VIPDetailInfoPane);
	}
	
	private String[][] showVIPsDetailInfo(){
		ArrayList<VIPCustomer> datailsVIP = new ArrayList<VIPCustomer>();
		if(countChoice.getSelectedItem().equals(gradeCount)){
			for(int i=0;i<VIPsCount_RowData.length;i++){
				if(VIPs.get(i).getGrade()==Integer.parseInt(checkChoice.getSelectedItem())){
					datailsVIP.add(VIPs.get(i));
				}
			}
		}
		else if(countChoice.getSelectedItem().equals(pointCount)){
			for(int i=0;i<VIPsCount_RowData.length;i++){
				if(VIPs.get(i).getPoint()==Integer.parseInt(checkChoice.getSelectedItem())){
					datailsVIP.add(VIPs.get(i));
				}
			}
		}
		String[][] rowData = new String[datailsVIP.size()][4];
		for(int i=0;i<datailsVIP.size();i++){
			VIPCustomer VIP =   datailsVIP.get(i);
			if(countChoice.getSelectedItem().equals(gradeCount)){
				rowData[i][0] = String.valueOf(VIP.getGrade());
				rowData[i][3] = String.valueOf(VIP.getPoint());
			}
			else if(countChoice.getSelectedItem().equals(pointCount)){
				rowData[i][3] = String.valueOf(VIP.getGrade());
				rowData[i][0] = String.valueOf(VIP.getPoint());
			}
			rowData[i][1] = VIP.getName();
			rowData[i][2] = VIP.getID();
			
		}
		return rowData;
	}
}

	