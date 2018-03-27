package library;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;
import library.database.LibrariesDAO;
import library.database.ProjectLibraryDAO;
import library.datastructure.Book;
import library.datastructure.SearchProperty;
import library.model.Library;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BooksViewController implements Initializable{
    @FXML
    private TextField textField;
    @FXML
    private ChoiceBox<SearchProperty> choiceBox;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, Void> indexColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorsColumn;


    private Library library;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LibrariesDAO librariesDAO = new ProjectLibraryDAO();
        this.library = new Library(librariesDAO);

        choiceBox.getItems().setAll(SearchProperty.TITLE, SearchProperty.AUTHOR);
        choiceBox.getSelectionModel().selectFirst();

//        indexColumn = new TableColumn<>("Index");
//        indexColumn.setCellFactory(col -> {
//            TableCell<Book, Void> cell = new TableCell<>();
//            cell.textProperty().bind(Bindings.createStringBinding(() -> {
//                if (cell.isEmpty()) {
//                    return null ;
//                } else {
//                    return Integer.toString(cell.getIndex());
//                }
//            }, cell.emptyProperty(), cell.indexProperty()));
//            return cell ;
//        });
//
//        tableView.getColumns().add(0, indexColumn);



        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorsColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("authors"));
        tableView.setItems(library.findAllOfOneTypeBook());

    }


    @FXML
    public void findBook(){
        String value = textField.getText();
        SearchProperty searchProperty = choiceBox.getValue();
        ObservableList<Book> books = library.findAllOfOneTypeBookByProperty(searchProperty, value);
        tableView.setItems(books);
    }

    @FXML
    public void switchToDeatiledView(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../library/detailedview.fxml"));
        Parent layout = loader.load();
        Scene scene = new Scene(layout);

        DetailedViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem().getTitle());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }
}
