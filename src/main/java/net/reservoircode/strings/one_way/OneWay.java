package net.reservoircode.strings.one_way;

public class OneWay {

    public Boolean check(String s1, String s2) {
        // in ascii encoding do the sum (char to int) all chars for s1 and s2
        // to lower case s1 and s2
        // if the sum between 'a' and 'z' there is not more one edit

        Integer sumOfS1 = s1.toLowerCase().chars().sum();
        Integer sumOfS2 = s2.toLowerCase().chars().sum();

        Integer delta = Math.abs(sumOfS1 - sumOfS2);

        return (delta - (int) 'a') <= 26;
    }
}
