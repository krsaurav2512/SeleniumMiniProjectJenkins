package com.epam.practice.collection;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kumar_Saurav on 8/29/2017.
 */
public class StringTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];
        System.out.println(intArray.length);
        System.out.println("Enter int values to add in array");
        for (int i = 0; i < intArray.length; i++) {

            intArray[i] = scanner.nextInt();

        }
        System.out.println(Arrays.toString(intArray));
        System.out.println("Enter int value which is to be divided");
        int divisionByValue = scanner.nextInt();
        int remainder = 0;
        int count = 0;
        for (int j = 0; j < intArray.length; j++) {
            for (int k = j + 1; k < intArray.length; k++) {
                int addResult = intArray[j] + intArray[k];
                if (addResult % divisionByValue == remainder) {
                    System.out.println(intArray[j] + "," + intArray[k]);
                    count++;
                }
            }
        }
        System.out.println("Number of pair " + count);


    }
}
