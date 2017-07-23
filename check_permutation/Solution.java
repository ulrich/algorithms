import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * CheckPermutation implementation
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Solution {

  public static void main(String[] args) {
    new Solution().should_not_find_permutation_for_invalid_parameter();
    new Solution().should_not_find_permutation_for_different_strings();
    new Solution().should_find_permutation();
  }

  public void should_not_find_permutation_for_invalid_parameter() {
    boolean expect = new CheckPermutation().check("abc", null);

    assertThat(expect, false);
  }

  public void should_not_find_permutation_for_different_strings() {
    boolean expect = new CheckPermutation().check("abc", "def");

    assertThat(expect, false);
  }

  public void should_find_permutation() {
    boolean expect = new CheckPermutation().check("abc", "cab");

    assertThat(expect, true);
  }

  class CheckPermutation {
    public boolean check(String a, String b) {
      if (a != null && b != null) {
        return toHash(a).equals(toHash(b));
      }
      return false;
    }
  }

  private String toHash(String s) {
    return s.chars().sorted() //
      .mapToObj(c -> "" + c) //
      .collect(Collectors.joining(""));  
  }

  public static void assertThat(Boolean test, Boolean expect) {
    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + Thread.currentThread().getStackTrace()[2]);
    }
  }
}
