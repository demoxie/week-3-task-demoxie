package Main;

import Enums.LibraryUsers;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BorrowersCard {
    private String borrowersName;
    private final LibraryUser libraryUser;
    private String bookBorrowing;

    public BorrowersCard(String borrowersName, LibraryUser libraryUser, String bookName) {
        this.borrowersName = borrowersName;
        this.libraryUser = libraryUser;
        this.bookBorrowing = bookName;
    }

    @Override
    public String toString() {
        return "BorrowersCard{" +
                "borrowersName='" + borrowersName + '\'' +
                ", libraryUser=" + libraryUser +
                ", bookBorrowing=" + bookBorrowing +
                '}';
    }

    public String getBorrowersName() {
        return borrowersName;
    }

    public void setBorrowersName(String borrowersName) {
        this.borrowersName = borrowersName;
    }

    public String getBookName(){
        return bookBorrowing;
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public String getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(String bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }
}
