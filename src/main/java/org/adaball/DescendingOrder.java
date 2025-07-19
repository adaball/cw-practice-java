package org.adaball;

import java.util.Arrays;
import java.util.List;

public class DescendingOrder {
  public static int sortDesc(int i) {
    List<Integer> digits = Arrays.stream(String.valueOf(i).split(""))
        .map(Integer::parseInt).sorted().toList();

    StringBuilder sb = new StringBuilder();
    for (int i1 = digits.size() - 1; i1 >= 0; i1--) {
      sb.append(digits.get(i1));
    }

    return Integer.parseInt(sb.toString());
  }
}