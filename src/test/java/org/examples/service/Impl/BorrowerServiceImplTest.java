package org.examples.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.examples.model.Book;
import org.examples.model.Library1;
import org.examples.model.Library2;
import org.examples.model.Person;
import org.junit.jupiter.api.Test;

class BorrowerServiceImplTest {
    @Test
    void testBorrowBookWithPriority() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        Person person = new Person();

        Library1 library1 = new Library1();
        library1.setBorrowers(new PriorityQueue<>());

        borrowerServiceImpl.borrowBookWithPriority("Book Name", person, library1);

        assertEquals(1, library1.getBorrowers().size());
    }
    @Test
    void testBorrowWithoutPriority() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        Person person = new Person();
        ArrayList<Book> listOfBooks = new ArrayList<>();
        LinkedList<Person> borrowers = new LinkedList<>();
        Library2 library2 = new Library2("Name", listOfBooks, borrowers, new Person());


        borrowerServiceImpl.borrowWithoutPriority("Book Name", person, library2);
        assertEquals(1, library2.getBorrowers().size());
    }
}
