package com.thoughtworks.promotions;

import com.thoughtworks.DataProvider;
import com.thoughtworks.Dish;

import java.util.List;

public class HalfPrice extends Promotion {

  public HalfPrice(List<Dish> orderDetails) {
    super(orderDetails);
  }

  @Override
  public double getDiscount() {
    List<String> dishInHalfPrice = DataProvider.getHalfDishIds();
    double discount = 0;
    for (Dish dish : getOrderDetails()) {
      if (dishInHalfPrice.contains(dish.getId())) {
        discount = discount + dish.getSum() * 0.5;
      }
    }
    return discount;
  }
}
