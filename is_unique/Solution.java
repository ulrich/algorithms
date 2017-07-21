import java.io.*;
import java.util.*;
import java.util.function.*;

/**
 * IsUnique implementation
 */
public class Solution {

  public static void main(String[] args) {
    new Solution().should_check_empty_string();
    new Solution().should_check_one_element();
    new Solution().should_find_doublon();
    new Solution().should_not_find_doublon();
  }

  public void should_check_empty_string() {
    IsUnique iu = new IsUnique();

    assertThat(iu.one(""), true);
  }

  public void should_check_one_element() {
    IsUnique iu = new IsUnique();

    assertThat(iu.one("a"), true);
  }

  public void should_find_doublon() {
    IsUnique iu = new IsUnique();

    assertThat(iu.one("aa"), false);
  }

  public void should_not_find_doublon() {
    IsUnique iu = new IsUnique();

    assertThat(iu.one("abcde"), true);
  }

  class IsUnique {

    public boolean one(String string) {
      if (string != null && string.length() < 2) {
        return true;
      }
      Set<Character> stringToSet = new HashSet<Character>();
      char[] fromString = string.toCharArray();

      for(int i = 0; i < fromString.length; i++) {
        stringToSet.add(fromString[i]);
      }
      return stringToSet.size() == string.length();
    }
  }

  public static void assertThat(Boolean test, Boolean expect) {
    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + Thread.currentThread().getStackTrace()[2]);
    }
  }
}
