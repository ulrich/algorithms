import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Palindrome implementation
 *
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­
 * drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
*/
public class Solution {

  public static void main(String[] args) {
    new Solution().should_not_urlify_with_invalid_parameter();
    new Solution().should_urlify_empy_string();
    new Solution().should_urlify();
  }

  public void should_not_urlify_with_invalid_parameter() {
    try {
      new URLify().urlify(null, 5);
      assertThat("false", "true");
    } catch (Exception e) {
        // OK
    }
  }

  public void should_urlify_empy_string() {
    String expect = new URLify().urlify("  ", 5);

    assertThat(expect, "%20%20");
  }

  public void should_urlify() {
    String expect = new URLify().urlify("Mr John Smith    ", 13);

    assertThat(expect, "Mr%20John%20Smith");
  }

  class URLify {
    public String urlify(String url, Integer length) {
      if (url == null || length <= 0) {
        throw new IllegalStateException("Invalid parameters found, url=" + url + "length=" + length);
      }
      return url.chars() //
        .limit(length) //
        .mapToObj(i -> (i == ' ')? "%20" : Character.toString((char) i)) //
        .collect(Collectors.joining(""));
    }
  }

  public static void assertThat(String test, String expect) {
    if(!test.equals(expect)) {
      throw new IllegalStateException("Assertion failed in " + Thread.currentThread().getStackTrace()[2]);
    }
  }
}
