package org.adaball;

import java.util.List;

public class FriendOrFoe {
  public static List<String> friend(List<String> names) {
    return names.stream().filter(s -> s.length() == 4).toList();
  }
}
