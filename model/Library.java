package library.model;

import javafx.collections.ObservableList;
import library.database.LibrariesDAO;
import library.datastructure.Book;
import library.datastructure.SearchProperty;

import java.util.List;

public class Library {

    private LibrariesDAO librariesDAO;

    public Library(LibrariesDAO librariesDAO) {
        this.librariesDAO = librariesDAO;
    }

    public void addBoook(String title, String authors, String urlToImage, String description, int yearOfPublication) {
        Book book = new Book(title, authors, urlToImage, description, yearOfPublication);
        librariesDAO.insertBook(book);

    }

    public void loanBook(long id) {
        String id_str = Long.toString(id);
        List<Book> booksList = librariesDAO.findBook(SearchProperty.ID, id_str);
        if (booksList.size() > 0) {
            booksList.get(0).setAvaiable(false);
            librariesDAO.updateBook(booksList.get(0));
        }
    }

    public void returnBook(long id) {
        String id_str = Long.toString(id);
        List<Book> booksList = librariesDAO.findBook(SearchProperty.ID, id_str);
        if (booksList.size() > 0) {
            booksList.get(0).setAvaiable(true);
            librariesDAO.updateBook(booksList.get(0));
        }
    }

    public ObservableList<Book> findBook(SearchProperty searchProperty, String value) {
        return librariesDAO.findBook(searchProperty, value);
    }

    public ObservableList<Book> findAllOfOneTypeBook() {
        return librariesDAO.findAllOfOneTypeBook();
    }

    public ObservableList<Book> findAllOfOneTypeBookByProperty(SearchProperty searchProperty, String value) {
        return librariesDAO.findAllOfOneTypeBookByProperty(searchProperty, value);
    }

    public LibrariesDAO getLibrariesDAO() {
        return librariesDAO;
    }


}
