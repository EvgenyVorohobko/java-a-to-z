package by.vorokhobko.Control_questions.Start;

import by.vorokhobko.Control_questions.Model.Book;
import by.vorokhobko.Control_questions.Model.BookOrders;
import by.vorokhobko.Control_questions.Model.Compare;
import by.vorokhobko.Control_questions.SAXParsing.SAXPars;
import java.io.File;

/**
 * StartUI.
 *
 * Class StartUI for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class StartUI {
    /**
     * The class field.
     */
    private StringBuilder strBuilder = new StringBuilder();
    /**
     * The class field.
     */
    private SAXPars parser = new SAXPars();
    /**
     * The class field.
     */
    private BookOrders orders = new BookOrders();
    /**
     * The class field.
     */
    private Compare compare = new Compare();
    /**
     * The method run application for parsing XML document.
     * @param file - file.
     */
    public void runApplicationForFirstBook(File file) {
        this.parser.parsingXMLDocument(file);
        this.orders.addElementsInMap(parser.getOrderBook());
        this.compare.compareElementInListForBook(orders.getBuyBook(), orders.getSellBook());
        this.compare.decreaseInTheNumberOfOrders();
    }
    /**
     * The method output element for price and volume.
     */
    public void whenOutputElementForPriceAndVolume() {
        strBuilder.append("   BID   ").append("        ").append("ASK").append("\r\n");
        for (int i = 0; i < this.compare.getListSell().size(); i++) {
            Book buy = this.compare.getListBuy().get(i);
            Book sell = this.compare.getListSell().get(i);
            strBuilder.append(buy.getVolume()).append(" @ ").append(buy.getPrice()).append("  -  ");
            strBuilder.append(sell.getVolume()).append(" @ ").append(sell.getPrice()).append("\r\n");
        }
        System.out.println(strBuilder);
    }
}