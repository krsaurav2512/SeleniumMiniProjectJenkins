package com.epam.practice.collection;

/**
 * Below class is to throw custom exception by extending Exception class
 */
public class MarksIsLessThanZeroException extends Exception {
    /**
     * below constructor is to call Exception class constructor and return custom Exeption
     * @param message - input custom message
     */
    public MarksIsLessThanZeroException(String message) {
        super(message);

    }
}
