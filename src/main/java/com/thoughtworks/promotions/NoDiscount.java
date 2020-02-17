package com.thoughtworks.promotions;

import com.thoughtworks.Dish;

import java.util.List;

public class NoDiscount extends Promotion {
  public NoDiscount(List<Dish> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    return 0;
  }
}
