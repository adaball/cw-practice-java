package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxSumDigitsTests {
  @Test
  public void sampleTests() {
    //             nMax maxSum            expected
    testing(2000, 3, new long[] {11, 1110, 12555});
    testing(2000, 4, new long[] {21, 1120, 23665});
    testing(2000, 7, new long[] {85, 1200, 99986});
    testing(3000, 7, new long[] {141, 1600, 220756});
    testing(4000, 4, new long[] {35, 2000, 58331});
    testing(5000, 2, new long[] {5, 1100, 6111});
    testing(5000, 3, new long[] {15, 1200, 21666});
    testing(5000, 4, new long[] {35, 2000, 58331});
    testing(5000, 5, new long[] {70, 2000, 132216});
    // testing(5000, 6, new long[] {122, 2010, 244875});
    testing(5000, 7, new long[] {196, 2110, 413306});
    testing(5000, 8, new long[] {296, 2200, 649951});
    testing(5000, 9, new long[] {426, 2250, 967696});
  }

  private static void testing(long nMax, int maxSum, long[] expected) {
    String message = String.format("nMax = %d, maxSum = %d\n", nMax, maxSum);
    long[] actual = MaxSumDigits.maxSumDig(nMax, maxSum);
    assertArrayEquals(expected, actual, message);
  }
}
