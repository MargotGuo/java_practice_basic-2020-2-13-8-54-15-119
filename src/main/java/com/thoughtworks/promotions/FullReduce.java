package com.thoughtworks.promotions;

import com.thoughtworks.OrderDetail;

import java.util.List;

public class FullReduce extends Promotion {

  public FullReduce(List<OrderDetail> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    return getSumPrice() >= 30 ? 6 : 0;
  }

  @Override
  public String getDiscountInfo() {
    return "使用优惠:\n"
        + "满30减6元，省6元\n"
        + "-----------------------------------\n";
  }
}
