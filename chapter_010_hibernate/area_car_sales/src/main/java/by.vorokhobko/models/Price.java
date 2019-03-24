package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Price.
 *
 * Class Price create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "price")
public class Price {
    /**
     * The class field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * The class field.
     */
    @Column(name = "price")
    private int price;
    /**
     * Add constructor.
     */
    public Price() {}
    /**
     * Add constructor.
     */
    public Price(int idPrice) {
        this.id = idPrice;
    }
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