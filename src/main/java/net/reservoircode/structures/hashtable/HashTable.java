package net.reservoircode.structures.hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public class HashTable<T> {

    private static final int DEFAULT_SIZE = 4;

    private final int size;
    private final Logger logger;
    private final Entry<T>[] entries;

    private int count = 0;

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    public HashTable(int size) {
        this(size, LoggerFactory.getLogger(HashTable.class));
    }

    /* visible for testing */ HashTable(int size, Logger logger) {
        if (size < 1) {
            throw new IllegalStateException(format("Invalid size provided: %s", size));
        }
        this.size = size;
        this.logger = logger;

        logger.debug("Creating hashtable with size: {}", size);
        entries = new Entry[this.size];
    }

    public void put(String key, T value) {
        if (isNull(key)) {
            throw new IllegalArgumentException("Key must not be null");
        }
        Entry<T> entry = new Entry<>(key, value);

        count++;

        int position = hash(key) % size;

        if (entries[position] == null) {
            entries[position] = entry;
        } else {
            logger.debug("Collision when putting key: {}", key);
            Entry<T> current = entries[position];
            while (current.next != null) {
                current = current.next;
            }
            current.next = entry;
        }
    }

    public T get(String key) {
        if (isNull(key)) {
            throw new IllegalArgumentException("Key must not be null");
        }
        int position = hash(key) % size;

        Entry<T> current = entries[position];

        if (entries[position] == null) {
            return null;
        }
        if (current.key.equals(key)) {
            return current.value;
        }
        logger.debug("Collision when getting key: {}", key);
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                return current.next.value;
            }
            current = current.next;
        }
        return null;
    }

    public int count() {
        return count;
    }

    public int hash(String key) {
        return key.hashCode();
    }

    private static class Entry<T> {
        private final String key;
        private final T value;
        private Entry<T> next;

        public Entry(String key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
