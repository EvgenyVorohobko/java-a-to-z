package by.vorokhobko.models;

/**
 * Price.
 *
 * Class Price create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Price {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private int price;
    /**
     * Add constructor.
     */
    public Price() {}
    /**
     * Add getter getId.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add setter setId.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Add getter getPrice.
     * @return tag.
     */
    public int getPrice() {
        return price;
    }
    /**
     * Add setter setPrice.
     * @param price - price.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}