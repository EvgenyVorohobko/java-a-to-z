package by.vorokhobko.controlq.SAXParsing;

import by.vorokhobko.controlq.Model.Book;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * SAXPars.
 *
 * Class SAXPars for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class SAXPars {
    /**
     * The class field.
     */
    private Map<Integer, Book> orderBook = new HashMap<>();
    /**
     * The method parse document XML way SAX.
     * @param file - file.
     */
    public void parsingXMLDocument(File file) {
        SAXParserFactory saxParsFact = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxParser = saxParsFact.newSAXParser();
            saxParser.parse(file, handler);
            orderBook = handler.getMap();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Add getter map.
     * @return tag.
     */
    public Map<Integer, Book> getOrderBook() {
        return orderBook;
    }
}