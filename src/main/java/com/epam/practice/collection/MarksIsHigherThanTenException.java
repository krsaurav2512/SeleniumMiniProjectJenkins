package com.epam.practice.collection;

/**
 * Below class is to throw custom exception by extending Exception class
 */
public class MarksIsHigherThanTenException extends Exception {
    /**
     * below constructor is to call Exception class constructor and return custom Exeption
     * @param strMessage - input custom message
     */
    public MarksIsHigherThanTenException(String strMessage) {
        super(strMessage);
    }
}
