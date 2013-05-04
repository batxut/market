package logic;

import java.util.ArrayList;

import server_interface.SearchStra;

import dataOperation.*;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;
import data.strategy.GoodsGiftStra;
import data.strategy.GoodsOnSaleStra;

public class SearchStraController implements SearchStra
{
	
	public AmountGiftStra searchAmountGiftStra(int mark)
	{
		ArrayList<AmountGiftStra> amountGiftlist=new GetData().getAmountGiftStralist();
		for(int i=0;i<amountGiftlist.size();i++)
		{
			AmountGiftStra stra=amountGiftlist.get(i);
			if(stra.getMark()==mark)
				return stra;
		}
		return null;
	}
	
	public void deleteAmountGiftStra(int mark)
	{
		ArrayList<AmountGiftStra> amountGiftlist=new GetData().getAmountGiftStralist();
		for(int i=0;i<amountGiftlist.size();i++)
		{
			if(amountGiftlist.get(i).getMark()==mark)
			{
				amountGiftlist.remove(i);
				break;
			}
		}
		new SaveData().saveAmountGiftStra(amountGiftlist);
	}

	@Override
	public AmountOnSaleStra searchAmountOnSaleStra(int mark) 
	{
		ArrayList<AmountOnSaleStra> amountOnSalelist=new GetData().getAmountOnSaleStraList();
		for(int i=0;i<amountOnSalelist.size();i++)
		{
			AmountOnSaleStra stra=amountOnSalelist.get(i);
			if(stra.getMark()==mark)
				return stra;
		}
		return null;
	}
	
	public void deleteAmountOnSaleStra(int mark)
	{
		ArrayList<AmountOnSaleStra> amountOnSalelist=new GetData().getAmountOnSaleStraList();
		for(int i=0;i<amountOnSalelist.size();i++)
		{
			if(amountOnSalelist.get(i).getMark()==mark)
			{
				amountOnSalelist.remove(i);
				break;
			}
		}
		new SaveData().saveAmountOnSaleStra(amountOnSalelist);
	}

	@Override
	public GoodsGiftStra searchGoodsGiftStra(int mark)
	{
		ArrayList<GoodsGiftStra> goodsGiftlist=new GetData().getGoodsGiftStralist();
		for(int i=0;i<goodsGiftlist.size();i++)
		{
			GoodsGiftStra stra=goodsGiftlist.get(i);
			if(stra.getMark()==mark)
				return stra;
		}
		return null;
	}
	
	public void deleteGoodsGiftStra(int mark)
	{
		ArrayList<GoodsGiftStra> goodsGiftlist=new GetData().getGoodsGiftStralist();
		for(int i=0;i<goodsGiftlist.size();i++)
		{
			if(goodsGiftlist.get(i).getMark()==mark)
			{
				goodsGiftlist.remove(i);
				break;
			}
		}
		new SaveData().saveGoodsGiftStra(goodsGiftlist);
	}

	@Override
	public GoodsOnSaleStra searchGoodsOnSaleStra(int mark)
	{
		ArrayList<GoodsOnSaleStra> goodOnSalelist=new GetData().getGoodsOnSaleStraList();
		for(int i=0;i<goodOnSalelist.size();i++)
		{
			GoodsOnSaleStra stra=goodOnSalelist.get(i);
			if(stra.getMark()==mark)
				return stra;
		}
		return null;
	}
	
	public void deleteGoodsOnSaleStra(int mark)
	{
		ArrayList<GoodsOnSaleStra> goodOnSalelist=new GetData().getGoodsOnSaleStraList();
		for(int i=0;i<goodOnSalelist.size();i++)
		{
			if(goodOnSalelist.get(i).getMark()==mark)
			{
				goodOnSalelist.remove(i);
				break;
			}
		}
		new SaveData().saveGoodsOnSaleStra(goodOnSalelist);
	}
}
