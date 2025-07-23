package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringIncrementerTests {

  private static void doTest(String str, String expected) {
    String actual = assertDoesNotThrow(() -> StringIncrementer.incrementString(str), "Solution thrown an unexpected exception for " +
        "str=\"" + str + "\"\n\n");
    assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
  }


  @Test
  public void exampleTests() {
    doTest("foobar000", "foobar001");
    doTest("foo", "foo1");
    doTest("foobar001", "foobar002");
    doTest("foobar99", "foobar100");
    doTest("foobar099", "foobar100");
    doTest("", "1");
    doTest("1", "2");
    doTest("fo99obar99", "fo99obar100");
    doTest(
        "v@hh[.~K*FLIc|C-)u#efD\"R0000025302448201434625945770254006",
        "v@hh[.~K*FLIc|C-)u#efD\"R0000025302448201434625945770254007");
    doTest("R000000000000000000000000000055238356207", "R000000000000000000000000000055238356208");
  }
}
