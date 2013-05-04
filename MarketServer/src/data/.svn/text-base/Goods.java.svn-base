package data;

import java.io.Serializable;

import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ID;
	private double originalCost;
	private int shopNum;
	private int inputNums; // 入库时的数量
	private int presentNums; // 当前的数量
	private int outputNums;   //出库的数量
	private String output_reason;// = new String("-");  //出库原因
	private MyDate produceDate; //生产日期
	private MyDate scrapDate; // 报废日期
	private MyDate inputDate; // 入库日期
	private MyDate outputDate;//出库日期
	private int predict_days; // 预计天数
	private double predict_scrapRate; // 预计报废率

	private double salesCost;

	private boolean isdiscount; // 是否为优惠商品
	private boolean isfreeGift; // 是否为赠送商品
	private int numBought; // 每次买的数量（销售时的数量+ 退货-）

	private GoodsOnSaleStra onsaleStrategy;
	private GoodsGiftStra goodGiftStra;

	public Goods() {
		ID = "1-0001";
		shopNum = 1;
	}

	public Goods(String Gname, String GID, double originalCost, int nums,
			MyDate produceDate, MyDate scrapDate, MyDate input_date, int shopNum) {
		name = Gname;
		ID = GID;
		this.originalCost = originalCost;
		this.inputNums = nums;
		presentNums=nums;
		this.produceDate = produceDate;
		this.scrapDate = scrapDate;
		this.inputDate = input_date;
		this.shopNum = shopNum;
		salesCost = originalCost;
		numBought = 0;
		output_reason="-";
		outputNums=0;
		outputDate=null;
	}
	

	public double getOriginalCost() {
		return this.originalCost;
	}

	public int getInputNum() {
		return this.inputNums;
	}

	public int getPresentNum() {
		return this.presentNums;
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public int getShopNum() {
		return shopNum;
	}

	public MyDate getScrapDate() {
		return this.scrapDate;
	}
	
	public MyDate getOutputDate(){  //新加的
		return this.outputDate;
	}
	
	public void setOutputDate(MyDate date){  //新加的
		this.outputDate=date;
	}
	
	public void setOutputNums(int i){
		this.outputNums = i;
	}
	
	public int getOutputNums(){
		return this.outputNums;
	}

	public MyDate getProduceDate() {
		return this.produceDate;
	}

	public MyDate getInputDate() {
		return this.inputDate;
	}

	public void setPredict_Scrap_Rate(double rate) {
		this.predict_scrapRate = rate;
	}

	public double getPredict_Scrap_Rate() {
		return this.predict_scrapRate;
	}

	public void setPredict_days(int days) {
		this.predict_days = days;
	}

	public int getPredict_days() {
		return this.predict_days;
	}

	public void setNumBought(int n) {
		this.numBought = n;
	}

	public void recoverNumBought() {
		numBought = 0;
	}

	public int getNumBought() {
		return numBought;
	}

	public String getIsDiscount() {
		return (isdiscount ? "是" : "不是");
	}

	public String getIsfreeGift() {
		return (isfreeGift ? "是" : "不是");
	}

	public void setIsDiscount(boolean isdiscount) {
		this.isdiscount = isdiscount;
	}

	public void setIsfreeGift(boolean isfreeGift) {
		this.isfreeGift = isfreeGift;
	}

	public void setGoodsOnSaleStra(GoodsOnSaleStra stra) {
		this.onsaleStrategy = stra;
	}

	public GoodsOnSaleStra getOnsaleStrategy() {
		return onsaleStrategy;
	}

	public void setGoodGiftStra(GoodsGiftStra goodGiftStra) {
		this.goodGiftStra = goodGiftStra;
	}

	public GoodsGiftStra getGoodGiftStra() {
		return goodGiftStra;
	}

	public double getSalesCost() {
		return salesCost;
	}
	
	public void setPresentNum(int num){
		this.presentNums=num;
	}
	
	public void setOutput_reason(boolean r1_is_select,boolean r2_is_select,boolean r3_is_select,boolean r4_is_select){
		if(r1_is_select==true) this.output_reason.concat("转移到其他店铺");
		if(r2_is_select==true) this.output_reason.concat("到期报废");
		if(r3_is_select==true) this.output_reason.concat("个别残次品");
		if(r4_is_select==true) this.output_reason.concat("批次质量缺陷");
	}
	
	public void setShopNum(int shopNum)
	{
		this.shopNum=shopNum;
	}
}

