package org.adaball;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java
 */
public class Order {

  /**
   * Your task is to sort a given string. Each word in the string will contain a single number. This number is the
   * position the word should have in the result.
   * <p>
   * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
   * <p>
   * If the input string is empty, return an empty string. The words in the input String will only contain valid
   * consecutive numbers.
   */
  public static String order(String s) {
    if ("".equals(s)) {
      return "";
    }

    Pattern pattern = Pattern.compile("^\\D*(\\d)\\D*$");
    String[] tokens = s.split(" ");

    Map<Integer, String> stringOrdering = new HashMap<>();

    for (String token : tokens) {
      Matcher matcher = pattern.matcher(token);
      matcher.matches();
      stringOrdering.put(Integer.parseInt(matcher.group(1)), token);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer k : stringOrdering.keySet().stream().sorted().toList()) {
      sb.append(stringOrdering.get(k));
      sb.append(" ");
    }

    return sb.toString().strip();
  }
}
