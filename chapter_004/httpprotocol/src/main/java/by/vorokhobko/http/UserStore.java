package by.vorokhobko.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * UserStore.
 *
 * Class UserStore is the inner part of the work with the database part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.01.2018.
 * @version 1.
 */
public enum UserStore {
    /**
     * The class field.
     */
    INSTANCE;
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
    private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);
    /**
     * The class field.
     */
    private Connection connection;
    /**
     * The class field.
     */
    private static final Random RN = new Random();
    /**
     * The method the method generates random Id.
     * @return tag.
     */
    public int generateId() {
        return RN.nextInt(100000);
    }
    /**
     * Add constructor.
     */
    UserStore() {
    }
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
            statement.execute("CREATE TABLE if NOT EXISTS userWork("
                    + "id INT,"
                    + "nameUser VARCHAR(100),"
                    + "loginUser VARCHAR(100),"
                    + "emailUser VARCHAR(100),"
                    + "createDate TIMESTAMP)");
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method adds a user to database.
     * @param user - user.
     */
    public void addUser(User user) {
        String sqlQuestion = "INSERT INTO userWork(id, nameUser, loginUser, emailUser, createDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setInt(1, generateId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getEmail());
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method updates a user to database.
     * @param user - user.
     */
    public void updateUser(User user) {
        String sqlQuestion = "UPDATE userWork SET nameUser = ?, loginUser = ?, emailUser = ?, createDate = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
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
    public void removeUser(int id) {
        String sqlQuestion = "DELETE FROM userWork WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method searches all users.
     * @return tag.
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sqlQuestion = "SELECT * FROM userWork";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User result = new User(
                        rs.getString("nameUser"),
                        rs.getString("loginUser"),
                        rs.getString("emailUser"),
                        rs.getTimestamp("createDate")
                );
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