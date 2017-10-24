package by.vorokhobko.controlq;

/**
 * Account.
 *
 * Class Account for control questions 005_Lite, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 09.06.2017.
 * @version 1.
 */
public class Account {
    /**
     * The class field.
     */
    private double value;
    /**
     * The class field.
     */
    private int requisites;
    /**
     * Add constructor.
     * @param value - value.
     * @param requisites - requisites.
     */
    public Account(int requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }
    /**
     * Add getter value.
     * @return tag.
     */
    public double getValue() {
        return value;
    }
    /**
     * Add setter value.
     * @param value - value.
     */
    public void setValue(double value) {
        this.value = value;
    }
    /**
     * Add getter requisites.
     * @return tag.
     */
    public int getRequisites() {
        return requisites;
    }
}