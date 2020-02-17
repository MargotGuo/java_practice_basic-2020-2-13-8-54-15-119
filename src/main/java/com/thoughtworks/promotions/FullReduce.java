package com.thoughtworks.promotions;

import com.thoughtworks.Dish;

import java.util.List;

public class FullReduce extends Promotion {

  public FullReduce(List<Dish> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    return getSumPrice() >= 30 ? 6 : 0;
  }
}
