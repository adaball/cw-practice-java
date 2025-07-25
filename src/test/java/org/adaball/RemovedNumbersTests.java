package org.adaball;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovedNumbersTests {
  @Test
  public void test12() {
    List<long[]> res = new ArrayList<>();
    res.add(new long[] {15, 21});
    res.add(new long[] {21, 15});
    List<long[]> a = RemovedNumbers.removNb(26);
    assertArrayEquals(res.get(0), a.get(0));
    assertArrayEquals(res.get(1), a.get(1));
  }

  @Test
  public void test14() {
    List<long[]> a = RemovedNumbers.removNb(100);
    assertEquals(0, a.size());
  }
}
