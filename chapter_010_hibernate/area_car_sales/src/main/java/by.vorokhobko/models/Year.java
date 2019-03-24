package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Year.
 *
 * Class Year create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "year")
public class Year {
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
    @Column(name = "releaseYear")
    private int releaseYear;
    /**
     * Add constructor.
     */
    public Year() {}
    /**
     * Add constructor.
     */
    public Year(int id) {
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
     * Add getter getReleaseYear.
     * @return tag.
     */
    public int getReleaseYear() {
        return releaseYear;
    }
    /**
     * Add setter setReleaseYear.
     * @param releaseYear - releaseYear.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}