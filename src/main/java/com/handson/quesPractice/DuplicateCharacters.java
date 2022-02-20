package com.handson.quesPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DuplicateCharacters {
    public static void main(String[] args) {

        //in place of string it be array also
        String str = "heElloOO";

        //case insensitive
        Map<Character, Integer> charOccurrenceMap = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            if (charOccurrenceMap.containsKey(ch)) charOccurrenceMap.put(ch, charOccurrenceMap.get(ch) + 1);
            else charOccurrenceMap.put(ch, 1);
        }
        System.out.println("DuplicateCharacter map (case insensitive: " + charOccurrenceMap);

        //case sensitive
        Map<String, Integer> charOccurrenceMapCaseInsensitive = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Character ch : str.toCharArray()) {
            String chStr = ch + "";
            if (charOccurrenceMapCaseInsensitive.containsKey(chStr))
                charOccurrenceMapCaseInsensitive.put(chStr, charOccurrenceMapCaseInsensitive.get(chStr) + 1);
            else charOccurrenceMapCaseInsensitive.put(chStr, 1);
        }
        System.out.println("DuplicateCharacter map (case sensitive): " + charOccurrenceMapCaseInsensitive);

    }
}
