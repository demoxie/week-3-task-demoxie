package Main;

import Enums.BookStatus;
import Enums.LibraryCatalog;
import Enums.LibraryUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {
    Librarian librarian;
    LibraryUser teacher;
    LibraryUser seniorStudent;
    LibraryUser juniorStudent1;
    LibraryUser juniorStudent2;
    @BeforeEach
    void setUp() {
        //Creating librarian's object
        librarian = new Librarian("Mr. Tobilola","Male",30,"Lagos State");
        //Creating various library users
        teacher = new LibraryUser("Dr. James Mikky","Male",34,"Lgos State", LibraryUsers.TEACHER);
        seniorStudent = new LibraryUser("Adebola Adekunle","Male",13,"Lgos State", LibraryUsers.SENIOR_STUDENT);
        juniorStudent1 = new LibraryUser("Joshua Anthony","Male",12,"Lgos State", LibraryUsers.JUNIOR_STUDENT);
        juniorStudent2 = new LibraryUser("Fatima Abdul","Male",14,"Lgos State", LibraryUsers.JUNIOR_STUDENT);
        //Librarian creating books
        librarian.createBookRecord("New General Mathematics JSS 2", LibraryCatalog.SCIENCE_AND_ENGINEERING,"Osei Abibio",3, BookStatus.AVAILABLE);
        librarian.createBookRecord("New School Government JSS 2",LibraryCatalog.ART_AND_HUMANITY,"Adebayo Ugonlayo",3,BookStatus.AVAILABLE);

        //Users borrowing books
        teacher.BorrowBook("New General Mathematics JSS 2",teacher, librarian.getLibrary());
        seniorStudent.BorrowBook("New General Mathematics JSS 2",seniorStudent, librarian.getLibrary());
        juniorStudent1.BorrowBook("General Mathematics JSS 2",juniorStudent1, librarian.getLibrary());
        juniorStudent2.BorrowBook("General Mathematics JSS 2",juniorStudent2, librarian.getLibrary());
        juniorStudent1.BorrowBook("New School Government JSS 2",juniorStudent1, librarian.getLibrary());
        librarian.issueBook();

    }

    @Test
    void getLibraryUserType() {
        assertEquals(LibraryUsers.SENIOR_STUDENT,seniorStudent.getLibraryUserType());
    }

    @Test
    void getListOfBooksInPossession() {
        assertEquals(1,teacher.getListOfBooksInPossession().size());
    }

    @Test
    void borrowBook() {
        teacher.BorrowBook("New General Mathematics JSS 2",teacher, librarian.getLibrary());
        librarian.issueBook();
        assertEquals(0,librarian.getBorrowersCardList().size());
    }
}