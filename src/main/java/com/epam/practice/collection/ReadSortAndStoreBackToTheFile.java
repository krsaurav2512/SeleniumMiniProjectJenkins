package com.epam.practice.collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * below class is to read the content of the file,sort it by FN and LN and store back to the file.
 */
public class ReadSortAndStoreBackToTheFile {
    private static Logger logger = LogManager.getLogger(ReadSortAndStoreBackToTheFile.class);
    private static final String TEXT_FILE_PATH = "D:\\JAVATraing\\testfile.txt";
    public static String strLine;

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
     * Method is to read the data from file,sort them and store back to the file
     * @throws FileNotFoundException - checked exception
     */
    private static void readSortAndStoreBackToTheFile() throws FileNotFoundException {
        FileReader in = new FileReader(TEXT_FILE_PATH);
        BufferedReader br = new BufferedReader(in);
        ArrayList<String> rows = new ArrayList<String>();
        try {
            while ((strLine = br.readLine()) != null) {
                rows.add(strLine);
            }
            Collections.sort(rows);
            logger.info("All data of the file is sorted");
            in.close();
            br.close();
            deleteTheExistingFile();
            for (String sortedString : rows) {
                writeToFile(sortedString);
                logger.info(sortedString);
            }
            logger.info("All sorted data is stored back to the file");
        } catch (IOException exe) {
            logger.error("Errror message :" + exe);
        }
    }

    public static void main(String[] args) throws IOException {
        readSortAndStoreBackToTheFile();
    }
}
