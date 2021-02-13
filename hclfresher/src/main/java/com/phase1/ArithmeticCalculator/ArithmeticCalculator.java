package com.phase1.ArithmeticCalculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticCalculator {

  private static final Pattern EXP_REGEX = Pattern.compile("^[0-9.]+[+\\-*/%][0-9.]+$");

  public static void main(String[] args) {

    System.out.print("" +
        "\n+-------------------------+" +
        "\n|  ARITHMETIC CALCULATOR  |" +
        "\n+-------------------------+");

    getInput();
  }

  private static void getInput() {
    Scanner sc = new Scanner(System.in);
    Matcher m;
    boolean exit = false;
    String exp;

    do {
      System.out.println("\n\nEnter a binomial expression using +, -, *, /, or %:");
      System.out.println("(Enter 'q' or 'Q' to exit.)");

      exp = sc.nextLine().replaceAll("\\s+", "");

      if (exp.equalsIgnoreCase("q")) {
        exit = true;
        break;
      }

      m = EXP_REGEX.matcher(exp);
    } while (!m.find());

    if (!exit) {
      parseInput(exp);
    } else {
      System.out.println("Good-bye!");
    }

  }

  private static void parseInput(String exp) {

    double[] expArr = Arrays.stream(exp.split("[+\\-*/%]"))
        .mapToDouble(Double::parseDouble).toArray();

    if (exp.contains("+")) {
      add(expArr[0], expArr[1]);
    } else if (exp.contains("-")) {
      subtract(expArr[0], expArr[1]);
    } else if (exp.contains("*")) {
      multiply(expArr[0], expArr[1]);
    } else if (exp.contains("/")) {
      divide(expArr[0], expArr[1]);
    } else if (exp.contains("%")) {
      modulo(expArr[0], expArr[1]);
    } else {
      System.out.println("Something is wrong");
    }
  }

  private static void add(double a, double b) {
    printSolution(a, b, a + b, '+');
  }

  private static void subtract(double a, double b) {
    printSolution(a, b, a - b, '-');
  }

  private static void multiply(double a, double b) {
    printSolution(a, b, a * b, '*');
  }

  private static void divide(double a, double b) {
    printSolution(a, b, a / b, '/');
  }

  private static void modulo(double a, double b) {
    printSolution(a, b, a % b, '%');

  }

  private static void printSolution(double a, double b, double solution, char operator) {
    System.out.printf("%f %s %f = %f", a, operator, b, solution);
    getInput();
  }
}
