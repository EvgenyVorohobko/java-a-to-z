package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Brand.
 *
 * Class Brand create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "brand")
public class Brand {
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
    @Column(name = "brandCar")
    private String brandCar;
    /**
     * Add constructor.
     */
    public Brand() {}
    /**
     * Add constructor.
     */
    public Brand(int id) {
        this.id = id;
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
     * Add getter getBrandCar.
     * @return tag.
     */
    public String getBrandCar() {
        return brandCar;
    }
    /**
     * Add setter setBrandCar.
     * @param brandCar - brandCar.
     */
    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }
}