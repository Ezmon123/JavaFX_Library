package library.datastructure;

import javafx.scene.image.Image;

import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private String authors;
    private String urlToImage;
    private Image photo;
    private String description;
    private int yearOfPublication;
    private boolean avaiable;

    public Book(){

    }

    public Book(String title, String authors, String urlToImage, String description, int yearOfPublication) {
        this.title = title;
        this.authors = authors;
        this.urlToImage = urlToImage;
        this.yearOfPublication = yearOfPublication;
        this.description = description;
        this.avaiable = true;
        this.photo = new Image(urlToImage);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int dateOfPublication) {
        this.yearOfPublication = dateOfPublication;
    }

    public boolean isAvaiable() {
        return avaiable;
    }

    //    public String getavaiable() {
//        String avaiableString = Boolean.toString(avaiable);
//        return avaiableString;
//    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(String url) {
        this.photo = new Image(urlToImage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublication == book.yearOfPublication &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(urlToImage, book.urlToImage) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, authors, urlToImage, description, yearOfPublication);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", description='" + description + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", avaiable=" + avaiable +
                '}';
    }
}
