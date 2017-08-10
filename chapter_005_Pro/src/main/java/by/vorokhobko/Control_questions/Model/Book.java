package by.vorokhobko.Control_questions.Model;

/**
 * Book.
 *
 * Class Book for control questions 005_Pro, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.08.2017.
 * @version 1.
 */
public class Book {
    /**
     * The class field.
     */
    private String book;
    /**
     * The class field.
     */
    private String operation;
    /**
     * The class field.
     */
    private Double price;
    /**
     * The class field.
     */
    private Integer volume;
    /**
     * The class field.
     */
    private Integer orderId;
    /**
     * Add constructor.
     * @param book - book.
     * @param operation - operation.
     * @param price - price.
     * @param volume - volume.
     * @param orderId - orderId.
     */
    public Book(String book, String operation, Double price, Integer volume, Integer orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }
    /**
     * Add getter book.
     * @return tag.
     */
    public String getBook() {
        return book;
    }
    /**
     * Add getter operation.
     * @return tag.
     */
    public String getOperation() {
        return operation;
    }
    /**
     * Add getter price.
     * @return tag.
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Add getter volume.
     * @return tag.
     */
    public Integer getVolume() {
        return volume;
    }
    /**
     * Add setter nextElement.
     * @param volume - volume.
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    /**
     * Override method toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "Book{"
                + "book='" + book + '\''
                + ", operation='" + operation + '\''
                + ", price=" + price
                + ", volume=" + volume
                + ", orderId=" + orderId + '}';
    }
}