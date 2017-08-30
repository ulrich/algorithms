import java.io.*;
import java.util.*;
import java.util.function.*;

public class Solution {

  public static void main(String[] args) {
    new Solution().should_calculate_factorial();
  }

  public void should_calculate_factorial() {
    Factorial factorial = new Factorial();

    assertThat(factorial.calculate(8), 40320);
  }

  class Factorial {

    public int calculate(int element) {
      return (element == 0) ? 1 : element * calculate(element - 1);
    }
  }

  public static void assertThat(int test, int expect) {
    String testMethod = Thread.currentThread().getStackTrace()[2].toString();

    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + testMethod + ". Expected=" + expect + " found=" + test);
    }
    System.out.println(testMethod + " passed!");
  }
}
