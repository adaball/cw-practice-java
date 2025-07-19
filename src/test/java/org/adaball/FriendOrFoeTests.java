package org.adaball;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendOrFoeTests {
  @Test
  void testFriend() {
    assertEquals(
        List.of("Ryan", "Yous"),
        FriendOrFoe.friend(List.of("Ryan", "Kieran", "Jason", "Yous")),
        "Input: [\"Ryan\", " +
            "\"Kieran\", \"Jason\", \"Yous\"]");
    assertEquals(
        List.of(),
        FriendOrFoe.friend(List.of("Peter", "Stephen", "Joe")),
        "Input: [\"Peter\", \"Stephen\", \"Joe\"]");
  }
}
