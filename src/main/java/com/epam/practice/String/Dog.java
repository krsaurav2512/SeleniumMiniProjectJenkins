package com.epam.practice.String;

/**
 * Created by Kumar_Saurav on 9/6/2017.
 */
class Animal {

    public void eat()
    {
        System.out.println("Animal is eating");
    }
}
public class Dog extends Animal{

    public void eat()
    {
        System.out.println("Dog is eating");
    }

    public static void main(String[] args)
    {
        Animal animal = new Dog();
        animal.eat();
    }
}
