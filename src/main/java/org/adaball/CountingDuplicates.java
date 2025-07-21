package org.adaball;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java
 */
public class CountingDuplicates {
  // Write a function that will return the **count of distinct case-insensitive alphabetic
  // characters and numeric digits** that occur **more than once** in the input string. The
  // input string can be assumed to contain only alphabets (both uppercase and lowercase)
  // and numeric digits.
  public static int duplicateCount(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    String toLower = text.toLowerCase(Locale.ENGLISH);
    String[] tokens = toLower.split("");
    Map<String, Integer> frequencies = new HashMap<>();

    for (String token : tokens) {
      if (frequencies.containsKey(token)) {
        frequencies.put(token, frequencies.get(token) + 1);
      } else {
        frequencies.put(token, 1);
      }
    }

    return (int) frequencies.values().stream().filter(i -> i >= 2).count();
  }
}
