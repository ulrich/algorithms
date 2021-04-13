package net.reservoircode.structures.patternmatching;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static net.reservoircode.structures.patternmatching.PatternMatching.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternMatchingTest {

    @Test
    void should_match_for_string() {
        // Given
        var patternMatching =
                when((String s) -> s.contains("world"), s -> "Hello " + s)
                        .orWhen((String s) -> s.contains("monde"), s -> "Bonjour " + s)
                        .orWhen((String s) -> s.contains("mundo"), s -> "Hola " + s);

        // When
        var result = patternMatching.matches("le monde !");

        // Then
        assertTrue(result.isPresent());
        assertEquals("Bonjour le monde !", result.get());
    }

    @Test
    void should_match_for_integer() {
        // Given
        var patternMatching =
                when((Integer i) -> i.equals(1), s -> "I")
                        .orWhen((Integer i) -> i.equals(2), s -> "II")
                        .orWhen((Integer i) -> i.equals(3), s -> "III")
                        .orWhen((Integer i) -> i.equals(4), s -> "IV")
                        .orWhen((Integer i) -> i.equals(5), s -> "V");

        // When
        var result = patternMatching.matches(3);

        // Then
        assertTrue(result.isPresent());
        assertEquals("III", result.get());
    }

    @Test
    void should_match_for_object() {
        // Given
        var persons = List.of(new Person(20, "Dennis", Gender.MALE), new Person(30, "Brian", Gender.MALE), new Person(40, "Anny", Gender.FEMALE));
        var matchingByGender =
                when(Gender.MALE::equals, g -> filterPerson(persons, person -> person.gender.equals(g)))
                        .orWhen(Gender.FEMALE::equals, g -> filterPerson(persons, person -> person.gender.equals(g)));

        // When
        var result = matchingByGender.matches(Gender.MALE);

        // Then
        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
    }

    private static List<Person> filterPerson(List<Person> persons, Predicate<? super Person> p) {
        return persons.stream().filter(p).collect(toList());
    }

    static class Person {
        private final int age;
        private final String name;
        private final Gender gender;

        Person(int age, String name, Gender gender) {
            this.age = age;
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE,
        FEMALE
    }
}