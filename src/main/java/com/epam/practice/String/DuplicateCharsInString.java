package com.epam.practice.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharsInString {

    public void findDuplicateChars(String str) {

        Map<Character, Integer> mapObj = new HashMap<Character, Integer>();
        char[] chrs = str.toCharArray();
        for (Character chArray : chrs) {
            if (mapObj.containsKey(chArray)) {
                mapObj.put(chArray, mapObj.get(chArray) + 1);
            } else {
                mapObj.put(chArray, 1);
            }
        }

        Set<Character> keys = mapObj.keySet();
        for (Character ch : keys) {
            if (mapObj.get(ch) >= 1) {
                System.out.println(ch + "-->" + mapObj.get(ch));
            }
        }
    }

    public static void main(String a[]) {
        DuplicateCharsInString dcs = new DuplicateCharsInString();
        dcs.findDuplicateChars("aabbbccd");
    }
}