package com.epam.practice.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * below class is to find duplicate char in a string array using different methods
 */
public class FindDuplicate {

    /**
     * below method will check whether String array contains duplicate element or not
     * @param str - String array
     * @return - true means it contains duplicate otherwise false
     * since Set doesn't contain duplicate, size must be less for an array which contains duplicates
     */
    public static boolean checkDuplicateUsingSet(String[] str){
        boolean result;
        List inputList = Arrays.asList(str);
        Set inputSet = new HashSet(inputList);
        if(inputSet.size()< inputList.size()) {
            result = true;
            return result;
        }else {
            result = false;
            return result;
}
    }

    /**
     * below method will check whether String array contains duplicate element or not
     * @param str - String array
     * @return - true means it contains duplicate otherwise false
     * Since Set doesn't allow duplicates add() return false
     * if we try to add duplicates into Set and this property
     */
    public static void checkDuplicateUsingAdd(String[] str) {
        Set tempSet = new HashSet();
        for (int i = 0; i < str.length; i++) {
            if (!tempSet.add(str[i])) {
                System.out.println("String array has duplicate element : " + str[i]);
            }
        }
    }
    public static void main(String[] args){
        String[] str = {"Ram","Rama","Ramu","Ram"};
        boolean findDuplicate = checkDuplicateUsingSet(str);
        System.out.println("Sring array duplicate status : " + findDuplicate);
        checkDuplicateUsingAdd(str);
    }
}

