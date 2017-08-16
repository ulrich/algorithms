import java.io.*;
import java.util.*;
import java.util.function.*;

/**
 * LinearSearch implementation
 * 
 * Implement the linear search simple algorithm.
 */ 
public class Solution {

  public static void main(String[] args) {
    new Solution().should_return_first_index_of_element();
    new Solution().should_return_error_code_if_not_found();
  }

  public void should_return_first_index_of_element() {
    LinearSearch ls = new LinearSearch();

    assertThat(ls.search(new Integer[]{0, 200, 34, 99, 2, 901, 2}, 2), 4);
  }

  public void should_return_error_code_if_not_found() {
    LinearSearch ls = new LinearSearch();

    assertThat(ls.search(new Integer[]{0, 1, 2}, 3), -1);
  }

  class LinearSearch {

    public Integer search(Integer[] array, Integer element) {
      for(int i = 0; i < array.length; i++) {
        if (array[i] == element) {
          return i;
        }
      }
      return -1;
    }
  }

  public static void assertThat(Integer test, Integer expect) {
    String testMethod = Thread.currentThread().getStackTrace()[2].toString();

    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + testMethod);
    }
    System.out.println(testMethod + " passed!");
  }
}
