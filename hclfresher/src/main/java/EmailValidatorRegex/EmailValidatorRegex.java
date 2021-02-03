package EmailValidatorRegex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmailValidatorRegex {

  private static final Logger LOG = LogManager.getLogger(EmailValidatorRegex.class);

  private static final File FILE = new File("" +
      "hclfresher/src/main/java/EmailValidatorRegex/email_addresses.txt");

  private static final Pattern VALID_EMAIL_REGEX = Pattern.compile("" +
      //localpart
      "^([A-Za-z\\d\\._\\-]){2,63}@" +
      //domain
      "([A-Za-z\\d\\-]){2,63}.([A-Za-z]{3}|[A-Za-z]{2}.[A-Za-z]{2})$");

  public static void main(String[] args) {
    System.out.print("" +
        "\n+-------------------+" +
        "\n|  EMAIL VALIDATOR  |" +
        "\n+-------------------+");

    getInputAndValidate();
  }

  private static void getInputAndValidate() {
    Scanner sc = new Scanner(System.in);
    Matcher m;
    boolean exit = false;
    String newEmail;

    do {
      System.out.println("\nPlease give me a valid email address:");
      System.out.println("(Enter 'q' or 'Q' to exit.)");

      newEmail = sc.nextLine().replaceAll("\\s+", "");

      if (newEmail.equalsIgnoreCase("q")) {
        exit = true;
        break;
      }

      m = VALID_EMAIL_REGEX.matcher(newEmail);

    } while (!m.find());

    if (!exit) {

      int index = newEmail.indexOf('@');

      searchEmailsAsArray(newEmail, newEmail.substring(0, index));

    } else {
      System.out.println("Good-bye!");
    }
  }

  private static void searchEmailsAsArray(String newEmail, String newId) {

    ArrayList<String> addresses = null;

    // Read in all emails from email_addresses.txt to List
    try {
      Stream<String> lines = Files.lines(FILE.toPath());

      addresses = lines
          .flatMap(l -> Stream.of(l.split("\n")))
          .collect(Collectors.toCollection(ArrayList::new));

    } catch (Exception ex) {
      LOG.error(ex);
    }

    ArrayList<String> emailIds = new ArrayList<>();

    // Create new array with email ids only
    if (addresses != null) {
       emailIds = addresses.stream()
          .map(id -> id.substring(0, id.indexOf("@")))
          .collect(Collectors.toCollection(ArrayList::new));
    } else {
      LOG.error("Something is wrong with the addresses array");
    }

    // Check if newid is in array of email ids
    if (emailIds.contains(newId)) {

      int index = emailIds.indexOf(newId);

      tryAgain(newId, addresses.get(index));

    } else {
      writeNewEmailToFile(newEmail);
    }
  }

  private static void writeNewEmailToFile(String newEmail) {

    System.out.format("%nWriting new email to file: %s%n", newEmail);

    try {
      FileWriter writer = new FileWriter(FILE, true);
      BufferedWriter buffWriter = new BufferedWriter(writer);
      buffWriter.write("\n" + newEmail);
      buffWriter.close();

    } catch (Exception ex) {
      LOG.error(ex);
    }

    getInputAndValidate();
  }

  private static void tryAgain(String id, String existingEmail) {
    System.out.format("%nThere is already a valid email containing %s:" +
           "%n\t%s%n", id, existingEmail);
    getInputAndValidate();
  }
}