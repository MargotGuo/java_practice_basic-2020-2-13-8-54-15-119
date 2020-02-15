package com.thoughtworks.promotions;

import com.thoughtworks.DataProvider;
import com.thoughtworks.OrderDetail;

import java.util.List;

public class HalfPrice extends Promotion {

  public HalfPrice(List<OrderDetail> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    List<String> dishInHalfPrice = DataProvider.getHalfDishIds();
    double discount = 0;
    for (OrderDetail orderDetail : getOrderDetails()) {
      if (dishInHalfPrice.contains(orderDetail.getDish().getId())) {
        discount = discount + orderDetail.getTotalPrice() * 0.5;
      }
    }
    return discount;
  }

  @Override
  public String getDiscountInfo() {
    return "使用优惠:\n"
        + String.format("指定菜品半价(黄焖鸡，凉皮)，省%s元\n", formatDoubleNumber(getDiscount()))
        + "-----------------------------------\n";
  }
}
