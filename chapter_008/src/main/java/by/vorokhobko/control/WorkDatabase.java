package by.vorokhobko.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * WorkDatabase.
 *
 * Class WorkDatabase control question part 008, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.12.2017.
 * @version 1.
 */
public class WorkDatabase {
    /**
     * The class field.
     */
    private static final String URL = "jdbc:postgresql://localhost:5432";
    /**
     * The class field.
     */
    private static final String USERNAME = "postgres";
    /**
     * The class field.
     */
    private static final String PASSWORD = "1";
    /**
     * The class field.
     */
    private static final String DRIVER_NAME = "org.postgresql.Driver";
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(WorkDatabase.class);
    /**
     * The class field.
     */
    private Connection connection;
    /**
     * The method create connection with database.
     */
    public void createConnection() {
        try {
            Class.forName(DRIVER_NAME);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            this.connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method create database.
     */
    public void createTable() {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute("CREATE TABLE if NOT EXISTS javaWork(id INTEGER PRIMARY KEY, "
                    + "vacancy VARCHAR(100),"
                    + "description VARCHAR(100),"
                    + "creates VARCHAR(100));");
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method adds a cell to database.
     * @param vacancy - vacancy.
     * @param description - description.
     * @param creates - creates.
     */
    public void add(String vacancy, String description, String creates) {
        String sqlQuestion = "INSERT INTO javaWork(vacancy, description, creates) VALUES (?, ?, ?);";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, vacancy);
            statement.setString(2, description);
            statement.setString(3, creates);
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method deletes duplicate.
     */
    public void removeDuplicateElements() {
        String sqlQuestion = "DELETE FROM javaWork WHERE ctid NOT IN (SELECT max(ctid) FROM javaWork GROUP BY vacancy);";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method searches all cells.
     * @return tag.
     */
    public List<Target> findAll() {
        List<Target> list = new ArrayList<>();
        String sqlQuestion = "SELECT * FROM javaWork;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Target result = new Target(rs.getString("vacancy"), rs.getString("description"), rs.getString("creates"));
                result.setId(rs.getInt("id"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * The method close connection with database.
     */
    public void closeConnection() {
        try {
            this.connection.close();
            this.connection = null;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}