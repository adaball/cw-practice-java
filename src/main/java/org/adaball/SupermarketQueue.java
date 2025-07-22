package org.adaball;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * https://www.codewars.com/kata/57b06f90e298a7b53d000a86/train/java
 * <p>
 * customers: an array of positive integers representing the queue.
 * Each integer represents a customer, and its value is
 * the amount of time they require to check out.
 * <p>
 * n:         a positive integer, the number of checkout tills.
 * <p>
 * <pre>
 *     Clarifications
 *
 *     There is only ONE queue serving many tills
 *     The order of the queue NEVER changes
 *     The front person in the queue (i.e. the first element
 *             in the array/list) proceeds to a till as soon as it becomes free.
 *   </pre>
 * output: The function should return an integer, the total time required.
 */
public class SupermarketQueue {
  public static int solveSuperMarketQueue(int[] customers, int n) {
    if (n == 1) {
      int sum = 0;
      for (int customer : customers) {
        sum += customer;
      }

      return sum;
    }

    Map<Integer, Integer> tills = new HashMap<>();
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      tills.put(i, 0);
    }

    for (int customer : customers) {
      queue.add(customer);
    }

    int totalTime = 0;
    while (!queue.isEmpty() || tillsOccupied(tills)) {
      System.out.printf("%d\n", totalTime);

      for (Integer k : tills.keySet()) {
        // if a till is open and someone is waiting
        if (tills.get(k) <= 0 && !queue.isEmpty()) {
          tills.put(k, queue.remove());
        }

        System.out.printf("Till %d has value %d\n", k, tills.get(k));
        tills.put(k, tills.get(k) - 1);
      }

      totalTime++;

      System.out.println("-----");
    }

    return totalTime;
  }

  private static boolean tillsOccupied(Map<Integer, Integer> tills) {
    for (Integer v : tills.values()) {
      if (v >= 1) {
        return true;
      }
    }

    return false;
  }

  private static void output(Map<Integer, Integer> tills) {
    tills.forEach((k, v) -> System.out.printf("Till %d has value %d\n", k, v));
  }
}
