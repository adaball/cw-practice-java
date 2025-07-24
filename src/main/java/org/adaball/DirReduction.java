package org.adaball;

import java.util.Map;
import java.util.Stack;

/**
 * https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java
 */
public class DirReduction {
  private static final Map<String, String> opposites = Map.of(
      "NORTH", "SOUTH",
      "SOUTH", "NORTH",
      "EAST", "WEST",
      "WEST", "EAST"
  );

  public static String[] dirReduc(String[] arr) {
    Stack<String> dirStack = new Stack<>();

    for (String dir : arr) {
      if (dirStack.isEmpty()) {
        dirStack.push(dir);
        continue;
      }

      if (dirStack.peek().equals(opposites.get(dir))) {
        dirStack.pop();
      } else {
        dirStack.push(dir);
      }
    }

    String[] results = new String[dirStack.size()];
    int i = dirStack.size() - 1;
    while (!dirStack.isEmpty()) {
      results[i--] = dirStack.pop();
    }

    return results;
  }
}
