package net.reservoircode.data_structures.my_hashtable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class HashTableTest {

    @Mock
    private Logger logger;

    @Test
    void should_throw_exception_when_creating_with_invalid_size() {
        // Given, When
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new HashTable<>(0));

        // Then
        assertThat(exception.getMessage()).isEqualTo("Invalid size provided: 0");
    }

    @Test
    void should_throw_exception_when_putting_with_null_key() {
        // Given
        HashTable<String> hashtable = new HashTable<>();

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> hashtable.put(null, "A string"));

        // Then
        assertThat(exception.getMessage()).isEqualTo("Key must not be null");
    }

    @Test
    void should_throw_exception_when_getting_with_null_key() {
        // Given
        HashTable<String> hashtable = new HashTable<>();

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> hashtable.get(null));

        // Then
        assertThat(exception.getMessage()).isEqualTo("Key must not be null");
    }

    @Test
    void should_return_null_if_no_element_found() {
        // Given, When
        HashTable<Person> hashtable = new HashTable<>();

        // Then
        assertThat(hashtable.count()).isEqualTo(0);
        assertThat(hashtable.get("foo")).isNull();
    }

    @Test
    void should_put_element_without_collision() {
        // Given
        HashTable<Person> hashtable = new HashTable<>(4, logger);

        // When
        hashtable.put("id1", new Person("User1", "Name1"));
        hashtable.put("id2", new Person("User2", "Name2"));
        hashtable.put("id3", new Person("User3", "Name3"));
        hashtable.put("id4", new Person("User4", "Name4"));

        // Then
        assertThat(hashtable.count()).isEqualTo(4);
        assertThat(hashtable.get("id1").getLastName()).isEqualTo("Name1");
        assertThat(hashtable.get("id2").getLastName()).isEqualTo("Name2");
        assertThat(hashtable.get("id3").getLastName()).isEqualTo("Name3");
        assertThat(hashtable.get("id4").getLastName()).isEqualTo("Name4");
        verify(logger).debug("Creating hashtable with size: {}", 4);
        verifyNoMoreInteractions(logger);
    }

    @Test
    void should_put_element_with_collision() {
        // Given
        HashTable<Person> hashtable = new HashTable<>(2, logger);

        // When
        hashtable.put("id1", new Person("User1", "Name1"));
        hashtable.put("id2", new Person("User2", "Name2"));
        hashtable.put("id3", new Person("User3", "Name3"));

        // Then
        assertThat(hashtable.count()).isEqualTo(3);
        assertThat(hashtable.get("id1").getLastName()).isEqualTo("Name1");
        assertThat(hashtable.get("id2").getLastName()).isEqualTo("Name2");
        assertThat(hashtable.get("id3").getLastName()).isEqualTo("Name3");
        verify(logger, times(0)).debug("Collision when putting key: {}", "id1");
        verify(logger, times(0)).debug("Collision when putting key: {}", "id2");
        verify(logger, times(1)).debug("Collision when putting key: {}", "id3");
        verify(logger, times(1)).debug("Collision when getting key: {}", "id3");
    }

    private static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }
    }
}