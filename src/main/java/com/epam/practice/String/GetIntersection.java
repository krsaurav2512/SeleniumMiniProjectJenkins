package com.epam.practice.String;

/**
 * this class is to get the intersection values from arrays
 */
public class GetIntersection {

    /**
     * get the intersection values from arrays
     * @param arr1 - array 1
     * @param arr2 - array 2
     */
    public static void getIntersectionValue(int[] arr1,int[] arr2){
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                System.out.println("Intersection value is " + arr2[j++]);
                i++;
            }
        }
    }
    public static void main(String[] args){
        int[] arr1 = {1,3,4,6,7};
        int[] arr2 = {1,3,7,43,56,78};
        getIntersectionValue(arr1,arr2);
    }
}
