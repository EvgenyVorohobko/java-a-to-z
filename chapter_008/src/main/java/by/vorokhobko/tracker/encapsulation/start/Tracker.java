package by.vorokhobko.tracker.encapsulation.start;

import by.vorokhobko.tracker.encapsulation.models.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracker.
 *
 * Class Tracker is the inner part of the work with the database part 008, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 08.12.2017.
 * @version 1.
 */
public class Tracker {
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Tracker.class);
    /**
     * The class field.
     */
    private Connection connection;
    /**
     * The class field.
     */
    private static final String DRIVER_NAME = "org.sqlite.JDBC";
    /**
     * The method create connection with database.
     * @param url - url.
     */
    public void createConnection(String url) {
        try {
            Class.forName(DRIVER_NAME);
            this.connection = DriverManager.getConnection(url);
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
            statement.execute("CREATE TABLE if NOT EXISTS items (id INTEGER PRIMARY KEY, "
                        + "name_author VARCHAR(100),"
                        + "description VARCHAR(100),"
                        + "creates DATA TIMESTAMP);");
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
	/**
	* The method adds a cell to database.
	* @param item - item.
	*/
	public void add(Item item) {
        String sqlQuestion = "INSERT INTO items(name_author, description, creates) VALUES (?, ?, ?);";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, item.getAuthor());
            statement.setString(2, item.getDescription());
            statement.setTimestamp(3, new Timestamp(item.getCreates()));
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	/**
	* The method finds similar cells in the Id.
	* @param id - id.
	* @return tag.
	*/
	public Item findById(int id) {
		Item result = null;
        String sqlQuestion = "SELECT * FROM items WHERE id = ?;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getString("name_author"), rs.getString("description"), rs.getTimestamp("creates").getTime());
                result.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	/**
	* The method searches all cells.
	* @return tag.
	*/
	public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        String sqlQuestion = "SELECT * FROM items;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Item result = new Item(rs.getString("name_author"), rs.getString("description"), rs.getTimestamp("creates").getTime());
                result.setId(rs.getInt("id"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}
	/**
	* The method needs to replace the cell in database.
	* @param item - item.
	*/
	public void update(Item item) {
        String sqlQuestion = "UPDATE items SET name_author = ?, description = ?, creates = ? WHERE id = ?;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, item.getAuthor());
            statement.setString(2, item.getDescription());
            statement.setTimestamp(3, new Timestamp(item.getCreates()));
            statement.setLong(4, item.getId());
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	/**
	* The method should delete the cells in database.
	* @param itemDelete - itemDelete.
	*/
	public void delete(Item itemDelete) {
        String sqlQuestion = "DELETE FROM items WHERE id = ?;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setLong(1, itemDelete.getId());
            statement.executeUpdate();
            this.connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    /**
     * The method looks up the cell name using the key.
     * @return tag.
     */
    public Item findByName(String key) {
        Item result = null;
        String sqlQuestion = "SELECT * FROM items WHERE name_author = ?;";
        try (PreparedStatement statement = this.connection.prepareStatement(sqlQuestion)) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getString("name_author"), rs.getString("description"), rs.getTimestamp("creates").getTime());
                result.setAuthor(rs.getString("name_author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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