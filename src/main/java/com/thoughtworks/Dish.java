package com.thoughtworks;

public class Dish {

  private String id;
  private String name;
  private double price;
  private int count;

  public Dish(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public double getSum() {
    return count * price;
  }
}
