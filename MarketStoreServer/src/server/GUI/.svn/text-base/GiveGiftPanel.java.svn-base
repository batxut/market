package server.GUI;

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
import javax.swing.table.DefaultTableModel;

import Controlers.GiveGiftControler;
import data.Goods;
import data.user.VIPCustomer;
import Interface.GiveGiftInterface;

public class GiveGiftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<VIPCustomer> giftVIPs;
	ArrayList<Goods> gifts;

	GiveGiftInterface giveGiftControler ;
	
	JLabel VIPInfoShow, oneVIPShow, giftInfoShow, oneGiftShow;
	JTextField inputVIP, inputGift;
	JButton beingCheck, beginGift, sureGift;
	JTable VIPInfo, giftInfo;
	JScrollPane VIPInfoPane, giftInfoPane;

	private String[] VIPColumnNames = { "ID", "积分 ", "等级", "顾客名称","顾客生日","是否获赠","礼品名" };
	DefaultTableModel VIPMod = new DefaultTableModel(null, VIPColumnNames);
	private String[][] giftVIPsRowData, giftsRowData;
	private String[] giftColumnNames = { "类别", "ID", "数量", "价格", "赠送要求" };
	DefaultTableModel giftMod = new DefaultTableModel(null, giftColumnNames);

	public GiveGiftPanel() {
		this.setLayout(null);
		giveGiftControler = new GiveGiftControler();
	}

	private void initComponent() {
		beingCheck = new JButton("开始查询");
		beingCheck.setBounds(30, 10, 100, 30);
		beingCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				giftVIPs = giveGiftControler.searchGiftVIP();
				giftVIPsRowData = showVIPsInfo();
				VIPMod = new DefaultTableModel(giftVIPsRowData, VIPColumnNames);
				remove(VIPInfoPane);
				loadVIPInfo();
			}
		});
		this.add(beingCheck);

		VIPInfoShow = new JLabel("享受礼品的顾客列表：");
		VIPInfoShow.setBounds(30, 40, 160, 30);
		this.add(VIPInfoShow);

		oneVIPShow = new JLabel("输入特定顾客的ID：");
		oneVIPShow.setBounds(30, 200, 120, 30);
		this.add(oneVIPShow);

		inputVIP = new JTextField();
		inputVIP.setBounds(170, 205, 100, 30);
		this.add(inputVIP);

		beginGift = new JButton("开始选择礼品");
		beginGift.setBounds(330, 205, 120, 30);
		beginGift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String VIPID = inputVIP.getText();	
				boolean isCheck=giveGiftControler.checkVIPID(VIPID);
				if(isCheck){
					gifts = giveGiftControler.searchGifts();
					giftsRowData = showGiftsInfo();
					giftMod = new DefaultTableModel(giftsRowData,giftColumnNames);
					remove(giftInfoPane);
					loadGiftInfo();
				}
				else{
					JOptionPane.showMessageDialog(GiveGiftPanel.this,"VIPID有误！", "提示", 1);
				}
			}
		});
		this.add(beginGift);

		giftInfoShow = new JLabel("对应赠品列表：");
		giftInfoShow.setBounds(30, 240, 120, 30);
		this.add(giftInfoShow);

		oneGiftShow = new JLabel("输入特定礼品：");
		oneGiftShow.setBounds(30, 440, 120, 30);
		this.add(oneGiftShow);

		inputGift = new JTextField();
		inputGift.setBounds(170, 445, 100, 30);
		this.add(inputGift);

		sureGift = new JButton("开始赠送");
		sureGift.setBounds(330, 445, 120, 30);
		sureGift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String VIPID = "";
				String giftID = "";
				VIPID = inputVIP.getText();
				giftID = inputGift.getText();
				if (giveGiftControler.giveGift(VIPID, giftID)) {
					JOptionPane.showMessageDialog(GiveGiftPanel.this,"礼品赠送成功！", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(GiveGiftPanel.this,"礼品号错误或是会员已获赠！", "提示", 1);
				}
			}
		});
		this.add(sureGift);

		this.loadVIPInfo();
		this.loadGiftInfo();
	}

	private void loadVIPInfo() {
		VIPInfo = new JTable(VIPMod);
		VIPInfo.setEnabled(false);

		VIPInfoPane = new JScrollPane(VIPInfo);
		VIPInfoPane.setBounds(30, 80, 720, 100);
		this.add(VIPInfoPane);
	}

	private String[][] showVIPsInfo() {
		String[][] rowData = new String[giftVIPs.size()][7];
		for (int i = 0; i < giftVIPs.size(); i++) {
			VIPCustomer VIP = giftVIPs.get(i);
			rowData[i][0] = VIP.getID();
			rowData[i][1] = String.valueOf(VIP.getGrade());
			rowData[i][2] = String.valueOf(VIP.getleft_point());
			rowData[i][3] = VIP.getName();
			rowData[i][4] = VIP.getBirthday().toString();
			rowData[i][5] = (VIP.getGift()!=null)?"已获赠":"未获赠";
			rowData[i][6] = (VIP.getGift()!=null)?VIP.getGift().getName():"";
		}
		return rowData;
	}

	private void loadGiftInfo() {
		giftInfo = new JTable(giftMod);
		giftInfo.setEnabled(false);

		giftInfoPane = new JScrollPane(giftInfo);
		giftInfoPane.setBounds(30, 270, 720, 160);
		this.add(giftInfoPane);
	}

	private String[][] showGiftsInfo() {
		String[][] rowData = new String[gifts.size()][5];
		for (int i = 0; i < gifts.size(); i++) {
			Goods gift = gifts.get(i);
			rowData[i][0] = gift.getName();
			rowData[i][1] = gift.getID();
			rowData[i][2] = String.valueOf(gift.getPresentNum());
			rowData[i][3] = String.valueOf(gift.getOriginalCost());
			rowData[i][4] = "顾客未获赠";
		}
		return rowData;
	}

	public void showPanel() {
		initComponent();
	}
}
