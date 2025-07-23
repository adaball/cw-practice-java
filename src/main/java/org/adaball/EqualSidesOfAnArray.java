package org.adaball;

/**
 * https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/java
 * <p>
 * You are going to be given an array of integers. Your job is to take
 * that array and find an index N where the sum of the integers to the
 * left of N is equal to the sum of the integers to the right of N.
 * <p>
 * If there is no index that would make this happen, return -1.
 */
public class EqualSidesOfAnArray {

  private static int sum(int[] arr, int a, int b) {
    int sum = 0;

    for (int i = a; i < b; i++) {
      sum += arr[i];
    }

    return sum;
  }

  public static int findEvenIndex(int[] arr) {
    int i = 0;

    while (i < arr.length) {
      int a = sum(arr, 0, i);
      int b = sum(arr, i + 1, arr.length);
      if (a == b) {
        return i;
      }
      i++;
    }

    return -1;
  }
}
