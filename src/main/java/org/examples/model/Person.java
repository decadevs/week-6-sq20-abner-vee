package org.examples.model;

import lombok.*;
import org.examples.enums.Role;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private String name;
    private Role role;
    private List<Book> borrowedBooks;
    private static int counter = 0;
    private int order;

    public Person(String name, Role role, List<Book> borrowedBooks) {
        this.name = name;
        this.role = role;
        this.borrowedBooks = borrowedBooks;
        this.order = counter++;
    }
}
