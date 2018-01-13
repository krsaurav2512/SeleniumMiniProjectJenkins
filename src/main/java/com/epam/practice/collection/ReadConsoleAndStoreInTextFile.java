package com.epam.practice.collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

/**
 * Read the data from console line by line and save it to the file.
 */

public class ReadConsoleAndStoreInTextFile {

    private static Logger logger = LogManager.getLogger(ReadConsoleAndStoreInTextFile.class);
    private static final String TEXT_FILE_PATH = "D:\\JAVATraing\\testfile.txt";
    private static final int MARK_MIN = 0;
    private static final int MARK_MAX = 10;
    private static final int MARK_INDEX = 2;
    private static final int FN_INDEX = 0;
    private static final int LN_INDEX = 1;

    /**
     * Method to check whether entered input is integer or not.
     * @param str - mark value
     * @return - true - if input is integer,otherewise false
     */
    private static boolean isInteger(String str) {
        boolean isInteger = true;
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException numberFormateException) {
            isInteger = false;
            logger.error("Could not parse string value = " + str, numberFormateException.getMessage());
        }
        return isInteger;
    }

    /**
     * Method to validate the student mark against minimum and maximum mark value.
     * @param studentMark - mark value
     */
    private static void validateMark(int studentMark) {
        try {
            if (studentMark < MARK_MIN) {
                throw new MarksIsLessThanZeroException("Marks is less than zero");
            }
        } catch (MarksIsLessThanZeroException marksLessThanZero) {
            logger.error("Errror occured :" + marksLessThanZero.getMessage());
        }
        try {
            if (studentMark > MARK_MAX) {
                throw new MarksIsHigherThanTenException("Marks is higher than 10");
            }
        } catch (MarksIsHigherThanTenException marksIsHigherThanTen) {
            logger.error("Errror occured :" + marksIsHigherThanTen.getMessage());
        }
    }

    /**
     * Method to delete the existing file if it is present at project location.
     */
    private static void deleteTheExistingFile() {
        File file = new File(TEXT_FILE_PATH);
        if (file.exists()) {
            boolean isDeleted = file.delete();
            logger.info("File IsDeleted :" + isDeleted);
        }
    }

    /**
     * Method to create the text file and write the data line by line.
     * @param fileContent - content of the file
     */
    private static void writeToFile(String fileContent) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(TEXT_FILE_PATH), true));
            bufferedWriter.write(fileContent);
            bufferedWriter.newLine();
        } catch (IOException exception) {
            logger.error("Exception occured while creating new file " + exception.getMessage());
        } finally {
            if (bufferedWriter != null)
                try {
                    bufferedWriter.close();
                } catch (IOException ioe) {
                    logger.error("Exception occured while closing bufferedWriter " + ioe.getMessage());
                }
        }
    }

    /**
     * Method to read line by line data from console and then write the same into the file.
     */
    private static void readConsoleInputAndWriteToFile() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter First Name,Last Name and Marks of the student seperated by spaces, or 'quit' to quit: ");
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("quit")) {
            String[] lineItem = line.split(" ");
            logger.info("Lenght of the array : " + lineItem.length);
            String markValue = lineItem[MARK_INDEX];
            if (isInteger(markValue)) {
                validateMark(Integer.valueOf(markValue));
                String fileContent = String.format("FirstName : %s ,LastName  : %s ,Marks : %d ", lineItem[FN_INDEX], lineItem[LN_INDEX], Integer.valueOf(markValue));
                writeToFile(fileContent);
            } else {
                logger.error("Entered mark value is not an integer number");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        ReadConsoleAndStoreInTextFile readConsoleAndStoreInTextFile = new ReadConsoleAndStoreInTextFile();
        Class className = ReadConsoleAndStoreInTextFile.class;
        logger.info("Class Name is : " + className.toString());
        logger.info(className + "@" + Integer.toHexString(readConsoleAndStoreInTextFile.hashCode()));
        deleteTheExistingFile();
        readConsoleInputAndWriteToFile();
    }
}