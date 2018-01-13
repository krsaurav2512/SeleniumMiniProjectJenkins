package com.epam.practice.String;

/**
 * this class is to describe how dynamic binding works
 */
class Sample1 {

    public void test1() {
        System.out.println("Running test1() method of Sample1 class");
    }
}

public class DynamicBinding extends Sample1 {
    public void test1() {
        System.out.println("Running test1() method of DynamicBinding class");
    }

    public static void main(String[] args) {

        Sample1 obj = (Sample1) new DynamicBinding();
        obj.test1();
        //Sample1 sample1 = new Sample1();
        //sample1.test1();
        DynamicBinding dynamicBinding = new DynamicBinding();
        dynamicBinding.test1();
    }
}
