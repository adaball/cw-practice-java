package org.adaball;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/5547cc7dcad755e480000004/train/java
 * <p>
 * In the end couldn't figure this one out.  Failed some of the tests cases, but it doesn't show the test input
 * to test against, so :shrug:
 * <p>
 * <p>
 * <p>
 * - A friend of mine takes the sequence of all numbers from 1 to n (where n > 0).
 * - Within that sequence, he chooses two numbers, a and b.
 * - He says that the **product of a and b** should be **equal to the sum of all numbers in
 * the sequence, excluding a and b.**
 * - Given a number n, could you tell me the numbers he excluded from the sequence?
 * a*b = sum of all numbers in seq, sans a and b
 * removNb(26) should return [(15, 21), (21, 15)]
 * <pre>
 * long sumWithout(long a, long b, long[])
 *   long sum = 0
 *   for l in long[]
 *     if l != a and l != b
 *       sum += l
 *   return sum
 *
 *
 * long[] seq = new long[n+1]
 * for long i = 0; i <= n; i++
 *   seq[i] = i
 *
 * i = 0
 *
 * List<Long[]> answers = new ArrayList<>()
 * while(i <= n)
 *   j = i + 1
 *   while(j <= n)
 *     long a = seq[i]
 *     long b = seq[j]
 *     long prod = a * b
 *     long sum = sumWithout(a, b, seq)
 *     if prod == sum
 *       answers.add(new long[] {a, b})
 *       answers.add(new long[] {b, a})
 *   i++
 *
 *       // n: 50
 *     // a: 14
 *     // b: 23
 *     // prod: 322
 *     // sum without: 1238
 *     // sum with all: 1275 (diff 37, which is a + b)
 *     // 1275 = 1238 - 14 - 23
 * </pre>
 */
public class RemovedNumbers {

  private static long binarySearch(long a, long seqLen, long totalSum) {
    long left = a + 1;
    long right = seqLen;

    while (left < right) {
      long mid = left + ((right - left) / 2);
      long prod = a * mid;
      long sumWithout = totalSum - a - mid;

      if (prod == sumWithout) {
        return mid;
      } else if (prod > sumWithout) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static List<long[]> removNb(long n) {
    List<long[]> answers = new ArrayList<>();
    long totalSum = 0;

    for (long i = 0; i <= n; i++) {
      totalSum += i;
    }

    for (long i = 0; i < n; i++) {
      long result = binarySearch(i, n, totalSum);
      if (result != -1) {
        answers.add(new long[] {i, result});
        answers.add(new long[] {result, i});
      }
    }

    return answers;
  }
}
