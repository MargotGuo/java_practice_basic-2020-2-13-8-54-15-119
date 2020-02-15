package com.thoughtworks;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String selectedItems = sc.nextLine();
    Restaurant restaurant = new Restaurant();
    System.out.println(restaurant.bestCharge(selectedItems));
  }
}
