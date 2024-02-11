package hh.sof3.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book") 
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private long id;

    @Column (name = "title")
    private String title;

    @Column (name = "author")
    private String author;

    @Column (name = "pulicationYear")
    private int publicationYear;

    @Column (name = "isbn")
    private String isbn;
    
    @Column (name = "price")
    private double price;


    public Book() {
        super();
        this.title = null;
        this.author = null;
        this.publicationYear = -1;
        this.isbn = null;
        this.price = -1;
    }

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + "]";
    }

    
    


}
