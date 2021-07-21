package Main;

import Enums.BookStatus;
import Enums.LibraryCatalog;
import Enums.LibraryUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {
    Librarian librarian;
    LibraryUser teacher;
    LibraryUser seniorStudent;
    LibraryUser juniorStudent1;
    LibraryUser juniorStudent2;
    @BeforeEach
    void setUp() {
        librarian = new Librarian("Mr. Tobilola","Male",30,"Lagos State");

        teacher = new LibraryUser("Dr. James Mikky","Male",34,"Lgos State", LibraryUsers.TEACHER);
        seniorStudent = new LibraryUser("Adebola Adekunle","Male",13,"Lgos State", LibraryUsers.SENIOR_STUDENT);
        juniorStudent1 = new LibraryUser("Joshua Anthony","Male",12,"Lgos State", LibraryUsers.JUNIOR_STUDENT);
        juniorStudent2 = new LibraryUser("Fatima Abdul","Male",14,"Lgos State", LibraryUsers.JUNIOR_STUDENT);
        librarian.createBookRecord("New General Mathematics JSS 2", LibraryCatalog.SCIENCE_AND_ENGINEERING,"Osei Abibio",3, BookStatus.AVAILABLE);
        librarian.createBookRecord("New School Government JSS 2",LibraryCatalog.ART_AND_HUMANITY,"Adebayo Ugonlayo",3,BookStatus.AVAILABLE);

        teacher.BorrowBook("New General Mathematics JSS 2",teacher, librarian.getLibrary());
        seniorStudent.BorrowBook("New General Mathematics JSS 2",seniorStudent, librarian.getLibrary());
        juniorStudent1.BorrowBook("New General Mathematics JSS 2",juniorStudent1, librarian.getLibrary());
        juniorStudent2.BorrowBook("New General Mathematics JSS 2",juniorStudent2, librarian.getLibrary());
        //juniorStudent1.BorrowBook("New School Government JSS 2",juniorStudent1, librarian.getLibrary());

    }

    @org.junit.jupiter.api.Test
    void issueBook() {
        librarian.issueBook();
        //assertEquals(1,librarian.getBooksCollectionByCatalog().get(LibraryCatalog.SCIENCE_AND_ENGINEERING).size());
        assertEquals(0,juniorStudent2.getListOfBooksInPossession().size());
    }

    @Test
    void getBooksCollectionByCatalog() {
        assertEquals(2,librarian.getBooksCollectionByCatalog().size());
    }

    @Test
    void getBorrowersCardList() {
        librarian.issueBook();
        assertEquals(1,librarian.getBorrowersCardList().size());
    }

    @Test
    void getQueueOrderList() {
        assertEquals(3,librarian.getQueueOrderList().size());
    }

    @Test
    void createBookRecord() {
        assertTrue(librarian.getLibrary().searchForABookInTheLibrary("New School Government JSS 2"));
    }
}