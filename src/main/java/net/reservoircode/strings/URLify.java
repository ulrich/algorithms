package net.reservoircode.strings;

import java.util.stream.Collectors;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the
 * end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in
 * Java, please use a character array so that you can perform this operation in place).
 */
public class URLify {

    public String urlify(String url, Integer length) {
        return url.chars()
                .limit(length)
                .mapToObj(i -> (i == ' ') ? "%20" : Character.toString((char) i))
                .collect(Collectors.joining(""));
    }
}
