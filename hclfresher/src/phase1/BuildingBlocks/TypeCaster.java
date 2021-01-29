package phase1.BuildingBlocks;

import java.util.Scanner;

public class TypeCaster {

  public static void main(String[] args) {

    char foo = 'M';
    byte a = (byte) foo;
    short b = (short) foo;
    int c = foo;
    long d = foo;
    float f = foo;
    double g = foo;

    String builder = "Transforming " + foo + ":" +
        "\n" + a +
        "\n" + b +
        "\n" + c +
        "\n" + d +
        "\n" + f +
        "\n" + g;
    System.out.println(builder);

    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter a string or number: ");
    String input = sc.next();

    try {
      byte inputByte = Byte.parseByte(input);
      short inputShort = Short.parseShort(input);
      int inputInt = Integer.parseInt(input);
      long inputLong = Long.parseLong(input);
      float inputFloat = Float.parseFloat(input);
      double inputDbl = Double.parseDouble(input);

      System.out.println("As a byte: " + inputByte);
      System.out.println("As an short: " + inputInt);
      System.out.println("As a int: " + inputByte);
      System.out.println("As a long: " + inputByte);
      System.out.println("As a float: " + inputByte);
      System.out.println("As a double: " + inputByte);

    } catch (Exception e) {
      System.out.println("Could not convert a string to numeric types");
    }

  }
}
