package net.reservoircode.strings.is_unique;

import java.util.HashSet;
import java.util.Set;

public class IsUniq {

    public boolean one(String string) {
        if (string != null && string.length() < 2) {
            return true;
        }
        Set<Character> stringToSet = new HashSet<Character>();
        char[] fromString = string.toCharArray();

        for (int i = 0; i < fromString.length; i++) {
            stringToSet.add(fromString[i]);
        }
        return stringToSet.size() == string.length();
    }
}
