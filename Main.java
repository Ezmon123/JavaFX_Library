package library;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.database.LibrariesDAO;
import library.database.ProjectLibraryDAO;
import library.model.Library;
import library.MainViewController;

public class Main extends Application{
    public static void main(String[] args) throws Exception{
//        LibrariesDAO libraryDAO = new ProjectLibraryDAO();
//        Library library = new Library(libraryDAO);
//        libraryDAO.setup();
//
//        addSomeBooks(library);
//
//
//        libraryDAO.close();
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../library/mainview.fxml"));
        window.setTitle("Hello World");
        window.setScene(new Scene(root));

        window.show();
    }

    public static void addSomeBooks(Library library){
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile1993.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                1993);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile1993.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                1993);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile1993.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                1993);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile1993.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                1993);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile1993.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                1993);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile2000.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                2000);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile2000.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                2000);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile2000.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                2000);
        library.addBoook("The Green Mile", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\TheGreenMile2000.jpg",
                "King released his prison drama The Green Mile in six monthly installments in the spring and summer of 1993. It's the story of a large black man sentenced to death for the rape of two young girls. He's very timid and quiet, but he possesses the power to heal people with a touch. Some accused King of creating a \"magical negro\" character, but the writer strongly disagrees: \"When I was writing the book I said to myself, 'What can I do to make sure that this character goes to the chair even if he's innocent?'\" King says. \"And I said, 'Well, it's 1933. If he's black, nobody is going to let him off the hook no matter what the evidence is. They're going to fry him.' So I made him a black guy.",
                2000);


        library.addBoook("Salem's Lot", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\SalemsLot1975.jpg",
                "After breaking big with his debut novel Carrie, King proved he wasn't a one-trick pony when he released the follow-up in 1975. Salem's Lot has a rather simple premise: What if a Dracula-like vampire moved to a small town in Maine? Slowly, much of the town transforms into vampires – until a high school teacher and his young girlfriend begin fighting back. For years King contemplated writing a sequel, but he decided to simply fold one of characters, Father Callahan, into the final Dark Tower books. ",
                1975);
        library.addBoook("Salem's Lot", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\SalemsLot1975.jpg",
                "After breaking big with his debut novel Carrie, King proved he wasn't a one-trick pony when he released the follow-up in 1975. Salem's Lot has a rather simple premise: What if a Dracula-like vampire moved to a small town in Maine? Slowly, much of the town transforms into vampires – until a high school teacher and his young girlfriend begin fighting back. For years King contemplated writing a sequel, but he decided to simply fold one of characters, Father Callahan, into the final Dark Tower books. ",
                1975);
        library.addBoook("Salem's Lot", "Stephen King", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\SalemsLot1975.jpg",
                "After breaking big with his debut novel Carrie, King proved he wasn't a one-trick pony when he released the follow-up in 1975. Salem's Lot has a rather simple premise: What if a Dracula-like vampire moved to a small town in Maine? Slowly, much of the town transforms into vampires – until a high school teacher and his young girlfriend begin fighting back. For years King contemplated writing a sequel, but he decided to simply fold one of characters, Father Callahan, into the final Dark Tower books. ",
                1975);


        library.addBoook("Of Mice and Men", "John Steinbeck", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\OfMiceAndMen1937.jpg",
                "Only a year after the March 1937 publication of the book and opening of the Broadway play (November), Steinbeck’s George and Lennie had entered America’s popular lexicon, This odd couple still worms its way into readers’ hearts—“a little study in humility” Steinbeck called his novella. Lennie’s worshipful love of George and George’s equally sharp need for Lennie’s adoration is archetypal. Everybody is lonely in this book—where a visionary cooperative farm is a temporary and ever-poignant stay against confusion. “Tell me about the rabbits, George.” Who wouldn’t sign on?",
                1937);
        library.addBoook("Of Mice and Men", "John Steinbeck", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\OfMiceAndMen1937.jpg",
                "Only a year after the March 1937 publication of the book and opening of the Broadway play (November), Steinbeck’s George and Lennie had entered America’s popular lexicon, This odd couple still worms its way into readers’ hearts—“a little study in humility” Steinbeck called his novella. Lennie’s worshipful love of George and George’s equally sharp need for Lennie’s adoration is archetypal. Everybody is lonely in this book—where a visionary cooperative farm is a temporary and ever-poignant stay against confusion. “Tell me about the rabbits, George.” Who wouldn’t sign on?",
                1937);
        library.addBoook("Of Mice and Men", "John Steinbeck", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\OfMiceAndMen1937.jpg",
                "Only a year after the March 1937 publication of the book and opening of the Broadway play (November), Steinbeck’s George and Lennie had entered America’s popular lexicon, This odd couple still worms its way into readers’ hearts—“a little study in humility” Steinbeck called his novella. Lennie’s worshipful love of George and George’s equally sharp need for Lennie’s adoration is archetypal. Everybody is lonely in this book—where a visionary cooperative farm is a temporary and ever-poignant stay against confusion. “Tell me about the rabbits, George.” Who wouldn’t sign on?",
                1937);
        library.addBoook("Of Mice and Men", "John Steinbeck", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\OfMiceAndMen1950.jpg",
                "Only a year after the March 1937 publication of the book and opening of the Broadway play (November), Steinbeck’s George and Lennie had entered America’s popular lexicon, This odd couple still worms its way into readers’ hearts—“a little study in humility” Steinbeck called his novella. Lennie’s worshipful love of George and George’s equally sharp need for Lennie’s adoration is archetypal. Everybody is lonely in this book—where a visionary cooperative farm is a temporary and ever-poignant stay against confusion. “Tell me about the rabbits, George.” Who wouldn’t sign on?",
                1950);
        library.addBoook("Of Mice and Men", "John Steinbeck", "file:\\C:\\Users\\Admin\\Desktop\\programowanie\\Java\\Rozne\\Library_JavaFX\\screens\\OfMiceAndMen1950.jpg",
                "Only a year after the March 1937 publication of the book and opening of the Broadway play (November), Steinbeck’s George and Lennie had entered America’s popular lexicon, This odd couple still worms its way into readers’ hearts—“a little study in humility” Steinbeck called his novella. Lennie’s worshipful love of George and George’s equally sharp need for Lennie’s adoration is archetypal. Everybody is lonely in this book—where a visionary cooperative farm is a temporary and ever-poignant stay against confusion. “Tell me about the rabbits, George.” Who wouldn’t sign on?",
                1950);
    }
}
