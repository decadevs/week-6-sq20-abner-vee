package org.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Library2 {
    private String name;
    private List<Book> listOfBooks;
    private Queue<Person> borrowers;
    private Person librarian;
}
