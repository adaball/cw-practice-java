package org.adaball;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TwoToOne {
  public static String longest(String a, String b) {
    Set<String> uniqueLetters = new HashSet<>();

    Collections.addAll(uniqueLetters, a.split(""));
    Collections.addAll(uniqueLetters, b.split(""));

    return String.join("", uniqueLetters.stream().sorted().toList());
  }
}
