package org.adaball;

public class DigPow {
  /*
  Given two positive integers n and p, we want to find a positive integer k,
  if it exists, such that the sum of the
  digits of n raised to consecutive powers starting from p is equal to k * n.
  */
  public static int digPow(int n, int p) {
    String[] digitStrings = String.valueOf(n).split("");
    int[] digits = new int[digitStrings.length];

    for (int i = 0; i < digitStrings.length; i++) {
      digits[i] = Integer.parseInt(digitStrings[i]);
    }

    double sum = 0.0;
    for (int digit : digits) {
      sum += Math.pow(digit, p++);
    }

    if (sum % n == 0) {
      return (int) (sum / n);
    }

    return -1;
  }
}
