package by.vorokhobko.Control_questions.Model;

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
    private Book book;
    /**
     * The class field.
     */
    private Map<Integer, Book> orderBook = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> buyBook1 = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> buyBook2 = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> buyBook3 = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> sellBook1 = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> sellBook2 = new TreeMap<>();
    /**
     * The class field.
     */
    private Map<Double, Book> sellBook3 = new TreeMap<>();
    /**
     * The method add element in Map.
     * @param map - map.
     */
    public void addElementsInMap(Map<Integer, Book> map) {
        this.orderBook = map;
        for (Map.Entry<Integer, Book> elements : orderBook.entrySet()) {
            Book book = elements.getValue();
            if (book.getOperation().equals("BUY") && book.getBook().equals("book-1")) {
                Book book1 = this.book;
                buyBook1.put(book.getPrice(), book);
                if (book1 != null) {
                    int volume = book1.getVolume();
                    int finalVolume = buyBook1.get(book.getPrice()).getVolume() + volume;
                    buyBook1.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (book.getOperation().equals("SELL") && book.getBook().equals("book-1")) {
                Book book1 = this.book;
                sellBook1.put(book.getPrice(), book);
                if (book1 != null) {
                    int volume = book1.getVolume();
                    int finalVolume = sellBook1.get(book.getPrice()).getVolume() + volume;
                    sellBook1.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (book.getOperation().equals("BUY") && book.getBook().equals("book-2")) {
                Book book2 = this.book;
                buyBook2.put(book.getPrice(), book);
                if (book2 != null) {
                    int volume = book2.getVolume();
                    int finalVolume = buyBook2.get(book.getPrice()).getVolume() + volume;
                    buyBook2.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (book.getOperation().equals("SELL") && book.getBook().equals("book-2")) {
                Book book2 = this.book;
                sellBook2.put(book.getPrice(), book);
                if (book2 != null) {
                    int volume = book2.getVolume();
                    int finalVolume = sellBook2.get(book.getPrice()).getVolume() + volume;
                    sellBook2.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (book.getOperation().equals("BUY") && book.getBook().equals("book-3")) {
                Book book3 = this.book;
                buyBook3.put(book.getPrice(), book);
                if (book3 != null) {
                    int volume = book3.getVolume();
                    int finalVolume = buyBook3.get(book.getPrice()).getVolume() + volume;
                    buyBook3.get(book.getPrice()).setVolume(finalVolume);
                }
            }
            if (book.getOperation().equals("SELL") && book.getBook().equals("book-3")) {
                Book book3 = this.book;
                sellBook3.put(book.getPrice(), book);
                if (book3 != null) {
                    int volume = book3.getVolume();
                    int finalVolume = sellBook3.get(book.getPrice()).getVolume() + volume;
                    sellBook3.get(book.getPrice()).setVolume(finalVolume);
                }
            }
        }
    }
    /**
     * Add getter buyBook1.
     * @return tag.
     */
    public Map<Double, Book> getBuyBook1() {
        return buyBook1;
    }
    /**
     * Add getter getSellBook1.
     * @return tag.
     */
    public Map<Double, Book> getSellBook1() {
        return sellBook1;
    }
}