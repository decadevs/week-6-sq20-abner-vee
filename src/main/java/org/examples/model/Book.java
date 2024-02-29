package org.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private int noOfCopies;

    public Book(String title, String author, int noOfCopies) {
        this.title = title;
        this.author = author;
        this.noOfCopies = noOfCopies;
    }
}