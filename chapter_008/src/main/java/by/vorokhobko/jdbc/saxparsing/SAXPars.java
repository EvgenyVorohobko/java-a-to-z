package by.vorokhobko.jdbc.saxparsing;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * SaxHandler.
 *
 * Class SaxHandler for parser documents for 004, lesson 8.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.12.2017.
 * @version 1.
 */
public class SAXPars {
    /**
     * The method parse document XML way SAX.
     * @param file - file.
     */
    public long parsingXMLDocument(File file) {
        SAXParserFactory saxParsFact = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxParser = saxParsFact.newSAXParser();
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler.getCount();
    }
}