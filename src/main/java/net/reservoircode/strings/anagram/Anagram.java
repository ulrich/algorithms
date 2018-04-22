package net.reservoircode.strings.anagram;

import java.util.stream.Collectors;

public class Anagram {

    public boolean find(String a, String b) {
        return toHash(a).equals(toHash(b));
    }

    private String toHash(String s) {
        return s.chars().sorted() //
                .mapToObj(c -> "" + c) //
                .collect(Collectors.joining(""));
    }
}
