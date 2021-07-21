package Services.ServicesImpl;

import Enums.LibraryUsers;
import Main.*;
import Services.BookBorrowerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowerServiceImpl implements BookBorrowerService {

    @Override
    public BorrowersCard borrowBook(String borrowersName,LibraryUser libraryUser,String bookName, Library library) {
        List<BorrowersCard> tempCard = new ArrayList<BorrowersCard>();
        library.getBooksCollectionByCatalog().forEach((key, value) -> {
            for(Book book: value){
                if(book.getTitle().equalsIgnoreCase(bookName)){
                    List<BorrowersCard> cardList = library.getBorrowersCardList();
                    library.addIssueOrder(libraryUser.getLibraryUserType());
                    library.addToFirstComeFirstServe(libraryUser.getLibraryUserType().getValue());
                    BorrowersCard borrowersCard = new BorrowersCard(borrowersName,libraryUser,bookName);
                    tempCard.add(borrowersCard);
                    cardList.add(borrowersCard);

                }
                    System.out.println(borrowersName+": The book you're requesting for is unavailable in our catalog");

            }
        });
        return tempCard.size() != 0 ? tempCard.get(0) : null;
    }

    @Override
    public List<Book> addBookToListOfBooksInPossession(Book book,List<Book> listOfBooks) {
        listOfBooks.add(book);
        return listOfBooks;
    }

    @Override
    public void returnBook(Book book, LibraryUsers typeOfLibraryUser) {

    }
}
