package Main;

import Enums.LibraryUsers;
import Services.ServicesImpl.BorrowerServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User{
    private List<Book> listOfBooksInPossession;
    protected BorrowerServiceImpl borrowerService;
    private final LibraryUsers libraryUserType;

    public LibraryUser(String name, String gender, Integer age, String address, LibraryUsers userType) {
        super(name, gender, age, address);
        this.listOfBooksInPossession = new ArrayList<>();
        this.borrowerService = new BorrowerServiceImpl();
        this.libraryUserType = userType;
    }

    public LibraryUsers getLibraryUserType() {
        return libraryUserType;
    }

    protected void addBookToListOfBooksInPossession(Book book){
        listOfBooksInPossession.add(book);
    }

    public List<Book> getListOfBooksInPossession() {
        return listOfBooksInPossession;
    }

    protected void BorrowBook(String bookName, LibraryUser libraryUser, Library library){
        //String borrowersName,LibraryUsers libraryUsers,Book book, Library library
        borrowerService.borrowBook(getName(), libraryUser, bookName, library);
    }
}
