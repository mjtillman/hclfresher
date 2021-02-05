package FileIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class RtgMenus {

  private static final Logger LOG = LogManager.getLogger(RtgMenus.class);
  private static final Scanner sc = new Scanner(System.in);


  public static void mainMenu() {

    boolean exit = false;
    char input;

    do {
      System.out.println("\nPress '+' to add a new thought, or press 'n' to view a random thought");
      System.out.println("(Enter 'q' to exit.)");

      input = sc.nextLine().replaceAll("\\s+", "").toLowerCase().charAt(0);

      switch (input) {
        case '+':
          newThoughtMenu();
          break;
        case 'n':
          generateRandomThought();
          break;
        case 'q':
          exit = true;
          break;
      }

    } while (!exit);

    System.out.println("Good-bye!");
  }

  public static void newThoughtMenu() {

    String newThought;
    boolean main = false;

    do {
      System.out.println("\nEnter your new random thought:");
      System.out.println("(Enter 'm' to return to the main menu.)\n");

      newThought = sc.nextLine().replaceAll("\\s+", "");

      if (newThought.equalsIgnoreCase("m")) {
        main = true;
      } else {
        FileHandler.saveNewThought(newThought);
      }

    } while (!main);

    mainMenu();
  }

  public static void generateRandomThought() {

    Random r = new Random();
    int low = 1;
    int high = 100;
    int randomNum = r.nextInt(high-low) + low;

    String randomThought = FileHandler.getRandomThought(randomNum);

    System.out.println(randomThought);

    mainMenu();
  }

}
