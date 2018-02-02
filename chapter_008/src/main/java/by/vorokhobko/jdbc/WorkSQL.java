package by.vorokhobko.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

/**
 * WorkSQL.
 *
 * Class WorkSQL work with database in SQLite and xml document for 004, lesson 8.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.12.2017.
 * @version 1.
 */
public class WorkSQL {
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(WorkSQL.class);
    /**
     * The class field.
     */
    private Connection connection;
    /**
     * The class field.
     */
    private static final String DRIVER_NAME = "org.sqlite.JDBC";
    /**
     * The class field.
     */
    private static final String NAMEDOCUMENT = "d:/WORK/SQLlite/TEST/1.xml";
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
        try {
            Statement statement = this.connection.createStatement();
            statement.addBatch("DROP TABLE if EXISTS test");
            statement.addBatch("CREATE TABLE test (field INTEGER NOT NULL);");
            statement.executeBatch();
            this.connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method add element to database.
     * @param element - element.
     */
    public void addElement(int element) {
        String sqlQuestion = "INSERT INTO test (field) VALUES (?)";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sqlQuestion);
            for (int i = 0; i <= element; i++) {
                statement.setInt(1, i);
                statement.addBatch();
            }
            statement.executeBatch();
            this.connection.commit();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
    /**
     * The method create xml document on database.
     */
    public void createDocumentXML() {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(
                    new FileWriter(NAMEDOCUMENT));
            streamWriter.writeStartDocument();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test");
            streamWriter.writeStartElement("entries");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                streamWriter.writeStartElement("entry");
                streamWriter.writeStartElement("field");
                streamWriter.writeCharacters(String.valueOf(resultSet.getInt("field")));
                streamWriter.writeEndElement();
                streamWriter.writeEndElement();
            }
            streamWriter.writeEndElement();
            streamWriter.writeEndDocument();

            streamWriter.flush();
            streamWriter.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
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