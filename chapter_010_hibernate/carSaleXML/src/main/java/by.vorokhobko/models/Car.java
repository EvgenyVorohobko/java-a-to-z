package by.vorokhobko.models;

/**
 * Car.
 *
 * Class Car create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Car {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private Body body;
    /**
     * The class field.
     */
    private Brand brand;
    /**
     * The class field.
     */
    private Drive drive;
    /**
     * The class field.
     */
    private Engine engineSize;
    /**
     * The class field.
     */
    private Fuel fuel;
    /**
     * The class field.
     */
    private Model model;
    /**
     * The class field.
     */
    private Transmission transmission;
    /**
     * The class field.
     */
    private Year year;
    /**
     * The class field.
     */
    private String color;
    /**
     * The class field.
     */
    private int mileage;
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
     * Add constructor.
     */
    public Car() {}
    /**
     * Add getter.
     * @return tag.
     */
    public Body getBody() {
        return body;
    }
    /**
     * Add setter.
     * @param body - body.
     */
    public void setBody(Body body) {
        this.body = body;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Brand getBrand() {
        return brand;
    }
    /**
     * Add setter.
     * @param brand - brand.
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Drive getDrive() {
        return drive;
    }
    /**
     * Add setter.
     * @param drive - drive.
     */
    public void setDrive(Drive drive) {
        this.drive = drive;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Engine getEngineSize() {
        return engineSize;
    }
    /**
     * Add setter.
     * @param engineSize - engineSize.
     */
    public void setEngineSize(Engine engineSize) {
        this.engineSize = engineSize;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Fuel getFuel() {
        return fuel;
    }
    /**
     * Add setter.
     * @param fuel - fuel.
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Model getModel() {
        return model;
    }
    /**
     * Add setter.
     * @param model - model.
     */
    public void setModel(Model model) {
        this.model = model;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Transmission getTransmission() {
        return transmission;
    }
    /**
     * Add setter.
     * @param transmission - transmission.
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public Year getYear() {
        return year;
    }
    /**
     * Add setter.
     * @param year - year.
     */
    public void setYear(Year year) {
        this.year = year;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getColor() {
        return color;
    }
    /**
     * Add setter.
     * @param color - color.
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public int getMileage() {
        return mileage;
    }
    /**
     * Add setter.
     * @param mileage - mileage.
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}