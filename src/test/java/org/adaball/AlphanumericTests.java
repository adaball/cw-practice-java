package org.adaball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlphanumericTests {
  @Test
  @DisplayName("Valid input")
  void testValidInput() {
    assertTrue(Alphanumeric.alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
  }

  @DisplayName("Invalid character")
  @ParameterizedTest(name="Should return false for \"{0}\"")
  @ValueSource(strings = {"", "with space", "with_underscore", "punctuation.", "naïve", "１strangedigit", "emoji😊"})
  void testInvalidChars(String input) {
    assertFalse(Alphanumeric.alphanumeric(input));
  }
}
