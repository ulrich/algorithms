package net.reservoircode.strings;

import java.util.stream.Collectors;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that
 * is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 */
public class Palindrome {

    public String find(String url, Integer length) {
        return url.chars()
                .limit(length)
                .mapToObj(i -> (i == ' ') ? "%20" : Character.toString((char) i)) //
                .collect(Collectors.joining(""));
    }
}