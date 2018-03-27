package library.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.datastructure.Book;
import library.datastructure.SearchProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectLibraryDAO implements LibrariesDAO {
    private Connection connection = null;
    private Statement statement = null;


    @Override
    public long insertBook(Book book) {
        String generatedColumns[] = { "ID" };
        ResultSet resultSet;
        long id = -1;

        try {
            this.connect();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO books (title, authors, imageURL, description, yearOfPublication, avaiable )" +
                            "VALUES(?,?,?,?,?,?) ", generatedColumns);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthors());
            preparedStatement.setString(3, book.getUrlToImage());
            preparedStatement.setString(4, book.getDescription());
            preparedStatement.setInt(5, book.getYearOfPublication());
            preparedStatement.setBoolean(6, book.isAvaiable());

            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }

            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return -1L;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            this.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET" +
                    " title = ?, authors = ?, imageURL = ?,description = ?, yearOfPublication = ?, avaiable = ? WHERE Id = ?" );
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthors());
            preparedStatement.setString(3, book.getUrlToImage());
            preparedStatement.setString(4, book.getDescription());
            preparedStatement.setInt(5, book.getYearOfPublication());
            preparedStatement.setBoolean(6, book.isAvaiable());
            preparedStatement.setLong(7, book.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return false;
        }
    }

    @Override
    public boolean deleteBook(Book book) {
        try {
            this.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE Id=?");
            preparedStatement.setLong(1, book.getId());
            preparedStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }


    @Override
    public ObservableList<Book> findBook(SearchProperty searchProperty, String value) {
        ObservableList<Book> allBooks = FXCollections.observableArrayList();
        ResultSet resultSet;
        String whereClause = "";
        String valueClose = "";
        if(searchProperty == SearchProperty.TITLE)
        {
            whereClause = "title LIKE ?";
            valueClose = "%" + value.toString() + "%";
        }
        if (searchProperty == SearchProperty.AUTHOR) {
            whereClause = "authors LIKE ?";
            valueClose = "%" + value.toString() + "%";
        }
        if (searchProperty == SearchProperty.ID) {
            whereClause = "Id = ?";
            valueClose = value.toString();
        }
        try {
            this.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE " + whereClause);
            preparedStatement.setObject(1, valueClose);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                //PROBLEM
                book.setId(resultSet.getInt("Id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthors(resultSet.getString("authors"));
                book.setUrlToImage(resultSet.getString("imageURL"));
                book.setDescription(resultSet.getString("description"));
                book.setYearOfPublication(resultSet.getInt("yearOfPublication"));
                book.setAvaiable(resultSet.getBoolean("avaiable"));
                book.setPhoto(resultSet.getString("imageURL"));
                allBooks.add(book);
            }
            return allBooks;


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return allBooks;
    }

    @Override
    public ObservableList<Book> findAllOfOneTypeBook() {
        ResultSet resultSet;
        ObservableList<Book> allBooks = FXCollections.observableArrayList();
        try {
            this.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT DISTINCT title, authors FROM books");
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setAuthors(resultSet.getString("authors"));
                allBooks.add(book);
            }
            return allBooks;

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return allBooks;
    }

    @Override
    public ObservableList<Book> findAllOfOneTypeBookByProperty(SearchProperty searchProperty, String value) {
        ObservableList<Book> allBooks = FXCollections.observableArrayList();
        ResultSet resultSet;
        String whereClause = "";
        String valueClose = "";
        if(searchProperty == SearchProperty.TITLE)
        {
            whereClause = "title LIKE ?";
            valueClose = "%" + value.toString() + "%";
        }
        if (searchProperty == SearchProperty.AUTHOR) {
            whereClause = "authors LIKE ?";
            valueClose = "%" + value.toString() + "%";
        }
        try {
            this.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT title, authors FROM books WHERE " + whereClause);
            preparedStatement.setObject(1, valueClose);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setAuthors(resultSet.getString("authors"));
                allBooks.add(book);
            }
            return allBooks;


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    this.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return allBooks;
    }

    @Override
    public void setup() throws Exception {

        connection = ConfigureConnection.getConnection();

        statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS books (" +
                "Id INT PRIMARY KEY UNIQUE auto_increment," +
                "title VARCHAR(55), " +
                "authors VARCHAR(55), " +
                "imageURL VARCHAR(150), " +
                "description VARCHAR(1000), " +
                "yearOfPublication INT, " +
                "avaiable TINYINT(1)" +
                ") DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;");
    }

    @Override
    public void connect() throws Exception {
        connection = ConfigureConnection.getConnection();

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
