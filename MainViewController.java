package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.database.LibrariesDAO;
import library.database.ProjectLibraryDAO;
import library.datastructure.Book;
import library.datastructure.SearchProperty;
import library.model.Library;

import java.net.URL;
import java.util.ResourceBundle;


public class MainViewController implements Initializable{
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void switchToBooksView(ActionEvent event) throws Exception{
        Parent layout = FXMLLoader.load(getClass().getResource("../library/booksview.fxml"));
        Scene scene = new Scene(layout);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
    }


}