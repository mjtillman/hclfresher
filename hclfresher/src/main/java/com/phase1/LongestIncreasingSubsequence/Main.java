package com.phase1.LongestIncreasingSubsequence;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {

  private static final int MIN_RANDOM_NUM = 1;
  private static final int MAX_RANDOM_NUM = 101;
  private static final int MIN_LIST_SIZE = 30;
  private static final int MAX_LIST_SIZE = 101;

  public static void main(String[] args) {
    List<Integer> randNumArr = generateRandomNumArr();

    List<List<Integer>> allStreaks = new ArrayList<>(parseStreaks(randNumArr));

    List<Integer> longestStreak = allStreaks.get(findLongestStreakIndex(allStreaks));

    int minRandNum = randNumArr.stream().min(Integer::compare).get();
    int maxRandNum = randNumArr.stream().max(Integer::compare).get();

    print(randNumArr.size(), minRandNum, maxRandNum, longestStreak);
  }

 private static List<Integer> generateRandomNumArr() {
    return new Random().ints(MIN_RANDOM_NUM, MAX_RANDOM_NUM)
        .limit(ThreadLocalRandom.current().nextInt(MIN_LIST_SIZE, MAX_LIST_SIZE))
        .boxed().collect(Collectors.toList());
  }

  private static List<List<Integer>> parseStreaks(List<Integer> randNumArr) {
    List<List<Integer>> allStreaks = new ArrayList<>();
    List<Integer> newStreak = new ArrayList<>();

    for (int i = 0; i < randNumArr.size() - 1; i++) {
      int a = randNumArr.get(i);
      int b = randNumArr.get(i + 1);

      if (newStreak.isEmpty()) {
        newStreak.add(randNumArr.get(i));
      }

      if (a < b) {
        newStreak.add(randNumArr.get(i + 1));
      } else {
        if (newStreak.size() > 1) {
          allStreaks.add(newStreak);
          newStreak = new ArrayList<>();
        }
      }
    }
    return allStreaks;
  }

  private static int findLongestStreakIndex(List<List<Integer>> streaks) {
    return streaks.stream().mapToInt(List::size).max().getAsInt();
  }

  public static void print(int allNumsSize, int minRandNum, int maxRandNum,
      List<Integer> longestStreak) {

    System.out.printf("%d random numbers between %d and %d were selected.\n", allNumsSize, minRandNum, maxRandNum);
    System.out.printf("The longest increasing subsequence, which was %d numbers long, was: %s", longestStreak.size(), longestStreak);
  }

}
