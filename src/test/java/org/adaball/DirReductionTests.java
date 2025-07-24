package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirReductionTests {
  @Test
  public void testSimpleDirReduc() {
    assertArrayEquals(
        new String[] {"WEST"},
        DirReduction.dirReduc(new String[] {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}),
        "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
    assertArrayEquals(
        new String[] {},
        DirReduction.dirReduc(new String[] {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}),
        "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
  }
}
