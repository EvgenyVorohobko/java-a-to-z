package by.vorokhobko.control;

import org.apache.log4j.BasicConfigurator;

/**
 * StartUI.
 *
 * Class StartUI is for starting program for 008, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.12.2017.
 * @version 1.
 */
public class StartUI {
    /**
     * The class field.
     */
    private WorkDatabase db = new WorkDatabase();
    /**
     * The class field.
     */
    private JsoupWork js = new JsoupWork();
    /**
     * The method need for start program.
     */
    public void runWork() {
        BasicConfigurator.configure();
        this.db.createConnection();
        this.db.createTable();
        this.js.addDatabaseElements(db);
        this.db.removeDuplicateElements();
        System.out.println(this.db.findAll());
        this.db.closeConnection();
    }
    /**
     * The method need for start program.
     */
    public static void main(String[] args) {
        new StartUI().runWork();
    }
}