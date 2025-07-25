package org.adaball;

/**
 * https://www.codewars.com/kata/528d9adf0e03778b9e00067e/train/java
 * NxN grid, find the mine
 * square where mine is represented by 1
 * other squares represented by 2
 * return val: [ row, col ] (both zero based)
 * examples:
 * [ [1, 0, 0], [0, 0, 0], [0, 0, 0] ] --> [0, 0]
 * [ [0, 0, 0], [0, 1, 0], [0, 0, 0] ] --> [1, 1]
 * [ [0, 0, 0], [0, 0, 0], [0, 1, 0] ] --> [2, 1]
 */
public class MineFinder {
  public static int[] findMine(int[][] field) {
    for (int row = 0; row < field.length; row++) {
      for (int col = 0; col < field[row].length; col++) {
        if (field[row][col] == 1) {
          return new int[] {row, col};
        }
      }
    }

    return new int[] {};
  }
}
