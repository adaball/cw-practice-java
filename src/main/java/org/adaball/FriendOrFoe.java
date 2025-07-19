package org.adaball;

import java.util.List;

/**
 * https://www.codewars.com/kata/55b42574ff091733d900002f
 */
public class FriendOrFoe {
  public static List<String> friend(List<String> names) {
    return names.stream().filter(s -> s.length() == 4).toList();
  }
}
