package by.vorokhobko.models;

import javax.persistence.*;
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
@Entity
@Table(name = "order")
public class Order {
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
    @Column(name = "createDate")
    private Timestamp createDate;
    /**
     * The class field.
     */
    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;
    /**
     * The class field.
     */
    @Column(name = "description")
    private String description;
    /**
     * The class field.
     */
    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;
    /**
     * The class field.
     */
    @OneToMany(mappedBy = "id")
    private List<Image> imageList;
    /**
     * The class field.
     */
    @ManyToOne
    @JoinColumn(name = "id_owner")
    private Owner owner;
    /**
     * The class field.
     */
    @ManyToOne
    @JoinColumn(name = "id_price")
    private Price price;
    /**
     * The class field.
     */
    @Column(name = "sold")
    private boolean sold;
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