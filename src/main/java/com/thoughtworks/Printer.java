package com.thoughtworks;

import com.thoughtworks.promotions.Promotion;

public class Printer {
  private static final String RECEIPT_TITLE = "============= 订餐明细 =============\n";
  private static final String SPLIT_LINE = "-----------------------------------\n";
  private static final String RECEIPT_FOOTER = "===================================";

  public static String printInfo(Promotion promotion) {
    return String.format("%s%s%s%s%s%s",
        RECEIPT_TITLE,
        promotion.getOrderInfo(),
        SPLIT_LINE,
        promotion.getDiscountInfo(),
        promotion.getSummary(),
        RECEIPT_FOOTER);
  }
}
