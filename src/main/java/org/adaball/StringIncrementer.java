package org.adaball;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/54a91a4883a7de5d7800009c
 */
public class StringIncrementer {
  public static String incrementString(String str) {
    Pattern pattern = Pattern.compile("^(.*\\D)?(\\d+)$");
    Matcher matcher = pattern.matcher(str);

    if (!matcher.matches()) {
      return String.format("%s%d", str, 1);
    }

    String prefix = matcher.group(1) == null ? "" : matcher.group(1);
    String digitString = matcher.group(2);

    try {
      // int digits = Math.max(digitString.length(), String.valueOf(incremented).length());
      String formatString = "%s%0" + digitString.length() + "d";
      return String.format(formatString, prefix, Integer.parseInt(digitString) + 1);
    } catch (NumberFormatException ex) {
      System.out.printf("Exception thrown while parsing int: %s\n", ex.getMessage());
    }

    String formatString = "%s%0" + digitString.length() + "d";
    return String.format(formatString, prefix, new BigInteger(digitString).add(BigInteger.ONE));
  }
}
