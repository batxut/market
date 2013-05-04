package Controlers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Goods;
import data.MyDate;
import DataOperation.GetData;
import Interface.CheckGoodsInterface;

public class CheckGoodsControler implements CheckGoodsInterface{
	private ArrayList<Goods> goods_searched = new ArrayList<Goods>();
	public ArrayList<Goods> analyseStorage(){
		GetData geter = new GetData();
		goods_searched = geter.getGoods();
		
		//����
		MyDate today=MyDate.getDate();
		if(goods_searched!=null){
			for(int i=0;i<goods_searched.size();i++){
				//�ɴ�����
				int available_day = Math.abs(goods_searched.get(i).getScrapDate().getDaysBetween(today));
				//��ͨ����
				int total_circulation=goods_searched.get(i).getInputNum()-goods_searched.get(i).getPresentNum();
				//�߶�����
				int scale_period = Math.abs(today.getDaysBetween(goods_searched.get(i).getInputDate()));
				//ÿ����ͨ��
				
				double everyday_circulation;
				if(!(scale_period==0)){
					everyday_circulation=(double)total_circulation/scale_period;
				}else{
//					JOptionPane.showMessageDialog(null,"��Ʒ:"+goods_searched.get(i).getName()+" �������,��ͨ��Ϊ0���޷�����","����",2);
					everyday_circulation=-1;
				}
				int predict_days;  //Ԥ������
				double predict_scrapRate=0.0 ;
				if(everyday_circulation>0){
				    predict_days=(int)Math.min(goods_searched.get(i).getInputNum()/everyday_circulation,available_day );
				    if(predict_days<available_day){
				    	predict_scrapRate=0;
				    	
				    }else{
				    	if(predict_days>available_day)
				    	predict_scrapRate=(double)(predict_days-available_day)/(double)predict_days;
				    	else
				    		predict_scrapRate=-1;
				    }
				}else{
					predict_days=-1;
//					JOptionPane.showMessageDialog(null, "��Ʒ��"+goods_searched.get(i).getName()+" ��Ԥ�����������壡","��ʾ", 1);
					
				}
				goods_searched.get(i).setPredict_days(predict_days);
				goods_searched.get(i).setPredict_Scrap_Rate(predict_scrapRate);
				
			}
		return goods_searched;
	}
		JOptionPane.showMessageDialog(null, "���������Ʒ��","��ʾ", 1);
		return null;
	}
	
	/*
	 * 1��	Ԥ������������򣺶����ض���Ʒ
�ɴ�����=���һ�������Ʒ�ı�������-��������
��ͨ����=���һ�������Ʒ����+���һ�����ǰ���-���ڿ��
�߶�����=����������һ�������Ʒ���������
ÿ����ͨ��= ��ͨ����/�߶�����
���ÿ����ͨ��>0
Ԥ������= min���������/ÿ����ͨ��, �ɴ�������
����
Ԥ������ ������

��� Ԥ������������ ���� Ԥ������<�ɴ�����
Ԥ�Ʊ�����=0
��� Ԥ������������ ����Ԥ������>�ɴ�����
Ԥ�Ʊ�����=��Ԥ������-�ɴ�������/Ԥ������
����
Ԥ�Ʊ����� ������

	 */
	
}

