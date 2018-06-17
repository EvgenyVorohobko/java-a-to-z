package by.vorokhobko.servletwithuser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * UserStore.
 *
 * Class UserStore is the inner part of the work with the database part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2018.
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
     *
    private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);
    /**
     * The class field.
     */
    private static final Random RN = new Random();
    /**
     * The class field.
     */
    private Connection connection;
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
            e.printStackTrace();
        }
    }
    /**
     * The method create database.
     */
    public void createTable() {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute("CREATE TABLE if NOT EXISTS userWork("
                    + "id INTEGER,"
                    + "nameUser VARCHAR(100),"
                    + "loginUser VARCHAR(100),"
                    + "emailUser VARCHAR(100),"
                    + "createDate TIMESTAMP,"
                    + "password VARCHAR(100),"
                    + "role VARCHAR(100),"
                    + "country VARCHAR(100),"
                    + "town VARCHAR(100))");
            this.connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method adds a user to database.
     * @param user - user.
     */
    public void addUser(User user) {
        String sqlQuestion = "INSERT INTO userWork(id, nameUser, loginUser, "
                + "emailUser, createDate, password, role, country, town) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setInt(1, generateId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getEmail());
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getRole());
            statement.setString(8, user.getCountry());
            statement.setString(9, user.getTown());
            statement.executeUpdate();
            this.connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method updates a user to database.
     * @param user - user.
     */
    public void updateUser(int id, User user) {
        String sqlQuestion = "UPDATE userWork SET nameUser = ?, loginUser = ?,"
                + "emailUser = ?, createDate = ?, password = ?, role = ?, country = ?,"
                + "town = ? WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getRole());
            statement.setString(7, user.getCountry());
            statement.setString(8, user.getTown());
            statement.setInt(9, id);
            statement.executeUpdate();
            this.connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method deletes duplicate.
     */
    public void removeUser(String id) {
        String sqlQuestion = "DELETE FROM userWork WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setInt(1, Integer.parseInt(id));
            statement.executeUpdate();
            this.connection.commit();
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
                        rs.getTimestamp("createDate"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("town")
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
     * The method search a user in database by id.
     * @param id - id.
     * @return tag.
     */
    public User searchUser(String id) {
        String sqlQuestion = "SELECT * FROM userWork WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("nameUser"),
                        rs.getString("loginUser"),
                        rs.getString("emailUser"),
                        rs.getTimestamp("createDate"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("town")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException("This user haven't in my database");
    }
    /**
     * The method close connection with database.
     */
    public void closeConnection() {
        try {
            this.connection.close();
            this.connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * The method updates a user to database.
     * @param login - login.
     * @param password - password.
     * @return tag.
     */
    public User searchElementInDatabase(String login, String password) {
        User result = null;
        for (User user : this.findAll()) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                result = user;
            } else {
                throw new NoSuchElementException("This element haven't in database");
            }
        }
        return result;
    }
}