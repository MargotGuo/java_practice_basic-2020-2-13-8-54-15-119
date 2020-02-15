package com.thoughtworks;

import com.thoughtworks.promotions.FullReduce;
import com.thoughtworks.promotions.HalfPrice;
import com.thoughtworks.promotions.NoDiscount;
import com.thoughtworks.promotions.Promotion;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    List<OrderDetail> orderList = getOrderList(selectedItems);
    Promotion finalPromotion = getFinalPromotion(orderList);
    return Printer.printInfo(finalPromotion);
  }

  private List<OrderDetail> getOrderList(String selectedItems) {
    List<OrderDetail> orderList = new ArrayList<>();
    String[] selectedArray = selectedItems.split(",");
    for (String orderInfo : selectedArray) {
      String dishId = orderInfo.split(" x ")[0];
      int count = Integer.parseInt(orderInfo.split(" x ")[1]);
      orderList.add(new OrderDetail(DataProvider.getDishById(dishId), count));
    }
    return orderList;
  }

  private Promotion getFinalPromotion(List<OrderDetail> orderList) {
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
