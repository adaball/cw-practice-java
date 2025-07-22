package org.adaball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrambliesTests {

  @Test
  @Order(1)
  public void sampleTests() {
    // assertEquals(Scramblies.scramble("rkqodlw", "world"), true);
    assertEquals(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true);
    assertEquals(Scramblies.scramble("katas", "steak"), false);
    assertEquals(Scramblies.scramble("scriptjavx", "javascript"), false);
    assertEquals(Scramblies.scramble("scriptingjava", "javascript"), true);
    assertEquals(Scramblies.scramble("scriptsjava", "javascripts"), true);
    assertEquals(Scramblies.scramble("javscripts", "javascript"), false);
    assertEquals(Scramblies.scramble("aabbcamaomsccdd", "commas"), true);
    assertEquals(Scramblies.scramble("commas", "commas"), true);
    assertEquals(Scramblies.scramble("sammoc", "commas"), true);
  }

  @Test
  @Order(2)
  public void largeTest() {

    String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
    String s2 = "zyxcba".repeat(9_000);

    assertEquals(Scramblies.scramble(s1, s2), true);
  }
}
