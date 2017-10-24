package by.vorokhobko.controlq.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * BookOrders.
 *
 * Class BookOrders for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class BookOrders {
    /**
     * The class field.
     */
    private static final String FOR_BUY = "BUY";
    /**
     * The class field.
     */
    private static final String FOR_SELL = "SELL";
    /**
     * The class field.
     */
    private static final String BOOK_FOR_ORDERS_ONE = "book-1";
    /**
     * The class field.
     */
    private Book book;
    /**
     * The class field.
     */
    private Map<Integer, Book> orderBook = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> buyBook = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> sellBook = new TreeMap<>();
    /**
     * The method add element in map.
     * @param map - map.
     */
    public void addElementsInMap(Map<Integer, Book> map) {
        this.orderBook = map;
        for (Map.Entry<Integer, Book> elements : this.orderBook.entrySet()) {
            Book book = elements.getValue();
            if (FOR_BUY.equals(book.getOperation()) && BOOK_FOR_ORDERS_ONE.equals(book.getBook())) {
                Book book1 = this.book;
                this.buyBook.put(book.getPrice(), book);
                if (book1 != null) {
                    int volume = book1.getVolume();
                    int finalVolume = this.buyBook.get(book.getPrice()).getVolume() + volume;
                    this.buyBook.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (FOR_SELL.equals(book.getOperation()) && BOOK_FOR_ORDERS_ONE.equals(book.getBook())) {
                Book book1 = this.book;
                this.sellBook.put(book.getPrice(), book);
                if (book1 != null) {
                    int volume = book1.getVolume();
                    int finalVolume = this.sellBook.get(book.getPrice()).getVolume() + volume;
                    this.sellBook.get(book.getPrice()).setVolume(finalVolume);
                }
            }
        }
    }
    /**
     * Add getter buyBook1.
     * @return tag.
     */
    public Map<Double, Book> getBuyBook() {
        return buyBook;
    }
    /**
     * Add getter getSellBook1.
     * @return tag.
     */
    public Map<Double, Book> getSellBook() {
        return sellBook;
    }
}