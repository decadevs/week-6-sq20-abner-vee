package org.examples.service.Impl;

import org.examples.enums.Role;
import org.examples.exception.LibraryException;
import org.examples.model.Book;
import org.examples.model.Library1;
import org.examples.model.Library2;
import org.examples.model.Person;
import org.examples.service.BorrowerService;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class BorrowerServiceImpl implements BorrowerService {
    @Override
    public void borrowBookWithPriority(String bookName, Person person, Library1 library1) {
        PriorityQueue<Person> borrowers = new PriorityQueue<>((p1, p2) -> {
            int roleValue1 = getRoleValue.apply(p1.getRole());
            int roleValue2 = getRoleValue.apply(p2.getRole());
            if (roleValue1 == roleValue2){
                return Integer.compare(p1.getOrder(), p2.getOrder());
            }
            return roleValue1 - roleValue2;
        });
        borrowers.add(person);
        borrowers.addAll(library1.getBorrowers());
        library1.setBorrowers(borrowers);
    }

    @Override
    public void borrowWithoutPriority(String bookName, Person person, Library2 library2) {
        Queue<Person> borrowers = library2.getBorrowers();
        borrowers.add(person);
        library2.setBorrowers(borrowers);
    }

    private final Function<Role, Integer> getRoleValue = role -> switch (role) {
        case TEACHER -> 1;
        case SENIOR_STUDENT -> 2;
        case JUNIOR_STUDENT -> 3;
        default -> throw new LibraryException("Unknown role: " + role);
    };
}
