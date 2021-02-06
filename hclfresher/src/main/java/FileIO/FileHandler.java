package FileIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

  private static final Logger LOG = LogManager.getLogger(FileHandler.class);

  private static final File FILE = new File("" +
      "hclfresher/src/main/java/FileIO/random_thoughts.txt");

  private static ArrayList<String> thoughts = new ArrayList<>();

  public static ArrayList<String> getThoughts() {
    return thoughts;
  }

  public static int getNumberOfThoughts() {
    return thoughts.size();
  }

  public static void collectThoughts() {
    if (FILE.exists()) {

      try {
        Stream<String> lines = Files.lines(FILE.toPath());

        thoughts = lines
            .flatMap(l -> Stream.of(l.split("\n")))
            .collect(Collectors.toCollection(ArrayList::new));
      } catch (Exception ex) {
        LOG.error(ex);
      }
    } else {
      LOG.error("{} does not exist", FILE);
    }
  }

  public static void saveNewThought(final String newThought) {

    try {
      FileWriter writer = new FileWriter(FILE, true);
      BufferedWriter buffWriter = new BufferedWriter(writer);
      buffWriter.write("\n" + newThought);
      buffWriter.close();
    } catch (Exception ex) {
      LOG.error(ex);
    } finally {
      thoughts.add(newThought);
    }
  }

  public static String getRandomThought(final int num) {
   return "Here's a random thought:\n\t" + thoughts.get(num);
  }

}
