package net.reservoircode.strings.palindrome;

import java.util.stream.Collectors;

/**
 * Palindrome implementation
 * <p>
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­
 * drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 */
public class Palindrome {

    public String urlify(String url, Integer length) {
        return url.chars() //
                .limit(length) //
                .mapToObj(i -> (i == ' ') ? "%20" : Character.toString((char) i)) //
                .collect(Collectors.joining(""));
    }
}