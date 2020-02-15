package com.thoughtworks.promotions;

import com.thoughtworks.OrderDetail;

import java.util.List;

public class NoDiscount extends Promotion {
  public NoDiscount(List<OrderDetail> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    return 0;
  }

  @Override
  public String getDiscountInfo() {
    return "";
  }
}
