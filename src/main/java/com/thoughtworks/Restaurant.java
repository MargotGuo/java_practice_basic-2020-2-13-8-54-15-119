package com.thoughtworks;

import com.thoughtworks.promotions.FullReduce;
import com.thoughtworks.promotions.HalfPrice;
import com.thoughtworks.promotions.NoDiscount;
import com.thoughtworks.promotions.Promotion;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    List<Dish> orderList = getOrderList(selectedItems);
    Promotion finalPromotion = getFinalPromotion(orderList);
    System.out.println(finalPromotion.getClass().getSimpleName());
    return Printer.printInfo(finalPromotion);
  }

  private List<Dish> getOrderList(String selectedItems) {
    List<Dish> orderList = new ArrayList<>();
    String[] selectedArray = selectedItems.split(",");
    for (String itemInfo : selectedArray) {
      Dish tempDish = DataProvider.getDishById(itemInfo.split(" x ")[0]);
      tempDish.setCount(Integer.parseInt(itemInfo.split(" x ")[1]));
      orderList.add(tempDish);
    }
    return orderList;
  }

  private Promotion getFinalPromotion(List<Dish> orderList) {
    Promotion fullReduce = new FullReduce(orderList);
    Promotion halfPrice = new HalfPrice(orderList);
    Promotion finalPromotion;
    if (fullReduce.getDiscount() == 0 && halfPrice.getDiscount() == 0) {
      finalPromotion = new NoDiscount(orderList);
    } else if (fullReduce.getDiscount() >= halfPrice.getDiscount()) {
      finalPromotion = fullReduce;
    } else {
      finalPromotion = halfPrice;
    }
    return finalPromotion;
  }
}
