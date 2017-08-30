import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Solution {

  public static void main(String[] args) {
    new Solution().should_not_find_more_than_one_edit();
    new Solution().should_find_more_than_one_edit();
  }

  public void should_not_find_more_than_one_edit() {
    OneWay oneWay = new OneWay();

    assertThat(oneWay.check("pale", "ple"), true);
    assertThat(oneWay.check("pales", "pale"), true);
    assertThat(oneWay.check("pale", "bale"), true);
    assertThat(oneWay.check("ple", "pale"), true);
  }

  public void should_find_more_than_one_edit() {
    OneWay oneWay = new OneWay();

    assertThat(oneWay.check("pale", "bake"), false);
  }

  class OneWay {
    public Boolean check(String s1, String s2) {
      // in ascii encoding do the sum (char to int) all chars for s1 and s2
      // to lower case s1 and s2
      // if the sum between 'a' and 'z' there is not more one edit

      Integer sumOfS1 = s1.toLowerCase().chars().sum();
      Integer sumOfS2 = s2.toLowerCase().chars().sum();

      System.out.println(sumOfS1);
      System.out.println(sumOfS2);

      Integer delta = Math.abs(sumOfS1 - sumOfS2);

      System.out.println((int) 'b');

      return (delta - (int)'a') <= 26;
    }
  }

  public static void assertThat(Boolean test, Boolean expect) {
    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + Thread.currentThread().getStackTrace()[2]);
    }
  }
}
