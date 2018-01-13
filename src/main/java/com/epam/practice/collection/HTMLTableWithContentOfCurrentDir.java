package com.epam.practice.collection;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;


/**
 * this class is to create a HTML table with content of current directory
 */
public class HTMLTableWithContentOfCurrentDir {
    private static Logger logger = LogManager.getLogger(HTMLTableWithContentOfCurrentDir.class);
    private static final String DIRECTORY_PATH = "D:\\JAVATraing\\src\\main\\java\\com\\epam\\practice\\collection\\KumarSaurav";
    private static final String TABLE_HEADER = "<tr><td><b>Name</b></td><td><b>Type</b></td><td><b>Creation Date</b></td><td><b>Size(in KB)</b></td></tr>";
    private static final String FILE_TYPE = "FILE";
    private static final String DIR_TYPE = "DIR";
    private static final String FILE_NAME = "testfile.html";
    private static long fileSize;
    private static String fileType;
    private static String fileName;
    private static String date;

    /**
     * below mwthod will create HTML file at project level and write into it
     * @param fileContent - content of the HTML file
     * @param fileName    - name of the file
     * @throws IOException - checked InputOutput exception
     */
    private static void writeToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator + fileName;
        File file = new File(tempFile);
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + "backup_" + fileName + "_" + System.currentTimeMillis());
                file.renameTo(newFileName);
                file.createNewFile();
                logger.info("HTML file has created at project location");
            } catch (FileNotFoundException fileNotFoundExec) {
                logger.error("Errror message :", fileNotFoundExec);
            }
        }
        Writer writer = null;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file.getAbsoluteFile());
            writer = new OutputStreamWriter(outputStream);
            writer.write(fileContent);
        } catch (IOException exec) {
            logger.error("Errror message :", exec);
        } finally {
            writer.close();
            outputStream.close();
        }
    }

    /**
     * below method will calculate the size of directory or file
     * @param dirctory - input file or directory
     * @return - return the size of file or directory
     */
    private static long getFileOrFolderSize(File dirctory) {
        fileSize = 0;
        for (File dir : dirctory.listFiles()) {
            if (dir.isFile()) {
                fileSize += dir.length();
            } else {
                fileSize += getFileOrFolderSize(dir);
            }
        }
        return fileSize;
    }

    /**
     * below method will get the file or directory details
     * @param file - file input
     */

    private static void getDirOrFileDetails(File file) {
        fileName = file.getName();
        long fileCreatedDate = file.lastModified();
        date = new SimpleDateFormat("dd.MM.yyyy").format(fileCreatedDate);
        if (DIR_TYPE.equals(fileType)) {
            fileSize = getFileOrFolderSize(file);
        } else {
            fileSize = file.length();
        }
    }

    /**
     * below method will create HTML table and insert the content of current file or directory
     */

    private static void createHTMLTableWithCurrentFileOrDirContent() {

        StringBuilder htmlStringBuilder = new StringBuilder();
        htmlStringBuilder.append("<html><head><title>Selenium Test </title></head>");
        htmlStringBuilder.append("<body>");
        htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\" id=\"myTable\">");
        htmlStringBuilder.append(TABLE_HEADER);
        File file = new File(DIRECTORY_PATH);
        File[] listOfFileOrDir = file.listFiles();
        logger.info("This folder has " + listOfFileOrDir.length + " DirOrFile ");
        for (File items : listOfFileOrDir) {
            if (items.isFile()) {
                fileType = FILE_TYPE;

            } else if (items.isDirectory()) {
                fileType = DIR_TYPE;
            }
            getDirOrFileDetails(items);
            htmlStringBuilder.append("<tr><td>" + fileName + "</td><td>" + fileType + "</td><td>" + date + "</td><td>" + fileSize + "</td></tr>");
        }
        /**
         * below code is to close html file after writing
         */
        htmlStringBuilder.append("</table></body></html>");
        try {
            writeToFile(htmlStringBuilder.toString(), FILE_NAME);
            logger.info("HTML file has appended with content of current directory");
        } catch (IOException execption) {
            logger.error("Errror message :", execption);
        }
    }

    public static void main(String[] args) {

        createHTMLTableWithCurrentFileOrDirContent();
    }
}