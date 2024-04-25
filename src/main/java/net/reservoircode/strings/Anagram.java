package net.reservoircode.strings;

import java.util.stream.Collectors;

/**
 * This is a simple implementation of anagram searcher. Given two strings, write a method to decide if one is a permutation
 * of the other.
 */
public class Anagram {

    public boolean find(String a, String b) {
        return toHash(a).equals(toHash(b));
    }

    private String toHash(String s) {
        return s.chars().sorted()
                .mapToObj(c -> "" + c)
                .collect(Collectors.joining(""));
    }
}
