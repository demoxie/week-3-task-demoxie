package Main;

import Enums.BookStatus;
import Enums.Librarians;
import Enums.LibraryCatalog;
import Enums.LibraryUsers;
import Services.LibrarianService;

import java.util.*;


public class Librarian extends User implements LibrarianService {
    private final Library library;
    private final Librarians role;
    public Librarian(String name, String gender, Integer age, String address) {
        super(name, gender, age, address);
        this.role = Librarians.LIBRARIAN;
        this.library = new Library("Oxford University Main.Main.Library","Lagos");
    }

    @Override
    public void issueBook() {

        List<String> booksRequestingFor = new ArrayList<>();
        List<BorrowersCard> tempCards = new ArrayList<BorrowersCard>();
        //Looping through list of books in the library
        library.getBooksCollectionByCatalog().forEach((key, value) -> {
            for(Book book: value){
                //Looping through the library list of cards
                for (BorrowersCard card : library.getBorrowersCardList()) {
                    //checking to see if the book requested by cards are available in the library list of books
                    if (book.getTitle().equalsIgnoreCase(card.getBookName())) {
                        booksRequestingFor.add(card.getBookName());
                    }
                }
            }
        });
        //Checking to see if there are similar request of the same book
        Set<String> tempList = new HashSet<>(booksRequestingFor);
        if(booksRequestingFor.size() == tempList.size()){
            for (BorrowersCard card : library.getBorrowersCardList()) {
            library.getBooksCollectionByCatalog().forEach((key, value) -> {
                for(Book book: value){

                        if (book.getTitle().equalsIgnoreCase(card.getBookName())) {
                            if(book.getQuantity()>=1){
                                card.getLibraryUser().addBookToListOfBooksInPossession(book);
                                int currentBookQuantity = book.getQuantity();
                                book.setQuantity(currentBookQuantity-1);
                                tempCards.add(card);

                            }else{
                                book.setBookStatus(BookStatus.BORROWED);
                                System.out.println(card.getBorrowersName()+": The book requesting for is no longer available");
                            }
                        }
                    }
            });
            }
            for(BorrowersCard card: tempCards){
                library.removeUserFromTheQueue(card.getLibraryUser().getLibraryUserType().getValue());
                library.removeCardFromCardList(card);
            }


        }else{
            for (BorrowersCard card : library.getBorrowersCardList()) {
            library.getBooksCollectionByCatalog().forEach((key, value) -> {
                for(Book book: value){
                        if (book.getTitle().equalsIgnoreCase(card.getBookName())) {
                            LibraryUsers user = library.getIssueOrder().poll();
                            Integer userValue = library.getUserOnFirstComeFirstServe();
                            if(user != null){
                                if(userValue.equals(card.getLibraryUser().getLibraryUserType().getValue()) && book.getQuantity()>=1){
                                    card.getLibraryUser().addBookToListOfBooksInPossession(book);
                                    int currentBookQuantity = book.getQuantity();
                                    book.setQuantity(currentBookQuantity-1);
                                    tempCards.add(card);
                                }else{
                                    book.setBookStatus(BookStatus.BORROWED);
                                    System.out.println(card.getBorrowersName()+": The book you're requesting for is no longer available");
                                }
                            }

                        }
                }
            });
            }
            for(BorrowersCard card: tempCards){
                library.removeUserFromTheQueue(card.getLibraryUser().getLibraryUserType().getValue());
                library.removeCardFromCardList(card);
            }
        }


    }

    private void addBooksByCatalog(Book book) {
        if(library.getBooksCollectionByCatalog().containsKey(book.getLibraryCatalog())){
            List<Book> books = library.getListOfBooks(book);
            if(!books.isEmpty()){
                for(Book book1: books){
                    if(book1 == book && book1.getQuantity()>=1){
                        book1.setQuantity(book1.getQuantity()+1);
                    }
                }
            }else{
                books.add(book);
            }
            Map<LibraryCatalog,List<Book>> list = library.getBooksCollectionByCatalog();
            list.put(book.getLibraryCatalog(),books);
            library.setBooksCollectionByCatalog(list);
        }else{
            library.addNewBookWithNewCatalog(book);
        }
    }
    protected Library getLibrary(){
        return library;
    }


    protected Map<LibraryCatalog,List<Book>> getBooksCollectionByCatalog(){
        return library.getBooksCollectionByCatalog();
    }
    protected List<BorrowersCard> getBorrowersCardList(){
        return library.getBorrowersCardList();
    }

    protected PriorityQueue<LibraryUsers> getQueueOrderList(){
        return library.getIssueOrder();
    }
    @Override
    public void createBookRecord(String title, LibraryCatalog libraryCatalog, String author, Integer quantity, BookStatus bookStatus){
        Book book = new Book(title, libraryCatalog,author,quantity, bookStatus);
        addBooksByCatalog(book);
    }

}
