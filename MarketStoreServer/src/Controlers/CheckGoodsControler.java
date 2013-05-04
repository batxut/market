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
		
		//处理
		MyDate today=MyDate.getDate();
		if(goods_searched!=null){
			for(int i=0;i<goods_searched.size();i++){
				//可存天数
				int available_day = Math.abs(goods_searched.get(i).getScrapDate().getDaysBetween(today));
				//流通总量
				int total_circulation=goods_searched.get(i).getInputNum()-goods_searched.get(i).getPresentNum();
				//尺度天数
				int scale_period = Math.abs(today.getDaysBetween(goods_searched.get(i).getInputDate()));
				//每天流通量
				
				double everyday_circulation;
				if(!(scale_period==0)){
					everyday_circulation=(double)total_circulation/scale_period;
				}else{
//					JOptionPane.showMessageDialog(null,"商品:"+goods_searched.get(i).getName()+" 今天入库,流通量为0！无法计算","警告",2);
					everyday_circulation=-1;
				}
				int predict_days;  //预计天数
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
//					JOptionPane.showMessageDialog(null, "商品："+goods_searched.get(i).getName()+" 的预计天数无意义！","提示", 1);
					
				}
				goods_searched.get(i).setPredict_days(predict_days);
				goods_searched.get(i).setPredict_Scrap_Rate(predict_scrapRate);
				
			}
		return goods_searched;
	}
		JOptionPane.showMessageDialog(null, "库存中无商品！","提示", 1);
		return null;
	}
	
	/*
	 * 1、	预计天数计算规则：对于特定商品
可存天数=最后一批入库商品的报废日期-当天日期
流通总量=最后一批入库商品数量+最后一批入库前库存-现在库存
尺度天数=今天距离最后一批入库商品的入库日期
每天流通量= 流通总量/尺度天数
如果每天流通量>0
预计天数= min（库存数量/每天流通量, 可存天数）
否则
预计天数 无意义

如果 预计天数有意义 并且 预计天数<可存天数
预计报废率=0
如果 预计天数有意义 并且预计天数>可存天数
预计报废率=（预计天数-可存天数）/预计天数
否则
预计报废率 无意义

	 */
	
}

