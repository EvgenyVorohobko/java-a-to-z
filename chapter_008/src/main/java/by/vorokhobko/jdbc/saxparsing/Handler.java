package by.vorokhobko.jdbc.saxparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * XMLParser.
 *
 * Class XMLParser for parser documents for 004, lesson 8.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.12.2017.
 * @version 1.
 */
public class Handler extends DefaultHandler {
    /**
     * The class field.
     */
    private long count;
    /**
     * Add getter count.
     * @return tag.
     */
    public long getCount() {
        return count;
    }
    /**
     * The class field.
     */
    private String element = "";
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
        if (this.element.equals("entry")) {
            this.count = count + Integer.valueOf(attr.getValue(0));
        }
    }
}