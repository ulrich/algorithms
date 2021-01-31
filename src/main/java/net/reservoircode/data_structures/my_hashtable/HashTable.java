package net.reservoircode.data_structures.my_hashtable;

public class HashTable<T> {

    private static final int DEFAULT_SIZE = 4;

    private final int size;
    private final Entry<T>[] entries;

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    public HashTable(int size) {
        this.size = size;

        entries = new Entry[this.size];
    }

    public void put(String key, T value) {
        Entry<T> entry = new Entry<>(key, value);

        int position = hash(key) % size;

        if (entries[position] == null) {
            entries[position] = entry;
        } else {
            System.out.println("[DEBUG] - Collision in put for " + key);
            Entry<T> current = entries[position];
            while (current.next != null) {
                current = current.next;
            }
            current.next = entry;
        }
    }

    public T get(String key) {
        int position = hash(key) % size;

        Entry<T> current = entries[position];

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

    private static class Entry<T> {
        String key;
        T value;
        Entry<T> next;

        public Entry(String key, T value) {
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
