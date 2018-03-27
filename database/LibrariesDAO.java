package library.database;

import javafx.collections.ObservableList;
import library.datastructure.Book;
import library.datastructure.SearchProperty;

import java.util.List;
import java.util.Optional;

public interface LibrariesDAO extends DAO {
    long insertBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Book book);

    ObservableList<Book> findBook(SearchProperty searchProperty, String value);

    ObservableList<Book> findAllOfOneTypeBook();

    ObservableList<Book> findAllOfOneTypeBookByProperty(SearchProperty searchProperty, String value);

}
