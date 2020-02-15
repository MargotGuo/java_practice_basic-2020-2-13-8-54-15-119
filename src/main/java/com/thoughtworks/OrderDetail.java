package com.thoughtworks;

public class OrderDetail {
  private Dish dish;
  private int count;

  public OrderDetail(Dish dish, int count) {
    this.dish = dish;
    this.count = count;
  }

  public double getTotalPrice() {
    return dish.getPrice() * count;
  }

  @Override
  public String toString() {
    return String.format("%s x %s = %s元\n", dish.getName(), count, (int) getTotalPrice());
  }

  public Dish getDish() {
    return dish;
  }
}
