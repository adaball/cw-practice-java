package org.adaball;

public class StringSplit {
  public static String[] solution(String s) {
    if (s.isEmpty()) {
      return new String[]{};
    }

    String[] tokens = s.split("");
    int arrLen;

    if (tokens.length % 2 == 0) {
      arrLen = tokens.length / 2;
    } else {
      // pad out one extra if we have an odd number of tokens
      arrLen = (int) Math.ceil((double) tokens.length / 2);
    }

    String[] result = new String[arrLen];

    for (int i = 0; i < tokens.length; i += 2) {
      String first = tokens[i];
      String second = i + 1 < tokens.length ? tokens[i + 1] : "_";
      result[i / 2] = String.format("%s%s", first, second);
    }

    return result;
  }
}
