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

import Controlers.Input_GoodsControler;
import Interface.Input_GoodsInterface;
import data.Goods;
import data.MyDate;



public class InputGoodsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<Goods> goods;
	ArrayList<Goods> goodslist = new ArrayList<Goods>();
	private boolean info_right = true;
    MyDate current_date = MyDate.getDate();
	JLabel inputGoods;
	JLabel goodsType, goodsID, goodsPrice, goodsNumber,produce_date,scrap_date;
	JTextField typeInput, IDInput, priceInput, numberInput;
	JButton addItem, renewItem, sureAddItem, deleteLastItem;
	JSpinner produce_day;   //������
	JSpinner produce_month;
	JSpinner produce_year;
	JSpinner scrap_day;    //������
	JSpinner scrap_month;
	JSpinner scrap_year;
	

	JLabel inputGoodsInfoShow;
	JTable newGoodsInfo;
	JScrollPane goodsInfoPane;

	private String[] columnNames = { "����", "ID", "�۸�", "����" ,"��������","��������"};
	private String[][] rowData;
	DefaultTableModel mod = new DefaultTableModel(rowData, columnNames);

	Input_GoodsInterface controler = new Input_GoodsControler();

	public InputGoodsPanel(ArrayList<Goods> goods) {
		this.goods = goods;
		this.setLayout(null);
	}

	// ��ʼ����Ӧ�����
	private void initComponent() {
		goodsType = new JLabel("��Ʒ���ƣ�");
		goodsType.setBounds(30, 30, 80, 30);
		this.add(goodsType);

		goodsID = new JLabel("��ƷID�ţ�");
		goodsID.setBounds(275,30,80,30);
		this.add(goodsID);

		goodsPrice = new JLabel("��Ʒ�۸�");
		goodsPrice.setBounds(500,30,90,30);
		this.add(goodsPrice);

		goodsNumber = new JLabel("��Ʒ��Ŀ��");
		goodsNumber.setBounds(30,70,80,30);
		this.add(goodsNumber);
		
		produce_date = new JLabel("�������ڣ�");
		produce_date.setBounds(275,70,80,30);
		this.add(produce_date);
		
		scrap_date = new JLabel("��������:");
		scrap_date.setBounds(500,70,90,30);
		this.add(scrap_date);

		typeInput = new JTextField();
		typeInput.setBounds(110, 30, 100, 30);
		this.add(typeInput);

		IDInput = new JTextField();
		IDInput.setBounds(360, 30, 100, 30);
		IDInput.setEditable(false);
		IDInput.setText(getGoodsID());
		this.add(IDInput);

		priceInput = new JTextField();
		priceInput.setBounds(585, 30, 100, 30);
		this.add(priceInput);
        
		numberInput = new JTextField();
		numberInput.setBounds(110, 70, 100, 30);
		this.add(numberInput);
		
		produce_day = new JSpinner(new SpinnerNumberModel(current_date.getDay(),1,31,1));
		produce_day.setBounds(455,70,35,30);
		produce_month = new JSpinner(new SpinnerNumberModel(current_date.getMonth(),1,12,1));
		produce_month.setBounds(420,70,35,30);
		produce_year = new JSpinner(new SpinnerNumberModel(current_date.getYear(),null,current_date.getYear(),1));
		produce_year.setBounds(360,70,60,30);
		this.add(produce_day);
		this.add(produce_month);
		this.add(produce_year);
		
		scrap_day = new JSpinner(new SpinnerNumberModel(current_date.getDay(),1,31,1));
		scrap_day.setBounds(685,70,35,30);
		scrap_month = new JSpinner(new SpinnerNumberModel(current_date.getMonth(),1,12,1));
		scrap_month.setBounds(640,70,35,30);
		scrap_year = new JSpinner(new SpinnerNumberModel(current_date.getYear(),current_date.getYear(),null,1));
		scrap_year.setBounds(580,70,60,30);
		this.add(scrap_day);
		this.add(scrap_month);
		this.add(scrap_year);
		

		addItem = new JButton("���������Ʒ");
		addItem.setBounds(240, 120, 120, 30);
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// ��ȡ����Ա�������Ϣ
				double price = 0.0;
				int number = 0;
				String Gname = typeInput.getText().trim();
				String GID = IDInput.getText().trim();
				String pricestr = priceInput.getText().trim();
				String numberstr = numberInput.getText().trim();
				
				
				if(pricestr.equals("")||numberstr.equals("")||Gname.equals("")){
					JOptionPane.showMessageDialog(InputGoodsPanel.this,"��Ʒ��Ϣ��������","��ʾ",1);
					info_right=false;
				}
				else{
					number = Integer.parseInt(numberstr);
					price = Double.parseDouble(pricestr);
					if(number <= 0||price <= 0){
						JOptionPane.showMessageDialog(InputGoodsPanel.this,"��Ʒ��Ϣ�д���","��ʾ",1);
						info_right=false;
					}
				}
				
				
			
				
				MyDate scrapDate = new MyDate((Integer)scrap_year.getValue(),(Integer)(scrap_month.getValue()),(Integer)scrap_day.getValue());
				MyDate produceDate = new MyDate((Integer)scrap_year.getValue(),(Integer)(scrap_month.getValue()),(Integer)scrap_day.getValue());
				MyDate inputDate= MyDate.getDate();  //��õ�ǰʱ����Ϊ���ʱ��
				
				if(info_right==true)
				{
					Goods agoods = new Goods(Gname, GID, price, number,produceDate,scrapDate,inputDate,1);
					goodslist.add(agoods);
					rowData = showGoodsInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(goodsInfoPane);
					loadNewGoodsInfo();
				}
			}
		});
		this.add(addItem);

		renewItem = new JButton("������Ϣ"); // ��յ�ǰText�е��ı�
		renewItem.setBounds(400, 120, 100, 30);
		renewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				renewGoodsInfo();
			}
		});
		this.add(renewItem);

		inputGoodsInfoShow = new JLabel("������Ʒ��Ϣ��ʾ��");
		inputGoodsInfoShow.setBounds(30, 150, 140, 30);
		this.add(inputGoodsInfoShow);

		deleteLastItem = new JButton("ɾ����һ����Ʒ"); // ɾ�����һ����Ϣ
		deleteLastItem.setBounds(240, 440, 140, 30);
		deleteLastItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int size = goodslist.size();
				if (size > 0) {
					goodslist.remove(size - 1);
					rowData = showGoodsInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(goodsInfoPane);
					loadNewGoodsInfo();
				}
			}
		});
		this.add(deleteLastItem);
		
		sureAddItem = new JButton("ȷ�����");
		sureAddItem.setBounds(400, 440, 100, 30);
		sureAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (goodslist.size() > 0) {
					boolean add_success = controler.addGoods(goodslist);
					if (add_success) {
						JOptionPane.showMessageDialog(InputGoodsPanel.this,
								"����Ʒ���ɹ���", "��ʾ", 1);
					} else {
						JOptionPane.showMessageDialog(InputGoodsPanel.this,
								"����Ʒ���ʧ�ܣ�����������", "����", 2);
					}
					goodslist.removeAll(goodslist);
					rowData = showGoodsInfo();
					mod = new DefaultTableModel(rowData, columnNames);
					remove(goodsInfoPane);
					loadNewGoodsInfo();
				} else {
					JOptionPane.showMessageDialog(InputGoodsPanel.this,
							"����Ʒ�����룬���������ִ����⣡", "����", 2);
				}
			}
		});
		this.add(sureAddItem);

		this.loadNewGoodsInfo();
	}

	public void showPanel() {
		initComponent();
	}

	private void renewGoodsInfo() {
		typeInput.setText("");
		IDInput.setText(getGoodsID());
		priceInput.setText("");
		numberInput.setText("");
		produce_day.setValue(current_date.getDay());
		produce_month.setValue(current_date.getMonth());
		produce_year.setValue(current_date.getYear());
		scrap_day.setValue(current_date.getDay());
		scrap_month.setValue(current_date.getMonth());
		scrap_year.setValue(current_date.getYear());
	}

	private void loadNewGoodsInfo() {
		newGoodsInfo = new JTable(mod);
		newGoodsInfo.setEnabled(false);

		goodsInfoPane = new JScrollPane(newGoodsInfo);
		goodsInfoPane.setBounds(30, 180, 720, 240);
		this.add(goodsInfoPane);
	}

	private String[][] showGoodsInfo() {
		String[][] rowData = new String[goodslist.size()][6];
		for (int i = 0; i < goodslist.size(); i++) {
			rowData[i][0] = goodslist.get(i).getName();
			rowData[i][1] = goodslist.get(i).getID();
			rowData[i][2] = Double.toString(goodslist.get(i).getOriginalCost());
			rowData[i][3] = Integer.toString(goodslist.get(i).getInputNum());
			rowData[i][4] = goodslist.get(i).getProduceDate().toString();
			rowData[i][5] = goodslist.get(i).getScrapDate().toString();
		}
		return rowData;
	}
	
	private String getGoodsID(){
		ArrayList<Goods> goods_stored = controler.getStored_goods();
		if(goods_stored!=null){
		int id =goods_stored.size()+1;
		return Integer.toString(id);
		}
		else 
			return ""+1;
	}
	
	
}
