package by.vorokhobko.Control_questions.SAXParsing;

import by.vorokhobko.Control_questions.Model.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Handler.
 *
 * Class Handler for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class Handler extends DefaultHandler {
    /**
     * The class field.
     */
    private String element = "";
    /**
     * The class field.
     */
    private Map<Integer, Book> map = new HashMap<>();
    /**
     * The class field.
     */
    private long start;

    /**
     * Override method startDocument.
     * @throws SAXException tag.
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing...");
        this.start = System.currentTimeMillis();
    }

    /**
     * Override method startElement.
     * @param namespace - namespace.
     * @param localName - localName.
     * @param qName - qName.
     * @param attr - attr.
     * @throws SAXException tag.
     */
    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) throws SAXException {
        this.element = qName;
        if (this.element.equals("AddOrder")) {
            String book = attr.getValue("book");
            String operation = attr.getValue("operation");
            Double price = Double.parseDouble(attr.getValue("price"));
            Integer volume = Integer.parseInt(attr.getValue("volume"));
            Integer orderId = Integer.parseInt(attr.getValue("orderId"));
            map.put(orderId, new Book(book, operation, price, volume, orderId));
        }
        if (this.element.equals("DeleteOrder")) {
            Integer orderId = Integer.parseInt(attr.getValue("orderId"));
            map.remove(orderId);
        }
    }

    /**
     * Override method endElement.
     * @param namespace - namespace.
     * @param localName - localName.
     * @param qName - qName.
     * @throws SAXException tag.
     */
    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        this.element = "";
    }

    /**
     * Override method endDocument.
     * @throws SAXException tag.
     */
    @Override
    public void endDocument() throws SAXException {
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Finish parsing " + timeWorkCode + " miliSecond");
    }

    /**
     * Add getter map.
     * @return tag.
     */
    public Map<Integer, Book> getMap() {
        return this.map;
    }
}