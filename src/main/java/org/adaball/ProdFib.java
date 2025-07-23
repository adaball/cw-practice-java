package org.adaball;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/5541f58a944b85ce6d00006a
 */
public class ProdFib {
  private static final Map<Long, Long> memo = new HashMap<>();

  private static long fib(long n) {
    if (n < 2) {
      return n;
    }

    if (!memo.containsKey(n - 1)) memo.put(n - 1, fib(n - 1));
    if (!memo.containsKey(n - 2)) memo.put(n - 2, fib(n - 2));

    return memo.get(n - 1) + memo.get(n - 2);
  }

  public static long[] productFib(long prod) {
    int n = 0;
    int n1 = 1;

    while (fib(n) * fib(n1) < prod) {
      n++;
      n1++;
    }

    return new long[] {fib(n), fib(n1), fib(n) * fib(n1) == prod ? 1 : 0};
  }
}
