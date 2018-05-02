package net.reservoircode.data_structures.hash_table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTableTest {

    @Test
    public void should_add_retrieve_element() {
        HashTable hashtable = new HashTable();

        hashtable.put("id1", new HashTable.Person("User1", "Name1", "0102030405"));
        hashtable.put("id2", new HashTable.Person("User2", "Name2", "0102030405"));
        hashtable.put("id3", new HashTable.Person("User3", "Name3", "0102030405"));
        hashtable.put("id4", new HashTable.Person("User4", "Name4", "0102030405"));
        hashtable.put("id5", new HashTable.Person("User5", "Name5", "0102030405"));
        hashtable.put("id6", new HashTable.Person("User6", "Name6", "0102030405"));
        hashtable.put("id7", new HashTable.Person("User7", "Name7", "0102030405"));
        hashtable.put("id8", new HashTable.Person("User8", "Name8", "0102030405"));
        hashtable.put("id9", new HashTable.Person("User9", "Name9", "0102030405"));

        assertThat(hashtable.get("id1").getLastName()).isEqualTo("Name1");
        assertThat(hashtable.get("id5").getLastName()).isEqualTo("Name5");
        assertThat(hashtable.get("id9").getLastName()).isEqualTo("Name9");
    }
}