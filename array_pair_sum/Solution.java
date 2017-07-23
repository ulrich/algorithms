import java.io.*;
import java.util.*;

/*
 * ArrayPairSum implentation
 *
 * Given an integer array, output all pairs that sum up to a specific value k.
 */
public class Solution {

  public static void main(String[] args) {
    new Solution().should_find_one_pair();
    new Solution().should_find_several_pairs();
  }

  public void should_find_one_pair() {
    int[] array = new int[]{4, 1, 0, 9, 6};

    List<Tuple> tuples = new ArrayPairSum(array).find(15);

    assert tuples.get(0).left == 6 && tuples.get(0).right == 9;
  }

  public void should_find_several_pairs() {
    int[] array = new int[]{4, 1, 0, 9, 6, 14, 2, 3, 34, 7, 5, 19};

    List<Tuple> tuples = new ArrayPairSum(array).find(5);
    
    assert tuples.size() == 3;
  }

  class ArrayPairSum {
    int[] array;
    int left, right;

    public ArrayPairSum(int[] array) {
      this.array = array;

      left = 0;
      right = array.length - 1;
    }

    public List<Tuple> find(Integer value) {
      Arrays.sort(array);
      
      List<Tuple> tuples = new ArrayList<Tuple>();
      
      while(left < right) {
        int sum = array[left] + array[right];

        if (sum == value) {
          tuples.add(new Tuple(array[left], array[right]));
          left += 1;
        } else if (sum < value) {
          left += 1;
        } else {
          right -= 1;
        }
      }
      return tuples;
    }
  }
  
  class Tuple {
    Integer left;
    Integer right;

    public Tuple(Integer left, Integer right) {
      this.left = left;
      this.right = right;
    }
  }
}
