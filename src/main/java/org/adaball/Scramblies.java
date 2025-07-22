package org.adaball;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java
 * <p>
 * Complete the function scramble(str1, str2) that returns true if a portion of
 * str1 characters can be rearranged to match str2, otherwise returns false.
 */
public class Scramblies {
  public static boolean scramble(String str1, String str2) {
    Map<String, Integer> str1Freqs = getCharFreqs(str1);
    Map<String, Integer> str2Freqs = getCharFreqs(str2);

    boolean found = false;

    for (Map.Entry<String, Integer> kv : str2Freqs.entrySet()) {
      String key = kv.getKey();
      Integer val = kv.getValue();

      if (str1Freqs.containsKey(key) && val <= str1Freqs.get(key)) {
        found = true;
      } else {
        found = false;
        break;
      }
    }

    return found;
  }

  private static Map<String, Integer> getCharFreqs(String s) {
    Map<String, Integer> freqs = new HashMap<>();
    for (String c : s.split("")) {
      freqs.put(c, freqs.getOrDefault(c, 0) + 1);
    }

    return freqs;
  }
}
