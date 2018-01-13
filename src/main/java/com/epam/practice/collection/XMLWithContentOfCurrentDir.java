package com.epam.practice.collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * below class is to create XML file with content of current dir of file.
 */

public class XMLWithContentOfCurrentDir {
    private static Logger logger = LogManager.getLogger(XMLWithContentOfCurrentDir.class);
    private static final String DIRECTORY_PATH = "D:\\JAVATraing\\src\\main\\java\\com\\epam\\practice\\collection\\KumarSaurav";
    private static final String XML_FILE_PATH = "D:\\JAVATraing\\testfile.xml";
    private static final String FILE_TYPE = "FILE";
    private static final String DIR_TYPE = "DIR";
    private static String date;
    private static String fileName;
    private static long fileSize;
    private static String fileType;
    private static String fileCreatedDate;
    static Document doc;
    static Element rootElement;

    /**
     * Method for creating Nodes in XML file
     */
    public static void createNode() {
        Element fileTag = doc.createElement(fileType);
        rootElement.appendChild(fileTag);
        Attr attributerOne = doc.createAttribute("fileName");
        attributerOne.setNodeValue(fileName);
        fileTag.setAttributeNode(attributerOne);
        Attr attributerTwo = doc.createAttribute("fileType");
        attributerTwo.setNodeValue(fileType);
        fileTag.setAttributeNode(attributerTwo);
        Attr attributethree = doc.createAttribute("fileCreatedDate");
        attributethree.setNodeValue(fileCreatedDate);
        fileTag.setAttributeNode(attributethree);
        Attr attributeFour = doc.createAttribute("fileSize");
        attributeFour.setNodeValue(String.valueOf(fileSize));
        fileTag.setAttributeNode(attributeFour);

    }

    /**
     * Method for Writting into XML File
     * @throws TransformerException - checked exeception
     */
    public static void writeIntoXmlFile() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(XML_FILE_PATH));
        transformer.transform(source, result);
    }

    /**
     * Method to create XML file with content of current directory or file
     * @param directoryName - input file or directory path
     * @throws TransformerException - checked exception
     */
    public static void creatingXMLDirectory(String directoryName) throws TransformerException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            File file = new File(DIRECTORY_PATH);
            File[] listOfFileOrDir = file.listFiles();
            logger.info("This folder has " + listOfFileOrDir.length + " DirOrFile ");
            rootElement = doc.createElement("data");
            doc.appendChild(rootElement);
            for (File Items : listOfFileOrDir) {
                if (Items.isFile()) {
                    fileType = FILE_TYPE;
                    fileName = Items.getName();
                    long createdDate = Items.lastModified();
                    fileCreatedDate = new SimpleDateFormat("dd.MM.yyyy").format(createdDate);
                    fileSize = Items.length();

                    createNode();
                } else if (Items.isDirectory()) {
                    fileName = Items.getName();
                    fileType = DIR_TYPE;
                    long createdDate = Items.lastModified();
                    fileCreatedDate = new SimpleDateFormat("dd.MM.yyyy").format(createdDate);
                    fileSize = Items.length();
                    createNode();
                }
                writeIntoXmlFile();
            }
        } catch (ParserConfigurationException e) {
            logger.error("Errror message :" + e);
        }
    }

    public static void main(String[] args) throws IOException, TransformerException {
        creatingXMLDirectory(DIRECTORY_PATH);
    }
}
