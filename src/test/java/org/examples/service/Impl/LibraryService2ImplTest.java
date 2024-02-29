package org.examples.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.*;

import org.examples.enums.Role;
import org.examples.model.Book;
import org.examples.model.Library2;
import org.examples.model.Person;
import org.examples.service.BorrowerService;
import org.examples.service.LibraryService2;
import org.junit.jupiter.api.Test;

class LibraryService2ImplTest {
    @Test
    void testIssueBookWithoutPriority() {
        Person john = new Person("John", Role.JUNIOR_STUDENT, new ArrayList<>());
        Person james = new Person("James", Role.SENIOR_STUDENT, new ArrayList<>());
        Person shamah = new Person("Shamah", Role.TEACHER, new ArrayList<>());
        Person mathew = new Person("Mathew", Role.TEACHER, new ArrayList<>());
        Person librarian = new Person("Librarian", Role.LIBRARIAN, new ArrayList<>());

        Book efj = new Book("Effective Java", "Joshua Bloch", 6);
        Book htdp = new Book("How to Design", "Matthias Felleisen", 5);
        Book cc = new Book("Clean Code", "Robert C. Martin", 7);

        Library2 library2 = new Library2("Central Library", new ArrayList<>(), new LinkedList<>(), librarian);

        library2.setListOfBooks(List.of(efj, htdp, cc));

        LibraryService2 libraryService2 = new LibraryService2Impl(library2);

        BorrowerService borrowerService = new BorrowerServiceImpl();

        //When the same book is borrowed by multiple people, the person with the highest priority should be given the book first.
        borrowerService.borrowWithoutPriority("Effective Java", james, library2);
        borrowerService.borrowWithoutPriority("Effective Java", john, library2);
        borrowerService.borrowWithoutPriority("Effective Java", shamah, library2);
        borrowerService.borrowWithoutPriority("Effective Java", mathew, library2);
        libraryService2.issueBook("Effective Java");
        assertEquals(1, james.getBorrowedBooks().size());
        assertEquals("James",library2.getBorrowers().peek().getName());
    }
}
