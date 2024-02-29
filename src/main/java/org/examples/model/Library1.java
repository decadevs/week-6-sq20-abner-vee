package org.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.PriorityQueue;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Library1 {
    private String name;
    private List<Book> listOfBooks;
    private PriorityQueue<Person> borrowers;
    private Person librarian;
}
