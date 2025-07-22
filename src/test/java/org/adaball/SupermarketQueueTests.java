package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketQueueTests {
  @Test
  void normalCondition() {
    assertEquals(9, SupermarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2), "For customers {2, 2, 3, 3, 4, 4} and 2 tills");
  }

  @Test
  void emptyWaitingQueue() {
    assertEquals(0, SupermarketQueue.solveSuperMarketQueue(new int[] {}, 1), "For no customers and 1 till");
  }

  @Test
  void singleTillManyCustomers() {
    assertEquals(15, SupermarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1), "For customers {1, 2, 3, 4, 5} and 1 till");
  }

  @Test
  void asdf() {
    assertEquals(13, SupermarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 5, 8 }, 2));
  }
}
