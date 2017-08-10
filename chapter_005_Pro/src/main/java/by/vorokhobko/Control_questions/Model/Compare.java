package by.vorokhobko.Control_questions.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Compare.
 *
 * Class Compare for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class Compare {
    /**
     * The class field.
     */
    private List<Book> listBuy = new ArrayList<>();
    /**
     * The class field.
     */
    private List<Book> listSell = new ArrayList<>();
    /**
     * The method compare element for book.
     * @param buyBook - buyBook.
     * @param sellBook - sellBook.
     */
    public void compareElementInListForBook(Map<Double, Book> buyBook, Map<Double, Book> sellBook) {
        for (Map.Entry<Double, Book> mapBuy : buyBook.entrySet()) {
            listBuy.add(mapBuy.getValue());
            Collections.sort(listBuy, (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice()));
        }
        for (Map.Entry<Double, Book> mapSell : sellBook.entrySet()) {
            listSell.add(mapSell.getValue());
            listSell.sort((book1, book2) -> {
                int result = 0;
                if (book1.getPrice() > book2.getPrice()) {
                    result = -1;
                }
                if (book1.getPrice() < book2.getPrice()) {
                    result = 1;
                }
                return result;
            });
        }
    }
    /**
     * The method the decrease in the number of orders.
     */
    public void decreaseInTheNumberOfOrders() {
        int i = 0;
        while (i < listBuy.size() && i < listSell.size()) {
            int bookBuy = listBuy.get(i).getVolume();
            int bookSell = listSell.get(i).getVolume();
            if (bookBuy > bookSell) {
                listBuy.get(i).setVolume(bookBuy - bookSell);
                listSell.get(i).setVolume(0);
                if (listSell.get(i).getVolume() == 0) {
                    listSell.remove(i);
                }
            } else if (bookBuy == bookSell) {
                listBuy.get(i).setVolume(bookBuy - bookSell);
                listSell.get(i).setVolume(0);
                if (listSell.get(i).getVolume() == 0) {
                    listSell.remove(i);
                }
            } else {
                i++;
            }
        }
    }
    /**
     * Add getter listBuy.
     * @return tag.
     */
    public List<Book> getListBuy() {
        return listBuy;
    }
    /**
     * Add getter listSell.
     * @return tag.
     */
    public List<Book> getListSell() {
        return listSell;
    }
}
