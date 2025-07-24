package org.adaball;

import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/526dbd6c8c0eb53254000110/train/java
 */
public class Alphanumeric {
  public static boolean alphanumeric(String s) {
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
    return pattern.matcher(s).matches();
  }
}
