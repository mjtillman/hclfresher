package FileIO;

public class Main {

  public static void main(String[] args) {

    FileHandler.collectThoughts();

    System.out.print("" +
        "\n+----------------------------+" +
        "\n|  RANDOM THOUGHT GENERATOR  |" +
        "\n+----------------------------+");

    RtgMenus.mainMenu();
  }
}
