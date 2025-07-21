package org.adaball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoToOneTests {

  @Test
  public void test() {
    System.out.println("longest Fixed Tests");
    assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
    assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
    assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
  }
}
