package by.vorokhobko.models;

/**
 * Drive.
 *
 * Class Drive create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class Drive {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String drive;
    /**
     * Add constructor.
     */
    public Drive() {}
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
     * Add getter getDrive.
     * @return tag.
     */
    public String getDrive() {
        return drive;
    }
    /**
     * Add setter setDrive.
     * @param drive - drive.
     */
    public void setDrive(String drive) {
        this.drive = drive;
    }
}