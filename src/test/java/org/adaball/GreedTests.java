package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedTests {
  @Test
  public void shouldBeWorthless() {
    assertEquals(0, Greed.greedy(new int[] {2, 3, 4, 6, 2}));
  }

  @Test
  public void shouldValueTriplets() {
    assertEquals(400, Greed.greedy(new int[] {4, 4, 4, 3, 3}));
  }

  @Test
  public void shouldValueMixedSets() {
    assertEquals(450, Greed.greedy(new int[] {2, 4, 4, 5, 4}));
  }

  @Test
  public void asdf() {
    // Incorrect answer for dice = [1, 1, 2, 3, 6] ==> expected: <200> but was: <100>
    assertEquals(200, Greed.greedy(new int[] {1, 1, 2, 3, 6}));
  }
}
