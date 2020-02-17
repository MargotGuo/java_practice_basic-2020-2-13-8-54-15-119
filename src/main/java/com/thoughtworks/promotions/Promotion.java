package com.thoughtworks.promotions;

import com.thoughtworks.Dish;

import java.util.List;

public abstract class Promotion {

  private List<Dish> orderDetails;

  public Promotion(List<Dish> orderDetails) {
    this.orderDetails = orderDetails;
  }

  double getSumPrice() {
    double sum = 0;
    for (Dish dish : orderDetails) {
      sum = sum + dish.getSum();
    }
    return sum;
  }

  public abstract double getDiscount();

  public double getFinalPrice() {
    return getSumPrice() - getDiscount();
  };

  public List<Dish> getOrderDetails() {
    return orderDetails;
  }
}
