package com.phase1.InterfacesAndCollections;

//call by value
public class callMethod {

  static int val = 150;

  static int operation(int val) {
    val = val * 10 / 100;
    return (val);
  }

  public static void main(String args[]) {
    System.out.println("Before operation value of data is " + val);
    val = operation(val);
    System.out.println("After operation value of data is " + val);
  }
}
