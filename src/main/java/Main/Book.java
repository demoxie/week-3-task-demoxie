package Main;

import Enums.BookStatus;
import Enums.LibraryCatalog;

public class Book{
    private String title;
    private LibraryCatalog libraryCatalog;
    private String author;
    private Integer quantity;
    private BookStatus bookStatus;

    public Book(String title,LibraryCatalog catalogName,  String author, Integer quantity, BookStatus bookStatus) {
        this.title = title;
        this.libraryCatalog = catalogName;
        this.author = author;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +

                '}';
    }
     //", quantity=" + quantity +
         //   ", bookStatus=" + bookStatus +

    public LibraryCatalog getLibraryCatalog() {
        return libraryCatalog;
    }

    public void setLibraryCatalog(LibraryCatalog libraryCatalog) {
        this.libraryCatalog = libraryCatalog;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
