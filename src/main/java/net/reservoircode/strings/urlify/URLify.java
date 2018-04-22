package net.reservoircode.strings.urlify;

import java.util.stream.Collectors;

public class URLify {

    public String urlify(String url, Integer length) {
        return url.chars() //
                .limit(length) //
                .mapToObj(i -> (i == ' ') ? "%20" : Character.toString((char) i)) //
                .collect(Collectors.joining(""));
    }
}
