package by.vorokhobko.models;

/**
 * Brand.
 *
 * Class Brand create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Brand {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String brandCar;
    /**
     * Add constructor.
     */
    public Brand() {}
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