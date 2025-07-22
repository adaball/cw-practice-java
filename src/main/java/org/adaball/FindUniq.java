package org.adaball;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/585d7d5adb20cf33cb000235
 */
public class FindUniq {
  public static double findUniq(double[] arr) {
    Map<Double, Integer> freq = new HashMap<>();

    for (double v : arr) {
      freq.put(v, freq.getOrDefault(v, 0) + 1);
    }

    for (Map.Entry<Double, Integer> kv : freq.entrySet()) {
      if (kv.getValue() == 1) {
        return kv.getKey();
      }
    }

    return 0;
  }
}
