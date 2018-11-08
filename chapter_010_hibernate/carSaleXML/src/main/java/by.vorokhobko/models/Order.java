package by.vorokhobko.models;

import java.sql.Timestamp;
import java.util.List;

/**
 * Order.
 *
 * Class Order create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Order {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private Timestamp createDate;
    /**
     * The class field.
     */
    private Car car;
    /**
     * The class field.
     */
    private String description;
    /**
     * The class field.
     */
    private Location location;
    /**
     * The class field.
     */
    private List<Image> imageList;
    /**
     * The class field.
     */
    private Owner owner;
    /**
     * The class field.
     */
    private Price price;
    /**
     * The class field.
     */
    private boolean sold;
    /**
     * Add constructor.
     */
    public Order() {}
    /**
     * Add getter.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add setter.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
    /**
     * Add setter.
     * @param createDate - createDate.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Car getCar() {
        return car;
    }
    /**
     * Add setter.
     * @param car - car.
     */
    public void setCar(Car car) {
        this.car = car;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Add setter.
     * @param description - description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Location getLocation() {
        return location;
    }
    /**
     * Add setter.
     * @param location - location.
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public List<Image> getImageList() {
        return imageList;
    }
    /**
     * Add setter.
     * @param imageList - imageList.
     */
    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Owner getOwner() {
        return owner;
    }
    /**
     * Add setter.
     * @param owner - owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public boolean isSold() {
        return sold;
    }
    /**
     * Add setter.
     * @param sold - sold.
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Price getPrice() {
        return price;
    }
    /**
     * Add setter.
     * @param price - price.
     */
    public void setPrice(Price price) {
        this.price = price;
    }
}