package com.thoughtworks;

import com.thoughtworks.promotions.Promotion;

public class Printer {
  private static final String RECEIPT_TITLE = "============= 订餐明细 =============\n";
  private static final String SPLIT_LINE = "-----------------------------------\n";
  private static final String PROMOTION = "使用优惠:\n";
  private static final String FULL_REDUCE_INFO = "满30减6元，省6元\n";
  private static final String HALF_PRICE_INFO_01 = "指定菜品半价(黄焖鸡，凉皮)，省";
  private static final String UNIT = "元\n";
  private static final String SUMMARY = "总计：";
  private static final String RECEIPT_FOOTER = "===================================";


  public static String printReceipt(Promotion promotion) {
    return String.format("%s%s%s%s%s%s",
        RECEIPT_TITLE,
        getOrderInfo(promotion),
        SPLIT_LINE,
        getDiscountInfo(promotion),
        getSummary(promotion),
        RECEIPT_FOOTER);
  }

  private static String getOrderInfo(Promotion promotion) {
    StringBuilder allDishInfo = new StringBuilder();
    promotion.getOrderDetails().forEach(dish -> allDishInfo.append(
        String.format("%s x %s = %s元\n", dish.getName(), dish.getCount(), formatDouble(dish.getSum()))));
    return allDishInfo.toString();
  }

  private static String formatDouble(double number) {
    if (Math.round(number) - number == 0) {
      return String.valueOf((int) number);
    }
    return String.valueOf(number);
  }

  private static String getDiscountInfo(Promotion promotion) {
    switch (promotion.getClass().getSimpleName()) {
      case "NoDiscount":
        return "";
      case "FullReduce":
        return PROMOTION + FULL_REDUCE_INFO + SPLIT_LINE;
      case "HalfPrice":
        return PROMOTION + HALF_PRICE_INFO_01 + formatDouble(promotion.getDiscount()) + UNIT + SPLIT_LINE;
      default:
        return null;
    }
  }

  private static String getSummary(Promotion promotion) {
    return SUMMARY + formatDouble(promotion.getFinalPrice()) + UNIT;
  }
}
