package logic;

import java.util.ArrayList;

import dataOperation.*;
import data.strategy.AmountGiftStra;
import data.strategy.AmountOnSaleStra;

public class SalesStra {
	public AmountGiftStra getAmountGiftStra(double amount) {
		ArrayList<AmountGiftStra> list = new GetData()
				.getAmountGiftStralist();
		for (int i = 0; i < list.size(); i++) {
			AmountGiftStra stra = list.get(i);
			if (amount > stra.getAmount())
				return stra;
		}
		return null;
	}

	public double getAmountDiscount(double amount) {
		ArrayList<AmountOnSaleStra> list = new GetData()
				.getAmountOnSaleStraList();
		for (int i = 0; i < list.size(); i++) {
			AmountOnSaleStra stra = list.get(i);
			if (amount > stra.getAmount())
				return stra.getDiscount();
		}
		return 1;
	}
}
