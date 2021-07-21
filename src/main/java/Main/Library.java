package Main;

import Enums.LibraryCatalog;
import Enums.LibraryUsers;

import java.util.PriorityQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Library {
    public String libraryName;
    public String address;
    private final Librarian librarian;
    private Map<LibraryCatalog,List<Book>> booksCollectionByCatalog;
    private List<Book> listOfBooksBorrowed;
    private Queue<Integer> firstComeFirstServe;
    private PriorityQueue<LibraryUsers> issueOrder;
    private final List<BorrowersCard> borrowersCardList;

    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
        this.librarian = null;
        this.booksCollectionByCatalog = new TreeMap<>();
        this.firstComeFirstServe = new LinkedList<>();
        this.issueOrder = new PriorityQueue<>(new CustomComparator());
        this.borrowersCardList = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Map<LibraryCatalog, List<Book>> getBooksCollectionByCatalog() {
        return booksCollectionByCatalog;
    }

    public void setBooksCollectionByCatalog(Map<LibraryCatalog, List<Book>> booksCollectionByCatalog) {
        this.booksCollectionByCatalog = booksCollectionByCatalog;
    }

    public List<Book> getListOfBooksBorrowed() {
        return listOfBooksBorrowed;
    }
    public List<Book> getListOfBooksByCatalog(Book book) {
        return booksCollectionByCatalog.get(book.getLibraryCatalog());
    }

    public void setListOfBooksBorrowed(List<Book> listOfBooksBorrowed) {
        this.listOfBooksBorrowed = listOfBooksBorrowed;
    }

    public PriorityQueue<LibraryUsers> getIssueOrder() {
        return issueOrder;
    }

    public void setIssueOrder(PriorityQueue<LibraryUsers> issueOrder) {
        this.issueOrder = issueOrder;
    }
    public void addIssueOrder(LibraryUsers libraryUserType) {
        this.issueOrder.add(libraryUserType);
    }

    public List<BorrowersCard> getBorrowersCardList() {
        return borrowersCardList;
    }
    public void addBorrowersCardToLibraryCardList(BorrowersCard borrowersCard){
        borrowersCardList.add(borrowersCard);
    }
    protected List<Book> getListOfBooks(Book book){
        return booksCollectionByCatalog.get(book.getLibraryCatalog());
    }

    public void removeCardFromCardList(BorrowersCard borrowersCard) {
        this.borrowersCardList.remove(borrowersCard);
    }
    protected void addNewBookWithNewCatalog(Book book){
        List<Book> list = new ArrayList<>();
        list.add(book);
        booksCollectionByCatalog.put(book.getLibraryCatalog(),list);
    }
    protected boolean searchForABookInTheLibrary(String bookName){
        List<Boolean> bookExist = new ArrayList<>();
        getBooksCollectionByCatalog().forEach((key, value) -> {
            for(Book book: value){
                bookExist.add(book.getTitle().equalsIgnoreCase(bookName));
            }
        });
        return bookExist.contains(true);
    }

    protected Queue<Integer> getFirstComeFirstServe() {
        return firstComeFirstServe;
    }
    protected void removeUserFromTheQueue(Integer userValue) {
        firstComeFirstServe.remove(userValue);
    }
    public void addToFirstComeFirstServe(Integer userValue){
        firstComeFirstServe.add(userValue);
    }

    protected Integer getUserOnFirstComeFirstServe() {
        return this.firstComeFirstServe.poll();
    }
}
