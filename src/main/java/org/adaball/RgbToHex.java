package org.adaball;

import java.util.List;

/**
 * https://www.codewars.com/kata/513e08acc600c94f01000001/train/java
 */
public class RgbToHex {
  public static String rgb(int r, int g, int b) {
    // Valid decimal values for RGB are 0 - 255. Any values that fall
    // out of that range must be rounded to the closest valid value.
    StringBuilder sb = new StringBuilder();

    for (Integer i : List.of(r, g, b)) {
      if (i < 0) {
        i = 0;
      } else if (i > 255) {
        i = 255;
      }

      sb.append(String.format("%02X", i));
    }

    return sb.toString();
  }
}
