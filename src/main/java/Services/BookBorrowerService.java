package Services;

import Enums.LibraryUsers;
import Main.BorrowersCard;
import Main.Library;

import Main.Book;
import Main.LibraryUser;

import java.util.List;

public interface BookBorrowerService {
    BorrowersCard borrowBook(String borrowersName, LibraryUser libraryUser, String bookName, Library library);
    List<Book> addBookToListOfBooksInPossession(Book book,List<Book> listOfBooks);
    void returnBook(Book book,LibraryUsers typeOfLibraryUser);

}
