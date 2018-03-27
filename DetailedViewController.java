package library;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import library.database.LibrariesDAO;
import library.database.ProjectLibraryDAO;
import library.datastructure.Book;
import library.datastructure.SearchProperty;
import library.model.Library;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DetailedViewController implements Initializable{


    @FXML
    private Button loanButton;
    @FXML
    private Button returnButton;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorsColumn;
    @FXML
    private TableColumn<Book, String> yearofpublishColumn;
    @FXML
    private TableColumn<Book, Boolean> avaiableColumn;
    @FXML
    private ImageView imageView;
    @FXML
    private TextFlow textFlow;
    @FXML
    private String selectedTitle;
    @FXML
    private ObservableList<Book> booksDB;



    private Library library;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LibrariesDAO librariesDAO = new ProjectLibraryDAO();
        this.library = new Library(librariesDAO);
    }

    @FXML
    public void initData(String selectedTitle) {
        this.selectedTitle = selectedTitle;
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authors"));
        yearofpublishColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("yearOfPublication"));
        avaiableColumn.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("avaiable"));
        this.booksDB = library.findBook(SearchProperty.TITLE, selectedTitle);
        tableView.setItems(booksDB);
        tableView.getSelectionModel().selectFirst();
        Book selectedItem = tableView.getSelectionModel().getSelectedItem();
        imageView.setImage(selectedItem.getPhoto());
        textFlow.getChildren().add(new Text(selectedItem.getDescription()));
    }

    @FXML
    public void changeImageAndDescription(){
        textFlow.getChildren().clear();
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        imageView.setImage(selectedBook.getPhoto());
        textFlow.getChildren().add(new Text(selectedBook.getDescription()));
    }


    @FXML
    public void loanBook() {

        long id =  tableView.getSelectionModel().getSelectedItem().getId();
        library.loanBook(id);
        this.refresh();
//        loanButton.setDisable(true);
//        returnButton.setDisable(false);
    }

    @FXML
    public void returnBook(){

        long id = tableView.getSelectionModel().getSelectedItem().getId();
        library.returnBook(id);
        this.refresh();
//        loanButton.setDisable(false);
//        returnButton.setDisable(true);
    }

    public void refresh(){
        booksDB.removeAll(booksDB);
        booksDB = library.findBook(SearchProperty.TITLE, selectedTitle);
        tableView.setItems(booksDB);


    }

    @FXML
    public void switchToBooksView(ActionEvent event) throws Exception{
        Parent layout = FXMLLoader.load(getClass().getResource("../library/booksview.fxml"));
        Scene scene = new Scene(layout);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }
}
