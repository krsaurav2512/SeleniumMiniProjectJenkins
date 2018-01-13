package com.epam.practice.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kumar_Saurav on 9/5/2017.
 */
public class FindOccuranceOfAChar {
    public static void getOccuranceOfCharInStr(String str)
    {
        char[] chars = str.toCharArray();
        Map<Character,Integer> mapObj = new HashMap<Character, Integer>();
        for (Character chArray : chars) {
            if (mapObj.containsKey(chArray)) {
                mapObj.put(chArray, mapObj.get(chArray) + 1);
            } else {
                mapObj.put(chArray, 1);
            }
        }
            Set<Character> keys = mapObj.keySet();
            for (Character character : keys)
            {
                if (mapObj.get(character) >= 1){
                    System.out.println(character + "---" + mapObj.get(character));
                }
            }
        }

    public static void main(String[] args)
    {
        getOccuranceOfCharInStr("abbbbac");
    }

}
