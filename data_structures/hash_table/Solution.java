
public class Solution {

  public static void main(String[] args) {
    new Solution().should_add_retrieve_element();
  }

  public void should_add_retrieve_element() {
    HashTable hashtable = new HashTable();

    hashtable.put("id1", new Person("User1", "Name1", "0102030405"));
    hashtable.put("id2", new Person("User2", "Name2", "0102030405"));
    hashtable.put("id3", new Person("User3", "Name3", "0102030405"));
    hashtable.put("id4", new Person("User4", "Name4", "0102030405"));
    hashtable.put("id5", new Person("User5", "Name5", "0102030405"));
    hashtable.put("id6", new Person("User6", "Name6", "0102030405"));
    hashtable.put("id7", new Person("User7", "Name7", "0102030405"));
    hashtable.put("id8", new Person("User8", "Name8", "0102030405"));
    hashtable.put("id9", new Person("User9", "Name9", "0102030405"));

    assertThat(hashtable.get("id1").getLastName(), "Name1");
    assertThat(hashtable.get("id5").getLastName(), "Name5");
    assertThat(hashtable.get("id9").getLastName(), "Name9");
  }

  class HashTable {
    public static final int SIZE = 4;
    public Entry[] entries = new Entry[SIZE];

    public void put(String key, Person person) {
      Entry entry = new Entry(key, person);

      int position = hash(key) % SIZE;

      if (entries[position] == null) {
        entries[position] = entry;
      } else {
        System.out.println("[DEBUG] - Collision in put for " + key);

        Entry current = entries[position];

        while(current.next != null) {
          current = current.next;
        }
        current.next = entry;
      }
    }

    public Person get(String key) {
      int position = hash(key) % SIZE;

      Entry current = entries[position];

      if (entries[position] == null) {
        return null;
      }
      if (current.key.equals(key)) {
        return current.value;
      }
      System.out.println("[DEBUG] - Collision in get for " + key);

      while(current.next != null) {
        if (current.next.key.equals(key)) {
          return current.next.value;
        }
        current = current.next;
      }
      return null;
    }

    public int hash(String key) {
      return key.hashCode();
    }

    class Entry {
      String key;
      Person value;
      Entry next;

      public Entry(String key, Person value) {
        this.key = key;
        this.value = value;
        this.next = null;
      }
    }
  }

  class Person {
    private final String firstName;
    private final String lastName;
    private final String phone;

    public Person(String firstName, String lastName, String phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public String getPhone() {
      return phone;
    }
  }

  public static void assertThat(String test, String expect) {
    String testMethod = Thread.currentThread().getStackTrace()[2].toString();

    if(test != expect) {
      throw new IllegalStateException("Assertion failed in " + testMethod + ". Expected=" + expect + " found=" + test);
    }
    System.out.println(testMethod + " passed for predicates=(" + test + "=" + expect + ")");
  }
}
