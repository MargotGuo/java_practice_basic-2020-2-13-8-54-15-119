package com.thoughtworks.promotions;

import com.thoughtworks.OrderDetail;

import java.util.List;

public abstract class Promotion {

  private List<OrderDetail> orderDetails;

  public Promotion(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  // 计算总价、折扣、最终价格
  double getSumPrice() {
    double sum = 0;
    for (OrderDetail orderDetail : orderDetails) {
      sum = sum + orderDetail.getTotalPrice();
    }
    return sum;
  }

  public abstract double getDiscount();

  public double getFinalPrice() {
    return getSumPrice() - getDiscount();
  };

  // 生成文字信息： 订单详情，折扣详情，合计
  public String getOrderInfo() {
    StringBuilder allDishInfo = new StringBuilder();
    orderDetails.forEach(allDishInfo::append);
    return allDishInfo.toString();
  }

  public abstract String getDiscountInfo();

  public String getSummary() {
    return String.format("总计：%s元\n", (int) getFinalPrice());
  }

  // getter
  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }
}
