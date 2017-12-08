package by.vorokhobko.jdbc;

import by.vorokhobko.jdbc.saxparsing.SAXPars;

import java.io.File;

/**
 * StartUI.
 *
 * Class StartUI is for starting program for 004, lesson 8.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.12.2017.
 * @version 1.
 */
public class StartUI {
    /**
     * The class field.
     */
    private static final String URL = "jdbc:sqlite:d:/WORK/SQLlite/TEST/test.db";
    /**
     * The class field.
     */
    private static final String XML_FILE_FIRST = "d:/WORK/SQLlite/TEST/1.xml";
    /**
     * The class field.
     */
    private static final String XML_FILE_SECOND = "d:/WORK/SQLlite/TEST/2.xml";
    /**
     * The class field.
     */
    private WorkSQL workSQL = new WorkSQL();
    /**
     * The class field.
     */
    private SAXPars pars = new SAXPars();
    /**
     * The class field.
     */
    private static final int ELEMENT = 1000000;
    /**
     * The class field.
     */
    private TransformXMLDocument trans = new TransformXMLDocument();
    /**
     * The method main.
     * @param args - args.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new StartUI().runWork();
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Time work " + timeWorkCode);
    }
    /**
     * The method need for start program.
     */
    public void runWork() {
        this.workSQL.createConnection(URL);
        this.workSQL.createTable();
        this.workSQL.addElement(ELEMENT);
        this.workSQL.createDocumentXML();
        this.workSQL.closeConnection();
        this.trans.updateXML(XML_FILE_FIRST, XML_FILE_SECOND);
        long result = pars.parsingXMLDocument(new File(XML_FILE_SECOND));
        System.out.println("Sum all element " + result);
    }
}