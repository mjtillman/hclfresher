package FileIO;

public class FileHandler {

  public static void saveNewThought(final String newThought) {
    System.out.println(newThought + "saved");
    RtgMenus.mainMenu();
  }

  public static String getRandomThought(final int num) {
   return "Here's a random thought: " + num;
  }

}
