package by.vorokhobko.jdbc;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * TransformXMLDocument.
 *
 * Class TransformXMLDocument transform xml document for 004, lesson 8.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.12.2017.
 * @version 1.
 */
public class TransformXMLDocument {
    /**
     * The method transform xml document through xslt.
     * @param xmlFileInput - xmlFileInput.
     * @param xmlFileOutput - xmlFileOutput.
     */
    public void updateXML(String xmlFileInput, String xmlFileOutput) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Source xmlSource = new StreamSource(new FileInputStream(xmlFileInput));
            Source xsltTransformer = new StreamSource(new FileInputStream("chapter_008/src/main/java/by/vorokhobko/jdbc/1.xsl"));
            Result xmlOutput = new StreamResult(new FileOutputStream(xmlFileOutput));

            Transformer transformer = transformerFactory.newTransformer(xsltTransformer);
            transformer.transform(xmlSource, xmlOutput);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}