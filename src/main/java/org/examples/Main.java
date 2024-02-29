package org.examples;

import org.examples.enums.Role;
import org.examples.model.Book;
import org.examples.model.Library1;
import org.examples.model.Library2;
import org.examples.model.Person;
import org.examples.service.*;
import org.examples.service.Impl.BorrowerServiceImpl;
import org.examples.service.Impl.LibraryService1Impl;
import org.examples.service.Impl.LibraryService2Impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", Role.JUNIOR_STUDENT, new ArrayList<>());
        Person james = new Person("James", Role.SENIOR_STUDENT, new ArrayList<>());
        Person shadyvee = new Person("shadyvee", Role.SENIOR_STUDENT, new ArrayList<>());
        Person shamah = new Person("Shamah", Role.TEACHER, new ArrayList<>());
        Person mathew = new Person("Mathew", Role.TEACHER, new ArrayList<>());
        Person librarian = new Person("Librarian", Role.LIBRARIAN, new ArrayList<>());

        Book efj = new Book("Effective Java", "Joshua Bloch", 6);
        Book htdp = new Book("How to Design", "Matthias Felleisen", 5);
        Book cc = new Book("Clean Code", "Robert C. Martin", 7);

        Library1 library1 = new Library1("Central Library", new ArrayList<>(), new PriorityQueue<>(), librarian);
        Library2 library2 = new Library2("James Library", new ArrayList<>(), new LinkedList<>(), librarian);

        library1.setListOfBooks(List.of(efj, htdp, cc));
        library2.setListOfBooks(List.of(efj, htdp, cc));

        LibraryService1 libraryService1 = new LibraryService1Impl(library1);
        LibraryService2 libraryService2 = new LibraryService2Impl(library2);

        BorrowerService borrowerService = new BorrowerServiceImpl();
        
        //When the same book is borrowed by multiple people, the person with the highest priority should be given the book first.
        borrowerService.borrowBookWithPriority("Effective Java", james, library1);
        borrowerService.borrowBookWithPriority("Effective Java", john, library1);
        borrowerService.borrowBookWithPriority("Effective Java", shadyvee, library1);
        borrowerService.borrowBookWithPriority("Effective Java", shamah, library1);
        borrowerService.borrowBookWithPriority("Effective Java", mathew, library1);
        libraryService1.issueBook("Effective Java");

        System.out.println("***********************************************************");

        //When the same book is borrowed by multiple people, the person who requested the book first should be given the book first.
        borrowerService.borrowWithoutPriority("How to Design", james, library2);
        borrowerService.borrowWithoutPriority("How to Design", john, library2);
        borrowerService.borrowWithoutPriority("How to Design", shamah, library2);

        libraryService2.issueBook("How to Design");
        System.out.println(james.getBorrowedBooks());

    }
}