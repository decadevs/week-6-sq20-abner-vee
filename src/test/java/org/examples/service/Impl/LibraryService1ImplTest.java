package org.examples.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.examples.enums.Role;
import org.examples.model.Book;
import org.examples.model.Library1;
import org.examples.model.Library2;
import org.examples.model.Person;
import org.examples.service.BorrowerService;
import org.examples.service.LibraryService1;
import org.examples.service.LibraryService2;
import org.junit.jupiter.api.Test;

class LibraryService1ImplTest {
    @Test
    void testIssueBook() {
        Person john = new Person("John", Role.JUNIOR_STUDENT, new ArrayList<>());
        Person james = new Person("James", Role.SENIOR_STUDENT, new ArrayList<>());
        Person shamah = new Person("Shamah", Role.TEACHER, new ArrayList<>());
        Person mathew = new Person("Mathew", Role.TEACHER, new ArrayList<>());
        Person librarian = new Person("Librarian", Role.LIBRARIAN, new ArrayList<>());

        Book efj = new Book("Effective Java", "Joshua Bloch", 6);
        Book htdp = new Book("How to Design", "Matthias Felleisen", 5);
        Book cc = new Book("Clean Code", "Robert C. Martin", 7);

        Library1 library1 = new Library1("Central Library", new ArrayList<>(), new PriorityQueue<>(), librarian);

        library1.setListOfBooks(List.of(efj, htdp, cc));

        LibraryService1 libraryService1 = new LibraryService1Impl(library1);

        BorrowerService borrowerService = new BorrowerServiceImpl();

        //When the same book is borrowed by multiple people, the person with the highest priority should be given the book first.
        borrowerService.borrowBookWithPriority("Effective Java", james, library1);
        borrowerService.borrowBookWithPriority("Effective Java", john, library1);
        borrowerService.borrowBookWithPriority("Effective Java", shamah, library1);
        borrowerService.borrowBookWithPriority("Effective Java", mathew, library1);
        libraryService1.issueBook("Effective Java");
        assertEquals(1, james.getBorrowedBooks().size());
        assertEquals("Shamah",library1.getBorrowers().peek().getName());
    }
}
