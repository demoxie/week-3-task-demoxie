package Services;

import Enums.BookStatus;
import Enums.LibraryCatalog;
import Enums.LibraryUsers;
import Main.*;

import java.util.List;

public interface LibrarianService {
    void issueBook();
    void createBookRecord(String title, LibraryCatalog libraryCatalog, String author, Integer quantity, BookStatus bookStatus);
}
