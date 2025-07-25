package org.adaball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/55f5efd21ad2b48895000040/train/java
 * <pre>
 *   numbers >= 1000 who's sum of every four consecutive digits cannot be higher than a given value
 *   for a 6 digit number 123456 the three four consecutive digits with their sums would be:
 *   1234 -> 10
 *   2345 -> 14
 *   3456 -> 18
 *
 *   nMax - maximum value of the interval to study (i.e. range(1000, nMax))
 *   maxSum - maximum sum that every four consecutive digits should be <= to.
 *
 *   output [1, 2, 3]
 *   1. amount of numbers that satisfy the constraint
 *   2. closest number to the mean of the results (if there are more than one, choose the smallest)
 *   3. total sum of all found numbers
 *
 *   Map<long, long> findConsecutiveDigits (long n)
 *      Map<long, long> results = new hash map
 *      String[] digitStrs = (n as a string).split("")
 *      Long[] digitsLong = nwe array
 *      for i=0 i < digitStrs.length i++
 *        digitsLong[i] = digitsStr[i] as long
 *
 *      int lower = 0
 *      int upper = 3
 *      while upper < digitsLong.length
 *        String s = ""
 *        long sum = 0
 *        for i = lower; i <= upper; i++
 *          s += digitStrs[i]
 *          sum += digitsLong[i]
 *        results.put(Long.parseLong(s), sum)
 *
 *        lower++
 *        upper++
 *
 *     return results
 *
 *
 *
 *   </pre>
 */
public class MaxSumDigits {

  private static void findConsecutive(long n, Map<Long, Long> resultMap) {
    String[] digitsStr = String.valueOf(n).split("");
    Long[] digitsLong = new Long[digitsStr.length];
    for (int i = 0; i < digitsStr.length; i++) {
      digitsLong[i] = Long.parseLong(digitsStr[i]);
    }

    int lower = 0;
    int upper = 3;
    while (upper < digitsLong.length) {

      StringBuilder s = new StringBuilder();
      long sum = 0;

      for (int i = lower; i <= upper; i++) {
        s.append(digitsStr[i]);
        sum += digitsLong[i];
      }

      resultMap.put(Long.parseLong(s.toString()), sum);

      lower++;
      upper++;
    }
  }

  public static long[] maxSumDig(long nMax, long maxSum) {
    Map<Long, Long> resultMap = new HashMap<>();

    for (long l = 1000; l <= nMax; l++) {
      findConsecutive(l, resultMap);
    }

    List<Long> filteredResults = resultMap.entrySet()
        .stream()
        .filter((e) -> e.getValue() <= maxSum)
        .map(Map.Entry::getKey)
        .toList();

    //  *   1. amount of numbers that satisfy the constraint
    //  *   2. closest number to the mean of the results (if there are more than one, choose the smallest)
    //  *   3. total sum of all found numbers

    long totalSum = 0;
    for (Long l : filteredResults) {
      totalSum += l;
    }
    long mean = totalSum / filteredResults.size();

    // find the long that is closest to the mean
    long[] closestTuple = new long[2];
    for (Long l : filteredResults) {
      long diff = mean - l;
      long absDiff = Math.abs(diff);

      if (closestTuple[0] == 0 || absDiff < closestTuple[1]) {
        closestTuple[0] = l;
        closestTuple[1] = absDiff;
      } else if (absDiff == closestTuple[1]) {
        if (l < closestTuple[0]) {
          closestTuple[0] = l;
        }
      }
    }

    return new long[] {(long) filteredResults.size(), closestTuple[0], totalSum};
  }
}
