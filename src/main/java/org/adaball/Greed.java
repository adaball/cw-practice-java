package org.adaball;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java
 * <pre>
 *  Three 6's =>  600 points
 *  Three 5's =>  500 points
 *  Three 4's =>  400 points
 *  Three 3's =>  300 points
 *  Three 2's =>  200 points
 *  Three 1's => 1000 points
 *  One   1   =>  100 points
 *  One   5   =>   50 point
 *
 *  Each of 5 dice can only be counted once in each roll. For example, a given "5"
 *  can only count as part of a triplet (contributing to the 500 points) or as a
 *  single 50 points, but not both in the same roll.
 *
 *  Example scoring
 *
 *  Throw       Score
 *  ---------   ------------------
 *  5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 *  1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 *  2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 */
public class Greed {

  private static final Map<Integer, Map<Integer, Integer>> diceScores = Map.of(
      1, Map.of(1, 100, 3, 1000),
      2, Map.of(3, 200),
      3, Map.of(3, 300),
      4, Map.of(3, 400),
      5, Map.of(1, 50, 3, 500),
      6, Map.of(3, 600)
  );

  public static int greedy(int[] dice) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int die : dice) {
      freq.put(die, freq.getOrDefault(die, 0) + 1);
    }

    int score = 0;
    for (int i = 1; i < 7; i++) {
      int dieFreq = freq.getOrDefault(i, -1);
      if (dieFreq == -1) {
        continue;
      }

      while (dieFreq > 0) {
        Map<Integer, Integer> dieScores = diceScores.get(i);
        if (dieFreq >= 3) {
          score += dieScores.get(3);
          dieFreq -= 3;
        } else if (dieScores.containsKey(1)) {
          score += dieScores.get(1);
          dieFreq--;
        } else {
          break;
        }
      }
    }

    return score;
  }
}
