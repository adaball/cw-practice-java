package org.adaball;

/**
 * https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/java
 * <pre>
 *   strips all text that follows any of a set of comment markers passed in.
 *   Any whitespace at the end of the line should also be stripped out.
 *
 * Given an input string of:
 *
 * apples, pears # and bananas
 * grapes
 * bananas !apples
 *
 * The output expected would be:
 *
 * apples, pears
 * grapes
 * bananas
 *
 * isCommentSym(s, cs[]):
 *   for cs in cs[]
 *      if s == cs return true
 *   return false
 *
 *  lines = split(string by \n)
 *  s = ""
 *  for line in lines
 *     i = 0
 *     while i < line length
 *       if isCommentSym(line[i], cs[])
 *          break;
 *       i++
 *     s += substring(line, 0, i).strip()
 *     s += "\n"
 *
 *  return s
 * </pre>
 */
public class StripComments {

  private static boolean isCommentSymbol(String s, String[] commentSymbols) {
    for (String cs : commentSymbols) {
      if (cs.equals(s)) {
        return true;
      }
    }

    return false;
  }

  public static String stripComments(String text, String[] commentSymbols) {
    String[] lines = text.split("\n");
    StringBuilder sb = new StringBuilder();

    for (String line : lines) {
      int i = 0;
      while (i < line.length()) {
        if (isCommentSymbol(line.substring(i, i + 1), commentSymbols)) {
          break;
        }
        i++;
      }

      sb.append(line.substring(0, i).stripTrailing());
      sb.append("\n");
    }

    return sb.substring(0, sb.toString().length() - 1);
  }
}
