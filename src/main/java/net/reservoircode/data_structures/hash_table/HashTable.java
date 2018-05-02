package net.reservoircode.data_structures.hash_table;

public class HashTable {
    private static final int SIZE = 4;
    private Entry[] entries = new Entry[SIZE];

    public void put(String key, Person person) {
        Entry entry = new Entry(key, person);

        int position = hash(key) % SIZE;

        if (entries[position] == null) {
            entries[position] = entry;
        } else {
            System.out.println("[DEBUG] - Collision in put for " + key);
            Entry current = entries[position];
            while (current.next != null) {
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

        while (current.next != null) {
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

    private static class Entry {
        String key;
        Person value;
        Entry next;

        public Entry(String key, Person value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static class Person {
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
}
