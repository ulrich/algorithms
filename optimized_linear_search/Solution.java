import java.io.*;
import java.util.*;
import java.util.function.*;

/**
 * OptimizedLinearSearch implementation
 * 
 * Implement an optimized linear search algorithm with sentinel.
 */ 
public class Solution {

  public static void main(String[] args) {
    new Solution().should_return_first_index_of_element();
    new Solution().should_return_error_code_if_not_found();
  }

  public void should_return_first_index_of_element() {
    OptimizedLinearSearch ols = new OptimizedLinearSearch();

    assertThat(ols.search(new Integer[]{0, 200, 34, 99, 2, 901, 2}, 2), 4);
  }

  public void should_return_error_code_if_not_found() {
    OptimizedLinearSearch ols = new OptimizedLinearSearch();

    assertThat(ols.search(new Integer[]{0, 1, 2}, 3), -1);
  }

  class OptimizedLinearSearch {

    public Integer search(Integer[] array, Integer element) {
      Integer i = 0;
      Integer last = array[array.length - 1];

      array[array.length - 1] = element;

      while(array[i] != element) {
        i++;
      }
      array[array.length - 1] = last;

      if (i < array.length - 1 || array[i] == element) {
        return i;
      }
      return -1;
    }
  }

  public static void assertThat(Integer test, Integer expect) {
    String testMethod = Thread.currentThread().getStackTrace()[2].toString();

    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + testMethod + ". Expected=" + expect + " found=" + test);
    }
    System.out.println(testMethod + " passed!");
  }
}
