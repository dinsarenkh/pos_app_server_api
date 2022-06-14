package com.dinsaren.bbuappserver.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalFormatter {

	public static String formatKHR(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(decimal);
	}

	public static String formatFeeKHR(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(decimal);
	}

	public static String formatDefault(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(decimal);
	}

	public static String formatUsdDigi(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat("###.##");
		return df.format(decimal);
	}

	public static BigDecimal forStAmount(String value) {
		double newValue = Double.parseDouble(value);
		return BigDecimal.valueOf(newValue);
	}

	public static BigDecimal moneyCurrency(BigDecimal amount) {
		return amount.setScale(2, RoundingMode.CEILING);
	}

}
