import java.io.*;
import java.util.*;

/**
 * a LinkedList implementation
 */
class Solution {

  public static void main(String[] args) {
    new Solution().should_return_size();
    new Solution().should_delete_node();
    new Solution().should_display_nodes();
  }

  public void should_display_nodes() {
    System.out.println("Start of test=" + "should_display_nodes");

    MyLinkedList mll = new MyLinkedList();

    mll.insert(1);
    mll.insert(2);
    mll.insert(3);

    mll.display();

    System.out.println("Successful");
  }

  public void should_return_size() {
    System.out.println("Start of test=" + "should_return_size");

    MyLinkedList mll = new MyLinkedList();

    mll.insert(4);
    mll.insert(5);

    assert 2 == mll.size();

    mll.display();
    System.out.println("Successful");
  }
  
  public void should_delete_node() {
    System.out.println("Start of test=" + "should_delete_node");

    MyLinkedList mll = new MyLinkedList();

    mll.insert(6);
    mll.insert(7);
    mll.insert(8);    
    mll.insert(9);    

    assert 4 == mll.size();

    mll.display();
    System.out.println("Remove");
    mll.remove();

    assert 3 == mll.size();

    mll.display();
    System.out.println("Successful");
  }
  
  class Node {
    private final Integer value;
    private final Node next;

    public Node(Integer value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  class MyLinkedList {
    private Node first;
    private Integer size = 0;

    public MyLinkedList() {
      first = new Node(null, null);
    }

    public void insert(Integer value) {
      size++;
      first = new Node(value, first);
    }

    public void remove() {
      size--;
      first = first.next;
    }

    public void display() {
      Node actual = first;

      while(actual.next != null) {
        System.out.println(actual.value);
        actual = actual.next;
      }
    }
    
    public Integer size() {
      return size;
    }
  }
}
